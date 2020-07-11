package com.cibertec.interfaces;
import java.util.List;
import com.cibertec.entidad.AsignaturaBean;
import com.cibertec.entidad.EvaluacionBean;
public interface AsignaturaDAO {
	public int saveAsignatura(AsignaturaBean bean);
	public int updateAsignatura(AsignaturaBean bean);
	public int deleteAsignatura(int codigo);
	public AsignaturaBean findAsignatura(int codigo);
	public List<AsignaturaBean> listAllAsignatura();
	public List<AsignaturaBean> listAllAsignaturaxNombre(String nombre);
	public List<AsignaturaBean> listAllAsignaturaxUsuario(int cod);
	public List<AsignaturaBean> listAllAsignaturaResgitradaxUsuario(int cod);
	public List<EvaluacionBean> listAllEvaluacionXAsignatura(int cod);
}

