package com.wooha.restaurant.services;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.wooha.restaurant.beans.Table;

@Path("/hello")
public class HelloWorldService {

	@GET
	@Path("/{param}")
	public Response getMsg(@PathParam("param") String msg) {
 
		String output = "Jersey say : " + msg;
 
		return Response.status(200).entity(output).build();
 
	}
	
	@GET
	@Path("/")
	@Produces({MediaType.APPLICATION_JSON})
	public String getJsonResponse(){
		List<Table> tables = new ArrayList<Table>();
		tables.add(new Table());
		tables.add(new Table());
		tables.add(new Table());
		tables.add(new Table());
		tables.add(new Table());
		
		return tables.toString();
	}
	
}
