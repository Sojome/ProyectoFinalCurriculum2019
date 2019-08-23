package com.dao;

import java.util.List;

import javax.ejb.Local;

import com.ejb.model.MiTitulosObtenido;

@Local
public interface MiTitulosObtenidoDao {
	public MiTitulosObtenido buscar(MiTitulosObtenido mititulosobtenido);
	public String grabar(MiTitulosObtenido mititulosobtenido);
	public String actualizar(MiTitulosObtenido m);
	public String eliminar(MiTitulosObtenido m);
	public List<MiTitulosObtenido> listar();
	public MiTitulosObtenido buscarporId(int id);
}
