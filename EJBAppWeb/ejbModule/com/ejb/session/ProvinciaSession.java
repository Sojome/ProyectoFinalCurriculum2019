package com.ejb.session;

import java.util.List;

import javax.ejb.Local;

import com.ejb.model.Provincia;;

@Local
public interface ProvinciaSession {
	public Provincia buscar(Provincia provincia);
	public String grabar(Provincia provincia);
	public String actualizar(Provincia p);
	public String eliminar(Provincia p);
	public List<Provincia> listar(int id);
	public Provincia buscarporId(int id);
}
