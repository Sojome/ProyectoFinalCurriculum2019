package com.generico.session;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.ejb.model.MiPublicacione;
import com.generico.dao.EjbMiPublicacioneGenerico;

@Stateless(name="ejbMiPublicacioneSessionGenerico")
public class ejbMiPublicacioneGenerico implements GenericoSession<MiPublicacione> {
	
	public ejbMiPublicacioneGenerico() {
		super();
	}

	//implentacion de los jpa desde el dao
	@EJB
	private EjbMiPublicacioneGenerico ejbMiPublicacioneGenerico;
	
	
	@Override
	public void save(MiPublicacione entity) {
		ejbMiPublicacioneGenerico.save(entity);
	}
	@Override
	public void update(MiPublicacione entity) {
		ejbMiPublicacioneGenerico.update(entity);
		
	}
	@Override
	public void find(MiPublicacione entity) {
		ejbMiPublicacioneGenerico.find(entity);
		
	}

	@Override
	public MiPublicacione findId(Integer entityId) {
		return ejbMiPublicacioneGenerico.findId(entityId);
		
	}

	@Override
	public void delete(MiPublicacione entity) {
		ejbMiPublicacioneGenerico.find(entity);
		
	}

	@Override
	public Iterable<MiPublicacione> findAll() {
		return ejbMiPublicacioneGenerico.findAll();
	}
	
	

}
