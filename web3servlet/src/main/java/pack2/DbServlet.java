package pack2;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

@WebServlet("/DbServlet")
public class DbServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private Connection connection = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet resultSet = null;
	
	public void init(ServletConfig config) throws ServletException { // 시작
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mariadb://localhost:3306/test", "root", "123");
			preparedStatement = connection.prepareStatement("SELECT * FROM sangdata");
		} catch (Exception e) { System.out.println(e.getMessage()); }
	}

	public void destroy() { // 종료
		try {
			if(resultSet != null) resultSet.close();
			if(preparedStatement != null) preparedStatement.close();
			if(connection != null) connection.close();		
		} catch (Exception e) { System.out.println(e.getMessage()); }
	}

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		out.println("<h2>상품 정보 (서블릿)</h2>");
		try {
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				out.println(resultSet.getString("code")+" "+
						resultSet.getString("sang")+" "+
						resultSet.getString("su")+" "+
						resultSet.getString("dan")+"<br>"
						);
			}
		} catch (Exception e) { System.out.println(e.getMessage()); }
		out.println("</body></html>");
		out.close();
	}
}
