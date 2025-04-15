package pack2;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/ServletSession")
public class ServletSession extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 서블릿 세션 요청
		// 클라이언트 정보를 서버 컴퓨터에 메모리를 확보하고 저장하는 것 상태 유지가 목적
		HttpSession httpSession = request.getSession(true); // 세션이 있으면 읽고 없으면 세션을 생성
		// HttpSession session = request.getSession(false); // 세션이 있으면 읽고 없으면 세션을 생성 안함
		httpSession.setMaxInactiveInterval(10); // 10은 10초를 의미 세션의 유효시간 기본값 30분 세션은 쿠키와 다르게 짧게 준다. 활동할때 시간은 리셋
		if(httpSession != null ) {
			httpSession.setAttribute("myname", "신기해"); // 키 밸류 형식
			httpSession.setAttribute("myaddr", "테헤란로"); 
		}
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		out.println("session id = " + httpSession.getId());
		out.println("<br>session 내의 myname 키가 가진 값 = " +httpSession.getAttribute("myname") );
		out.println("<br>session 내의 myaddr 키가 가진 값 = " +httpSession.getAttribute("myaddr") );
		out.println("</body></html>");
		out.close();
	}
}
