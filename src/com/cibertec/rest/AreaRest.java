package com.cibertec.rest;


import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import com.cibertec.dao.AreaDAOImpl;
import com.cibertec.entidad.AreaBean;
@Path("/area")
public class AreaRest {
	private AreaDAOImpl dao;
	
	public AreaRest() {
		dao=new AreaDAOImpl();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response listaArea(){
		return  Response.ok(dao.listAllArea()).build();
	}
	
	
	@GET
	@Path("/{codigo}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response buscarArea(@PathParam("codigo") int cod){
		return  Response.ok(dao.findArea(cod)).build();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public int registrarArea(AreaBean bean) {
		return dao.saveArea(bean);
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public int actualizarDocente(AreaBean bean) {
		return dao.updateArea(bean);
	}	
	
	@DELETE
	@Path("/{codigo}")
	@Produces(MediaType.APPLICATION_JSON)
	public int eliminarArea(@PathParam("codigo") int cod) {
		return dao.deleteArea(cod);
	}	
	
}








