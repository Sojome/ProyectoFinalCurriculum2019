package com.generico.session;

public interface GenericoSession <T> {
	public void save(T entity);
	
	public void update(T entity);
	
	public void find( T entity);
	
	public T findId(Integer entityId);
	
	public void delete(T entity);
	
	public Iterable<T> findAll();
}
