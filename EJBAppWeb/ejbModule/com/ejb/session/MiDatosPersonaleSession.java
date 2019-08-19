package com.ejb.session;

import java.util.List;

import javax.ejb.Local;

import com.ejb.model.MiDatosPersonale;

@Local
public interface MiDatosPersonaleSession {
	public MiDatosPersonale buscar(MiDatosPersonale midatospersonale);
	public String grabar(MiDatosPersonale midatospersonale);
	public String actualizar(MiDatosPersonale c);
	public String eliminar(MiDatosPersonale c);
	public List<MiDatosPersonale> listar();
	public MiDatosPersonale buscarporId(int id);
}
