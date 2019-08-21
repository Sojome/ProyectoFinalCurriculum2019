package com.dao;

import java.util.List;

import javax.ejb.Local;

import com.ejb.model.MiInvestigacionesRealizada;
@Local
public interface MiInvestigacionesRealizadaDao {
	//metodos para el crud
	public MiInvestigacionesRealizada buscar(MiInvestigacionesRealizada miinvestigacionesrealizada);
	public String grabar(MiInvestigacionesRealizada miinvestigacionesrealizada);
	public String actualizar(MiInvestigacionesRealizada c);
	public String eliminar(MiInvestigacionesRealizada c);
	public List<MiInvestigacionesRealizada> listar();
	public MiInvestigacionesRealizada buscarporId(int id);
}
