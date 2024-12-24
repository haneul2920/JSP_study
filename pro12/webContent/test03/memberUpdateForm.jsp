<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 가입창</title>
</head>
<body>
	<form name="frmMember" method="post" action="member.jsp">
		<table>
			<th>회원 정보 수정</th>
			<tr>
				<td>아이디</td>
				<td><input type="text" name="id" value="<%=request.getParameter("id") %>" required/></td>				
			</tr>			
			<tr>
				<td>맴버수</td>
				<td><input type="text" name="number" value="<%=request.getParameter("number") %>" required/></td>				
			</tr>			
			<tr>
				<td>그룹명</td>
				<td><input type="text" name="name" value="<%=request.getParameter("name") %>" required/></td>				
			</tr>			
			<tr>
				<td>주소</td>
				<td><input type="text" name="addr" value="<%=request.getParameter("addr") %>" required/></td>				
			</tr>			
			<tr>
				<td>데뷔일자</td>
				<td><input type="text" name="debut_date" value="<%=request.getParameter("debut_date") %>" required/></td>				
			</tr>			
			<tr>
				<td>핸드폰1</td>
				<td><input type="text" name="phone1" value="<%=request.getParameter("phone1") %>" required/></td>				
			</tr>			
			<tr>
				<td>핸드폰2</td>
				<td><input type="text" name="phone2" value="<%=request.getParameter("phone2") %>" required/></td>				
			</tr>			
			<tr>
				<td>키</td>
				<td><input type="text" name="height" value="<%=request.getParameter("height") %>" required/></td>				
			</tr>
		</table>
		<input type="hidden" name="command" value="updateMember"/>
		<input type="submit" value="수정하기"/>
		<input type="reset" value="다시입력"/>
	</form>
</body>
</html>