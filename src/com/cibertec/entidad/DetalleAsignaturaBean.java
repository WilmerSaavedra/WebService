package com.cibertec.entidad;
import java.io.Serializable;

public class DetalleAsignaturaBean implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int idasignatura,idasignaturapersona;
	private int idpersona;
	public int getIdasignatura() {
		return idasignatura;
	}
	public void setIdasignatura(int idasignatura) {
		this.idasignatura = idasignatura;
	}
	public int getIdpersona() {
		return idpersona;
	}
	public void setIdpersona(int idpersona) {
		this.idpersona = idpersona;
	}
	public int getIdasignaturapersona() {
		return idasignaturapersona;
	}
	public void setIdasignaturapersona(int idasignaturapersona) {
		this.idasignaturapersona = idasignaturapersona;
	}
	
	
}

