package pack;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/PostDataServlet")
public class PostDataServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			// post 요청 처리 전용 메소드
		response.setContentType("text/html;charset=utf-8"); 
		PrintWriter out = response.getWriter();
		request.setCharacterEncoding("utf-8");
		String name = request.getParameter("name");
		System.out.println(name);
		String addr[] = request.getParameterValues("addr"); // name이 같으면 배열처리
		System.out.println(addr[0] + addr[1]);
		try {
			String lan[] = request.getParameterValues("lan");
			out.println("<br>선택한 언어는");
			for(String ss:lan) {
				out.println(ss);
			}
		}catch(Exception e) { 
			out.println("언어를 한 개 이상 고르시오");
		}
		out.println("<br>운영체제는 "+request.getParameter("os"));
		out.println("<html><body>");
		out.println("<h3>서버가 전송한 자료 확인(post)</h3>");
		out.println("이름은 "+name);
		out.println("<br><br><a href='postdata.html'>자료다시 입력</a>");
		out.println("</body></html>");
		out.close();
	}
}
