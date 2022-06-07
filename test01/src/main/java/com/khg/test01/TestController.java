package com.khg.test01;

import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {
	
	@RequestMapping("/p.hi")
	public String p(HttpServletRequest r) {
		String p="김혁규";
		
		r.setAttribute("p", p);
		
		return "wow/p1";
	}
	
	@RequestMapping("/f.hi")
	public String f(HttpServletRequest r) {
		String[] f= {"대박","중박","소박","머박"};
		Random ran = new Random();
		r.setAttribute("f", f[ran.nextInt(4)]);
		return "wow/f";
	}
	@RequestMapping("/n_p.hi")
	public String p2(HttpServletRequest r) {
		String p2="알수없음";
		r.setAttribute("p2", p2);
		
		return "n_p";
		
	}
}
