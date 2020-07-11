package com.cibertec.interfaces;
import java.util.List;

import com.cibertec.entidad.EnlaceBean;
public interface EnlaceDAO {
	public EnlaceBean findEnlace(int codigo);
	public List<EnlaceBean> listAllEnlace(int codigo);
	
	
}

