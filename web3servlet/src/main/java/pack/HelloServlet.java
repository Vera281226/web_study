package pack;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/HelloServlet") // 클라이언트 측의 요청하는 서블릿 이름에 대해 매핑을 제공한다 이 이름은 클래스 이름과 관련이 없어도 된다
// 논리적인 요청으로 물리 파일을 찾아감
public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void init(ServletConfig config) throws ServletException {
		// 서블릿 요청시 1회만 수행 초기화 담당
	}

	public void destroy() {
		
	}

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("요청 성공");
		response.setContentType("text/html;charset=utf-8"); 
		// Mime type과 문자코드 설정 MIME TYPE은 인터넷에서 전송되는 다양한 종류의 데이터를 식별하기 위한 형식
		// ,주로 웹 브라우저가 웹 서버로부터 받은 데이터를 해석할 때 사용된다.
		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		out.println("<h2>안녕 서블릿</h2>");
		out.println("</body></html>");
		out.close(); // 클라이언트 브라우저로 전송
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
