package com.ejb.session;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.dao.MiCantonDao;
import com.ejb.model.MiCanton;

@Stateless(name="ejbMiCantonSession")
public class EjbMiCantonSession implements MiCantonSession {
	
	//unit con el dao los distintos metodos
	@EJB
	private MiCantonDao EjbMiCantonDao;

	@Override
	public MiCanton buscar(MiCanton canton) {
		return EjbMiCantonDao.buscar(canton);
	}

	@Override
	public String grabar(MiCanton canton) {
		return EjbMiCantonDao.grabar(canton);
	}

	@Override
	public String actualizar(MiCanton c) {
		return EjbMiCantonDao.actualizar(c);
	}

	@Override
	public String eliminar(MiCanton c) {
		return EjbMiCantonDao.eliminar(c);
	}

	@Override
	public List<MiCanton> listar(int id) {
		return EjbMiCantonDao.listar(id);
	}

	@Override
	public MiCanton buscarporId(int id) {
		return EjbMiCantonDao.buscarporId(id);
	}

}
