package com.cibertec.entidad;
import java.io.Serializable;

public class CicloBean implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int idciclo;
	private String ciclo;
	public int getIdciclo() {
		return idciclo;
	}
	public void setIdciclo(int idciclo) {
		this.idciclo = idciclo;
	}
	public String getCiclo() {
		return ciclo;
	}
	public void setCiclo(String ciclo) {
		this.ciclo = ciclo;
	}
	
	
	
}

