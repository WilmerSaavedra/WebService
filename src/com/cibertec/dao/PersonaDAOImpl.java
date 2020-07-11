package com.cibertec.dao;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.cibertec.entidad.PersonaBean;
import com.cibertec.interfaces.PersonaDAO;

import utils.MysqlDBConexion;
public class PersonaDAOImpl implements PersonaDAO{
	@Override
	public int savePersona(PersonaBean bean){
		int estado=-1;
		Connection cn=null;
		CallableStatement cstm=null;
		try {
			cn=MysqlDBConexion.getConexion();
			String sql="call sp_registrarPersonas(?,?,?,?,?,?,?)";
			cstm=cn.prepareCall(sql);
			cstm.setString(1,bean.getDni());
			cstm.setString(2,bean.getNombre());
			cstm.setString(3,bean.getApellido());
			cstm.setString(4, bean.getDireccion());
			cstm.setString(5, bean.getTelefono());
			cstm.setString(6, bean.getFechaNacimiento());
			cstm.setString(7, bean.getTipo());
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
	public int updatePersona(PersonaBean bean) {
		int estado=-1;
		Connection cn=null;
		CallableStatement cstm=null;
		try {
			cn=MysqlDBConexion.getConexion();
			String sql="call sp_actualizarPersonas(?,?,?,?,?,?,?,?)";
			cstm=cn.prepareCall(sql);
			cstm.setInt(1,bean.getIdpersona());
			cstm.setString(2,bean.getDni());
			cstm.setString(3,bean.getNombre());
			cstm.setString(4,bean.getApellido());
			cstm.setString(5, bean.getDireccion());
			cstm.setString(6, bean.getTelefono());
			cstm.setString(7, bean.getFechaNacimiento());
			cstm.setString(8, bean.getTipo());
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
	public int deletePersona(int codigo) {
		int estado=-1;
		Connection cn=null;
		CallableStatement cstm=null;
		try {
			cn=MysqlDBConexion.getConexion();
			String sql="call sp_eliminarPersonas(?)";
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
	public PersonaBean findPersona(int codigo) {
		PersonaBean bean=null;
		Connection cn=null;
		CallableStatement cstm=null;
		ResultSet rs=null;
		try {
			cn=MysqlDBConexion.getConexion();
			String sql="call sp_buscarPersonas(?)";
			cstm=cn.prepareCall(sql);
			cstm.setInt(1,codigo);
			rs=cstm.executeQuery();
			if(rs.next()) {
				bean=new PersonaBean();
				bean.setIdpersona(rs.getInt(1));
				bean.setDni(rs.getString(2));
				bean.setNombre(rs.getString(3));
				bean.setApellido(rs.getString(4));
				bean.setDireccion(rs.getString(5));
				bean.setTelefono(rs.getString(6));
				bean.setFechaNacimiento(rs.getString(7));
				bean.setTipo(rs.getString(8));
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
	public List<PersonaBean> listAllPersonas(){
		List<PersonaBean> lista=new ArrayList<PersonaBean>();
		PersonaBean bean=null;
		Connection cn=null;
		CallableStatement cstm=null;
		ResultSet rs=null;
		try {
			cn=MysqlDBConexion.getConexion();
			String sql="call sp_listAllPersonas()";
			cstm=cn.prepareCall(sql);
			rs=cstm.executeQuery();
			while(rs.next()) {
				bean=new PersonaBean();
				bean.setIdpersona(rs.getInt(1));
				bean.setDni(rs.getString(2));
				bean.setNombre(rs.getString(3));
				bean.setApellido(rs.getString(4));
				bean.setDireccion(rs.getString(5));
				bean.setTelefono(rs.getString(6));
				bean.setFechaNacimiento(rs.getString(7));
				bean.setTipo(rs.getString(8));
				
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
	public List<PersonaBean> listAllPersonasXSexo(String sexo) {
		List<PersonaBean> lista=new ArrayList<PersonaBean>();
		PersonaBean bean=null;
		Connection cn=null;
		CallableStatement cstm=null;
		ResultSet rs=null;
		try {
			cn=MysqlDBConexion.getConexion();
			String sql="call sp_listAllPersonasxTipo(?)";
			cstm=cn.prepareCall(sql);
			cstm.setString(1, sexo);
			rs=cstm.executeQuery();
			while(rs.next()) {
				bean=new PersonaBean();
				bean.setIdpersona(rs.getInt(1));
				bean.setDni(rs.getString(2));
				bean.setNombre(rs.getString(3));
				bean.setApellido(rs.getString(4));
				bean.setDireccion(rs.getString(5));
				bean.setTelefono(rs.getString(6));
				bean.setFechaNacimiento(rs.getString(7));
				bean.setTipo(rs.getString(8));
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
	public List<PersonaBean> listAllPersonasXAsignaturao(int cod) {
		// TODO Auto-generated method stub
		List<PersonaBean> lista=new ArrayList<PersonaBean>();
		PersonaBean bean=null;
		Connection cn=null;
		CallableStatement cstm=null;
		ResultSet rs=null;
		try {
			cn=MysqlDBConexion.getConexion();
			String sql="call sp_buscarAlumnosParaRegistraNota(?)";
			cstm=cn.prepareCall(sql);
			cstm.setInt(1, cod);
			rs=cstm.executeQuery();
			while(rs.next()) {
				bean=new PersonaBean();
				bean.setIdpersona(rs.getInt(1));
				bean.setApellido(rs.getString(2));
				bean.setNombre(rs.getString(3));

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
}


