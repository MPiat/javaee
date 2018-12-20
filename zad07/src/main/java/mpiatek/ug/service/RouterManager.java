package mpiatek.ug.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import javax.ejb.Singleton;

import mpiatek.ug.domain.Router;

@Stateless
public class RouterManager {

    @PersistenceContext
    EntityManager em;
    
    private List<Router> db = Collections.synchronizedList(new ArrayList<>());

    // public void addDefaultRouter() { db.add(new Router("Linksys",2000));}

    // public void deleteRouter(Integer id){
    //     db.remove(id);
    // }

    public Router updateRouter(Router router){
        // Router change = db.get(id);
        // change.setName(router.getName());
        // change.setModelNum(router.getModelNum());
        return em.merge(router);
    }

    public void addRouter( Router router){
        // db.add(new Router(router.getName(),router.getModelNum()));
        em.persist(router);
    }

    @SuppressWarnings("unchecked")
    public Router getRouter(Integer id) {
        // return db.get(id);
        return em.find(Router.class, id);

    }

    @SuppressWarnings("unchecked")
	public List<Router> getAllRouters(){
		return em.createNamedQuery("router.getAll").getResultList();
	}

    public void deleteAllRouters(){
        db.clear();
    }
    public void clearRouters(){
		em.createNamedQuery("routers.deleteAll").executeUpdate();
	}

}