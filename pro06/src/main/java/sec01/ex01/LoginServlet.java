package sec01.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class LoginServlet extends HttpServlet{

	public void init() throws ServletException {
        // 서블릿이 초기화될 때 호출되는 메서드
        System.out.println("서블릿 초기화 중: init() 메서드 호출");
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // 클라이언트의 GET 요청을 처리하는 메서드
        System.out.println("클라이언트 요청 처리 중: doGet() 메서드 호출");
        
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");
        
        String user_id = request.getParameter("user_id");
        String user_pw = request.getParameter("user_pw");
        
        System.out.println("아이디 : " + user_id);
        System.out.println("비밀번호 : " + user_pw);
        
        PrintWriter out = response.getWriter();
        String data = "<html>";
        data += "<body>";
        data += "아이디 : " + user_id;
        data += "<br>";
        data += "패스워드 : " + user_pw;
        data += "</body>";
        data += "</html>";
        out.print(data);

    }
}
