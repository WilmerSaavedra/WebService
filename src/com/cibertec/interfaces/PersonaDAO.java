package com.cibertec.interfaces;
import java.util.List;

import com.cibertec.entidad.PersonaBean;
public interface PersonaDAO {
	public int savePersona(PersonaBean bean);
	public int updatePersona(PersonaBean bean);
	public int deletePersona(int codigo);
	public PersonaBean findPersona(int codigo);
	public List<PersonaBean> listAllPersonas();
	public List<PersonaBean> listAllPersonasXSexo(String tipo);
	public List<PersonaBean> listAllPersonasXAsignaturao(int cod);
}

