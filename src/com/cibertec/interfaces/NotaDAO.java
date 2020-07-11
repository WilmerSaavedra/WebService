package com.cibertec.interfaces;
import java.util.List;

import com.cibertec.entidad.NotaBean;

public interface NotaDAO {
	public int saveNota(NotaBean bean);
	public int updateNota(NotaBean bean);
	public int deleteNota(int codigo);
	public NotaBean findNota(int codigo);
	public List<NotaBean> listAllNotas();
	public List<NotaBean> listAllNotasxEvaluacionxAsignatura(int idevaluacion);
	public List<NotaBean> listAllNotasxEvaluacionxAsignaturaxPersona(int idevaluacion,int idpersona);
	
}

