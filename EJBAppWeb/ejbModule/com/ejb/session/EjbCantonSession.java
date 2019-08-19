package com.ejb.session;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.dao.CantonDao;
import com.ejb.model.Canton;

@Stateless(name="ejbCantonSession")
public class EjbCantonSession implements CantonSession {
	
	//unit con el dao los distintos metodos
	@EJB
	private CantonDao EjbCantonDao;

	@Override
	public Canton buscar(Canton canton) {
		return EjbCantonDao.buscar(canton);
	}

	@Override
	public String grabar(Canton canton) {
		return EjbCantonDao.grabar(canton);
	}

	@Override
	public String actualizar(Canton c) {
		return EjbCantonDao.actualizar(c);
	}

	@Override
	public String eliminar(Canton c) {
		return EjbCantonDao.eliminar(c);
	}

	@Override
	public List<Canton> listar(int id) {
		return EjbCantonDao.listar(id);
	}

	@Override
	public Canton buscarporId(int id) {
		return EjbCantonDao.buscarporId(id);
	}

}
