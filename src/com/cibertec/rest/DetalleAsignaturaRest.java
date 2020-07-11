package com.cibertec.rest;


import java.util.List;

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
import com.cibertec.dao.AsignaturaDetalleDAOImpl;
import com.cibertec.entidad.DetalleAsignaturaBean;
@Path("/detalleasignatura")
public class DetalleAsignaturaRest {
	private AsignaturaDetalleDAOImpl dao;
	
	public DetalleAsignaturaRest() {
		dao=new AsignaturaDetalleDAOImpl();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response listaAsignaturaDetalle(){
		return  Response.ok(dao.listAllDetalleAsignatura()).build();
	}
	
	@GET
	@Path("/docente/{codigo}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response buscarAsignaturaDetallexTipoDocente(@PathParam("codigo") int codigo){
		return  Response.ok(dao.listAllAsignaturaDocente(codigo)).build();
	}
	@GET
	@Path("/alumno/{codigo}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response buscarAsignaturaDetallexAlumno(@PathParam("codigo") int codigo){
		return  Response.ok(dao.listAllAsignaturaAlumno(codigo)).build();
	}
	
	@GET
	@Path("/{codigo}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response buscarAsignaturaDetalle(@PathParam("codigo") int cod){
		return  Response.ok(dao.findDetalleAsignatura(cod)).build();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public int registrarAsignaturaDetalle(DetalleAsignaturaBean bean) {
		return dao.saveDetalleAsignatura(bean);
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public int actualizarDocente(DetalleAsignaturaBean bean) {
		return dao.updateDetalleAsignatura(bean);
	}	
	
	@DELETE
	@Path("/{codigo}")
	@Produces(MediaType.APPLICATION_JSON)
	public int eliminarAsignaturaDetalle(@PathParam("codigo") int cod) {
		return dao.deleteDetalleAsignatura(cod);
	}	
	
}








