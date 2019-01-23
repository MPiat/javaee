package mpiatek.ug.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.Date;

import javax.ejb.Singleton;

import mpiatek.ug.domain.Router;
import mpiatek.ug.domain.Isp;
import mpiatek.ug.domain.Admin;

@Stateless
public class RouterManager {

    @PersistenceContext
    EntityManager em;
    
    public boolean deleteRouter(Long id){
        Router router = getRouter(id);
        if(router!=null) {
            em.remove(router);
            return true;
        } else {
            return false;
        }
    }

    public boolean updateRouter(Long id, Router router){
        Router foundRouter = em.find(Router.class,id);
        router.setId(id);
        Router last = getRouter(id);
                
        if(last != null) {
            router.setAdmins(foundRouter.getAdmins());
            em.merge(router);
            return true;
        }
        return false;
    }
    
    public void addRouter(Router router){
        em.persist(router);
    }

    @SuppressWarnings("unchecked")
    public Router getRouter(Long id) {
        Router foundRouter = em.find(Router.class,id);
        return foundRouter;
        
    }

    @SuppressWarnings("unchecked")
	public Router getRouterBySerialNum(Integer number) {
		Query q = em.createNamedQuery("router.findBySerialNum");
		q.setParameter("number", number);
		List<Router> resultList = q.getResultList();
		if(!resultList.isEmpty()) {
			return resultList.get(0);
		}
		return null;
    }
    
    @SuppressWarnings("unchecked")
	public List<Router> getRoutersByIsp(String isp) {
		Query q = em.createNamedQuery("router.findByIsp");
		q.setParameter("isp", isp);
		return q.getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<Router> getRoutersByAdmin(String name) {
		Query q = em.createNamedQuery("router.findByAdminName");
		q.setParameter("first_name", name);
		return q.getResultList();
    }

    public List<Router> getRoutersAboveFrequency(Double freq) {
        Query q =  em.createNamedQuery("router.aboveFrequency");
        q.setParameter("freq", freq);
        return q.getResultList();
    }

    @SuppressWarnings("unchecked")
	public List<Router> getAllRouters(){
		return em.createNamedQuery("router.getAll").getResultList();
    }

    @SuppressWarnings("unchecked")
	public List<Admin> getAdmins(long id) {
		Query q = em.createNamedQuery("router.getAdmins");
		q.setParameter("id", id);
		return q.getResultList();
	}
    

	@SuppressWarnings("unchecked")
    public void deleteAll(){
		em.createNamedQuery("router.deleteAll").executeUpdate();
	}

}