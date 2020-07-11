package com.cibertec.interfaces;
import java.util.List;

import com.cibertec.entidad.RolBean;
public interface RolDAO {
	public RolBean findUsuario(int codigo);
	public List<RolBean> listAllRol();
	
	
}

