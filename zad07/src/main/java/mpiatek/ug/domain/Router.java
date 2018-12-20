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
import javax.persistence.ManyToMany;

import javax.xml.bind.annotation.XmlRootElement;
// import com.fasterxml.jackson.annotation.JsonProperty;

@XmlRootElement
@Entity
@NamedQueries({ 
	@NamedQuery(name = "router.getAll", query = "Select r from Router r"),
	@NamedQuery(name = "router.delete.all", query = "Delete from Router "),
	@NamedQuery(name = "router.findByName", query = "Select r from Router r where name = :name"),
    })
public class Router {


    private long id;

    private String name;
    private int modelNum;
    private List<Isp> isps = new ArrayList<>();


    public Router(){ }

    public Router(String name, int modelNum) {
        this.name = name;
        this.modelNum = modelNum;
    }

    // public Router(Long id, String name, int modelNum) {
	// 	super();
	// 	this.id = id;
	// 	this.name = name;
	// 	this.modelNum = modelNum;
	// }

    @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
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
    public int getModelNum() {
        return modelNum;
    }
    public void setModelNum(int modelNum) {
        this.modelNum = modelNum;
    }

    // @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	// public List<Isp> getIsps() {
	// 	return isps;
	// }

	// public void setIsps(List<Isp> isps) {
	// 	this.isps = isps;
	// }
	
	// public void addIsps(List<Isp> isps) {
		
	// 	this.setIsps(isps);
		
	// 	for (Isp isp: isps){
	// 		isp.getAvRouters().add(this);
	// 	}
	// }				

}
