package mpiatek.ug.domain;

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

    @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;
    private int modelNum;

    public Router(){ }

    public Router(String name, int modelNum) {
        this.name = name;
        this.modelNum = modelNum;
    }
    // public Router(@JsonProperty("name")String name, @JsonProperty("modelNum")String modelNum){

    // }
    // public Router(Long id, String name, int modelNum) {
	// 	super();
	// 	this.id = id;
	// 	this.name = name;
	// 	this.modelNum = modelNum;
	// }


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

    // @Override
    // public int hashCode() {
    //     final int prime = 31;
    //     int result = 1;
    //     result = prime * result + ((name == null) ? 0 : name.hashCode());
    //     result = prime * result + modelNum;
    //     return result;
    // }

    // @Override
    // public boolean equals(Object obj) {
    //     if (this == obj)
    //         return true;
    //     if (obj == null)
    //         return false;
    //     if (getClass() != obj.getClass())
    //         return false;
    //     Router other = (Router) obj;
    //     if (name == null) {
    //         if (other.name != null)
    //             return false;
    //     } else if (!name.equals(other.name))
    //         return false;
    //     if (modelNum != other.modelNum)
    //         return false;
    //     return true;
    // }

}
