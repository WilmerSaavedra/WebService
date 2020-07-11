package com.cibertec.entidad;
import java.io.Serializable;

public class NotaBean implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int idnota,idpersona,idevaluacion;
	private double nota;
	public int getIdnota() {
		return idnota;
	}
	public void setIdnota(int idnota) {
		this.idnota = idnota;
	}
	public int getIdpersona() {
		return idpersona;
	}
	public void setIdpersona(int idpersona) {
		this.idpersona = idpersona;
	}
	public int getIdevaluacion() {
		return idevaluacion;
	}
	public void setIdevaluacion(int idevaluacion) {
		this.idevaluacion = idevaluacion;
	}
	public double getNota() {
		return nota;
	}
	public void setNota(double nota) {
		this.nota = nota;
	}
	

	
}

