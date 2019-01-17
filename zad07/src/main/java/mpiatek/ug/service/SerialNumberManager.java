package mpiatek.ug.service;

import mpiatek.ug.domain.SerialNumber;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

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
    public List<SerialNumber> getAllSerialNumbers() {
        return em.createNamedQuery("serialNumber.all").getResultList();
    }

    @SuppressWarnings("unchecked")
    public void deleteAllSerialNumbers(){
        em.createNamedQuery("serialNumber.delete.all").executeUpdate();
    }
}