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
    // @EJB
    private RouterManager rm;

    @Inject
    // @EJB
    private IspManager im;

    // @GET
    // @Path("/{routerId}")
    // @Produces(MediaType.APPLICATION_JSON)
    // public Router getRouter(@PathParam("routerId") Long id) {
    //     // Router p = rm.getRouter(id);
    //     // return p;
    //     // return em.find(Router.class, id);
    // }


    @GET
    @Path("/getall")
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

    // @DELETE
    // public Response clearRouters() {
    //     // rm.deleteAllRouters();
    //     em.createNamedQuery("router.deleteAll").executeUpdate();
    //     return Response.status(200).build();
    // }

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
    
    // @GET
    // @Path("/manytomany/{routerID}")
    // @Produces(MediaType.TEXT_PLAIN)
	// public String relations(@PathParam("routerId") Long id){
        
    //     // Add mapping of existing objects
	// 	Router r = new Router("TP-Link",3000);
		
	// 	Isp isp1 = new Isp("Orange", "LLC");
	// 	Isp isp2 = new Isp("T-Mobile", "Inc.");

	// 	List<Isp> isps = new ArrayList<>();
	// 	isps.add(isp1);
	// 	isps.add(isp2);
		
	// 	r.addIsps(isps);		
	// 	rm.addRouter(r);
		
	
	// 	System.out.println("Id isp1: " + isp1.getId());
		
	// 	System.out.println("\n\n@@@ Size of avRouters: " + isp1.getAvRouters().size());
		
	// 	return "ManyToMany";
	// }

        
    @GET
    @Path("/query/checkrouteroffer{ispName}")
    @Produces(MediaType.TEXT_PLAIN)
	public Response relations(@PathParam("ispName") String name){
        
        List<Object[]> rawOffers = im.getOfferOfIspByName(name);
		JsonArrayBuilder offer = Json.createArrayBuilder();
		
		for(Object[] rawRouter: rawOffers){
			
			String rName = (String) rawRouter[0];
			int modelNum = (Integer) rawRouter[1];
			
			offer.add(Json.createObjectBuilder()
					.add("name", rName)
					.add("modelNum", modelNum));
			
		}
		
		JsonObject json =  Json.createObjectBuilder().add("result", offer).build();
		return Response.ok(json, MediaType.APPLICATION_JSON).build();
	}
}
