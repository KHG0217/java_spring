<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/todo/update.jsp</title>
</head>
<body>
	<h1>알림</h1>
	<p>
		<strong>${param.num }</strong>번째 할일 수정하였습니다.
		<a href="${pageContext.request.contextPath }/todo/list.do">확인</a>
	</p>
</body>
</html>