package com.ejb.session;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.dao.PaisDao;
import com.ejb.model.Pais;

@Stateless(name="ejbPaisSession")
public class EjbPaisSession implements PaisSession {
	
	//unit con el dao los distintos metodos
	@EJB
	private PaisDao EjbPaisDao;

	@Override
	public Pais buscar(Pais pais) {
		return EjbPaisDao.buscar(pais);
	}

	@Override
	public String grabar(Pais pais) {
		return EjbPaisDao.grabar(pais);
	}

	@Override
	public String actualizar(Pais p) {
		return EjbPaisDao.actualizar(p);
	}

	@Override
	public String eliminar(Pais p) {
		return EjbPaisDao.eliminar(p);
	}

	@Override
	public List<Pais> listar() {
		return EjbPaisDao.listar();
	}

	@Override
	public Pais buscarporId(int id) {
		return EjbPaisDao.buscarporId(id);
	}

}
