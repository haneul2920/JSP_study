package ex01;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;



@WebServlet("/staff")
public class StaffServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request,HttpServletResponse response)  throws ServletException, IOException{
      response.setContentType("text/html;charset=utf-8");
      PrintWriter out=response.getWriter();	
      StaffDAO dao=new StaffDAO();
      StaffVO vo=new StaffVO(); 
      List list=dao.listMembers(vo);
	
      out.print("<html><body>");
      out.print("<table border=1><tr align='center' bgcolor='lightgreen'>");
      out.print("<td>직원코드</td><td>직원이름</td><td>나이</td><td>성별</td><td>주소</td><td>전화번호</td><td>부서코드</td><td>직급</td></tr>");
     
     for (int i=0; i<list.size();i++){
		StaffVO staffVO = (StaffVO) list.get(i);
		String code = staffVO.getCode();
		//String pwd = memberVO.getPwd();
		String name = staffVO.getName();
		String age = staffVO.getAge();
		String sex = staffVO.getSex();
		String addr = staffVO.getAddr();
		String phone = staffVO.getPhone();
		String dept = staffVO.getDept();
		String rank = staffVO.getRank();
		out.print("<tr><td>"+code+"</td><td>"
			                +name+"</td><td>"
			                +age+"</td><td>"			                
			                +sex+"</td><td>"
			                +addr+"</td><td>"
			                +phone+"</td><td>"			             
			                +dept+"</td><td>"
			                +rank+"</td></tr>");		
	 }
	 out.print("</table></body></html>");
   }
}