package pack.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import pack.model.HobbyModel;

import java.io.IOException;
import java.util.ArrayList;

// @WebServlet("*.do") // xml에서의 설정과 동일한 기능을 하는 @이다
public class HobbyController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HobbyModel hobbyModel;
	
	@Override
	public void init() throws ServletException {
		hobbyModel = new HobbyModel();
	}
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 컨트롤러 작업
		// 1) 요청 수신
		String hobby = request.getParameter("hobby");
		
		// 2) 특정 클래스 수행 후 결과 반환 요청 처리 작업 단위
		ArrayList<String> list =  hobbyModel.getHobby(hobby);
		request.setAttribute("datas", list);
		String viewName = "/WEB-INF/views/hobbyresult.jsp";
		
		// 다른 요청에 대한 작업도 가능하다
		
		// 3) 뷰 영역 선택 후 호출
		request.getRequestDispatcher(viewName).forward(request, response);
	}
}