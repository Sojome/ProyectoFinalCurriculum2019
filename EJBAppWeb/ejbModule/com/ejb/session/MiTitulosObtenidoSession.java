package com.ejb.session;

import java.util.List;

import javax.ejb.Local;

import com.ejb.model.MiTitulosObtenido;

@Local
public interface MiTitulosObtenidoSession {
	public MiTitulosObtenido buscar(MiTitulosObtenido mititulosobtenido);
	public String grabar(MiTitulosObtenido mititulosobtenido);
	public String actualizar(MiTitulosObtenido c);
	public String eliminar(MiTitulosObtenido c);
	public List<MiTitulosObtenido> listar();
	public MiTitulosObtenido buscarporId(int id);
}
