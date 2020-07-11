package com.cibertec.interfaces;
import java.util.List;

import com.cibertec.entidad.UsuarioBean;
public interface UsuarioDAO {
	public int saveUsuario(UsuarioBean bean);
	public int updateUsuario(UsuarioBean bean);
	public int deleteUsuario(int codigo);
	public UsuarioBean findUsuario(int codigo);
	public UsuarioBean ValidarUsuario(String login,String clave);
	public List<UsuarioBean> listAllUsuarios();
	public List<UsuarioBean> listAllUsuariosxPerfil(int idrol);
	
}

