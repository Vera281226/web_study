package pack2;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/ServletCookie")
public class ServletCookie extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private CookieManager cookieManager;

    public void init() throws ServletException {
        cookieManager = CookieManager.getInstance();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        out.println("<html><head><title>로그인</title></head><body>");
        out.println("<h2>로그인</h2>");
        out.println("<form method='post' action='ServletCookie'>");
        out.println("ID: <input type='text' name='id'><br>");
        out.println("Password: <input type='password' name='pwd'><br>");
        out.println("<input type='submit' value='로그인'>");
        out.println("</form>");
        out.println("</body></html>");
        out.close();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();

        String id = request.getParameter("id");
        String pwd = request.getParameter("pwd");

        out.println("<html><head><title>로그인 결과</title></head><body>");

        try {
            // 로그인 정보를 암호화하여 쿠키에 저장
        	out.println("user_id : " + id+"<br>");
        	out.println("user_pwd : " + pwd+"<br>");
            Cookie idCookie = cookieManager.createCookie("user_id", id);
            Cookie pwdCookie = cookieManager.createCookie("user_pwd", pwd);
            out.println("user_id : " + idCookie.getValue()+"<br>");
            out.println("user_pwd : " + pwdCookie.getValue()+"<br>");
            
            response.addCookie(idCookie);
            response.addCookie(pwdCookie);

            out.println("<h2>로그인 성공!</h2>");
            out.println("<p>암호화된 쿠키가 생성되었습니다.</p>");

            // 저장된 쿠키 읽기 및 복호화
            Cookie[] cookies = request.getCookies();
            if (cookies != null) {
                for (Cookie cookie : cookies) {
                    if (cookie.getName().equals("user_id") || cookie.getName().equals("user_pwd")) {
                        String decryptedValue = cookieManager.readCookie(cookie);
                        out.println("<p>" + cookie.getName() + " (복호화): " + decryptedValue + "</p>");
                    }
                }
            }
        } catch (Exception e) {
            out.println("<h2>오류 발생</h2>");
            out.println("<p>쿠키 처리 중 오류가 발생했습니다: " + e.getMessage() + "</p>");
        }

        out.println("</body></html>");
        out.close();
    }
}