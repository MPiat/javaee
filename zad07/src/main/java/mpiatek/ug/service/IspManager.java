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
	
	public List<Router> getOfferOfIsp(Long id){
		Isp retrieved = em.find(Isp.class, id);
		List<Router> result = new ArrayList<>(retrieved.getAvRouters());
		return result;
	}
		
	@SuppressWarnings("unchecked")
	public List<Object[]> getOfferOfIspByName(String name){		
		return em.createNamedQuery("ispOffer.findOfferName").setParameter("name", name).getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<Isp> getAll(){
		return em.createNamedQuery("isp.all").getResultList();
	}
	
	public void deletAll(){
		em.createNamedQuery("isp.delete.all").executeUpdate();
	}
	
}