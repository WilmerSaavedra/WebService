package com.cibertec.entidad;
import java.io.Serializable;

public class EvaluacionBean implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int idevaluacion;
	private String evaluacion;
	public int getIdevaluacion() {
		return idevaluacion;
	}
	public void setIdevaluacion(int idevaluacion) {
		this.idevaluacion = idevaluacion;
	}
	public String getEvaluacion() {
		return evaluacion;
	}
	public void setEvaluacion(String evaluacion) {
		this.evaluacion = evaluacion;
	}
	
	
}

