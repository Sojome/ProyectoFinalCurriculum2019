package com.ejb.session;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.dao.MiPublicacioneDao;
import com.ejb.model.MiPublicacione;

@Stateless(name="ejbMiPublicacioneSession")
public class EjbMiPublicacioneSession implements MiPublicacioneSession {
	
	//unit con el dao los distintos metodos
	@EJB
	private MiPublicacioneDao EjbMiPublicacioneDao;

	@Override
	public MiPublicacione buscar(MiPublicacione mipublicacione) {
		return EjbMiPublicacioneDao.buscar(mipublicacione);
	}

	@Override
	public String grabar(MiPublicacione mipublicacione) {
		return EjbMiPublicacioneDao.grabar(mipublicacione);
	}

	@Override
	public String actualizar(MiPublicacione c) {
		return EjbMiPublicacioneDao.actualizar(c);
	}

	@Override
	public String eliminar(MiPublicacione c) {
		return EjbMiPublicacioneDao.eliminar(c);
	}

	@Override
	public List<MiPublicacione> listar() {
		return EjbMiPublicacioneDao.listar();
	}

	@Override
	public MiPublicacione buscarporId(int id) {
		return EjbMiPublicacioneDao.buscarporId(id);
	}

}
