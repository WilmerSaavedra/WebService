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
import com.cibertec.dao.UsuarioDAOImpl;
import com.cibertec.entidad.UsuarioBean;
@Path("/usuario")
public class UsuarioRest {
	private UsuarioDAOImpl dao;
	
	public UsuarioRest() {
		dao=new UsuarioDAOImpl();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response listaUsuario(){
		return  Response.ok(dao.listAllUsuarios()).build();
	}
	
	@GET
	@Path("/rol/{rol}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response buscarUsuarioxPerfil(@PathParam("rol") int rol){
		return  Response.ok(dao.listAllUsuariosxPerfil(rol)).build();
	}
	
	@GET
	@Path("/{codigo}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response buscarUsuario(@PathParam("codigo") int cod){
		return  Response.ok(dao.findUsuario(cod)).build();
	}
	
	@GET
	@Path("/{login}/{clave}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response ValidarUsuario(@PathParam("login") String login,@PathParam("clave") String clave){
		return  Response.ok(dao.ValidarUsuario(login,clave)).build();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public int registrarUsuario(UsuarioBean bean) {
		return dao.saveUsuario(bean);
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public int actualizarUsuario(UsuarioBean bean) {
		return dao.updateUsuario(bean);
	}	
	
	@DELETE
	@Path("/{codigo}")
	@Produces(MediaType.APPLICATION_JSON)
	public int eliminarUsuario(@PathParam("codigo") int cod) {
		return dao.deleteUsuario(cod);
	}	
	
}








