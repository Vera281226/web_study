package pack;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@WebServlet("/ProductList")
public class ProductList extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Product> products = new ArrayList<Product>();
		products.add(new Product("볼펜", 1500, "모나미 볼펜", new Date()));
		products.add(new Product("연필", 500, "4B 연필", new Date()));
		products.add(new Product("노트", 5500, "값싼 노트", new Date()));
		
		request.setAttribute("products", products);
		request.getRequestDispatcher("productshow.jsp").forward(request, response);
	}
}