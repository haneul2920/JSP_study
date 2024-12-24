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
			<th>회원 가입창</th>
			<tr>
				<td>아이디</td>
				<td><input type="text" name="id" placeholder="아이디을 입력해 주세요" required/></td>				
			</tr>			
			<tr>
				<td>맴버수</td>
				<td><input type="text" name="number" placeholder="맴버수을 입력해 주세요" required/></td>				
			</tr>			
			<tr>
				<td>그룹명</td>
				<td><input type="text" name="name" placeholder="그룹명을 입력해 주세요" required/></td>				
			</tr>			
			<tr>
				<td>주소</td>
				<td><input type="text" name="addr" placeholder="주소을 입력해 주세요" required/></td>				
			</tr>			
			<tr>
				<td>데뷔일자</td>
				<td><input type="text" name="debut_date" placeholder="데뷔일자을 입력해 주세요" required/></td>				
			</tr>			
			<tr>
				<td>핸드폰1</td>
				<td><input type="text" name="phone1" placeholder="핸드폰1을 입력해 주세요" required/></td>				
			</tr>			
			<tr>
				<td>핸드폰2</td>
				<td><input type="text" name="phone2" placeholder="핸드폰2을 입력해 주세요" required/></td>				
			</tr>			
			<tr>
				<td>키</td>
				<td><input type="text" name="height" placeholder="키을 입력해 주세요" required/></td>				
			</tr>
		</table>
		<input type="hidden" name="command" value="addMember"/>
		<input type="submit" value="가입하기"/>
		<input type="reset" value="다시입력"/>
	</form>
</body>
</html>