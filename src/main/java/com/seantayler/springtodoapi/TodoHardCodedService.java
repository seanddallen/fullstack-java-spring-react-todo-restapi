package com.seantayler.springtodoapi;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class TodoHardCodedService {
	
	private static List<Todo> todos = new ArrayList();
	private static int idCounter = 0;
	
	static {
		todos.add(new Todo(++idCounter, "sean", "finish todo app", new Date(), false));
		todos.add(new Todo(++idCounter, "sean", "learn Java/Spring", new Date(), false));
		todos.add(new Todo(++idCounter, "sean", "become senior engineer", new Date(), false));
	}
	
	public List<Todo> findAll(){
		return todos;
	}
	

	public Todo findById(int id) {
		for(Todo todo:todos) {
			if(todo.getId() == id) {
				return todo;
			}
		}
		return null;
	}
	
	public Todo deleteById(int id) {
		Todo todo = findById(id);
		if(todo == null) return null;
		if(todos.remove(todo)) return todo;
		return null;
	}
	
	public Todo save(Todo todo) {
		if(todo.getId() == -1) {
			todo.setId(++idCounter);
			todos.add(todo);
		} else {
			deleteById(todo.getId());
			todos.add(todo);
		}
		return todo;
	}

}
