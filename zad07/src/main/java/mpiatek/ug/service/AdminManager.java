package mpiatek.ug.service;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import mpiatek.ug.domain.Admin;
import mpiatek.ug.domain.Router;

@Stateless
public class AdminManager {
	
	@PersistenceContext
	EntityManager em;
	
	public void addAdmin(Admin admin){	
		em.persist(admin);
	}
	
	public Admin getAdmin(Long id){
		Admin retrieved = em.find(Admin.class, id);
		return retrieved;
	}
	
    public void addToAdmin(long adminId, long routerId) {
        Admin admin = em.find(Admin.class,adminId);
        Router router = em.find(Router.class,routerId);
        admin.getRouters().add(router);
        router.getAdmins().add(admin);
        em.persist(admin);
	}
	
    public void deleteFromAdmin(long adminId, long routerId) {
        Admin admin = em.find(Admin.class,adminId);
        Router router = em.find(Router.class,routerId);
        admin.getRouters().remove(router);
        router.getAdmins().remove(admin);
        em.persist(admin);
	}
	
	public boolean updateAdmin(Long id, Admin admin){
        Admin foundAdmin = em.find(Admin.class,id);
        if(foundAdmin!=null) {
            admin.setId(foundAdmin.getId());
            em.merge(admin);
            return true;
        }
        return false;
    }
	
	@SuppressWarnings("unchecked")
	public List<Admin> getAll(){
		return em.createNamedQuery("Admin.all").getResultList();
    }
    
    @SuppressWarnings("unchecked")
	public List<Admin> getRoutersOfAdmin(long id){
        Query q = em.createNamedQuery("Admin.getRouters");
        q.setParameter("id", id);
        return q.getResultList();    
    }

    @SuppressWarnings("unchecked")
    public List<Admin> getAdminByName(String name) {
        Query q = em.createNamedQuery("Admin.getByName");
        q.setParameter("name", name);
        return q.getResultList();
    }
	
	public void deleteAll(){
		em.createNamedQuery("Admin.delete.all").executeUpdate();
	}

	public boolean deleteAdmin(Long id){
        Admin foundAdmin = em.find(Admin.class,id);
        if(foundAdmin!=null) {
            em.remove(foundAdmin);
            return true;
        } else {
            return false;
        }
    }
	
}
