package com.co.domain.service;

import java.util.Collection;

import com.co.domain.model.Todo;

public interface TodoService {
	Collection<Todo> findAll();
	
	Todo create(Todo todo);
	
	Todo finish(String todoId);
	
	void delete(Todo todo);
	
}
