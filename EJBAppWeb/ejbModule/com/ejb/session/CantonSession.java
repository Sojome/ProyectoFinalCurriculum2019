package com.ejb.session;

import java.util.List;

import javax.ejb.Local;

import com.ejb.model.Canton;

@Local
public interface CantonSession {
	public Canton buscar(Canton canton);
	public String grabar(Canton canton);
	public String actualizar(Canton c);
	public String eliminar(Canton c);
	public List<Canton> listar(int id);
	public Canton buscarporId(int id);
}
