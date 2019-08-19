package com.ejb.session;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.dao.MiProvinciaDao;
import com.ejb.model.MiProvincia;

@Stateless(name="ejbMiProvinciaSession")
public class EjbMiProvinciaSession implements MiProvinciaSession {
	
	//unit con el dao los distintos metodos
	@EJB
	private MiProvinciaDao EjbMiProvinciaDao;

	@Override
	public MiProvincia buscar(MiProvincia provincia) {
		return EjbMiProvinciaDao.buscar(provincia);
	}

	@Override
	public String grabar(MiProvincia provincia) {
		return EjbMiProvinciaDao.grabar(provincia);
	}

	@Override
	public String actualizar(MiProvincia p) {
		return EjbMiProvinciaDao.actualizar(p);
	}

	@Override
	public String eliminar(MiProvincia p) {
		return EjbMiProvinciaDao.eliminar(p);
	}

	@Override
	public List<MiProvincia> listar(int id) {
		return EjbMiProvinciaDao.listar(id);
	}

	@Override
	public MiProvincia buscarporId(int id) {
		return EjbMiProvinciaDao.buscarporId(id);
	}

}
