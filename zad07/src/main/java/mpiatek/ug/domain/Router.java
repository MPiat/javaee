package mpiatek.ug.domain;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.ManyToOne;
import javax.persistence.ManyToMany;
import java.util.Date;
import javax.validation.constraints.NotNull;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
@NamedQueries({ 
    
	@NamedQuery(name = "router.getAll", query = "Select r from Router r"),
	@NamedQuery(name = "router.deleteAll", query = "Delete from Router "),
	@NamedQuery(name = "router.findByName", query = "Select r from Router r where name = :name"),
    @NamedQuery(name = "router.getRoutersOfIsp", query = "Select r from Router r where r.isp.id = :id"),
    @NamedQuery(name = "router.getRoutersOfAdmin", query = "Select r from Router r where r.admin.id = :id"),
    
})
public class Router {

    @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;
    private Date dateOfRelease;
    private double frequency;
    private boolean isWireless;
    private SerialNumber serialNumber;
    private List<Admin> admins;


    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @NotNull
    private Isp isp;

    // @ManyToOne
    // private Admin admin;

    


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

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    public List<Admin> getAdmins() {
        return admins;
    }

    public void setAdmins(List<Admin> admins) {
        this.admins = admins;
    }

    @OneToOne(fetch = FetchType.LAZY)
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
