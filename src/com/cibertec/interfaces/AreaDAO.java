package com.cibertec.interfaces;
import java.util.List;
import com.cibertec.entidad.AreaBean;
public interface AreaDAO {
	public int saveArea(AreaBean bean);
	public int updateArea(AreaBean bean);
	public int deleteArea(int codigo);
	public AreaBean findArea(int codigo);
	public List<AreaBean> listAllArea();
	public List<AreaBean> listAllAreaxNombre(String nombre);
	
}

