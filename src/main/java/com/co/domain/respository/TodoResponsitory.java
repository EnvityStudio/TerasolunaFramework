package com.co.domain.respository;

import java.util.Collection;

import com.co.domain.model.Todo;

public interface TodoResponsitory {
	Todo findOne(String todoId);
	
	Collection<Todo> findAll();
	
	void create(Todo todo);
	
	boolean update(Todo todo);
	
	void delete(Todo todo);
	
	long countByFinished(boolean finished);
	
}
