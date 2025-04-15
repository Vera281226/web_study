package pack;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/TestJstl")
public class HttpServlet extends jakarta.servlet.http.HttpServlet {
private static final long serialVersionUID = 1L;

protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String irum = "홍길동";
		request.setAttribute("irum", irum);		
		
		Person person = new Person();
		person.setName("한국인");
		request.setAttribute("person", person);
		
		Student student = new Student();
		student.setAge(22);
		request.setAttribute("student", student);
		
		
		String[] ani = {"개","고양이","닭"};
		request.setAttribute("animal", ani);
		
		String[] foods = {"개밥","고양이밥","모이"};
		List<Object> list = new ArrayList<Object>();
		list.add(ani);
		list.add(foods);
		request.setAttribute("list", list);
		request.getRequestDispatcher("testjstl.jsp").forward(request, response);
	}
}