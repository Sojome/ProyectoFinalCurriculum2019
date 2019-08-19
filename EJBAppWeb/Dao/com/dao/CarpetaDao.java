package com.dao;

import java.util.List;

import javax.ejb.Local;

import com.ejb.model.Carpeta;
@Local
public interface CarpetaDao {
	//metodos para el crud
	public Carpeta buscar(Carpeta carpeta);
	public String grabar(Carpeta carpeta);
	public String actualizar(Carpeta c);
	public String eliminar(Carpeta c);
	public List<Carpeta> listar();
	public Carpeta buscarporId(int id);
}
