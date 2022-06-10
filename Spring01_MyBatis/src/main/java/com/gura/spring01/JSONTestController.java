package com.gura.spring01;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gura.spring01.member.dao.MemberDao;
import com.gura.spring01.member.dto.MemberDto;

/*
 * 	1.	jackson-databind 라이브러리가 pome.xml에 dependency에 명시가 되어 있고
 * 	2.	servlet-context.xml 에 <annotation-driven/>이 명시 되어 있고
 * 	3. 	컨트롤러의 메소드 @ResponseBody 어노테이션이 붙어 있으면
 * 		Map or dto or List 객체 담긴 내용이 jso 문자열로 반환되어 응답된다.
 * 
 */

@Controller
public class JSONTestController {

	@RequestMapping("/send.do")
	@ResponseBody
	public Map<String,Object> send() {
		Map<String,Object> map=new HashMap<>();
		map.put("num", 1);
		map.put("name", "김구라");
		map.put("isMan", true);
		
		return map;
		
	}
	
	@RequestMapping("/send2.do")
	@ResponseBody
	public MemberDto send2() {
		MemberDto dto=new MemberDto(2,"해골","행신동");		
		return dto;		
	}
	
	@RequestMapping("/send3.do")
	@ResponseBody
	public List<String> send3() {
		List<String> list=new ArrayList<String>();
		list.add("하나");
		list.add("둘");
		list.add("셋");
		return list;		
	}
	@Autowired
	private MemberDao dao;
	
	@RequestMapping("/send4.do")
	@ResponseBody
	public List<MemberDto> send4() {
		return dao.getList();		
	}
	
}
