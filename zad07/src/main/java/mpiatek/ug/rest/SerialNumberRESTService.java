package mpiatek.ug.rest;

import mpiatek.ug.domain.SerialNumber;
import mpiatek.ug.service.SerialNumberManager;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("serial")
@Stateless
public class SerialNumberRESTService {
	
	@Inject
	private SerialNumberManager sm;

	@GET
	@Path("/{serialNumberId}")
	@Produces(MediaType.APPLICATION_JSON)
	public SerialNumber getSerialNumber(@PathParam("serialNumberId") long id) {
		return sm.getSerialNumber(id);
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<SerialNumber> getAll() {
		return sm.getAll();
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addSerialNumber(SerialNumber serialNumber) {
		sm.addSerialNumber(serialNumber);
		return Response.status(Response.Status.CREATED).entity("SerialNumber").build();
	}

	@PUT
	@Path("/{serialNumberId}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateSerialNumber(@PathParam("serialNumberId") long id, SerialNumber serialNumber) {
		sm.updateSerialNumber(serialNumber, id);
		return Response.status(200).build();
	}


	@DELETE
	public Response deleteAll() {
		sm.deleteAll();
		return Response.status(Response.Status.OK).build();
	}

	@DELETE
	@Path("/{serialNumberId}")
	public Response deleteSerialNumber(@PathParam("serialNumberId") long id) {
		sm.deleteSerialNumber(id);
		return Response.status(200).build();
	}

}
