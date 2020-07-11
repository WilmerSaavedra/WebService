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
import com.cibertec.dao.PersonaDAOImpl;
import com.cibertec.entidad.PersonaBean;
@Path("/persona")
public class PersonaRest {
	private PersonaDAOImpl dao;
	
	public PersonaRest() {
		dao=new PersonaDAOImpl();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response listaPersona(){
		return  Response.ok(dao.listAllPersonas()).build();
	}
	
	@GET
	@Path("/tipo/{tipo}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response buscarPersonaxTipo(@PathParam("tipo") String tipo){
		return  Response.ok(dao.listAllPersonasXSexo(tipo)).build();
	}
	
	@GET
	@Path("/asignatura/{codigo}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response buscarPersonaxAsignatura(@PathParam("codigo") int codigo){
		return  Response.ok(dao.listAllPersonasXAsignaturao(codigo)).build();
	}
	
	@GET
	@Path("/{codigo}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response buscarPersona(@PathParam("codigo") int cod){
		return  Response.ok(dao.findPersona(cod)).build();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public int registrarPersona(PersonaBean bean) {
		return dao.savePersona(bean);
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public int actualizarPersona(PersonaBean bean) {
		return dao.updatePersona(bean);
	}	
	
	@DELETE
	@Path("/{codigo}")
	@Produces(MediaType.APPLICATION_JSON)
	public int eliminarPersona(@PathParam("codigo") int cod) {
		return dao.deletePersona(cod);
	}	
	
}








