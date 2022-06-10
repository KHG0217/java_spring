package com.gura.spring01.member.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gura.spring01.member.dto.MemberDto;

//	component scan을 통해서 bean 이 될 수 있도록 적당한 어노테이션 붙이기
@Repository
public class MemberDaoImpl implements MemberDao {
	
	//ibatis 패키지안에 들어있는 객체 (mybatis 예전 이름)
	@Autowired
	private SqlSession session;
	
	@Override
	public List<MemberDto> getList() {
		/*
		 * 	mapper xml 의 namespace: member
		 * 	sql id : getList
		 * 	resultType: MemberDto
		 */
		
		//							selectList에  셀렉된 row가 하나하나씩 담긴다
		//							select된 것이 2개이상일때 타입은 Mapper에 resultType이다.
		//							select된 것이 1개라면 그 타입이다. (String,num..)
		List<MemberDto> list = session.selectList("member.getList");
		//row가 많을때 selectList row가 하나일때 selectOne

		
		return list;
	}

	   @Override
	   public MemberDto getData(int num) {
	      /* 
	       *  mapper 의  namespace : member
	       *  sql 의 id : getData
	       *  resultType : MemberDto
	       *  parameterType : int
	       */
	      MemberDto dto=session.selectOne("member.getData", num);
	      
	      return dto;
	   }

	   @Override
	   public void insert(MemberDto dto) {
	      /*
	       *  mapper 의 namespace : member
	       *  sql 의 id : insert
	       *  parameterType : MemberDto
	       */
	      session.insert("member.insert", dto);
	   }

	   @Override
	   public void update(MemberDto dto) {
	      session.update("member.update", dto);
	   }

	   @Override
	   public void delete(int num) {
	      session.delete("member.delete", num);
	   }

}
