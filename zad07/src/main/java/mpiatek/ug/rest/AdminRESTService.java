package mpiatek.ug.rest;

import java.util.List;
import java.util.ArrayList;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.PostUpdate;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import mpiatek.ug.domain.Router;
import mpiatek.ug.domain.Admin;
import mpiatek.ug.service.RouterManager;
import mpiatek.ug.service.AdminManager;


/*

OneToMany - ManyToOne Bidirectional - routers and admins(owners) 3 adnotacje mappedBy

rozwiązanie przypisania obiektów jak w przykładzie
np. Person.setCars()
    Person.addCars(){
        ...
        + ustaw właściciela w każdym samochodzie
    }

EXPORT TEST FROM POSTMAN


*/

@Path("admin")
@Stateless
public class AdminRESTService {

    @Inject
    private RouterManager rm;

    @Inject
    private AdminManager am;


    // @GET
    // @Path("/{adminId}")
    // @Produces(MediaType.APPLICATION_JSON)
    // public List<Router> getAdminsRouters(@PathParam("adminId") Long id) {
    //     try {
    //         return am.getAllRoutersOfAdmin(id);
    //     } catch (Exception e) {
    //         return null;
    //     }
    // }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Admin> getAll() {
        try {
            return am.getAll();
        } catch (Exception e) {
            return null;
        }

    }

    @GET
	@Path("/{adminId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Admin getAdmin(@PathParam("adminId") long id) {
		return am.getAdmin(id);
	}

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/{adminId}")
    public Response updateAdmin(@PathParam("adminId") Long id, Admin admin) {
        am.updateAdmin(id, admin);
        return Response.status(200).build();
    }


	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addAdmin(Admin admin) {
		am.addAdmin(admin);
		return Response.status(201).entity("Admin").build();
    }
    
    @DELETE
    public Response deleteAll() {
        am.deleteAll();
        return Response.status(200).build();
    }

    @DELETE
    @Path("/{adminId}")
    public Response deleteAdmin(@PathParam("adminId") Long id) {
        
        if(am.deleteAdmin(id)) {
			return Response.status(200).build();
		} else {
			return Response.status(404).build();
		}
    }

    @GET
	@Path("/test")
	@Produces(MediaType.TEXT_PLAIN)
	public String test(){
		return "REST Admins Service is running now!";
	}

}
