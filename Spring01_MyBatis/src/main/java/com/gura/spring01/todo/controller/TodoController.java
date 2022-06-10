package com.gura.spring01.todo.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.gura.spring01.todo.dao.TodoDao;
import com.gura.spring01.todo.dto.TodoDto;
import com.gura.spring01.todo.service.TodoService;

@Controller
public class TodoController {
	
	@Autowired
	private TodoDao dao;
	
	@Autowired
	private TodoService service;
	
	@RequestMapping(value = "/todo/list",method = RequestMethod.GET)
	public String list(HttpServletRequest request) {
		
		List<TodoDto> list=dao.getList();
		request.setAttribute("list", list);
		
		return "todo/list";
	}
	
	@RequestMapping(value = "/todo/list2",method = RequestMethod.GET)
	public ModelAndView list2(ModelAndView mView) {
		
		service.getListTodo(mView);
		mView.setViewName("todo/list");
		
		return mView;
	}
	
	@RequestMapping(value = "/todo/insertform",method = RequestMethod.GET)
	public String insertform() {
		return "todo/insertform";
	}
	
	@RequestMapping("/todo/insert1")
	public String insert1(HttpServletRequest request) {
		//폼으로부터 전송되는 parameter 추출
		String content = request.getParameter("content");
		
		//DB에 저장
		TodoDto dto = new TodoDto();
		dto.setContent(content);
		dao.insert(dto);
		
		return "todo/insert";
	}
	
	@RequestMapping(value = "/todo/insert2", method = RequestMethod.POST)
	public String insert2(@RequestParam String content) {
		
		//DB에 저장
		TodoDto dto=new TodoDto();
		dto.setContent(content);
		dao.insert(dto);
		
		return "todo/insert";
	}
	
	@RequestMapping(value = "/todo/insert3", method = RequestMethod.POST)
	public String insert3(@ModelAttribute TodoDto dto) {
		
		service.addTodo(dto);
		
		return "todo/insert";
	}
	
	@RequestMapping(value = "/todo/updateform", method = RequestMethod.GET)
	public ModelAndView updateform(int num, ModelAndView mView) {
		//수정할  정보 얻어오기
		service.getTodo(num, mView);
		mView.setViewName("todo/updateform");		
		return mView;
	}
	
	@RequestMapping(value = "/todo/update", method = RequestMethod.POST)
	public String update(TodoDto dto) {
		service.updateTodo(dto);
		return "todo/update";
	}
	
	@RequestMapping(value = "/todo/delete.do",method = RequestMethod.GET)
	public String delete(int num) {
		service.deleteTodo(num);
		
		return "redirect:/todo/list.do";
	}
		
		
	
}
