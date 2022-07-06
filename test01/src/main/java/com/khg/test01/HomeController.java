package com.khg.test01;



import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


//Servlet단 이라고 생각
@Controller
public class HomeController {
	
	// context의 최상위 경로요청이 오면
	@RequestMapping("/home.hi")
	public String home(HttpServletRequest request) {
		//공지사항
		List<String> noticeList=new ArrayList<String>();
		noticeList.add("테스트입니다.");
		noticeList.add("어째저째");
		noticeList.add("어쩌구...");
		noticeList.add("저쩌구...");
		
		// home.jsp 페이지에 전달한 공지사항을 HttpServletRequest 객체에 담기
		request.setAttribute("noticeList", noticeList);

		// /WEB-INF/views/home.jsp 페이지로 forward 이동해서 응답을 하겠다.
		return "home";
	}
}
