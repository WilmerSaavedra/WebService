package com.cibertec.dao;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.cibertec.entidad.NotaBean;
import com.cibertec.interfaces.NotaDAO;

import utils.MysqlDBConexion;
public class NotaDAOImpl implements NotaDAO{
	@Override
	public int saveNota(NotaBean bean){
		int estado=-1;
		Connection cn=null;
		CallableStatement cstm=null;
		try {
			cn=MysqlDBConexion.getConexion();
			String sql="call sp_registrarNotas(?,?,?)";
			cstm=cn.prepareCall(sql);
			
			cstm.setInt(1,bean.getIdpersona());
			cstm.setInt(2, bean.getIdevaluacion());
	
			cstm.setDouble(3, bean.getNota());

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
	public int updateNota(NotaBean bean) {
		int estado=-1;
		Connection cn=null;
		CallableStatement cstm=null;
		try {
			cn=MysqlDBConexion.getConexion();
			String sql="call sp_actualizarNotas(?,?,?,?)";
			cstm=cn.prepareCall(sql);
			cstm.setInt(1,bean.getIdnota());

			cstm.setInt(2,bean.getIdpersona());
			cstm.setInt(3, bean.getIdevaluacion());

			cstm.setDouble(4, bean.getNota());
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
	public int deleteNota(int codigo) {
		int estado=-1;
		Connection cn=null;
		CallableStatement cstm=null;
		try {
			cn=MysqlDBConexion.getConexion();
			String sql="call sp_eliminarNotas(?)";
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
	public NotaBean findNota(int codigo) {
		NotaBean bean=null;
		Connection cn=null;
		CallableStatement cstm=null;
		ResultSet rs=null;
		try {
			cn=MysqlDBConexion.getConexion();
			String sql="call sp_buscarNotas(?)";
			cstm=cn.prepareCall(sql);
			cstm.setInt(1,codigo);
			rs=cstm.executeQuery();
			if(rs.next()) {
				bean=new NotaBean();
				cstm.setInt(1,bean.getIdnota());

				cstm.setInt(2,bean.getIdpersona());
				cstm.setInt(3, bean.getIdevaluacion());

				cstm.setDouble(4, bean.getNota());
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
	public List<NotaBean> listAllNotas(){
		List<NotaBean> lista=new ArrayList<NotaBean>();
		NotaBean bean=null;
		Connection cn=null;
		CallableStatement cstm=null;
		ResultSet rs=null;
		try {
			cn=MysqlDBConexion.getConexion();
			String sql="call sp_listAllNotas()";
			cstm=cn.prepareCall(sql);
			rs=cstm.executeQuery();
			while(rs.next()) {
				bean=new NotaBean();
				cstm.setInt(1,bean.getIdnota());

				cstm.setInt(2,bean.getIdpersona());
				cstm.setInt(3, bean.getIdevaluacion());

				cstm.setDouble(4, bean.getNota());
				
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
	public List<NotaBean> listAllNotasxEvaluacionxAsignatura(int idevaluacion) {
		List<NotaBean> lista=new ArrayList<NotaBean>();
		NotaBean bean=null;
		Connection cn=null;
		CallableStatement cstm=null;
		ResultSet rs=null;
		try {
			cn=MysqlDBConexion.getConexion();
			String sql="call sp_buscarNotasxevayasig(1)";
			cstm=cn.prepareCall(sql);
			cstm.setInt(1, idevaluacion);
			rs=cstm.executeQuery();
			while(rs.next()) {
				bean=new NotaBean();
				cstm.setInt(1,bean.getIdnota());

				cstm.setInt(2,bean.getIdpersona());
				cstm.setInt(3, bean.getIdevaluacion());

				cstm.setDouble(4, bean.getNota());
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
	public List<NotaBean> listAllNotasxEvaluacionxAsignaturaxPersona(int idevaluacion,
			int idpersona) {
		List<NotaBean> lista=new ArrayList<NotaBean>();
		NotaBean bean=null;
		Connection cn=null;
		CallableStatement cstm=null;
		ResultSet rs=null;
		try {
			cn=MysqlDBConexion.getConexion();
			String sql="call sp_buscarNotasxevayasigpers(?)";
			cstm=cn.prepareCall(sql);
			cstm.setInt(1, idevaluacion);
			cstm.setInt(2, idpersona);
	
			rs=cstm.executeQuery();
			while(rs.next()) {
				bean=new NotaBean();
				cstm.setInt(1,bean.getIdnota());

				cstm.setInt(2,bean.getIdpersona());
				cstm.setInt(3, bean.getIdevaluacion());

				cstm.setDouble(4, bean.getNota());
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


