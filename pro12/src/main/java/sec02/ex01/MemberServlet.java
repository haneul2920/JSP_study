package sec02.ex01;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;



@WebServlet("/member2")
public class MemberServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request,HttpServletResponse response)  throws ServletException, IOException{
      response.setContentType("text/html;charset=utf-8");
      PrintWriter out=response.getWriter();	
      MemberDAO dao=new MemberDAO();
      MemberVO vo=new MemberVO(); 
      List list=dao.listMembers(vo);
	
      out.print("<html><body>");
      out.print("<table border=1><tr align='center' bgcolor='lightgreen'>");
      out.print("<td>아이디</td><td>멤버수</td><td>그룹명</td><td>주소</td><td>데뷔일자</td><td>전화번호</td><td>키</td></tr>");
     
     for (int i=0; i<list.size();i++){
		MemberVO memberVO = (MemberVO) list.get(i);
		String id = memberVO.getId();
		//String pwd = memberVO.getPwd();
		String number = memberVO.getNumber();
		String name = memberVO.getName();
		String addr = memberVO.getAddr();
		Date debut_date = memberVO.getDebut_date();
		String phone1 = memberVO.getPhone1();
		String phone2 = memberVO.getPhone2();
		String height = memberVO.getHeight();
		out.print("<tr><td>"+id+"</td><td>	"
			                +number+"</td><td>"
			                +name+"</td><td>"			                
			                +addr+"</td><td>"
			                +debut_date+"</td><td>"
			                +phone1+phone2+"</td><td>"			             
			                +height+"</td></tr>");		
	 }
	 out.print("</table></body></html>");
   }
}