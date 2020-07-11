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
import com.cibertec.dao.NotaDAOImpl;
import com.cibertec.entidad.NotaBean;
@Path("/notas")
public class NotaRest {
	private NotaDAOImpl dao;
	
	public NotaRest() {
		dao=new NotaDAOImpl();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response listaNota(){
		return  Response.ok(dao.listAllNotas()).build();
	}
	
	@GET
	@Path("/evaluacion/{idevaluacion}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response buscarNotaxTipo(@PathParam("evaluacion") int idevaluacion){
		return  Response.ok(dao.listAllNotasxEvaluacionxAsignatura(idevaluacion)).build();
	}
	@GET
	@Path("/evaluacion/{idevaluacion}/{idpersona}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response buscarNotaxTipo(@PathParam("evaluacion") int idevaluacion,@PathParam("idpersona") int idpersona){
		return  Response.ok(dao.listAllNotasxEvaluacionxAsignaturaxPersona(idevaluacion, idpersona)).build();
	}
	
	@GET
	@Path("/{codigo}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response buscarNota(@PathParam("codigo") int cod){
		return  Response.ok(dao.findNota(cod)).build();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public int registrarNota(NotaBean bean) {
		return dao.saveNota(bean);
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public int actualizarNota(NotaBean bean) {
		return dao.updateNota(bean);
	}	
	
	@DELETE
	@Path("/{codigo}")
	@Produces(MediaType.APPLICATION_JSON)
	public int eliminarNota(@PathParam("codigo") int cod) {
		return dao.deleteNota(cod);
	}	
	
}








