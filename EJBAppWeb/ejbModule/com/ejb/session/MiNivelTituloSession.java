package com.ejb.session;

import java.util.List;

import javax.ejb.Local;

import com.ejb.model.MiNivelTitulo;
@Local
public interface MiNivelTituloSession {
	//metodos para el crud
	public MiNivelTitulo buscar(MiNivelTitulo miniveltitulo);
	public String grabar(MiNivelTitulo miniveltitulo);
	public String actualizar(MiNivelTitulo c);
	public String eliminar(MiNivelTitulo c);
	public List<MiNivelTitulo> listar();
	public MiNivelTitulo buscarporId(int id);
}
