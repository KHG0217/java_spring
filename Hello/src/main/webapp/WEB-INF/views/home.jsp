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
	<h1>인덱스 페이지 입니다.</h1>
	<img src="/hello/images/kim1.png " alt="김구라셈" />
	<img src="${pageContext.request.contextPath}/images/kim1.png " alt="김구라셈" />
	<img src="images/kim1.png " alt="김구라셈" />
	<ul>
		<li><a href="fortune.do">오늘의 운세</a></li>
		<li><a href="person.do">오늘의 인물</a></li>
		<li><a href="next_person.do">다음의 인물</a></li>
	</ul>
	
	<h2>공지 사항</h2>
	<ul>
		<c:forEach var="tmp" items="${requestScope.noticeList }">
			<li>${tmp } </li>
		</c:forEach>
	</ul>
</body>
</html>