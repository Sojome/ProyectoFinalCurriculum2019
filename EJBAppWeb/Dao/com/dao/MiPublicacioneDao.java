package com.dao;

import java.util.List;

import javax.ejb.Local;

import com.ejb.model.MiPublicacione;
@Local
public interface MiPublicacioneDao {
	//metodos para el crud
	public MiPublicacione buscar(MiPublicacione mipublicacione);
	public String grabar(MiPublicacione mipublicacione);
	public String actualizar(MiPublicacione c);
	public String eliminar(MiPublicacione c);
	public List<MiPublicacione> listar();
	public MiPublicacione buscarporId(int id);
}
