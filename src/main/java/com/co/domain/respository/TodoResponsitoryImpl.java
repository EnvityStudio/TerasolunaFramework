package com.co.domain.respository;

import java.util.Collection;

import org.springframework.stereotype.Repository;

import com.co.domain.model.Todo;

@Repository
public class TodoResponsitoryImpl implements TodoResponsitory{

	@Override
	public Todo findOne(String todoId) {
		// TODO 
		return null;
	}

	@Override
	public Collection<Todo> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void create(Todo todo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean update(Todo todo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void delete(Todo todo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public long countByFinished(boolean finished) {
		// TODO Auto-generated method stub
		return 0;
	}

}
