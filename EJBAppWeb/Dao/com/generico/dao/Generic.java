package com.generico.dao;


public interface Generic <T> {
	public void save(T entity);
	
	public void update(T entity);
	
	public void find( T entity);
	
	public void findId(Integer entityId);
	
	public void delete(T entity);
	
	public Iterable<T> findAll();

}
