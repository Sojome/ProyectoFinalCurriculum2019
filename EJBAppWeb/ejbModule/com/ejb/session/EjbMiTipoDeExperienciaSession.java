package com.ejb.session;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.dao.MiTipoDeExperienciaDao;
import com.ejb.model.MiTipoDeExperiencia;

@Stateless(name="ejbMiTipoDeExperienciaSession")
public class EjbMiTipoDeExperienciaSession implements MiTipoDeExperienciaSession {
	
	//unit con el dao los distintos metodos
	@EJB
	private MiTipoDeExperienciaDao EjbMiTipoDeExperienciaDao;

	@Override
	public MiTipoDeExperiencia buscar(MiTipoDeExperiencia mitipodeexperiencia) {
		return EjbMiTipoDeExperienciaDao.buscar(mitipodeexperiencia);
	}

	@Override
	public String grabar(MiTipoDeExperiencia mitipodeexperiencia) {
		return EjbMiTipoDeExperienciaDao.grabar(mitipodeexperiencia);
	}

	@Override
	public String actualizar(MiTipoDeExperiencia c) {
		return EjbMiTipoDeExperienciaDao.actualizar(c);
	}

	@Override
	public String eliminar(MiTipoDeExperiencia c) {
		return EjbMiTipoDeExperienciaDao.eliminar(c);
	}

	@Override
	public List<MiTipoDeExperiencia> listar() {
		return EjbMiTipoDeExperienciaDao.listar();
	}

	@Override
	public MiTipoDeExperiencia buscarporId(int id) {
		return EjbMiTipoDeExperienciaDao.buscarporId(id);
	}

}
