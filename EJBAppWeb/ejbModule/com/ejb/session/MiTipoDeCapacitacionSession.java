package com.ejb.session;

import java.util.List;

import javax.ejb.Local;

import com.ejb.model.MiTipoDeCapacitacion;
@Local
public interface MiTipoDeCapacitacionSession {
	//metodos para el crud
	public MiTipoDeCapacitacion buscar(MiTipoDeCapacitacion mitipodecapacitacion);
	public String grabar(MiTipoDeCapacitacion mitipodecapacitacion);
	public String actualizar(MiTipoDeCapacitacion c);
	public String eliminar(MiTipoDeCapacitacion c);
	public List<MiTipoDeCapacitacion> listar();
	public MiTipoDeCapacitacion buscarporId(int id);
}
