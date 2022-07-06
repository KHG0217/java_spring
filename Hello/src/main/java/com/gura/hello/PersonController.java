package com.gura.hello;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PersonController {

	@RequestMapping("/person.do")
	public String person(HttpServletRequest request) {
		
		String personToday="김혁규";
		
		//request scope에 응답에 필요한 데이터(Model)를 담기
		request.setAttribute("personToday", personToday);
		
		// /WEB-INF/views/sub/person.jsp 페이지로 forward 이동해서 응답
		return "sub/person";
	}
	
	@RequestMapping("/next_person") //.do 생략가능
	public String next_person(HttpServletRequest request) {
		//다음 인물지정
		String nextPerson="원숭이";
		request.setAttribute("nextPerson", nextPerson);
		return "sub/next_person";
	}
}
