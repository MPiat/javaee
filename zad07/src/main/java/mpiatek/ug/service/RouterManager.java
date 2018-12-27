package mpiatek.ug.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import javax.ejb.Singleton;

import mpiatek.ug.domain.Router;
import mpiatek.ug.domain.Isp;

@Stateless
public class RouterManager {

    @PersistenceContext
    EntityManager em;
    
    private List<Router> db = Collections.synchronizedList(new ArrayList<>());

    public boolean deleteRouter(Long id){
        Router foundRouter = em.find(Router.class,id);
        if(foundRouter!=null) {
            em.remove(foundRouter);
            return true;
        } else {
            return false;
        }
    }

    public boolean updateRouter(Long id, Router router){
        Router foundRouter = em.find(Router.class,id);
        if(foundRouter!=null) {
            List<Isp> isps = em.createNamedQuery("Isp.all").getResultList();
            router.setIsp(isps.get(0));
            router.setId(foundRouter.getId());
            em.merge(router);
            return true;
        }
        return false;
    }

    public void addRouter( Router router){
        List<Isp> isps = em.createNamedQuery("Isp.all").getResultList();
        router.setIsp(isps.get(0));
        em.persist(router);
    }

    @SuppressWarnings("unchecked")
    public Router getRouter(Long id) {
        return em.find(Router.class, id);
    }

    @SuppressWarnings("unchecked")
	public List<Router> getAllRouters(){
		return em.createNamedQuery("router.getAll").getResultList();
	}

    public void clearRouters(){
		em.createNamedQuery("router.deleteAll").executeUpdate();
	}

}