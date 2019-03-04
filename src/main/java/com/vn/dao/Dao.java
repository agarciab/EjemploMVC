package com.vn.dao;

import java.util.List;

public interface Dao<T, ID> {

	public T findById(ID id);
	
	public List<T> findAll();
	
	public void save(T t);
	
	public void delete(T t);
}
