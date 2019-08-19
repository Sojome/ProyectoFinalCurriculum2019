package com.dao;

import java.util.List;

import javax.ejb.Local;

import com.ejb.model.MiDatosPersonale;

@Local
public interface MiDatosPersonaleDao {
	public MiDatosPersonale buscar(MiDatosPersonale midatospersonale);
	public String grabar(MiDatosPersonale midatospersonale);
	public String actualizar(MiDatosPersonale m);
	public String eliminar(MiDatosPersonale m);
	public List<MiDatosPersonale> listar();
	public MiDatosPersonale buscarporId(int id);
}
