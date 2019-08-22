package com.ejb.session;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.dao.MiNivelTituloDao;
import com.ejb.model.MiNivelTitulo;

@Stateless(name="ejbMiNivelTituloSession")
public class EjbMiNivelTituloSession implements MiNivelTituloSession {
	
	//unit con el dao los distintos metodos
	@EJB
	private MiNivelTituloDao EjbMiNivelTituloDao;

	@Override
	public MiNivelTitulo buscar(MiNivelTitulo miniveltitulo) {
		return EjbMiNivelTituloDao.buscar(miniveltitulo);
	}

	@Override
	public String grabar(MiNivelTitulo miniveltitulo) {
		return EjbMiNivelTituloDao.grabar(miniveltitulo);
	}

	@Override
	public String actualizar(MiNivelTitulo c) {
		return EjbMiNivelTituloDao.actualizar(c);
	}

	@Override
	public String eliminar(MiNivelTitulo c) {
		return EjbMiNivelTituloDao.eliminar(c);
	}

	@Override
	public List<MiNivelTitulo> listar() {
		return EjbMiNivelTituloDao.listar();
	}

	@Override
	public MiNivelTitulo buscarporId(int id) {
		return EjbMiNivelTituloDao.buscarporId(id);
	}

}
