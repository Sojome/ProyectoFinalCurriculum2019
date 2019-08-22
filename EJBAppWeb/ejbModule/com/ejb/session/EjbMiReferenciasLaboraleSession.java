package com.ejb.session;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.dao.MiReferenciasLaboraleDao;
import com.ejb.model.MiReferenciasLaborale;

@Stateless(name="ejbMiReferenciasLaboraleSession")
public class EjbMiReferenciasLaboraleSession implements MiReferenciasLaboraleSession {
	
	//unit con el dao los distintos metodos
	@EJB
	private MiReferenciasLaboraleDao EjbMiReferenciasLaboraleDao;

	@Override
	public MiReferenciasLaborale buscar(MiReferenciasLaborale mireferenciaslaborale) {
		return EjbMiReferenciasLaboraleDao.buscar(mireferenciaslaborale);
	}

	@Override
	public String grabar(MiReferenciasLaborale mireferenciaslaborale) {
		return EjbMiReferenciasLaboraleDao.grabar(mireferenciaslaborale);
	}

	@Override
	public String actualizar(MiReferenciasLaborale c) {
		return EjbMiReferenciasLaboraleDao.actualizar(c);
	}

	@Override
	public String eliminar(MiReferenciasLaborale c) {
		return EjbMiReferenciasLaboraleDao.eliminar(c);
	}

	@Override
	public List<MiReferenciasLaborale> listar() {
		return EjbMiReferenciasLaboraleDao.listar();
	}

	@Override
	public MiReferenciasLaborale buscarporId(int id) {
		return EjbMiReferenciasLaboraleDao.buscarporId(id);
	}

}
