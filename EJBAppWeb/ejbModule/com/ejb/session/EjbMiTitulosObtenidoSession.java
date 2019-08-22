package com.ejb.session;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.dao.MiTitulosObtenidoDao;
import com.ejb.model.MiTitulosObtenido;

@Stateless(name="ejbMiTitulosObtenidoSession")
public class EjbMiTitulosObtenidoSession implements MiTitulosObtenidoSession {
	
	//unit con el dao los distintos metodos
	@EJB
	private MiTitulosObtenidoDao EjbMiTitulosObtenidoDao;

	@Override
	public MiTitulosObtenido buscar(MiTitulosObtenido mititulosobtenido) {
		return EjbMiTitulosObtenidoDao.buscar(mititulosobtenido);
	}

	@Override
	public String grabar(MiTitulosObtenido mititulosobtenido) {
		return EjbMiTitulosObtenidoDao.grabar(mititulosobtenido);
	}

	@Override
	public String actualizar(MiTitulosObtenido c) {
		return EjbMiTitulosObtenidoDao.actualizar(c);
	}

	@Override
	public String eliminar(MiTitulosObtenido c) {
		return EjbMiTitulosObtenidoDao.eliminar(c);
	}

	@Override
	public List<MiTitulosObtenido> listar(int id) {
		return EjbMiTitulosObtenidoDao.listar(id);
	}

	@Override
	public MiTitulosObtenido buscarporId(int id) {
		return EjbMiTitulosObtenidoDao.buscarporId(id);
	}

}
