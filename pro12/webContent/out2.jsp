<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String name = request.getParameter("name");
	String age = request.getParameter("age");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>out 내장객체 테스트</title>
</head>
<body>
	<h1>이름 : <%=name %><br>나이 : <%=age%></h1>
	
	<h1><% out.println("이름 : "+name+"<br>나이 : "+age); %></h1>
</body>
</html>