package com.ejb.session;

import java.util.List;

import javax.ejb.Local;

import com.ejb.model.MiCapacitacion;
@Local
public interface MiCapacitacionSession {
	//metodos para el crud
	public MiCapacitacion buscar(MiCapacitacion micapacitacion);
	public String grabar(MiCapacitacion micapacitacion);
	public String actualizar(MiCapacitacion c);
	public String eliminar(MiCapacitacion c);
	public List<MiCapacitacion> listar();
	public MiCapacitacion buscarporId(int id);
}
