package pack.mvc.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.StringTokenizer;

@WebServlet("*.m2")
public class UserSerlvet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ModelAndView modelAndView = null;
	private Controller controller = null;
	
	protected void service(HttpServletRequest request, HttpServletResponse response){
		try {
			request.setCharacterEncoding("utf-8");
			
			// .m2 앞의 호출명을 요청 정보로 사용 
			String ss = request.getRequestURI();
			int idx = ss.lastIndexOf('/');
			StringTokenizer st = new StringTokenizer(ss.substring(idx + 1), ".");
			ss = st.nextToken();
			
			String command = ss;			
			controller = getAction(command);
			modelAndView = controller.execute(request, response);
			
			// 분할시킨 수행한 컨트롤러에서 얻은 view 경로와 사용할 데이터를 보내서 사용
			if(modelAndView.isRedirect()) { // 리다이렉트 처리
				response.sendRedirect(modelAndView.getViewName());
			} else { // 포워딩 처리
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/"+modelAndView.getViewName());
				dispatcher.forward(request, response);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	public Controller getAction(String command) throws Exception {
		if(command.equals("list")) controller = new ListController();
		else if (command.equals("login")) controller = new LoginController();
		else if (command.equals("logout")) controller = new LogoutController();
		else if (command.equals("insert")) controller = new InsertController();
		else if (command.equals("update")) controller = new UpdateController();
		else if (command.equals("updateform")) controller = new UpdateFormController();
		else if (command.equals("delete")) controller = new DeleteController();
		else if (command.equals("view")) controller = new ViewController();
		
		return controller;
	}
}