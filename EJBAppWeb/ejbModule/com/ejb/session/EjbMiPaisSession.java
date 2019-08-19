package com.ejb.session;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.dao.MiPaisDao;
import com.ejb.model.MiPais;

@Stateless(name="ejbMiPaisSession")
public class EjbMiPaisSession implements MiPaisSession {
	
	//unit con el dao los distintos metodos
	@EJB
	private MiPaisDao EjbMiPaisDao;

	@Override
	public MiPais buscar(MiPais pais) {
		return EjbMiPaisDao.buscar(pais);
	}

	@Override
	public String grabar(MiPais pais) {
		return EjbMiPaisDao.grabar(pais);
	}

	@Override
	public String actualizar(MiPais p) {
		return EjbMiPaisDao.actualizar(p);
	}

	@Override
	public String eliminar(MiPais p) {
		return EjbMiPaisDao.eliminar(p);
	}

	@Override
	public List<MiPais> listar() {
		return EjbMiPaisDao.listar();
	}

	@Override
	public MiPais buscarporId(int id) {
		return EjbMiPaisDao.buscarporId(id);
	}

}
