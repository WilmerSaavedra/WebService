package com.cibertec.entidad;
import java.io.Serializable;
public class RolBean implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int idrol;
	private String descripcion;
	public int getIdrol() {
		return idrol;
	}
	public void setIdrol(int idrol) {
		this.idrol = idrol;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	

	
}

