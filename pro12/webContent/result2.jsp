<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String user_id = request.getParameter("user_id");
	String user_pw = request.getParameter("user_pw");
%>   
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%if (user_id.length() != 0) {%>
        <p>안녕하세요, <%= user_id %>님!</p>
<% } else { %>
        <p>로그인이 필요합니다.</p>
        <a href="/pro12/login.html">로그인하기</a>
<% } %>
</body>
</html>