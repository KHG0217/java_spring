<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/todo/updateform</title>
</head>
<body>
   <div class="container">
      <h1>회원 정보 수정 폼</h1>
      <form action="update.do" method="post">
         <input type="hidden" name="num" value="${dto.num }"/>
         <div>
            <label for="num">번호</label>
            <input type="text" id="num" value="${dto.num }" disabled/>
         </div>
         <div>
            <label for="content">할일</label>
            <input type="text" name="content" id="content" value="${dto.content }"/>
         </div>
         <div>
            <label for="regdate">수정날짜</label>
            <input type="text" name="regdate" id="regdate" value="${dto.regdate }" disabled/>
         </div>
         <button type="submit">수정 확인</button>
         <button type="reset">취소</button>
      </form>
   </div>
</body>
</html>