package com.cibertec.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import com.cibertec.dao.EnlaceDAOImpl;
@Path("/enlace")
public class EnlaceRest {
	private EnlaceDAOImpl dao;
	
	public EnlaceRest() {
		dao=new EnlaceDAOImpl();
	}
	
	@GET
	@Path("/{codigo}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response listaEnlace(@PathParam("codigo") int codigo){
		return  Response.ok(dao.listAllEnlace(codigo)).build();
	}

	
	@GET
	@Path("/bean/{codigo}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response buscarEnlace(@PathParam("codigo") int cod){
		return  Response.ok(dao.findEnlace(cod)).build();
	}
	

	
}








