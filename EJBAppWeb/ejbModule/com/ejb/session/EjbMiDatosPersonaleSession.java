package com.ejb.session;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.dao.MiDatosPersonaleDao;
import com.ejb.model.MiDatosPersonale;

@Stateless(name="ejbMiDatosPersonaleSession")
public class EjbMiDatosPersonaleSession implements MiDatosPersonaleSession {
	
	//unit con el dao los distintos metodos
	@EJB
	private MiDatosPersonaleDao EjbMiDatosPersonaleDao;

	@Override
	public MiDatosPersonale buscar(MiDatosPersonale midatospersonale) {
		return EjbMiDatosPersonaleDao.buscar(midatospersonale);
	}

	@Override
	public String grabar(MiDatosPersonale midatospersonale) {
		return EjbMiDatosPersonaleDao.grabar(midatospersonale);
	}

	@Override
	public String actualizar(MiDatosPersonale p) {
		return EjbMiDatosPersonaleDao.actualizar(p);
	}

	@Override
	public String eliminar(MiDatosPersonale p) {
		return EjbMiDatosPersonaleDao.eliminar(p);
	}

	@Override
	public List<MiDatosPersonale> listar() {
		return EjbMiDatosPersonaleDao.listar();
	}

	@Override
	public MiDatosPersonale buscarporId(int id) {
		return EjbMiDatosPersonaleDao.buscarporId(id);
	}

}
