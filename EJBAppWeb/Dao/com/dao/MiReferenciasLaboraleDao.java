package com.dao;

import java.util.List;

import javax.ejb.Local;

import com.ejb.model.MiReferenciasLaborale;
@Local
public interface MiReferenciasLaboraleDao {
	//metodos para el crud
	public MiReferenciasLaborale buscar(MiReferenciasLaborale mireferenciaslaborale);
	public String grabar(MiReferenciasLaborale mireferenciaslaborale);
	public String actualizar(MiReferenciasLaborale c);
	public String eliminar(MiReferenciasLaborale c);
	public List<MiReferenciasLaborale> listar();
	public MiReferenciasLaborale buscarporId(int id);
}
