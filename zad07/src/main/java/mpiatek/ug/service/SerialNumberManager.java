package mpiatek.ug.service;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import mpiatek.ug.domain.SerialNumber;

@Stateless
public class SerialNumberManager {

    @PersistenceContext
    EntityManager em;

    public void addSerialNumber(SerialNumber serialNumber) {
        em.persist(serialNumber);
    }

    public SerialNumber updateSerialNumber(SerialNumber serialNumber, long id) {
        serialNumber.setId(id);
        SerialNumber old = getSerialNumber(id);
        if(old != null) {
            em.merge(serialNumber);
        }
        return old;
    }

    public void deleteSerialNumber(long id) {
        SerialNumber serialNumber = getSerialNumber(id);
        if(serialNumber != null) {
            em.remove(serialNumber);
        }
    }

    public SerialNumber getSerialNumber(long id) {
        return em.find(SerialNumber.class, id);
    }

    @SuppressWarnings("unchecked")
    public List<SerialNumber> getAll() {
        return em.createNamedQuery("serialNumber.all").getResultList();
    }

    @SuppressWarnings("unchecked")
    public void deleteAll(){
        em.createNamedQuery("serialNumber.delete.all").executeUpdate();
    }
}
