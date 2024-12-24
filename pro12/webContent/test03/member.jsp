<%@ page language="java" contentType="text/html; charset=UTF-8"
	import="java.util.*"
	import="sec02.ex01.*"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style>
	h1{
		text-align: center;
	}
</style>
<meta charset="UTF-8">
<title>회원 정보 출력창</title>
</head>
<body>
	<h1>회원 정보 출력</h1>
<%
	request.setCharacterEncoding("utf-8");
	String _name = request.getParameter("name");
	String command = request.getParameter("command");
	MemberVO memberVO = new MemberVO();
	memberVO.setName(_name);
	MemberDAO dao = new MemberDAO();
	if(command == null){
		if(_name != null) memberVO.setName(_name);
		else memberVO.setName("");
	}else if(command.equals("addMember")){
			String _id = request.getParameter("id");
			String _number = request.getParameter("number");
			String _addr = request.getParameter("addr");
			String _phone1 = request.getParameter("phone1");
			String _phone2 = request.getParameter("phone2");
			String _height = request.getParameter("height");			
			memberVO.setId(_id);
			memberVO.setName(_name);
			memberVO.setNumber(_number);
			memberVO.setAddr(_addr);
			memberVO.setPhone1(_phone1);
			memberVO.setPhone2(_phone2);
			memberVO.setHeight(_height);
			
			dao.addMember(memberVO);
	}else if(command.equals("delMember")){		
		String _id = request.getParameter("id");		
		memberVO.setId(_id);
		dao.delMember(memberVO);
	}else if(command.equals("updateMember")){
		String _id = request.getParameter("id");
		String _number = request.getParameter("number");
		String _addr = request.getParameter("addr");
		String _phone1 = request.getParameter("phone1");
		String _phone2 = request.getParameter("phone2");
		String _height = request.getParameter("height");
		memberVO.setId(_id);
		memberVO.setName(_name);
		memberVO.setNumber(_number);
		memberVO.setAddr(_addr);
		memberVO.setPhone1(_phone1);
		memberVO.setPhone2(_phone2);
		memberVO.setHeight(_height);
		dao.updateMember(memberVO);
	}
	List membersList = dao.listMembers(memberVO);
%>
	<table border=1 width=800 align=center>
		<tr align=center bgcolor="#FFFF66">
			<th>아이디</th>
			<th>맴버수</th>
			<th>그룹명</th>
			<th>주소</th>			
			<th>데뷔일자</th>
			<th>전화번호</th>			
			<th>키</th>
			<th>삭제</th>
		</tr>
	<%
		for(int i = 0; i<membersList.size();i++){
			MemberVO vo = (MemberVO)membersList.get(i);
			String id = vo.getId();
			String number = vo.getNumber();
			String name = vo.getName();
			String addr = vo.getAddr();		
			Date debut_date = vo.getDebut_date();
			String phone1 = vo.getPhone1();
			String phone2 = vo.getPhone2();
			String height = vo.getHeight();
	%>
		<tr align=center>
			<td><%=id %></td>
			<td><%=number %></td>
			<td><a href="/pro12/test03/memberUpdateForm.jsp?command=updateForm&id=<%=id%>
																			&name=<%=name%>
																			&addr=<%=addr%>
																			&debut_date=<%=debut_date%>
																			&phone1=<%=phone1%>
																			&phone2=<%=phone2%>
																			&number=<%=number%>
																			&height=<%=height%>"><%=name %></a></td>			
			<td><%=addr %></td>
			<td><%=debut_date %></td>
			<td><%=phone1+phone2 %></td>
			<td><%=height %></td>
			<td><a href="/pro12/test03/member.jsp?command=delMember&id=<%=id%>" onclick="return confirm('삭제하시겟습니까?')">삭제</a></td>
		</tr>
	<%
		}
	%>
	</table>
</body>
</html>