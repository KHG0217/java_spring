package com.gura.spring01.todo.service;


import org.springframework.web.servlet.ModelAndView;

import com.gura.spring01.todo.dto.TodoDto;

public interface TodoService {
	public void addTodo(TodoDto dto);
	public void updateTodo(TodoDto dto);
	public void deleteTodo(int num);
	public void getTodo(int num, ModelAndView mView);
	public void getListTodo(ModelAndView mView);
}
