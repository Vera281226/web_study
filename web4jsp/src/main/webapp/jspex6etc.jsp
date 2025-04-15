<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
// redirect 방식 호출
// response.sendRedirect("WEB-INF/kbs.jsp"); // 파일 경로에 WEB-INF에 들어가선 안된다

// forward 방식 호출
//RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/kbs.jsp"); // 경로가 나오지 않는다 foward 방식은 가능하다
//dispatcher.forward(request, response);
%>
<jsp:forward page="WEB-INF/kbs.jsp"/>