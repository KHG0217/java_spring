package com.gura.spring01.todo.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.gura.spring01.todo.dao.TodoDao;
import com.gura.spring01.todo.dto.TodoDto;

@Controller
public class TodoController {
	
	@Autowired
	private TodoDao dao;
	
	@RequestMapping(value = "/todo/list",method = RequestMethod.GET)
	public String list(HttpServletRequest request) {
		
		List<TodoDto> list=dao.getList();
		request.setAttribute("list", list);
		
		return "todo/list";
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
		//DB에 저장
		dao.insert(dto);
		
		return "todo/insert";
	}
	
	@RequestMapping(value = "/todo/updateform", method = RequestMethod.GET)
	public String updateform(int num, HttpServletRequest request) {
		//수정할  정보 얻어오기
		TodoDto dto = dao.getData(num);
		request.setAttribute("dto", dto);
		return "todo/updateform";
	}
	
	@RequestMapping(value = "/todo/update", method = RequestMethod.POST)
	public String update(TodoDto dto) {
		dao.update(dto);
		return "todo/update";
	}
	
	@RequestMapping(value = "/todo/delete.do",method = RequestMethod.GET)
	public String delete(int num) {
		dao.delete(num);
		
		return "redirect:/todo/list.do";
	}
		
		
	
}
