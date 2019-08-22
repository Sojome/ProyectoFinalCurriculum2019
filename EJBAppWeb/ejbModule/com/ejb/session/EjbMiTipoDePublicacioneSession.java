package com.ejb.session;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.dao.MiTipoDePublicacioneDao;
import com.ejb.model.MiTipoDePublicacione;

@Stateless(name="ejbMiTipoDePublicacioneSession")
public class EjbMiTipoDePublicacioneSession implements MiTipoDePublicacioneSession {
	
	//unit con el dao los distintos metodos
	@EJB
	private MiTipoDePublicacioneDao EjbMiTipoDePublicacioneDao;

	@Override
	public MiTipoDePublicacione buscar(MiTipoDePublicacione mitipodepublicacione) {
		return EjbMiTipoDePublicacioneDao.buscar(mitipodepublicacione);
	}

	@Override
	public String grabar(MiTipoDePublicacione mitipodepublicacione) {
		return EjbMiTipoDePublicacioneDao.grabar(mitipodepublicacione);
	}

	@Override
	public String actualizar(MiTipoDePublicacione c) {
		return EjbMiTipoDePublicacioneDao.actualizar(c);
	}

	@Override
	public String eliminar(MiTipoDePublicacione c) {
		return EjbMiTipoDePublicacioneDao.eliminar(c);
	}

	@Override
	public List<MiTipoDePublicacione> listar() {
		return EjbMiTipoDePublicacioneDao.listar();
	}

	@Override
	public MiTipoDePublicacione buscarporId(int id) {
		return EjbMiTipoDePublicacioneDao.buscarporId(id);
	}

}
