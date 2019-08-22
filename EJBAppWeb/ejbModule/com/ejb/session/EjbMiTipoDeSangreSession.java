package com.ejb.session;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.dao.MiTipoDeSangreDao;
import com.ejb.model.MiTipoDeSangre;

@Stateless(name="ejbMiTipoDeSangreSession")
public class EjbMiTipoDeSangreSession implements MiTipoDeSangreSession {
	
	//unit con el dao los distintos metodos
	@EJB
	private MiTipoDeSangreDao EjbMiTipoDeSangreDao;

	@Override
	public MiTipoDeSangre buscar(MiTipoDeSangre mitipodesangre) {
		return EjbMiTipoDeSangreDao.buscar(mitipodesangre);
	}

	@Override
	public String grabar(MiTipoDeSangre mitipodesangre) {
		return EjbMiTipoDeSangreDao.grabar(mitipodesangre);
	}

	@Override
	public String actualizar(MiTipoDeSangre c) {
		return EjbMiTipoDeSangreDao.actualizar(c);
	}

	@Override
	public String eliminar(MiTipoDeSangre c) {
		return EjbMiTipoDeSangreDao.eliminar(c);
	}

	@Override
	public List<MiTipoDeSangre> listar() {
		return EjbMiTipoDeSangreDao.listar();
	}

	@Override
	public MiTipoDeSangre buscarporId(int id) {
		return EjbMiTipoDeSangreDao.buscarporId(id);
	}

}
