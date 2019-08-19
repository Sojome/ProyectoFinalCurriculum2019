package com.ejb.session;

import java.util.List;

import javax.ejb.Local;

import com.ejb.model.MiPais;

@Local
public interface MiPaisSession {
	public MiPais buscar(MiPais pais);
	public String grabar(MiPais pais);
	public String actualizar(MiPais p);
	public String eliminar(MiPais p);
	public List<MiPais> listar();
	public MiPais buscarporId(int id);
}
