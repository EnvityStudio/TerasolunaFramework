package com.co.domain.service;

import java.util.Collection;
import java.util.Date;
import java.util.UUID;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.terasoluna.gfw.common.exception.BusinessException;
import org.terasoluna.gfw.common.exception.ResourceNotFoundException;
import org.terasoluna.gfw.common.message.ResultMessage;
import org.terasoluna.gfw.common.message.ResultMessages;

import com.co.domain.model.Todo;
import com.co.domain.respository.TodoResponsitory;

@Service// (1)
@Transactional // (2)
public class TodoServiceImp implements TodoService {

	private static final long MAX_UNFINISHED_COUNT = 5;
	
	@Inject
	TodoResponsitory todoResponsitory;
	
	public Todo findOne(String todoId) {
		Todo todo = todoResponsitory.findOne(todoId);
		if(todo == null) {
			ResultMessages messages = ResultMessages.error(); 
			messages.add(ResultMessage.fromText("[E404 The requested Todo is not found. (id=" + todoId + ")"));
			throw new ResourceNotFoundException(messages);
		}
		return todo;
	}
	
	
	@Override
	@Transactional (readOnly = true)
	public Collection<Todo> findAll() {
		return todoResponsitory.findAll();
	}

	@Override
	public Todo create(Todo todo) {
		long unfinishedCount = todoResponsitory.countByFinished(false);
		  if (unfinishedCount >= MAX_UNFINISHED_COUNT) {
	            ResultMessages messages = ResultMessages.error();
	            messages.add(ResultMessage
	                    .fromText("[E001] The count of un-finished Todo must not be over "
	                            + MAX_UNFINISHED_COUNT + "."));
	            // (8)
	            throw new BusinessException(messages);
	        }

	        // (9)
	        String todoId = UUID.randomUUID().toString();
	        Date createdAt = new Date();

	        todo.setTodoId(todoId);
	        todo.setCreatedAt(createdAt);
	        todo.setFinished(false);

	        todoResponsitory.create(todo);
	        /* REMOVE THIS LINE IF YOU USE JPA
	            todoRepository.save(todo); // 10
	           REMOVE THIS LINE IF YOU USE JPA */

	        return todo;
	}

	@Override
	public Todo finish(String todoId) {
	     Todo todo = findOne(todoId);
	        if (todo.isFinished()) {
	            ResultMessages messages = ResultMessages.error();
	            messages.add(ResultMessage
	                    .fromText("[E002] The requested Todo is already finished. (id="
	                            + todoId + ")"));
	            throw new BusinessException(messages);
	        }
	        todo.setFinished(true);
	        todoResponsitory.update(todo);
	        /* REMOVE THIS LINE IF YOU USE JPA
	            todoRepository.save(todo); // (11)
	           REMOVE THIS LINE IF YOU USE JPA */
	        return todo;
	}

	@Override
	public void delete(Todo todo) {
		// TODO Auto-generated method stub
		
	}

}
