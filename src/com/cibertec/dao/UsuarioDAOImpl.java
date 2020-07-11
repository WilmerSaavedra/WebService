package com.cibertec.dao;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.cibertec.entidad.UsuarioBean;
import com.cibertec.interfaces.UsuarioDAO;

import utils.MysqlDBConexion;
public class UsuarioDAOImpl implements UsuarioDAO{
	@Override
	public int saveUsuario(UsuarioBean bean){
		int estado=-1;
		Connection cn=null;
		CallableStatement cstm=null;
		try {
			cn=MysqlDBConexion.getConexion();
			String sql="call sp_registrarUsuario(?,?,?,?)";
			cstm=cn.prepareCall(sql);
			cstm.setString(1,bean.getLogin());
			cstm.setString(2,bean.getClave());
			cstm.setString(3,bean.getCorreo());
			cstm.setInt(4,bean.getIdpersona());
			
			System.out.println("SENTENCIA : "+cstm+"--");
			estado=cstm.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();	
		}
		finally{
			try {
				if(cstm!=null) cstm.close();
				if(cn!=null) cn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return estado;
	}
	@Override
	public int updateUsuario(UsuarioBean bean) {
		int estado=-1;
		Connection cn=null;
		CallableStatement cstm=null;
		try {
			cn=MysqlDBConexion.getConexion();
			String sql="call sp_actualizarUsuario(?,?,?,?)";
			cstm=cn.prepareCall(sql);
			cstm.setInt(1,bean.getIdusuario());
			cstm.setString(2,bean.getLogin());
			cstm.setString(3,bean.getClave());
			cstm.setString(4,bean.getCorreo());

			estado=cstm.executeUpdate();
			System.out.println("SENTENCIA : "+cstm+"--");
		} catch (Exception e) {
			e.printStackTrace();	
		}
		finally{
			try {
				if(cstm!=null) cstm.close();
				if(cn!=null) cn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return estado;
	}
	@Override
	public int deleteUsuario(int codigo) {
		int estado=-1;
		Connection cn=null;
		CallableStatement cstm=null;
		try {
			cn=MysqlDBConexion.getConexion();
			String sql="call sp_eliminarUsuario(?)";
			cstm=cn.prepareCall(sql);
			cstm.setInt(1,codigo);
			System.out.println("SENTENCIA : "+cstm+"--");
			estado=cstm.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();	
		}
		finally{
			try {
				if(cstm!=null) cstm.close();
				if(cn!=null) cn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return estado;
	}
	@Override
	public UsuarioBean findUsuario(int codigo) {
		UsuarioBean bean=null;
		Connection cn=null;
		CallableStatement cstm=null;
		ResultSet rs=null;
		try {
			cn=MysqlDBConexion.getConexion();
			String sql="call sp_buscarUsuario(?)";
			cstm=cn.prepareCall(sql);
			cstm.setInt(1,codigo);
			rs=cstm.executeQuery();
			if(rs.next()) {
				bean=new UsuarioBean();
				bean.setIdusuario(rs.getInt(1));
				bean.setLogin(rs.getString(2));
				bean.setClave(rs.getString(3));
				bean.setCorreo(rs.getString(4));
				bean.setIdpersona(rs.getInt(5));
			}
		} catch (Exception e) {
			e.printStackTrace();	
		}
		finally{
			try {
				if(rs!=null) rs.close();
				if(cstm!=null) cstm.close();
				if(cn!=null) cn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return bean;
	}	
	@Override
	public List<UsuarioBean> listAllUsuarios(){
		List<UsuarioBean> lista=new ArrayList<UsuarioBean>();
		UsuarioBean bean=null;
		Connection cn=null;
		CallableStatement cstm=null;
		ResultSet rs=null;
		try {
			cn=MysqlDBConexion.getConexion();
			String sql="call sp_listAllUsuario()";
			cstm=cn.prepareCall(sql);
			rs=cstm.executeQuery();
			while(rs.next()) {
				bean=new UsuarioBean();			
				bean.setIdusuario(rs.getInt(1));
				bean.setLogin(rs.getString(2));
				bean.setClave(rs.getString(3));
				bean.setCorreo(rs.getString(4));
				bean.setIdpersona(rs.getInt(5));
				lista.add(bean);
			}
		} catch (Exception e) {
			e.printStackTrace();	
		}
		finally{
			try {
				if(rs!=null) rs.close();
				if(cstm!=null) cstm.close();
				if(cn!=null) cn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return lista;
	}
	@Override
	public List<UsuarioBean> listAllUsuariosxPerfil(int idrol) {
		List<UsuarioBean> lista=new ArrayList<UsuarioBean>();
		UsuarioBean bean=null;
		Connection cn=null;
		CallableStatement cstm=null;
		ResultSet rs=null;
		try {
			cn=MysqlDBConexion.getConexion();
			String sql="call sp_buscarUsusarioxRol(?)";
			cstm=cn.prepareCall(sql);
			cstm.setInt(1, idrol);
			rs=cstm.executeQuery();
			while(rs.next()) {
				bean=new UsuarioBean();
				bean.setIdusuario(rs.getInt(1));
				bean.setLogin(rs.getString(2));
				bean.setClave(rs.getString(3));
				bean.setCorreo(rs.getString(4));
				bean.setIdpersona(rs.getInt(5));
				lista.add(bean);
			}
		} catch (Exception e) {
			e.printStackTrace();	
		}
		finally{
			try {
				if(rs!=null) rs.close();
				if(cstm!=null) cstm.close();
				if(cn!=null) cn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return lista;
	}
	@Override
	public UsuarioBean ValidarUsuario(String login,String clave) {
		UsuarioBean bean=null;
		Connection cn=null;
		CallableStatement cstm=null;
		ResultSet rs=null;
		try {
			cn=MysqlDBConexion.getConexion();
			String sql="call sp_validaUsaurio(?,?)";
			cstm=cn.prepareCall(sql);
			cstm.setString(1,login);
			cstm.setString(2,clave);
			rs=cstm.executeQuery();
			if(rs.next()) {
				bean=new UsuarioBean();
				bean.setIdusuario(rs.getInt(1));
				bean.setLogin(rs.getString(2));
				bean.setClave(rs.getString(3));
				bean.setCorreo(rs.getString(4));
				bean.setIdpersona(rs.getInt(5));
			}
		} catch (Exception e) {
			e.printStackTrace();	
		}
		finally{
			try {
				if(rs!=null) rs.close();
				if(cstm!=null) cstm.close();
				if(cn!=null) cn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return bean;
	}
}


