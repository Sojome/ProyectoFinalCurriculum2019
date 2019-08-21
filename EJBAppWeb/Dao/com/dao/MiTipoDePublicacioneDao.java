package com.dao;

import java.util.List;

import javax.ejb.Local;

import com.ejb.model.MiTipoDePublicacione;
@Local
public interface MiTipoDePublicacioneDao {
	//metodos para el crud
	public MiTipoDePublicacione buscar(MiTipoDePublicacione mitipodepublicacione);
	public String grabar(MiTipoDePublicacione mitipodepublicacione);
	public String actualizar(MiTipoDePublicacione c);
	public String eliminar(MiTipoDePublicacione c);
	public List<MiTipoDePublicacione> listar();
	public MiTipoDePublicacione buscarporId(int id);
}
