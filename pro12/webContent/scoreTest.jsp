<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	String score = request.getParameter("score");	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<% if (Integer.parseInt(score) >= 90){ %>
	<p>A학점 입니다.</p>
	<% }else if (Integer.parseInt(score) >= 80 && Integer.parseInt(score) < 90) {%>
	<p>B학점 입니다.</p>
	<% }else if (Integer.parseInt(score) >= 70 && Integer.parseInt(score) < 80) {%>
	<p>C학점 입니다.</p>
	<% }else if (Integer.parseInt(score) >= 60 && Integer.parseInt(score)  < 70) {%>
	<p>D학점 입니다.</p>
	<% }else { %>
	<p>F학점 입니다.</p>
	<% } %>
	<a href="/pro12/scoreTest.html">시험점수입력</a>
</body>
</html>