<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/todo/imsertform</title>
</head>
<body>
<div class="container">
	<h1>할일 입력</h1>
	<form action="${pageContext.request.contextPath}/todo/insert1.do" method="post">
		<div>
			<label for="content">할일</label>
			<input type="text" name="content" id="content" />
		</div>
		<button type="submit">추가</button>
	</form>
	
	<form action="${pageContext.request.contextPath}/todo/insert2.do" method="post">
		<div>
			<label for="content">할일</label>
			<input type="text" name="content" id="content" />
		</div>
		<button type="submit">추가</button>
	</form>
	
	<form action="${pageContext.request.contextPath}/todo/insert3.do" method="post">
		<div>
			<label for="content">할일</label>
			<input type="text" name="content" id="content" />
		</div>
		<button type="submit">추가</button>
	</form>
</div>
</body>
</html>