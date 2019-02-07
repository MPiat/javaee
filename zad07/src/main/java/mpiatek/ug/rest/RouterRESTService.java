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
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import mpiatek.ug.domain.Router;
import mpiatek.ug.domain.Admin;
import mpiatek.ug.service.RouterManager;
import java.util.Date;
import java.text.ParseException;



@Path("router")
@Stateless
public class RouterRESTService {

    @Inject
    private RouterManager rm;

    @GET
    @Path("/{routerId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Router getById(@PathParam("routerId") Long id) {
        try {
            return rm.getById(id);
        } catch (Exception e) {
            return null;
        }
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Router> getAllRouters() {
       return rm.getAllRouters();
    }

	@GET
	@Path("/isp")
    @Produces(MediaType.APPLICATION_JSON)
	public List<Router> getRoutersByIsp(@QueryParam("name") String isp) {
		return rm.getRoutersByIsp(isp);
	}

	@GET
	@Path("/serial")
    @Produces(MediaType.APPLICATION_JSON)
	public Router getRouterBySerialNumber(@QueryParam("number") Integer number) {
		return rm.getRouterBySerialNum(number);
    }
    
    @GET
	@Path("/above-frequency")
    @Produces(MediaType.APPLICATION_JSON)
	public List<Router> getRouterAboveFrequency(@QueryParam("freq") Double freq) {
		return rm.getRoutersAboveFrequency(freq);
    }

    @GET
	@Path("/before-date")
    @Produces(MediaType.APPLICATION_JSON)
	public List<Router> getRouterBeforeDate(@QueryParam("startDate") String startDate) {
        try{
            DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            Date parsedDate = format.parse(startDate);
            return rm.getRoutersBeforeDate(parsedDate);
        }catch(Exception e){
            return null;
        }	
    }
    

    // Criteria builder w tym
    @GET
	@Path("/after-date")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getRoutersAfterDate(@QueryParam("startDate") String startDate) {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date date = sdf.parse(startDate);
			return Response.ok(rm.getRoutersAfterDate(date), MediaType.APPLICATION_JSON).build();
		} catch (ParseException e) {
			return Response.status(Response.Status.BAD_REQUEST).entity("Date format: yyyy-MM-dd").build();
		}
	}

	@GET
	@Path("/admin")
    @Produces(MediaType.APPLICATION_JSON)
	public List<Router> getRoutersByAdmin(@QueryParam("name") String name) {
		return rm.getRoutersByAdmin(name);
	}

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addRouter(Router router) {
        rm.addRouter(router);
        return Response.status(201).entity("Router added.").build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/{routerId}")
    public Response updateRouter(@PathParam("routerId") Long id, Router router) {
        rm.updateRouter(id, router);
        return Response.status(200).build();
    }

    @DELETE
    public Response deleteAll() {
        rm.deleteAll();
        return Response.status(200).build();
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

    @GET
	@Path("/test")
	@Produces(MediaType.TEXT_PLAIN)
	public String test(){
		return "REST Routers Service is running now!";
	}

}
