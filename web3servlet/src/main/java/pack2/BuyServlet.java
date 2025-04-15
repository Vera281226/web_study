package pack2;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet("/BuyServlet")
public class BuyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession httpSession = request.getSession(false);
		if(httpSession == null) return; // 처리를 따로 더 해줘야함
		
		ArrayList<Goods> glist = (ArrayList<Goods>) httpSession.getAttribute("list");
		if(glist == null) return; // 처리를 따로 더 해줘야함
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		out.println("<br><table width='80%' border='1'>");
		out.println("<tr><th>상품명</th><th>가격</th></tr>");
		int totPrice =0;
		for(int i=0; i<glist.size(); i++) {
			Goods goods = glist.get(i); //컬렉션에 저장된 상품 자료(DTO) 한 개씩 꺼내서 출력
			out.println("<tr><td>"+goods.getName()+"</td><td>+"+goods.getPrice()+"</td></tr>");
			totPrice += goods.getPrice();			
		}
		out.println("<tr><td colspan='2'>결제 총액 : "+totPrice+"</td></tr>");
		out.println("</table>");
		out.println("<br>감사합니다");
		out.println("<br><a href='shopping/shop.html'>쇼핑하러 가기</a>");
		// 세션 초기화가 필요한 부분이 있다.
		httpSession.invalidate(); // 해당 클라이언트의 세션 내 모든 키 삭제
		httpSession.removeAttribute("list"); // 해당 클라이언트의 세션 내 특정 키만 삭제
		out.println("</body></html>");
		out.close();
	}
}