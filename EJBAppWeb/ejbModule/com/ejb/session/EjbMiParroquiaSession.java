package com.ejb.session;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.dao.MiParroquiaDao;
import com.ejb.model.MiParroquia;

@Stateless(name="ejbMiParroquiaSession")
public class EjbMiParroquiaSession implements MiParroquiaSession {
	
	//unit con el dao los distintos metodos
	@EJB
	private MiParroquiaDao EjbMiParroquiaDao;

	@Override
	public MiParroquia buscar(MiParroquia parroquia) {
		return EjbMiParroquiaDao.buscar(parroquia);
	}

	@Override
	public String grabar(MiParroquia parroquia) {
		return EjbMiParroquiaDao.grabar(parroquia);
	}

	@Override
	public String actualizar(MiParroquia p) {
		return EjbMiParroquiaDao.actualizar(p);
	}

	@Override
	public String eliminar(MiParroquia p) {
		return EjbMiParroquiaDao.eliminar(p);
	}

	@Override
	public List<MiParroquia> listar(int id) {
		return EjbMiParroquiaDao.listar(id);
	}

	@Override
	public MiParroquia buscarporId(int id) {
		return EjbMiParroquiaDao.buscarporId(id);
	}

}
