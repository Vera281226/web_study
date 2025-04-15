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

@WebServlet("/CartServlet")
public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String name = request.getParameter("name");
		int price = Integer.parseInt(request.getParameter("price"));
		
		// 넘어오는 데이터는 DTO로 만들고 list 컬렉션에 넣는다 그것을 세션안에 넣어둔다.
		// 클라이언트가 추가 DTO를 컬렉션에 넣을때 세션에서 불러오고 옮긴 뒤 다시 세션안에 들어간다
		// 추가 정보에 대해 이 과정을 반복한다.
		
		HttpSession httpSession = request.getSession(true); // 클라이언트의 고유 세션
		ArrayList<Goods> glist = (ArrayList<Goods>) httpSession.getAttribute("list"); // 세션이 있을 경우 리스트 키 값 읽기
		if(glist == null) glist = new ArrayList<Goods>(); // 세션이 없을 경우 Goods용 컬렉션 객체 생성
		glist.add(new Goods(name, price)); // 컬렉션에 DTO값을 읽어 저장 시켜 장바구니로 만들어줌
		httpSession.setAttribute("list", glist); // 장바구니 DTO 컬렉션을 세션에 저장 시킴
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<html><body>" +name+ " 상품 구입하셨습니다");
		out.println("<br>[ <a href='shopping/shop.html'>계속 쇼핑</a> ]");
		out.println("&nbsp;&nbsp;[ <a href='BuyServlet'>결제하기</a> ]");
		out.println("<br><table width='80%' border='1'>");
		out.println("<tr><th>상품명</th><th>가격</th></tr>");
		for(int i=0; i<glist.size(); i++) {
			Goods goods = glist.get(i); //컬렉션에 저장된 상품 자료(DTO) 한 개씩 꺼내서 출력
			out.println("<tr><td>"+goods.getName()+"</td><td>+"+goods.getPrice()+"</td></tr>");			
		}
		out.println("</table>");
		out.println("</body></html>");
		out.close();
	}
}
