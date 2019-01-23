package mpiatek.ug.domain;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;
import javax.persistence.*;

import java.util.Date;
import javax.validation.constraints.NotNull;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;
import mpiatek.ug.view.View;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
@NamedQueries({ 
    
	@NamedQuery(name = "router.getAll", query = "Select r from Router r"),
	@NamedQuery(name = "router.deleteAll", query = "Delete from Router "),
    @NamedQuery(name = "router.findByName", query = "Select r from Router r where name = :name"),
    @NamedQuery(name = "router.findById", query = "SELECT l FROM Router l LEFT JOIN FETCH l.isp i LEFT JOIN FETCH l.serialNumber sn LEFT JOIN FETCH l.admins WHERE l.id = :id"),
    @NamedQuery(name = "router.getAdmins", query = "SELECT a FROM Router r LEFT JOIN r.admins a WHERE r.id = :id"),
    @NamedQuery(name = "router.findByAdminName", query = "SELECT l FROM Router l LEFT JOIN l.admins a WHERE a.name = :name"),
    @NamedQuery(name = "router.findByIsp", query = "SELECT l FROM Router l JOIN l.isp i WHERE i.name = :isp"),
    @NamedQuery(name = "router.findBySerialNum", query = "SELECT l FROM Router l JOIN l.serialNumber sn WHERE sn.number = :number"),
    @NamedQuery(name = "router.getRoutersOfIsp", query = "Select r from Router r where r.isp.id = :id"),
    @NamedQuery(name = "router.aboveFrequency", query = "Select r from Router r WHERE r.frequency>=:freq")
})
public class Router {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonView(View.Internal.class)
    private long id;

    @JsonView({View.RouterView.class, View.Internal.class})
    private String name;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @JsonView(View.Internal.class)
    private Date dateOfRelease;
    
    @JsonView(View.Internal.class)
    private double frequency;
    
    @JsonView(View.RouterView.class)
    private boolean isWireless;
    
    @JsonIgnore
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name="Admin_Router", joinColumns=@JoinColumn(name="routers_id"), inverseJoinColumns=@JoinColumn(name="admins_id"))
    private List<Admin> admins = new ArrayList<>();

    
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    private Isp isp;

    @OneToOne(fetch = FetchType.EAGER, cascade=CascadeType.MERGE)
    private SerialNumber serialNumber;

    


    public Router(){ }

    public Router(String name, Date dateOfRelease, double frequency, boolean isWireless) {
        this.name = name;
        this.dateOfRelease = dateOfRelease;
        this.frequency = frequency;
        this.isWireless = isWireless;
    }

	public Long getId() {
		return id;
    }

    public void setId(Long id) {
		this.id = id;
	}
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDateOfRelease() {
        return dateOfRelease;
    }

    public void setDateOfRelease(Date dateOfRelease) {
        this.dateOfRelease = dateOfRelease;
    }

    public double getFrequency() {
        return frequency;
    }

    public void setFrequency(double frequency) {
        this.frequency = frequency;
    }

    public boolean getIsWireless() {
        return isWireless;
    }

    public void setIsWireless(boolean isWireless) {
        this.isWireless = isWireless;
    }

    public Isp getIsp() {
        return isp;
    }

    public void setIsp(Isp isp) {
        this.isp = isp;
    }

    public void addAdmin(Admin admin) {
        getAdmins().add(admin);
        admin.getRouters().add(this);
    }

    public void removeAdmin(Admin admin) {
        getAdmins().remove(admin);
        admin.getRouters().remove(this);
    }

    public List<Admin> getAdmins() {
        return admins;
    }

    public void setAdmins(List<Admin> admins) {
        this.admins = admins;
    }

    public SerialNumber getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(SerialNumber serialNumber) {
        this.serialNumber = serialNumber;
    }

    @Override
    public String toString() {
        return "Router{" +
                "name='" + name + '\'' +
                ", dateOfRelease=" + dateOfRelease +
                ", frequency=" + frequency +
                ", isWireless=" + isWireless +
                '}';
    }				

}
