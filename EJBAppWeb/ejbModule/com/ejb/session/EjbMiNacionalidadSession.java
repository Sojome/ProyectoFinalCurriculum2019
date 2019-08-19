package com.ejb.session;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.dao.MiNacionalidadDao;
import com.ejb.model.MiNacionalidad;

@Stateless(name="ejbMiNacionalidadSession")
public class EjbMiNacionalidadSession implements MiNacionalidadSession {
	
	//unit con el dao los distintos metodos
	@EJB
	private MiNacionalidadDao EjbMiNacionalidadDao;

	@Override
	public MiNacionalidad buscar(MiNacionalidad nacionalidad) {
		return EjbMiNacionalidadDao.buscar(nacionalidad);
	}

	@Override
	public String grabar(MiNacionalidad nacionalidad) {
		return EjbMiNacionalidadDao.grabar(nacionalidad);
	}

	@Override
	public String actualizar(MiNacionalidad c) {
		return EjbMiNacionalidadDao.actualizar(c);
	}

	@Override
	public String eliminar(MiNacionalidad c) {
		return EjbMiNacionalidadDao.eliminar(c);
	}

	@Override
	public List<MiNacionalidad> listar(int id) {
		return EjbMiNacionalidadDao.listar(id);
	}

	@Override
	public MiNacionalidad buscarporId(int id) {
		return EjbMiNacionalidadDao.buscarporId(id);
	}

}
