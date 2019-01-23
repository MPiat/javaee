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

@Path("admin")
@Stateless
public class AdminRESTService {

    @Inject
    private RouterManager rm;

    @Inject
    private AdminManager am;

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
	@Path("{adminId}/routers")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Admin> getRoutersOfAdmin(@PathParam("adminId") long id) {
		return am.getRoutersOfAdmin(id);
	}

    @GET
	@Path("/{adminId}")
    @Produces(MediaType.APPLICATION_JSON)
	public Admin getAdmin(@PathParam("adminId") long id) {
		return am.getAdmin(id);
    }
    
    @GET
	@Path("/name")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Admin> getAdminsByName(@QueryParam("name") String name) {
		return am.getAdminByName(name);
	}

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/{adminId}")
    public Response updateAdmin(@PathParam("adminId") Long id, Admin admin) {
        am.updateAdmin(id, admin);
        return Response.status(200).build();
    }

    @POST
    @Path("/{adminId}/{routerId}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addToAdmin(@PathParam("adminId") long adminId, @PathParam("routerId") long routerId) {
        am.addToAdmin(adminId,routerId);
        return Response.status(201).entity("Admin").build();
    }

    @DELETE
    @Path("/{adminId}/{routerId}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response deleteFromAdmin(@PathParam("adminId") long adminId, @PathParam("routerId") long routerId) {
        am.deleteFromAdmin(adminId,routerId);
        return Response.status(201).entity("Admin").build();
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
