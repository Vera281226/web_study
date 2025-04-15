package pack;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

@WebServlet(urlPatterns = {"/ServletTest", "/kbs.mbc", "/good"})
public class ServletTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private int number = 0; // 전역변수
	ServletTest2 test2;
	
    public ServletTest() {
        super();
        System.out.println("서블릿 생명주기 - 1 생성자 ");
    }

	public void init(ServletConfig config) throws ServletException {
		// 서블릿 요청시 1회만 수행 초기화 담당
		test2 = new ServletTest2("홍길동");
		System.out.println("서블릿 생명주기 - 2 init ");
	}
	// get과 post를 모두 받아 처리한다.
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("서블릿 생명주기 - 3 service ");
		number++;
		int a = 10,b = 20; // 지역변수
		int result = calcData(a, b);
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		out.println("<h2>서블릿의 멤버 확인</h2>");
		out.println("number :"+number+"<br>");
		out.println("a :"+a+"<br>");
		out.println("b :"+b+"<br>");
		out.println("클라이언트 컴퓨터 출력장치 계산 결과 : "+result);
		System.out.println("서버 컴퓨터 출력장치 계산 결과 출력" + result);
		
		// 별도 작성 클래스 멤버 호출
		// ServletTest2 test2 = new ServletTest2("홍길동"); // 객체를 요청 시마다 생성되어 메모리 낭비가 심각함 1회만 수행되도록 싱글톤 패턴을 사용
		out.println("<br>이름은 "+test2.getIrum());
		out.println("현재 년 : "+ Calendar.getInstance().get(Calendar.YEAR));
		out.println("</body></html>");
		out.close();
		
		// 클라이언트의 요청 시 내부적으로 스레드가 생성되고 소켓 통신을 이용한다. 
		// 기존의 객체에 스레드만 새로할당시켜 서비스를 수행시켜 메모리 사용을 효율적으로 한다. 
		String threadName = Thread.currentThread().getName();
		System.out.println("현재 스레드 명 : "+threadName);
		System.out.println("socket으로 클라이언트 ip : "+request.getRemoteAddr());
		System.out.println("socket으로 클라이언트 port : "+request.getRemotePort());
		doGet(request, response);
		doPost(request, response);
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// get 요청 처리 service보다 우선순위가 낮다
		System.out.println("서블릿 생명주기 - 4 doGet ");
	} // 요청에 맞지 않으면 403에러 
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// post 요청 처리 service보다 우선순위가 낮다
		System.out.println("서블릿 생명주기 - 4 doPost ");
	}
	@Override
	public void destroy() {
		// 웹 서버 서비스 종료시 수행
		System.out.println("서블릿 생명주기 - 5 destroy ");
	}
	private int calcData(int a, int b) {
		return a+b;
	}
}
