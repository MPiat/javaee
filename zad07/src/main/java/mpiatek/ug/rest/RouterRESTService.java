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
import mpiatek.ug.domain.Isp;
import mpiatek.ug.service.RouterManager;
import mpiatek.ug.service.IspManager;


@Path("router")
@Stateless
public class RouterRESTService {

    @Inject
    private RouterManager rm;

    @Inject
    private IspManager im;

    @GET
    @Path("/{routerId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Router getRouter(@PathParam("routerId") Long id) {
        return rm.getRouter(id);

    }

    @GET
    @Path("/{routerId}/isp")
    @Produces(MediaType.APPLICATION_JSON)
    public Isp getRoutersIsp(@PathParam("routerId") Long id) {
        try {
            return rm.getRouter(id).getIsp();
        } catch (Exception e) {
            return null;
        }

    }


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Router> getAllRouters() {
       return rm.getAllRouters();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addRouter(Router router) {
        rm.addRouter(router);
        return Response.status(201).entity("Router added.").build();
    }

    @DELETE
    public Response deleteAll() {
        rm.deleteAll();
        return Response.status(200).build();
    }

    @GET
	@Path("/test")
	@Produces(MediaType.TEXT_PLAIN)
	public String test(){
		return "REST Routers Service is running now!";
	}

    @DELETE
    @Path("/{routerId}")
    public Response deleteRouter(@PathParam("routerId") Long id) {
        
        if(rm.deleteRouter(id)) {
			return Response.status(200).build();
		} else {
			return Response.status(404).build();
		}
    }


    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/{routerId}")
    public Response updateRouter(@PathParam("routerId") Long id, Router router) {
        rm.updateRouter(id, router);
        return Response.status(200).build();
    }

}
