package mpiatek.ug.service;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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
	
	// TODO: Test that with ManyToMany
	public List<Router> getAllRoutersOfAdmin(Long id) {
        return em.createNamedQuery("router.getRoutersOfAdmin").setParameter("id",id).getResultList();
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
