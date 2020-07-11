package com.cibertec.dao;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.cibertec.entidad.DetalleAsignaturaBean;
import com.cibertec.interfaces.DetalleAsignaturaDAO;
import utils.MysqlDBConexion;
public class AsignaturaDetalleDAOImpl implements DetalleAsignaturaDAO{
	@Override
	public int saveDetalleAsignatura(DetalleAsignaturaBean bean){
		int estado=-1;
		Connection cn=null;
		CallableStatement cstm=null;
		try {
			cn=MysqlDBConexion.getConexion();	
			String sql="call SP_saveDetalleAsignatura(?,?)";
			cstm=cn.prepareCall(sql);
			cstm.setInt(2,bean.getIdasignatura());
			cstm.setInt(1,bean.getIdpersona());
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
	public int updateDetalleAsignatura(DetalleAsignaturaBean bean) {
		int estado=-1;
		Connection cn=null;
		CallableStatement cstm=null;
		try {
			cn=MysqlDBConexion.getConexion();	
			String sql="call SP_saveDetalleAsignatura(?)";
			cstm=cn.prepareCall(sql);
			cstm.setInt(1,bean.getIdasignaturapersona());
			cstm.setInt(2,bean.getIdasignatura());
			cstm.setInt(3,bean.getIdpersona());
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
	public int deleteDetalleAsignatura(int codigo) {
		int estado=-1;
		Connection cn=null;
		CallableStatement cstm=null;
		try {
			cn=MysqlDBConexion.getConexion();
			String sql="call SP_deleteDetalleAsignatura(?)";
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
	public DetalleAsignaturaBean findDetalleAsignatura(int codigo) {
		DetalleAsignaturaBean bean=null;
		Connection cn=null;
		CallableStatement cstm=null;
		ResultSet rs=null;
		try {
			cn=MysqlDBConexion.getConexion();
			String sql="call SP_findDetalleAsignatura(?)";
			cstm=cn.prepareCall(sql);
			cstm.setInt(1,codigo);
			rs=cstm.executeQuery();
			if(rs.next()) {
				bean=new DetalleAsignaturaBean();
				bean.setIdasignaturapersona(rs.getInt(1));
				bean.setIdasignatura(rs.getInt(2));
				bean.setIdpersona(rs.getInt(3));
				
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
	public List<DetalleAsignaturaBean> listAllAsignaturaDocente(int idpersona){
		List<DetalleAsignaturaBean> lista=new ArrayList<DetalleAsignaturaBean>();
		DetalleAsignaturaBean bean=null;
		Connection cn=null;
		CallableStatement cstm=null;
		ResultSet rs=null;
		try {
			cn=MysqlDBConexion.getConexion();
			String sql="call SP_listarDetalleAsignaturas(?)";
			cstm=cn.prepareCall(sql);
			cstm.setInt(1, idpersona);
			rs=cstm.executeQuery();
			while(rs.next()) {
				bean=new DetalleAsignaturaBean();
				bean.setIdasignaturapersona(rs.getInt(1));
				bean.setIdasignatura(rs.getInt(2));
				bean.setIdpersona(rs.getInt(3));
				
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
	public List<DetalleAsignaturaBean> listAllAsignaturaAlumno(int idpersona) {
		List<DetalleAsignaturaBean> lista=new ArrayList<DetalleAsignaturaBean>();
		DetalleAsignaturaBean bean=null;
		Connection cn=null;
		CallableStatement cstm=null;
		ResultSet rs=null;
		try {
			cn=MysqlDBConexion.getConexion();
			String sql="call SP_findDetalleAsignatura(?)";
			cstm=cn.prepareCall(sql);
			cstm.setInt(1, idpersona);
			rs=cstm.executeQuery();
			while(rs.next()) {
				bean=new DetalleAsignaturaBean();
				bean.setIdasignaturapersona(rs.getInt(1));
				bean.setIdasignatura(rs.getInt(2));
				bean.setIdpersona(rs.getInt(3));
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
	public List<DetalleAsignaturaBean> listAllDetalleAsignatura() {
		List<DetalleAsignaturaBean> lista=new ArrayList<DetalleAsignaturaBean>();
		DetalleAsignaturaBean bean=null;
		Connection cn=null;
		CallableStatement cstm=null;
		ResultSet rs=null;
		try {
			cn=MysqlDBConexion.getConexion();
			String sql="call SP_findDetalleAsignatura()";
			cstm=cn.prepareCall(sql);
			rs=cstm.executeQuery();
			while(rs.next()) {
				bean=new DetalleAsignaturaBean();
				bean.setIdasignaturapersona(rs.getInt(1));
				bean.setIdasignatura(rs.getInt(2));
				bean.setIdpersona(rs.getInt(3));
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


