package com.ejb.session;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.dao.MiCapacitacionDao;
import com.ejb.model.MiCapacitacion;

@Stateless(name="ejbMiCapacitacionSession")
public class EjbMiCapacitacionSession implements MiCapacitacionSession {
	
	//unit con el dao los distintos metodos
	@EJB
	private MiCapacitacionDao EjbMiCapacitacionDao;

	@Override
	public MiCapacitacion buscar(MiCapacitacion micapacitacion) {
		return EjbMiCapacitacionDao.buscar(micapacitacion);
	}

	@Override
	public String grabar(MiCapacitacion micapacitacion) {
		return EjbMiCapacitacionDao.grabar(micapacitacion);
	}

	@Override
	public String actualizar(MiCapacitacion c) {
		return EjbMiCapacitacionDao.actualizar(c);
	}

	@Override
	public String eliminar(MiCapacitacion c) {
		return EjbMiCapacitacionDao.eliminar(c);
	}

	@Override
	public List<MiCapacitacion> listar() {
		return EjbMiCapacitacionDao.listar();
	}

	@Override
	public MiCapacitacion buscarporId(int id) {
		return EjbMiCapacitacionDao.buscarporId(id);
	}

}
