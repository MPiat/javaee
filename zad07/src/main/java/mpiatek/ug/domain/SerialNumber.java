package mpiatek.ug.domain;

import javax.persistence.*;

@Entity
@NamedQueries({
        @NamedQuery(name = "serialNumber.all", query = "SELECT sc FROM SerialNumber sc"),
        @NamedQuery(name = "serialNumber.delete.all", query = "DELETE FROM SerialNumber")
})
public class SerialNumber {
    private long id;
    private Integer number;


    public SerialNumber() {}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }
}
