<%@ page language="java" contentType="text/html; charset=UTF-8"
	import="java.util.*"
	import="ex01.*"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>회원 정보 출력</h1>
<%
	request.setCharacterEncoding("utf-8");
	String _name = request.getParameter("name");
	String command = request.getParameter("command");
	StaffVO staffVO = new StaffVO();
	StaffDAO dao = new StaffDAO();
	if(command == null){
		if(_name != null) staffVO.setName(_name);
		else staffVO.setName("");
	}else if(command.equals("addStaff")){
			String _code = request.getParameter("code");
			String _age = request.getParameter("age");
			String _sex = request.getParameter("sex");
			String _addr = request.getParameter("addr");
			String _phone = request.getParameter("phone");
			String _dept = request.getParameter("dept");		
			String _rank = request.getParameter("rank");		
			staffVO.setCode(_code);
			staffVO.setName(_name);
			staffVO.setAge(_age);
			staffVO.setSex(_sex);
			staffVO.setAddr(_addr);
			staffVO.setPhone(_phone);
			staffVO.setDept(_dept);
			staffVO.setRank(_rank);
			
			dao.addStaff(staffVO);
	}else if(command.equals("delStaff")){		
		String _code = request.getParameter("code");		
		staffVO.setCode(_code);
		dao.delStaff(staffVO);
	}else if(command.equals("updateStaff")){
		String _code = request.getParameter("code");
		String _age = request.getParameter("age");
		String _sex = request.getParameter("sex");
		String _addr = request.getParameter("addr");
		String _phone = request.getParameter("phone");
		String _dept = request.getParameter("dept");
		String _rank = request.getParameter("rank");
		staffVO.setCode(_code);
		staffVO.setName(_name);
		staffVO.setAge(_age);
		staffVO.setSex(_sex);
		staffVO.setAddr(_addr);
		staffVO.setPhone(_phone);
		staffVO.setDept(_dept);
		staffVO.setRank(_rank);
		dao.updateStaff(staffVO);
	}
	List staffList = dao.listStaff(staffVO);
%>
	<table border=1 width=800 align=center>
		<tr align=center bgcolor="#FFFF66">
			<th>직원코드</th>
			<th>직원이름</th>
			<th>나이</th>
			<th>성별</th>			
			<th>주소</th>
			<th>전화번호</th>			
			<th>부서코드</th>
			<th>직급</th>
			<th>삭제</th>
		</tr>
	<%
		for(int i = 0; i<staffList.size();i++){
			StaffVO vo = (StaffVO)staffList.get(i);
			String code = vo.getCode();
			String name = vo.getName();
			String age = vo.getAge();
			String sex = vo.getSex();
			String addr = vo.getAddr();
			String phone = vo.getPhone();
			String dept = vo.getDept();
			String rank = vo.getRank();
	%>
		<tr align=center>
			<td><%=code %></td>
			<td><%=name %></td>
			<td><a href="/ProductionManagement/staffManagement/staffUpdateForm.jsp?command=updateForm&code=<%=code%>
																			&name=<%=name%>
																			&addr=<%=age%>
																			&debut_date=<%=sex%>
																			&phone1=<%=addr%>
																			&phone2=<%=phone%>
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