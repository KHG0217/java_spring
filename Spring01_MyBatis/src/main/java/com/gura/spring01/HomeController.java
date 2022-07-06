package com.gura.spring01;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/*
 *  @Controller 어노테이션을 붙여 놓으면 component scan 할 때 객체가 생성되고
 *  spring bean container에서 관리가 된다.
 *  
 *  클라이언트가 어떤 경로 요청하고 어떤작업하고 어디로 이동할지 알려주는 이노테이션
 */

@Controller
public class HomeController {
	

	//@RequestMapping(value = "/home.do", method = RequestMethod.GET)
	//위의 표현을 줄여서 아래와 같이 쓸 수 있다.
	//@RequestMapping("/home.do")
	//.do는 생략 가능하다.
	@RequestMapping("/home")
	public String home(HttpServletRequest request) {
		/*
		 * 	forward 이동될 jsp 페이지에 데이터 (model)을 전달하고 싶으면 request scope에 담아서 전달하면 된다.
		 * 	request scope에 담은 데이터는 응답하기 전까지 유지 된다.
		 * 	따라서 jsp 페이지로 forward 이동하면 아직은 응답을 하지 않는 상태 이므로 (응답을 위임시킨것)
		 * 	request scope에 담은 데이터를 추출해서 사용할 수 있다.
		 * 
		 * 	request scope 데이터를 담기 위해서는HttpServletRequest 객체가 필요하다.
		 * 	스프링 Controller의 메소드에서는
		 * 	HttpServletReuest, HttpServletResponse, HttpSession, ModelAndView 등의
		 * 	객체가 필요한 경우 메소드에 매개 변수에 해당 type을 선언하면 자동으로 해당 객체가 인자로 전달 된다.
		 * 
		 */
		
		//DB에서 읽어온 공지 사항이라고 가정하자
		List<String> list = new ArrayList<String>();
		list.add("전반기 수업이 한달도 남지 않았습니다.");
		list.add("곧 프로그젝트가 시작 됩니다.");
		list.add("어쨰...");
		list.add("저째...");
		
		//requset scope 에 noticeList 라는 키값으로 공지사항 담기
		request.setAttribute("noticeList", list);
		/*
		 * 	이 메소드는 String type을 리턴하기로 되어 있는데, 여기서 리턴한 문자열의
		 * 	접두어로 "/WEB-INF/views" 가 붙고,
		 * 	접미어로 ".jsp"가 붙어서
		 * 	forward 이동될(응답이 위임될) jsp 페이지가 지정이 된다.
		 * 	해당 설정은 DispatcherServlet을 설정하는 servlet-context.xml 문서에 정의가 되어있다.
		 * 
		 * 	따라서 "home"을 리턴하면
		 * 	"/WEB-INF/views/home.jsp"가 forward 이동 될 jsp 페이지가 된다.
		 */
		return "home";
	}
	
}
