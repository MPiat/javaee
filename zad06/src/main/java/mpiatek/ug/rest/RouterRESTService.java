package mpiatek.ug.rest;

import java.util.List;

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

import mpiatek.ug.domain.Router;
import mpiatek.ug.service.RouterManager;

@Path("router")
@Stateless
public class RouterRESTService {

    @Inject
    private RouterManager rm;

    @PersistenceContext
    EntityManager em;

    @GET
    @Path("/{routerId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Router getRouter(@PathParam("routerId") Long id) {
        // Router p = rm.getRouter(id);
        // return p;
        return em.find(Router.class, id);
    }


    @GET
    @Path("/getall")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Router> getAllRouters() {
    //    return rm.getAllRouters();
    return em.createNamedQuery("router.getAll").getResultList();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addRouter(Router router) {
        // rm.addRouter(router);
        em.persist(router);

        return Response.status(201).entity("Router added.").build();
    }

    @DELETE
    public Response clearRouters() {
        // rm.deleteAllRouters();
        em.createNamedQuery("router.deleteAll").executeUpdate();
        return Response.status(200).build();
    }

    @GET
	@Path("/test")
	@Produces(MediaType.TEXT_PLAIN)
	public String test(){
		return "REST Routers Service is running now!";
	}

    // @DELETE
    // @Path("/{routerId}")
    // public Response delRouters(@PathParam("routerId") Integer id) {
    //     // rm.deleteRouter(id);
    //     return Response.status(200).build();
    // }


    // @PUT
    // @Consumes(MediaType.APPLICATION_JSON)
    // @Path("/{routerId}")
    // public Response updateRouter(@PathParam("routerId") Long id, Router router) {
    //     // rm.updateRouter(id, router);
    //     em.merge(router);
    //     return Response.status(200).build();
    // }

}
