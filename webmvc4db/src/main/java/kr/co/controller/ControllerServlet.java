package kr.co.controller;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.ServletException;
import java.io.IOException;

@WebServlet("/sang.do")
public class ControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ControllerServlet() {
        super();
    }
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String command = request.getParameter("command"); 
 	
    	// 처리 인터페이스 운영
    	CommandInter inter = null;
    	String viewName="/WEB-INF/views/";
    	
    	try {
			if (command.equals("jikwon")) {
				// 직원 관련 작업
			}else if (command.equals("gogek")) {
				// 고객 관련 작업
			}else if (command.equals("sangpum")) {
				// 상품 관련 작업
				inter = new SangpumImp();
				viewName += inter.showData(request, response);
				request.getRequestDispatcher(viewName).forward(request, response);
			}else {
				viewName = "error.html";
				response.sendRedirect(viewName);
			}
		} catch (Exception e) {
			System.out.println("service err"+e.getMessage());
		}
    }
}