package com.ejb.session;

import java.util.List;

import javax.ejb.Local;

import com.ejb.model.Parroquia;

@Local
public interface ParroquiaSession {
	public Parroquia buscar(Parroquia parroquia);
	public String grabar(Parroquia parroquia);
	public String actualizar(Parroquia p);
	public String eliminar(Parroquia p);
	public List<Parroquia> listar(int id);
	public Parroquia buscarporId(int id);
}
