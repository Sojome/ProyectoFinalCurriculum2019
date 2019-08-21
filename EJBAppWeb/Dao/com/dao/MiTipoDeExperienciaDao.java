package com.dao;

import java.util.List;

import javax.ejb.Local;

import com.ejb.model.MiTipoDeExperiencia;
@Local
public interface MiTipoDeExperienciaDao {
	//metodos para el crud
	public MiTipoDeExperiencia buscar(MiTipoDeExperiencia mitipodeexperiencia);
	public String grabar(MiTipoDeExperiencia mitipodeexperiencia);
	public String actualizar(MiTipoDeExperiencia c);
	public String eliminar(MiTipoDeExperiencia c);
	public List<MiTipoDeExperiencia> listar();
	public MiTipoDeExperiencia buscarporId(int id);
}
