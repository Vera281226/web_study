package pack;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/irum.go")
public class jspex5servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String data = request.getParameter("data");
		//System.out.println("data : "+data);
		// jsp 또는 servlet 파일 호출 1: redirect - client를 통해 파일 호출
		// response.sendRedirect("jspex5jsp.jsp?mydata="+data); // 리다이렉트는 문자열만 보낼 수 있다.
		// jsp 또는 servlet 파일 호출 2: forward - server에서 바로 파일 호출
		request.setAttribute("mydata", data); //forward 방식에서 파일 호출시 값을 주려면 request 이용 가능 모든 형식 객체 가능
		RequestDispatcher dispatcher = request.getRequestDispatcher(data);
		dispatcher.forward(request, response); // 서비스로 보내는 request, response다
		
		// 호
	}
}
