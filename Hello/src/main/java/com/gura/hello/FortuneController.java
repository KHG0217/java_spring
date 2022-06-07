package com.gura.hello;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FortuneController {
	
	@RequestMapping("/fortune.do")
	public String fortune(HttpServletRequest request) {
		//오늘의 운세
		String fortuneToday="동쪽으로 가면 귀인을 만나요!";
		
		//오늘의 운세를 request scope에 담기
		request.setAttribute("fortuneToday", fortuneToday);
		
		// /WEB-INF/views/fortune.jsp 페이지로 forward 이동해서 응답
		return "fortune";
		
		// /WEB-INF/views/sub/fortune.jsp 페이지로 forward 이동해서 응답
		
		// return "sub/fortune";
	}
}
