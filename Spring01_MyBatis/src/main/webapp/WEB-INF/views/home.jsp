<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/home.jsp</title>
</head>
<body>
	<div class="containser">
		
		<h1>인덱스 페이지 입니다.</h1>
		
		<ul>
			<lu><a href="member/list.do">회원목록보기</a></lu>
			<lu><a href="member/list2.do">회원목록보기2</a></lu>
			<li><a href="todo/list.do">할일 목록 보기</a></li>
			<li><a href="todo/list2.do">할일 목록 보기2</a></li>
			<li><a href="study.jsp">테스트</a></li>
			<li><a href="send.do">json 테스트</a></li>
			<li><a href="send2.do">json2 테스트</a></li>
			<li><a href="send3.do">json3 테스트</a></li>
			<li><a href="send4.do">json4 테스트</a></li>
			<li><a href="file/upload_form.do">파일 업로드 테스트</a></li>
		</ul>
		
		<h2>공지사항</h2>
		<ul>
			<c:forEach var="tmp" items="${noticeList} ">
				<li>${tmp }</li>
			</c:forEach>
		</ul>
	</div>
</body>
</html>