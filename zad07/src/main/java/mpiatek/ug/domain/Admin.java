package mpiatek.ug.domain;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@NamedQueries({ 
	@NamedQuery(name = "Admin.all", query = "Select i from Admin i"),
	@NamedQuery(name = "Admin.getByName", query = "Select i from Admin i WHERE i.name=:name"),
	@NamedQuery(name = "Admin.getById", query = "Select i from Admin i WHERE i.name=:name AND i.id=:id"),
	@NamedQuery(name = "Admin.delete.all", query = "DELETE FROM Admin"),
	@NamedQuery(name = "Admin.getRouters", query = "SELECT l FROM Admin a LEFT JOIN a.routers l LEFT JOIN FETCH l.isp LEFT JOIN FETCH l.serialNumber WHERE a.id = :id"),
})
@XmlRootElement
public class Admin {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String name;

	private String email;
	
	@JsonIgnore
	@ManyToMany(cascade = CascadeType.ALL, mappedBy = "admins",fetch = FetchType.LAZY)
	private List<Router> routers = new ArrayList<>();

	public Admin() {
	}

	public Admin(String name, String email) {
		super();
		this.name = name;
		this.email = email;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public void addRouter(Router router) {
        getRouters().add(router);
        router.getAdmins().add(this);
    }

    public void removeRouter(Router router) {
        getRouters().remove(router);
        router.getAdmins().remove(this);
    }

    public List<Router> getRouters() {
        return routers;
    }

    public void setRouters(List<Router> routers) {
        this.routers = routers;
    }
}