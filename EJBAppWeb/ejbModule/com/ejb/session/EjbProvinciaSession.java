package com.ejb.session;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.dao.ProvinciaDao;
import com.ejb.model.Provincia;

@Stateless(name="ejbProvinciaSession")
public class EjbProvinciaSession implements ProvinciaSession {
	
	//unit con el dao los distintos metodos
	@EJB
	private ProvinciaDao EjbProvinciaDao;

	@Override
	public Provincia buscar(Provincia provincia) {
		return EjbProvinciaDao.buscar(provincia);
	}

	@Override
	public String grabar(Provincia provincia) {
		return EjbProvinciaDao.grabar(provincia);
	}

	@Override
	public String actualizar(Provincia p) {
		return EjbProvinciaDao.actualizar(p);
	}

	@Override
	public String eliminar(Provincia p) {
		return EjbProvinciaDao.eliminar(p);
	}

	@Override
	public List<Provincia> listar(int id) {
		return EjbProvinciaDao.listar(id);
	}

	@Override
	public Provincia buscarporId(int id) {
		return EjbProvinciaDao.buscarporId(id);
	}

}
