package mpiatek.ug.rest;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.PostUpdate;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import mpiatek.ug.domain.Router;
import mpiatek.ug.service.RouterManager;

@Path("router")
public class RouterRESTService {

    @Inject
    private RouterManager rm;

    @GET
    @Path("/{routerId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Router getRouter(@PathParam("routerId") Integer id) {
        Router p = rm.getRouter(id);
        return p;
    }


    @GET
    @Path("/getall")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Router> getAllRouters() {
       return rm.getAllRouters();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addDefaultRouter() {
        rm.addDefaultRouter();

        return Response.status(201).entity("Router").build();
    }

    @DELETE
    public Response clearRouters() {
        rm.deleteAllRouters();
        return Response.status(200).build();
    }

    @DELETE
    @Path("/{routerId}")
    public Response deleteRouter(Router router) {
        rm.deleteRouter(router);
        return Response.status(200).build();
    }

}
