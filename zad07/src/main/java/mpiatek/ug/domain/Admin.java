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
import javax.persistence.ManyToOne;
import javax.xml.bind.annotation.XmlRootElement;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.*;

@Entity
@NamedQueries({ 
	@NamedQuery(name = "Admin.all", query = "Select i from Admin i"),
	@NamedQuery(name = "Admin.getUnique", query = "Select i from Admin i WHERE i.name=:name AND i.email=:email"),
	@NamedQuery(name = "Admin.getById", query = "Select i from Admin i WHERE i.name=:name AND i.id=:id"),
	@NamedQuery(name = "Admin.delete.all", query = "DELETE FROM Admin")
})
@XmlRootElement
public class Admin {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String name;
	
	private String email;
	
    // @OneToMany(mappedBy="admin")
    // private List<Router> routers;
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

    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "admins")
    public List<Router> getRouters() {
        return routers;
    }

    public void setRouters(List<Router> routers) {
        this.routers = routers;
    }
}