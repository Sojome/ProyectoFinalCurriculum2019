package com.dao;

import java.util.List;

import javax.ejb.Local;

import com.ejb.model.MiCanton;

@Local
public interface MiCantonDao {
	public MiCanton buscar(MiCanton canton);
	public String grabar(MiCanton canton);
	public String actualizar(MiCanton c);
	public String eliminar(MiCanton c);
	public List<MiCanton> listar(int id);
	public MiCanton buscarporId(int id);
}
