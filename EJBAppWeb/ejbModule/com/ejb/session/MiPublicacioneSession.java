package com.ejb.session;

import java.util.List;

import javax.ejb.Local;

import com.ejb.model.MiPublicacione;
@Local
public interface MiPublicacioneSession {
	//metodos para el crud
	public MiPublicacione buscar(MiPublicacione mipublicacione);
	public String grabar(MiPublicacione mipublicacione);
	public String actualizar(MiPublicacione c);
	public String eliminar(MiPublicacione c);
	public List<MiPublicacione> listar();
	public MiPublicacione buscarporId(int id);
}
