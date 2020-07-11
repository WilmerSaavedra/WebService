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
import com.cibertec.dao.AsignaturaDAOImpl;
import com.cibertec.entidad.AsignaturaBean;
@Path("/asignatura")
public class AsignaturaRest {
	private AsignaturaDAOImpl dao;
	
	public AsignaturaRest() {
		dao=new AsignaturaDAOImpl();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response listaAsignatura(){
		return  Response.ok(dao.listAllAsignatura()).build();
	}
	
	@GET
	@Path("/tipo/{nombre}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response buscarAsignaturaxTipo(@PathParam("nombre") String nombre){
		return  Response.ok(dao.listAllAsignaturaxNombre(nombre)).build();
	}
	
	@GET
	@Path("/persona/{codigo}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response buscarAsignaturaxPersona(@PathParam("codigo") int codigo){
		return  Response.ok(dao.listAllAsignaturaxUsuario(codigo)).build();
	}
	
	@GET
	@Path("/persona/asignatura/{codigo}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response buscarAsignaturaRegistradaxPersona(@PathParam("codigo") int codigo){
		return  Response.ok(dao.listAllAsignaturaResgitradaxUsuario(codigo)).build();
	}
	
	@GET
	@Path("/persona/evaluacion/{codigo}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response buscarEvaluacionAsignatura(@PathParam("codigo") int codigo){
		return  Response.ok(dao.listAllEvaluacionXAsignatura(codigo)).build();
	}
	@GET
	@Path("/{codigo}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response buscarAsignatura(@PathParam("codigo") int cod){
		return  Response.ok(dao.findAsignatura(cod)).build();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public int registrarAsignatura(AsignaturaBean bean) {
		return dao.saveAsignatura(bean);
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public int actualizarDocente(AsignaturaBean bean) {
		return dao.updateAsignatura(bean);
	}	
	
	@DELETE
	@Path("/{codigo}")
	@Produces(MediaType.APPLICATION_JSON)
	public int eliminarAsignatura(@PathParam("codigo") int cod) {
		return dao.deleteAsignatura(cod);
	}	
	
}








