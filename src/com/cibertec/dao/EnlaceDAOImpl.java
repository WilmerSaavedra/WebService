package com.cibertec.dao;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.cibertec.entidad.EnlaceBean;
import com.cibertec.interfaces.EnlaceDAO;

import utils.MysqlDBConexion;
public class EnlaceDAOImpl implements EnlaceDAO{
	
	@Override
	public EnlaceBean findEnlace(int codigo) {
		EnlaceBean bean=null;
		Connection cn=null;
		CallableStatement cstm=null;
		ResultSet rs=null;
		try {
			cn=MysqlDBConexion.getConexion();
			String sql="call sp_buscarEnlace(?)";
			cstm=cn.prepareCall(sql);
			cstm.setInt(1,codigo);
			rs=cstm.executeQuery();
			if(rs.next()) {
				bean=new EnlaceBean();
				bean.setIdenlace(rs.getInt(1));
				bean.setDescripcion(rs.getString(2));
				bean.setRuta(rs.getString(3));
	
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
	public List<EnlaceBean> listAllEnlace(int codigo){
		List<EnlaceBean> lista=new ArrayList<EnlaceBean>();
		EnlaceBean bean=null;
		Connection cn=null;
		CallableStatement cstm=null;
		ResultSet rs=null;
		try {
			cn=MysqlDBConexion.getConexion();
			String sql="call sp_listAllEnlace(?)";
			cstm=cn.prepareCall(sql);
			cstm.setInt(1, codigo);
			rs=cstm.executeQuery();
			while(rs.next()) {
				bean=new EnlaceBean();			
				bean.setIdenlace(rs.getInt(1));
				bean.setDescripcion(rs.getString(2));
				bean.setRuta(rs.getString(3));
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


