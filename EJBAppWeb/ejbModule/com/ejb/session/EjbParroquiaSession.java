package com.ejb.session;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.dao.ParroquiaDao;
import com.ejb.model.Parroquia;

@Stateless(name="ejbParroquiaSession")
public class EjbParroquiaSession implements ParroquiaSession {
	
	//unit con el dao los distintos metodos
	@EJB
	private ParroquiaDao EjbParroquiaDao;

	@Override
	public Parroquia buscar(Parroquia parroquia) {
		return EjbParroquiaDao.buscar(parroquia);
	}

	@Override
	public String grabar(Parroquia parroquia) {
		return EjbParroquiaDao.grabar(parroquia);
	}

	@Override
	public String actualizar(Parroquia p) {
		return EjbParroquiaDao.actualizar(p);
	}

	@Override
	public String eliminar(Parroquia p) {
		return EjbParroquiaDao.eliminar(p);
	}

	@Override
	public List<Parroquia> listar(int id) {
		return EjbParroquiaDao.listar(id);
	}

	@Override
	public Parroquia buscarporId(int id) {
		return EjbParroquiaDao.buscarporId(id);
	}

}
