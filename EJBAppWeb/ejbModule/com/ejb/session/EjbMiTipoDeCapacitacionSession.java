package com.ejb.session;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.dao.MiTipoDeCapacitacionDao;
import com.ejb.model.MiTipoDeCapacitacion;

@Stateless(name="ejbMiTipoDeCapacitacionSession")
public class EjbMiTipoDeCapacitacionSession implements MiTipoDeCapacitacionSession {
	
	//unit con el dao los distintos metodos
	@EJB
	private MiTipoDeCapacitacionDao EjbMiTipoDeCapacitacionDao;

	@Override
	public MiTipoDeCapacitacion buscar(MiTipoDeCapacitacion mitipodecapacitacion) {
		return EjbMiTipoDeCapacitacionDao.buscar(mitipodecapacitacion);
	}

	@Override
	public String grabar(MiTipoDeCapacitacion mitipodecapacitacion) {
		return EjbMiTipoDeCapacitacionDao.grabar(mitipodecapacitacion);
	}

	@Override
	public String actualizar(MiTipoDeCapacitacion c) {
		return EjbMiTipoDeCapacitacionDao.actualizar(c);
	}

	@Override
	public String eliminar(MiTipoDeCapacitacion c) {
		return EjbMiTipoDeCapacitacionDao.eliminar(c);
	}

	@Override
	public List<MiTipoDeCapacitacion> listar() {
		return EjbMiTipoDeCapacitacionDao.listar();
	}

	@Override
	public MiTipoDeCapacitacion buscarporId(int id) {
		return EjbMiTipoDeCapacitacionDao.buscarporId(id);
	}

}
