package com.cibertec.dao;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.cibertec.entidad.AreaBean;
import com.cibertec.entidad.AsignaturaBean;
import com.cibertec.entidad.EvaluacionBean;
import com.cibertec.interfaces.AsignaturaDAO;
import utils.MysqlDBConexion;
public class AsignaturaDAOImpl implements AsignaturaDAO{
	@Override
	public int saveAsignatura(AsignaturaBean bean){
		int estado=-1;
		Connection cn=null;
		CallableStatement cstm=null;
		try {
			cn=MysqlDBConexion.getConexion();	
			String sql="call sp_registrarAsignatura(?,?)";
			cstm=cn.prepareCall(sql);
			cstm.setString(1,bean.getAsignatura());
			cstm.setInt(2,bean.getIdarea());
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
	public int updateAsignatura(AsignaturaBean bean) {
		int estado=-1;
		Connection cn=null;
		CallableStatement cstm=null;
		try {
			cn=MysqlDBConexion.getConexion();	
			String sql="call sp_actualizarAsignatura(?,?,?)";
			cstm=cn.prepareCall(sql);
			cstm.setInt(1,bean.getIdasignatura());
			cstm.setString(2,bean.getAsignatura());
			cstm.setInt(3,bean.getIdarea());
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
	public int deleteAsignatura(int codigo) {
		int estado=-1;
		Connection cn=null;
		CallableStatement cstm=null;
		try {
			cn=MysqlDBConexion.getConexion();
			String sql="call sp_eliminarAsignatura(?)";
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
	public AsignaturaBean findAsignatura(int codigo) {
		AsignaturaBean bean=null;
		AreaBean beanA=null;
		Connection cn=null;
		CallableStatement cstm=null;
		ResultSet rs=null;
		try {
			cn=MysqlDBConexion.getConexion();
			String sql="call sp_buscarAsignatura(?)";
			cstm=cn.prepareCall(sql);
			cstm.setInt(1,codigo);
			rs=cstm.executeQuery();
			if(rs.next()) {
				bean=new AsignaturaBean();
				beanA=new AreaBean();
				bean.setIdasignatura(rs.getInt(1));
				bean.setAsignatura(rs.getString(2));
				beanA.setIdarea(rs.getInt(3));
				beanA.setArea(rs.getString(4));
				bean.setArea(beanA);
				
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
	public List<AsignaturaBean> listAllAsignatura(){
		List<AsignaturaBean> lista=new ArrayList<AsignaturaBean>();
		AsignaturaBean bean=null;
		AreaBean beanA=null;

		Connection cn=null;
		CallableStatement cstm=null;
		ResultSet rs=null;
		try {
			cn=MysqlDBConexion.getConexion();
			String sql="call sp_listAllAsignatura()";
			cstm=cn.prepareCall(sql);
			rs=cstm.executeQuery();
			while(rs.next()) {
				bean=new AsignaturaBean();
				beanA=new AreaBean();
				bean.setIdasignatura(rs.getInt(1));
				bean.setAsignatura(rs.getString(2));
				beanA.setIdarea(rs.getInt(3));
				beanA.setArea(rs.getString(4));
				bean.setArea(beanA);
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
	public List<AsignaturaBean> listAllAsignaturaxNombre(String nombre) {
		List<AsignaturaBean> lista=new ArrayList<AsignaturaBean>();
		AsignaturaBean bean=null;
		AreaBean beanA=null;
		Connection cn=null;
		CallableStatement cstm=null;
		ResultSet rs=null;
		try {
			cn=MysqlDBConexion.getConexion();
			String sql="call SP_findAsignatura(?)";
			cstm=cn.prepareCall(sql);
			cstm.setString(1, nombre);
			rs=cstm.executeQuery();
			while(rs.next()) {
				bean=new AsignaturaBean();
				beanA=new AreaBean();
				bean.setIdasignatura(rs.getInt(1));
				bean.setAsignatura(rs.getString(2));
				beanA.setIdarea(rs.getInt(3));
				beanA.setArea(rs.getString(4));
				bean.setArea(beanA);
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
	public List<AsignaturaBean> listAllAsignaturaxUsuario(int cod) {
		// TODO Auto-generated method stub
		List<AsignaturaBean> lista=new ArrayList<AsignaturaBean>();
		AsignaturaBean bean=null;
		AreaBean beanA=null;
		Connection cn=null;
		CallableStatement cstm=null;
		ResultSet rs=null;
		try {
			cn=MysqlDBConexion.getConexion();
			String sql="call sp_buscarAsignaturaxPersona(?)";
			cstm=cn.prepareCall(sql);
			cstm.setInt(1, cod);
			rs=cstm.executeQuery();
			while(rs.next()) {
				bean=new AsignaturaBean();
				beanA=new AreaBean();
				bean.setIdasignatura(rs.getInt(1));
				bean.setAsignatura(rs.getString(2));
				beanA.setIdarea(rs.getInt(3));
				beanA.setArea(rs.getString(4));
				bean.setArea(beanA);
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
	public List<AsignaturaBean> listAllAsignaturaResgitradaxUsuario(int cod) {
		// TODO Auto-generated method stub
				List<AsignaturaBean> lista=new ArrayList<AsignaturaBean>();
				AsignaturaBean bean=null;
			
				Connection cn=null;
				CallableStatement cstm=null;
				ResultSet rs=null;
				try {
					cn=MysqlDBConexion.getConexion();
					String sql="call sp_buscarAsignaturaRregistradaPersona(?)";
					cstm=cn.prepareCall(sql);
					cstm.setInt(1, cod);
					rs=cstm.executeQuery();
					while(rs.next()) {
						bean=new AsignaturaBean();
					
						bean.setIdasignatura(rs.getInt(1));
						bean.setAsignatura(rs.getString(2));
						
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
	public List<EvaluacionBean> listAllEvaluacionXAsignatura(int cod) {
		// TODO Auto-generated method stub
		List<EvaluacionBean> lista=new ArrayList<EvaluacionBean>();
		EvaluacionBean bean=null;
	
		Connection cn=null;
		CallableStatement cstm=null;
		ResultSet rs=null;
		try {
			cn=MysqlDBConexion.getConexion();
			String sql="call sp_buscarevaluacionxAsignatura(?)";
			cstm=cn.prepareCall(sql);
			cstm.setInt(1, cod);
			rs=cstm.executeQuery();
			while(rs.next()) {
				bean=new EvaluacionBean();
			
				bean.setIdevaluacion(rs.getInt(1));
				bean.setEvaluacion(rs.getString(2));
				
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


