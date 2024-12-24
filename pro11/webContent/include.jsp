<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>인클루드 디렉티브</title>
<!--
디렉티브 태그는 주로 JSP 페이지에 전반적인 설정 정보를 지정할 때 사용하는 태그
1. 페이지 디렉티브 태그 : JSP 페이지의 전반적인 정보를 설정할 때 사용한다.
	language : JSP 페이지에서 사용할 언어를 지정(기본값 : java)
	contentType : JSP 페이지 출력 형식을 지정(기본값 : text/html)
	pageEncoding : JSP 페이지에서 사용하는 문자열 인코딩을 지정(기본값 : ISO-8859-1+)
2. 인클루드 디렉티브 태그 : 공통으로 사용하는 JSP 페이즈를 다른 JSP 페이지에 추가할 때 사용한다.
3. 태그라이브 디렉티브 태그 : 개발자난 프레임워크에서 제공하는 태그를 사용할 때 사용한다.
 
 -->
</head>
<body>
	<h1>시작입니다</h1>
	<%@ include file="duke_image.jsp" %>
	<h1>끝입니다</h1>
</body>
</html>