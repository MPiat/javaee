package mpiatek.ug.domain;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;
import javax.persistence.*;

import java.util.Date;
import javax.validation.constraints.NotNull;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.xml.bind.annotation.XmlRootElement;

@Entity
@NamedQueries({ 
	@NamedQuery(name = "router.getAll", query = "Select r from Router r"),
	@NamedQuery(name = "router.deleteAll", query = "Delete from Router "),
    @NamedQuery(name = "router.findByName", query = "SELECT r FROM Router r LEFT JOIN FETCH r.isp i LEFT JOIN FETCH r.serialNumber sn LEFT JOIN FETCH r.admins a WHERE name = :name"),
    @NamedQuery(name = "router.findById", query = "SELECT r FROM Router r LEFT JOIN FETCH r.isp i LEFT JOIN FETCH r.serialNumber sn LEFT JOIN FETCH r.admins a WHERE r.id = :id"),
    @NamedQuery(name = "router.getAdmins", query = "SELECT r FROM Router r LEFT JOIN FETCH r.isp i LEFT JOIN FETCH r.serialNumber sn LEFT JOIN FETCH r.admins a WHERE r.id = :id"),
    @NamedQuery(name = "router.findByAdminName", query = "SELECT r FROM Router r LEFT JOIN FETCH r.isp i LEFT JOIN FETCH r.serialNumber sn LEFT JOIN FETCH r.admins a WHERE a.name = :name"),
    @NamedQuery(name = "router.findByIsp", query = "SELECT DISTINCT r FROM Router r LEFT JOIN FETCH r.isp i LEFT JOIN FETCH r.serialNumber sn LEFT JOIN FETCH r.admins a WHERE i.name = :isp"),
    @NamedQuery(name = "router.findBySerialNum", query = "SELECT r FROM Router r LEFT JOIN FETCH r.isp i LEFT JOIN FETCH r.serialNumber sn LEFT JOIN FETCH r.admins a WHERE sn.number = :number"),
    @NamedQuery(name = "router.getRoutersOfIsp", query = "SELECT r FROM Router r LEFT JOIN FETCH r.isp i LEFT JOIN FETCH r.serialNumber sn LEFT JOIN FETCH r.admins a WHERE r.isp.id = :id"),
    @NamedQuery(name = "router.aboveFrequency", query = "SELECT DISTINCT r FROM Router r LEFT JOIN FETCH r.isp i LEFT JOIN FETCH r.serialNumber sn LEFT JOIN FETCH r.admins a WHERE r.frequency>=:freq"),
    @NamedQuery(name = "router.beforeDate", query = "SELECT r FROM Router r LEFT JOIN FETCH r.isp i LEFT JOIN FETCH r.serialNumber sn LEFT JOIN FETCH r.admins a WHERE r.dateOfRelease<=:startDate"),

})
public class Router {

    private long id;

    private String name;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date dateOfRelease;
    
    private double frequency;
    
    private boolean isWireless;
    
    private List<Admin> admins;

    private Isp isp;

    private SerialNumber serialNumber;


    public Router(){ }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @ManyToOne(fetch = FetchType.LAZY)
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

    @ManyToMany(fetch = FetchType.LAZY)
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

}
