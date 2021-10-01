package com.revature.project0.data;

import java.util.List;

public interface GenericDao <T> {

	List<T> getAll();
	
	T getByName(String name);
	
	void update(T t);
	
	void insert (T t);
	
	void delete (T t);
}
