package org.interlogica.controller;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.interlogica.json.request.FileCheckRequest;
import org.interlogica.json.response.FileTestResponse;
import org.interlogica.json.response.SingleTestResponse;
import org.interlogica.service.SouthAfricaService;
import org.jboss.logging.Logger;

@Path("/south-africa")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class SouthAfricaAPI {

	private SouthAfricaService southAfricaService;

	@Inject
	Logger logger;

	@Inject
	public SouthAfricaAPI(SouthAfricaService southAfricaService) {
		this.southAfricaService = southAfricaService;
	}

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String hello() {
		return "hello";
	}

	@GET
	@Path("/welcome")
	@Produces(MediaType.TEXT_PLAIN)
	public Response welcome(@QueryParam(value = "name") String name) {
		return southAfricaService.sayHi(name);
	}

	@GET
	@Path("/check/{phoneNumber}")
	public Response singleCheck(@HeaderParam("origin") String oring,
			@PathParam(value = "phoneNumber") String phoneNumber) {
		logger.info("Request : @GET /check/" + phoneNumber);
		SingleTestResponse response = southAfricaService.singleCheck(phoneNumber);
		// Send response
		logger.info("Response @GET /check/" + phoneNumber + " : " + response);
		return Response.status(response.getStatus()).entity(response).build();
	}

	@POST
	@Path("/check")
	public Response fileCheck(@HeaderParam("origin") String oring, FileCheckRequest request) {
		logger.info("Response @POST /check : " + request);
		// Request received by the server
		FileTestResponse response = new FileTestResponse(Response.Status.ACCEPTED);

		// Validate request
		if (request.getFileContent() == null || request.getFileName() == null || request.getFileName() == null) {
			response.setStatus(Response.Status.BAD_REQUEST);
		} else {
			// Exec service
			response = southAfricaService.fileCheck(request);
		}

		// Send response
		logger.info("Response @POST /check : " + response);
		return Response.status(response.getStatus()).entity(response).build();
	}

}