package com.ejb.session;

import java.util.List;

import javax.ejb.Local;

import com.ejb.model.MiNacionalidad;

@Local
public interface MiNacionalidadSession {
	public MiNacionalidad buscar(MiNacionalidad canton);
	public String grabar(MiNacionalidad canton);
	public String actualizar(MiNacionalidad c);
	public String eliminar(MiNacionalidad c);
	public List<MiNacionalidad> listar(int id);
	public MiNacionalidad buscarporId(int id);
}
