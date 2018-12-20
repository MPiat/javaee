package mpiatek.ug.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlRootElement;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({ 
	@NamedQuery(name = "isp.all", query = "Select i from Isp i"),
	@NamedQuery(name = "isp.delete.all", query = "Delete from Isp "),
	@NamedQuery(name = "ispOffer.findOfferOfIspByName",
	query = "Select * from Isp b JOIN b.routers a where a.name = :name")
	})
@XmlRootElement
public class Isp {
	
	private Long id;
	
	private String name;
	
	private String type;
	
	private List<Router> avRouters = new ArrayList<>();
	
	public Isp() {
	}

	public Isp(String name, String type) {
		super();
		this.name = name;
		this.type = type;
	}

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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@OneToMany(mappedBy = "isps", fetch = FetchType.EAGER)
	public List<Router> getAvRouters() {
		return avRouters;
	}

	public void setAvRouters(List<Router> avRouters) {
		this.avRouters = avRouters;
	}
	
}