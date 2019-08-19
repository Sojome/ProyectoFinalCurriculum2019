package com.ejb.session;

import java.util.List;

import javax.ejb.Local;

import com.ejb.model.MiProvincia;

@Local
public interface MiProvinciaSession {
	public MiProvincia buscar(MiProvincia canton);
	public String grabar(MiProvincia canton);
	public String actualizar(MiProvincia c);
	public String eliminar(MiProvincia c);
	public List<MiProvincia> listar(int id);
	public MiProvincia buscarporId(int id);
}
