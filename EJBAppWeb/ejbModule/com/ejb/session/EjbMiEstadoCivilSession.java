package com.ejb.session;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.dao.MiEstadoCivilDao;
import com.ejb.model.MiEstadoCivil;

@Stateless(name="ejbMiEstadoCivilSession")
public class EjbMiEstadoCivilSession implements MiEstadoCivilSession {
	
	//unit con el dao los distintos metodos
	@EJB
	private MiEstadoCivilDao EjbMiEstadoCivilDao;

	@Override
	public MiEstadoCivil buscar(MiEstadoCivil miestadocivil) {
		return EjbMiEstadoCivilDao.buscar(miestadocivil);
	}

	@Override
	public String grabar(MiEstadoCivil miestadocivil) {
		return EjbMiEstadoCivilDao.grabar(miestadocivil);
	}

	@Override
	public String actualizar(MiEstadoCivil c) {
		return EjbMiEstadoCivilDao.actualizar(c);
	}

	@Override
	public String eliminar(MiEstadoCivil c) {
		return EjbMiEstadoCivilDao.eliminar(c);
	}

	@Override
	public List<MiEstadoCivil> listar() {
		return EjbMiEstadoCivilDao.listar();
	}

	@Override
	public MiEstadoCivil buscarporId(int id) {
		return EjbMiEstadoCivilDao.buscarporId(id);
	}

}
