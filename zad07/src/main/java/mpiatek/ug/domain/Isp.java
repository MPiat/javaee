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
	@NamedQuery(name = "Isp.all", query = "Select i from Isp i"),
	@NamedQuery(name = "Isp.getUnique", query = "Select i from Isp i WHERE i.name=:name AND i.type=:type"),
	@NamedQuery(name = "Isp.getById", query = "Select i from Isp i WHERE i.name=:name AND i.id=:id"),

})
@XmlRootElement
public class Isp {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String name;
	
	private String type;
	
	
	public Isp() {
	}

	public Isp(String name, String type) {
		super();
		this.name = name;
		this.type = type;
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
}