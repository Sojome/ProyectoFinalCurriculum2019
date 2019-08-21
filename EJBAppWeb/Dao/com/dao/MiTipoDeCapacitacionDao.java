package com.dao;

import java.util.List;

import javax.ejb.Local;

import com.ejb.model.MiTipoDeCapacitacion;
@Local
public interface MiTipoDeCapacitacionDao {
	//metodos para el crud
	public MiTipoDeCapacitacion buscar(MiTipoDeCapacitacion mitipodecapacitacion);
	public String grabar(MiTipoDeCapacitacion mitipodecapacitacion);
	public String actualizar(MiTipoDeCapacitacion c);
	public String eliminar(MiTipoDeCapacitacion c);
	public List<MiTipoDeCapacitacion> listar();
	public MiTipoDeCapacitacion buscarporId(int id);
}
