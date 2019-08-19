package com.generico.dao;

import java.util.List;

import javax.ejb.Stateless;

import com.ejb.model.MiPublicacione;

@Stateless(name="ejbMiPublicacioneGenerico")
public class EjbMiPublicacioneGenerico extends GenericDao<MiPublicacione> {

	public EjbMiPublicacioneGenerico() {
		super(MiPublicacione.class);
		
	}
	public Iterable<MiPublicacione> findAll(){
		return super.findAll();
	}
	public void delete (MiPublicacione c) {
		super.delete(c);
	}
	public void save(MiPublicacione c) {
		super.save(c);
	}
	public void update (MiPublicacione c) {
		super.update(c);
	}
	public MiPublicacione findId(Integer entityId) {
		return super.findId(entityId);
	}
	public MiPublicacione find(MiPublicacione c) {
		return super.find(c);
	}
}
