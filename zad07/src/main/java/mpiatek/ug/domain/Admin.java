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
	@NamedQuery(name = "Admin.getRouters", query = "SELECT r FROM Admin a LEFT JOIN a.routers r LEFT JOIN FETCH r.isp LEFT JOIN FETCH r.serialNumber WHERE a.id = :id"),
	
})
public class Admin {


	private Long id;

	private String name;

	private String email;
	
	private List<Router> routers = new ArrayList<>();

	public Admin() {}

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
	@JsonIgnore
	@ManyToMany(mappedBy = "admins", fetch = FetchType.EAGER)
    public List<Router> getRouters() {
        return routers;
    }

    public void setRouters(List<Router> routers) {
        this.routers = routers;
    }
}