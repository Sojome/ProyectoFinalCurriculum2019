package com.ejb.session;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.dao.MiInvestigacionesRealizadaDao;
import com.ejb.model.MiInvestigacionesRealizada;

@Stateless(name="ejbMiInvestigacionesRealizadaSession")
public class EjbMiInvestigacionesRealizadaSession implements MiInvestigacionesRealizadaSession {
	
	//unit con el dao los distintos metodos
	@EJB
	private MiInvestigacionesRealizadaDao EjbMiInvestigacionesRealizadaDao;

	@Override
	public MiInvestigacionesRealizada buscar(MiInvestigacionesRealizada miinvestigacionesrealizada) {
		return EjbMiInvestigacionesRealizadaDao.buscar(miinvestigacionesrealizada);
	}

	@Override
	public String grabar(MiInvestigacionesRealizada miinvestigacionesrealizada) {
		return EjbMiInvestigacionesRealizadaDao.grabar(miinvestigacionesrealizada);
	}

	@Override
	public String actualizar(MiInvestigacionesRealizada c) {
		return EjbMiInvestigacionesRealizadaDao.actualizar(c);
	}

	@Override
	public String eliminar(MiInvestigacionesRealizada c) {
		return EjbMiInvestigacionesRealizadaDao.eliminar(c);
	}

	@Override
	public List<MiInvestigacionesRealizada> listar() {
		return EjbMiInvestigacionesRealizadaDao.listar();
	}

	@Override
	public MiInvestigacionesRealizada buscarporId(int id) {
		return EjbMiInvestigacionesRealizadaDao.buscarporId(id);
	}

}
