package com.cibertec.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import com.cibertec.dao.RolDAOImpl;
@Path("/rol")
public class RolRest {
	private RolDAOImpl dao;
	
	public RolRest() {
		dao=new RolDAOImpl();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response listaRol(){
		return  Response.ok(dao.listAllRol()).build();
	}

	
	@GET
	@Path("/{codigo}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response buscarRol(@PathParam("codigo") int cod){
		return  Response.ok(dao.findUsuario(cod)).build();
	}
	

	
}








