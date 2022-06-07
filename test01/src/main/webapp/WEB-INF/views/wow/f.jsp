<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String f=(String)request.getAttribute("f");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<p>오늘의 운세는 <strong>${f }</strong></p>
<%if(f.equals("대박")){ %>
	<img src="images/kim1.png" alt="대박일경우" />
<%} %>
</body>
</html>