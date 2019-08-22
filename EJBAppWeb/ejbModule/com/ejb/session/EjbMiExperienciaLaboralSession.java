package com.ejb.session;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.dao.MiExperienciaLaboralDao;
import com.ejb.model.MiExperienciaLaboral;

@Stateless(name="ejbMiExperienciaLaboralSession")
public class EjbMiExperienciaLaboralSession implements MiExperienciaLaboralSession {
	
	//unit con el dao los distintos metodos
	@EJB
	private MiExperienciaLaboralDao EjbMiExperienciaLaboralDao;

	@Override
	public MiExperienciaLaboral buscar(MiExperienciaLaboral miexperiencialaborall) {
		return EjbMiExperienciaLaboralDao.buscar(miexperiencialaborall);
	}

	@Override
	public String grabar(MiExperienciaLaboral miexperiencialaborall) {
		return EjbMiExperienciaLaboralDao.grabar(miexperiencialaborall);
	}

	@Override
	public String actualizar(MiExperienciaLaboral c) {
		return EjbMiExperienciaLaboralDao.actualizar(c);
	}

	@Override
	public String eliminar(MiExperienciaLaboral c) {
		return EjbMiExperienciaLaboralDao.eliminar(c);
	}

	@Override
	public List<MiExperienciaLaboral> listar() {
		return EjbMiExperienciaLaboralDao.listar();
	}

	@Override
	public MiExperienciaLaboral buscarporId(int id) {
		return EjbMiExperienciaLaboralDao.buscarporId(id);
	}

}
