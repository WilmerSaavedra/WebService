package com.cibertec.dao;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.cibertec.entidad.AreaBean;
import com.cibertec.interfaces.AreaDAO;
import utils.MysqlDBConexion;
public class AreaDAOImpl implements AreaDAO{
	@Override
	public int saveArea(AreaBean bean){
		int estado=-1;
		Connection cn=null;
		CallableStatement cstm=null;
		try {
			cn=MysqlDBConexion.getConexion();	
			String sql="call sp_registrarArea(?)";
			cstm=cn.prepareCall(sql);
			cstm.setString(1,bean.getArea());
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
	public int updateArea(AreaBean bean) {
		int estado=-1;
		Connection cn=null;
		CallableStatement cstm=null;
		try {
			cn=MysqlDBConexion.getConexion();	
			String sql="call sp_actualizarArea(?)";
			cstm=cn.prepareCall(sql);
			cstm.setString(1,bean.getArea());
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
	public int deleteArea(int codigo) {
		int estado=-1;
		Connection cn=null;
		CallableStatement cstm=null;
		try {
			cn=MysqlDBConexion.getConexion();
			String sql="call sp_eliminarArea(?)";
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
	public AreaBean findArea(int codigo) {
		AreaBean bean=null;
		Connection cn=null;
		CallableStatement cstm=null;
		ResultSet rs=null;
		try {
			cn=MysqlDBConexion.getConexion();
			String sql="call sp_buscarArea(?)";
			cstm=cn.prepareCall(sql);
			cstm.setInt(1,codigo);
			rs=cstm.executeQuery();
			if(rs.next()) {
				bean=new AreaBean();
				bean.setIdarea(rs.getInt(1));
				bean.setArea(rs.getString(2));
				
				
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
	public List<AreaBean> listAllArea(){
		List<AreaBean> lista=new ArrayList<AreaBean>();
		AreaBean bean=null;
		Connection cn=null;
		CallableStatement cstm=null;
		ResultSet rs=null;
		try {
			cn=MysqlDBConexion.getConexion();
			String sql="call sp_listAllArea()";
			cstm=cn.prepareCall(sql);
			rs=cstm.executeQuery();
			while(rs.next()) {
				bean=new AreaBean();
				bean.setIdarea(rs.getInt(1));
				bean.setArea(rs.getString(2));
				
				
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
	public List<AreaBean> listAllAreaxNombre(String nombre) {
		List<AreaBean> lista=new ArrayList<AreaBean>();
		AreaBean bean=null;
		Connection cn=null;
		CallableStatement cstm=null;
		ResultSet rs=null;
		try {
			cn=MysqlDBConexion.getConexion();
			String sql="call SP_findArea(?)";
			cstm=cn.prepareCall(sql);
			cstm.setString(1, nombre);
			rs=cstm.executeQuery();
			while(rs.next()) {
				bean=new AreaBean();
				bean.setIdarea(rs.getInt(1));
				bean.setArea(rs.getString(2));
//			sdfds
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


