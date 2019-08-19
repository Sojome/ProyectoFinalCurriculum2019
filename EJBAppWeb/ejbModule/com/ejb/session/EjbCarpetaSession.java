package com.ejb.session;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.dao.CarpetaDao;
import com.ejb.model.Carpeta;

@Stateless(name="ejbCarpetaSession")
public class EjbCarpetaSession implements CarpetaSession {
	
	//unit con el dao los distintos metodos
	@EJB
	private CarpetaDao EjbCarpetaDao;

	@Override
	public Carpeta buscar(Carpeta carpeta) {
		return EjbCarpetaDao.buscar(carpeta);
	}

	@Override
	public String grabar(Carpeta carpeta) {
		return EjbCarpetaDao.grabar(carpeta);
	}

	@Override
	public String actualizar(Carpeta c) {
		return EjbCarpetaDao.actualizar(c);
	}

	@Override
	public String eliminar(Carpeta c) {
		return EjbCarpetaDao.eliminar(c);
	}

	@Override
	public List<Carpeta> listar() {
		return EjbCarpetaDao.listar();
	}

	@Override
	public Carpeta buscarporId(int id) {
		return EjbCarpetaDao.buscarporId(id);
	}

}
