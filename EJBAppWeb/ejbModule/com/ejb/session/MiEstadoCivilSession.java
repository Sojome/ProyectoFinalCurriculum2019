package com.ejb.session;

import java.util.List;

import javax.ejb.Local;

import com.ejb.model.MiEstadoCivil;

@Local
public interface MiEstadoCivilSession {
	public MiEstadoCivil buscar(MiEstadoCivil miestadocivil);
	public String grabar(MiEstadoCivil miestadocivil);
	public String actualizar(MiEstadoCivil p);
	public String eliminar(MiEstadoCivil p);
	public List<MiEstadoCivil> listar();
	public MiEstadoCivil buscarporId(int id);
}
