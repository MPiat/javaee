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


@Path("isp")
@Stateless
public class IspRESTService {

    @Inject
    private RouterManager rm;

    @Inject
    private IspManager im;


    @GET
    @Path("/{ispId}/routers")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Router> getIspsRouters(@PathParam("ispId") Long id) {
        try {
            return im.getAllRoutersOfIsp(id);
        } catch (Exception e) {
            return null;
        }

    }

    @GET
	@Path("/{ispId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Isp getIsp(@PathParam("ispId") long id) {
		return im.getIsp(id);
	}

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Isp> getAll() {
        try {
            return im.getAll();
        } catch (Exception e) {
            return null;
        }

    }


	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addIsp(Isp isp) {
		im.addIsp(isp);
		return Response.status(201).entity("Isp").build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/{ispId}")
    public Response updateIsp(@PathParam("ispId") Long id, Isp isp) {
        im.updateIsp(id, isp);
        return Response.status(200).build();
    }


    
    @DELETE
    public Response deleteAll() {
        im.deleteAll();
        return Response.status(200).build();
    }

    @DELETE
    @Path("/{ispId}")
    public Response deleteIsp(@PathParam("ispId") Long id) {
        
        if(im.deleteIsp(id)) {
			return Response.status(200).build();
		} else {
			return Response.status(404).build();
		}
    }

    @GET
	@Path("/test")
	@Produces(MediaType.TEXT_PLAIN)
	public String test(){
		return "REST Isps Service is running now!";
	}

}
