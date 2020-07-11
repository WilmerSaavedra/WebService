package com.cibertec.interfaces;
import java.util.List;
import com.cibertec.entidad.DetalleAsignaturaBean;
public interface DetalleAsignaturaDAO {
	public int saveDetalleAsignatura(DetalleAsignaturaBean bean);
	public int updateDetalleAsignatura(DetalleAsignaturaBean bean);
	public int deleteDetalleAsignatura(int codigo);
	public DetalleAsignaturaBean findDetalleAsignatura(int codigo);
	public List<DetalleAsignaturaBean> listAllDetalleAsignatura();
	public List<DetalleAsignaturaBean> listAllAsignaturaDocente(int idpersona);
	public List<DetalleAsignaturaBean> listAllAsignaturaAlumno(int idpersona);
	
}

