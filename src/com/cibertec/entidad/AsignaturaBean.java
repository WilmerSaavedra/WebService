package com.cibertec.entidad;
import java.io.Serializable;

public class AsignaturaBean implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int idasignatura,idarea;
	private AreaBean area;
	private String asignatura;
	public int getIdasignatura() {
		return idasignatura;
	}
	public void setIdasignatura(int idasignatura) {
		this.idasignatura = idasignatura;
	}
	public int getIdarea() {
		return idarea;
	}
	public void setIdarea(int idarea) {
		this.idarea = idarea;
	}
	public AreaBean getArea() {
		return area;
	}
	public void setArea(AreaBean area) {
		this.area = area;
	}
	public String getAsignatura() {
		return asignatura;
	}
	public void setAsignatura(String asignatura) {
		this.asignatura = asignatura;
	}


	
}

