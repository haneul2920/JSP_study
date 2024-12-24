package sec01.ex01;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

// 서블릿 매핑을 위한 URL 패턴 지정
@WebServlet("/lifecycle")
public class FirstServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    // 서블릿이 초기화될 때 한 번 호출됨. 보통 초기화 작업을 수행함.
    @Override
    public void init() throws ServletException {
        // 서블릿이 초기화될 때 호출되는 메서드
        System.out.println("서블릿 초기화 중: init() 메서드 호출");
    }

    // HTTP GET 요청을 처리하는 메서드. 클라이언트로부터 GET 요청이 올 때마다 호출됨.
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        // 클라이언트의 GET 요청을 처리하는 메서드
        System.out.println("클라이언트 요청 처리 중: doGet() 메서드 호출");
        
        // 응답 콘텐츠 타입을 HTML로 설정하고, UTF-8 인코딩을 사용함.
        response.setContentType("text/html; charset=UTF-8");
        
        // 응답 출력 스트림을 통해 클라이언트에게 HTML 메시지를 전송함.
        response.getWriter().println("<h1>서블릿 생명주기 테스트</h1>");
    }

    // 서블릿이 제거될 때 한 번 호출됨. 보통 정리 작업을 수행함.
    @Override
    public void destroy() {
        // 서블릿이 종료될 때 호출되는 메서드
        System.out.println("서블릿 종료 중: destroy() 메서드 호출");
    }
}
