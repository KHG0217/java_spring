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
	<h1>TEST01입니다.</h1>
	<p>하이요</p>
	<ul>
		<li><a href="f.hi">오늘의 운세</a></li>
		<li><a href="p.hi">오늘의 인물</a></li>
		<li><a href="n_p.hi">다음의 인물</a></li>	
	</ul>
	<c:forEach var="tmp" items="${noticeList }" >
		<li>${tmp}</li>		
	</c:forEach>
</html>
