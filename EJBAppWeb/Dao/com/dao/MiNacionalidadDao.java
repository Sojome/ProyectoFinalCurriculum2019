package com.dao;

import java.util.List;

import javax.ejb.Local;

import com.ejb.model.MiNacionalidad;

@Local
public interface MiNacionalidadDao {
	public MiNacionalidad buscar(MiNacionalidad nacionalidad);
	public String grabar(MiNacionalidad nacionalidad);
	public String actualizar(MiNacionalidad n);
	public String eliminar(MiNacionalidad n);
	public List<MiNacionalidad> listar(int id);
	public MiNacionalidad buscarporId(int id);
}
