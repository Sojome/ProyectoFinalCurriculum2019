package com.ejb.session;

import java.util.List;

import javax.ejb.Local;

import com.ejb.model.MiParroquia;

@Local
public interface MiParroquiaSession {
	public MiParroquia buscar(MiParroquia canton);
	public String grabar(MiParroquia canton);
	public String actualizar(MiParroquia c);
	public String eliminar(MiParroquia c);
	public List<MiParroquia> listar(int id);
	public MiParroquia buscarporId(int id);
}
