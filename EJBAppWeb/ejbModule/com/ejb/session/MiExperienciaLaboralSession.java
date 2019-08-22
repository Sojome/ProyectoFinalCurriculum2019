package com.ejb.session;

import java.util.List;

import javax.ejb.Local;

import com.ejb.model.MiExperienciaLaboral;
@Local
public interface MiExperienciaLaboralSession {
	//metodos para el crud
	public MiExperienciaLaboral buscar(MiExperienciaLaboral miexperiencialaboral);
	public String grabar(MiExperienciaLaboral miexperiencialaboral);
	public String actualizar(MiExperienciaLaboral c);
	public String eliminar(MiExperienciaLaboral c);
	public List<MiExperienciaLaboral> listar();
	public MiExperienciaLaboral buscarporId(int id);
}
