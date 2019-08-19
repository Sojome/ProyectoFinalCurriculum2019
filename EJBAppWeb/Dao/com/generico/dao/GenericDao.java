package com.generico.dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;

@Stateless(name="genericDao")
public abstract class GenericDao <T> {
	
	@PersistenceContext(name="persistencia")
	private EntityManager em;
	private Class<T> entityClass;
	
	public GenericDao(Class<T> entityClass) {
		this.entityClass= entityClass;
	}

	
	public void save(T entity) {
		em.persist(entity);
		em.flush();
		
	}
	public void update(T entity) {
		em.merge(entity);
		
	}
	public T find(T entity) {
		return em.find(entityClass, entity);
		
	}
	public T findId(Integer entityId) {
		return em.find(entityClass, entityId);
		
	}

	public void delete(T entity) {
		em.remove(em.contains(entity));
		em.flush();
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Iterable<T> findAll() {
		CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
		cq.select(cq.from(entityClass));
		return em.createQuery(cq).getResultList();
	}

}
