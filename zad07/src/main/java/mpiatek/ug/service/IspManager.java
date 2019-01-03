package mpiatek.ug.service;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import mpiatek.ug.domain.Isp;
import mpiatek.ug.domain.Router;

@Stateless
public class IspManager {
	
	@PersistenceContext
	EntityManager em;
	
	public void addIsp(Isp isp){	
		em.persist(isp);
	}
	
	public Isp getIsp(Long id){
		Isp retrieved = em.find(Isp.class, id);
		return retrieved;
	}
	
	public List<Router> getAllRoutersOfIsp(Long id) {
        return em.createNamedQuery("router.getRoutersOfIsp").setParameter("id",id).getResultList();
	}
	
	public boolean updateIsp(Long id, Isp isp){
        Isp foundIsp = em.find(Isp.class,id);
        if(foundIsp!=null) {
            isp.setId(foundIsp.getId());
            em.merge(isp);
            return true;
        }
        return false;
    }
	
	@SuppressWarnings("unchecked")
	public List<Isp> getAll(){
		return em.createNamedQuery("Isp.all").getResultList();
	}
	
	public void deleteAll(){
		em.createNamedQuery("Isp.delete.all").executeUpdate();
	}

	public boolean deleteIsp(Long id){
        Isp foundIsp = em.find(Isp.class,id);
        if(foundIsp!=null) {
            em.remove(foundIsp);
            return true;
        } else {
            return false;
        }
    }
	
}
