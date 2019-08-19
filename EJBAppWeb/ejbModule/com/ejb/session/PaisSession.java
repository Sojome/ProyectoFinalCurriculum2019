package com.ejb.session;

import java.util.List;

import javax.ejb.Local;

import com.ejb.model.Pais;

@Local
public interface PaisSession {
	public Pais buscar(Pais pais);
	public String grabar(Pais pais);
	public String actualizar(Pais p);
	public String eliminar(Pais p);
	public List<Pais> listar();
	public Pais buscarporId(int id);
}
