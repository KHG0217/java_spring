package com.gura.spring01.member.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.gura.spring01.member.dao.MemberDao;
import com.gura.spring01.member.dto.MemberDto;

@Controller
public class MemberController {
	//핵심 의존 객체 주입받기
	@Autowired
	private MemberDao dao;
	
	@RequestMapping("/member/insert")
	public String insert(HttpServletRequest request) {
		//1. 폼 전송되는 parameter를 추출해서
		String name=request.getParameter("name");
		String addr=request.getParameter("addr");
		//2. DB에 저장하고
		MemberDto dto=new MemberDto();
		dto.setName(name);
		dto.setAddr(addr);
		dao.insert(dto);
		//3. view page 로 forward 이동해서 응답
		
		return "member/insert";
	}
	/*
	 * 	@RequestParam 어노테이션을 이용해서 요청 파라미터를 
	 *  Controller 메소드에서 추출할 수 있다.	
	 * 	단, 요청 파라미터명(form의 name들)과 매개변수명이 일치 해야 된다.
	 * 	default 를 지정할 필요가 없으면 @RequestParam 어노테이션은
	 * 	생략 가능하다.
	 */
	// post 방식 요청만 처리 하고 싶다면. . . (post 방식은 post만 올 수 있게 세분화 시켜주는게 좋다.)
	@RequestMapping(value = "/member/insert2", method = RequestMethod.POST)
	public String insert2(@RequestParam String name, String addr) {


		//2. DB에 저장하고
		MemberDto dto=new MemberDto();
		dto.setName(name);
		dto.setAddr(addr);
		dao.insert(dto);
		//3. view page 로 forward 이동해서 응답
		
		return "member/insert";
	}
	/*
	 * 	@ModelAttribute 어노테이션을 이용해서 요청 파라미터를
	 * 	추출해서 MemverDto 객체에 포장된 상태로 전달 받을 수 있다.
	 * 	단, 요청 파라미터명과 dto의 필드명이 일치해야 한다.
	 * 	@ModelAttribute 의 다른 옵션기능을 사용하지 않을거라면 생략 가능
	 */
	@RequestMapping("/member/insert3")
	public String insert3(@ModelAttribute MemberDto dto) {
		
		//2. DB에 저장하고
		dao.insert(dto);
		//3. view page 로 forward 이동해서 응답
		
		return "member/insert";
	}
	
	@RequestMapping("/member/insertform")
	public String insertform() {
		
		return "member/insertform";
	}
	
	//"/member/list.do" 요청을 처리할 메소드
	@RequestMapping("/member/list.do")
	public String list(HttpServletRequest request) {
		
		//DB 에서 회원 목록을 얻어와서 request scope에 담고
		List<MemberDto> list=dao.getList();
		request.setAttribute("list", list);
		//view page로 forward 이동해서 회원 목록 응답하기
		
		return "member/list";
	}
	
	//"/member/list.do" 요청을 처리할 메소드
	@RequestMapping("/member/list2.do")
	public ModelAndView list2(ModelAndView mView) {
		//응답에 필요한 Mode(데이터)
		List<MemberDto> list=dao.getList();
		
		//ModelAndView 객체에 Model과 view page 정보를 담고
		mView.addObject("list", list);
		mView.setViewName("member/list");
		
		//리턴해주면 위와 동일하게 동작한다.
		return mView;
	}
	
	@RequestMapping(value="/member/delete.do", method = RequestMethod.GET)
	public String delete(@RequestParam int num) {

		dao.delete(num);
		
		/*
		 * 	리다일렉트 응답하기(클라이언트에게 새로운 경로로 요청을 다시 하라고 강제하기)
		 * 
		 * 	"redirect: context path를 제외한 요청경로"
		 */
		return "redirect:/member/list.do";
	}
	
	   @RequestMapping("/member/updateform")
	   public String updateform(int num, HttpServletRequest request) {
	      //1. 수정할 회원의 정보를 얻어와서
	      MemberDto dto=dao.getData(num);
	      //2. request scope 에 담고
	      request.setAttribute("dto", dto);
	      //3. view page 로 forward 이동해서 회원 수정 폼을 출력해 준다.
	      return "member/updateform";
	   }
	   
	   @RequestMapping("/member/update")
	   public String update(MemberDto dto) {
		   //DB에 수정할 회원의 정보를 수정 반영하고
		   dao.update(dto);
		   //view page로 forward 이동해서 응답하기
		   return "member/update";
	   }
}
