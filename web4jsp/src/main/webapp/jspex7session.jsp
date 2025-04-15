<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%
request.setCharacterEncoding("utf-8");
String id = request.getParameter("id");

if(!id.equalsIgnoreCase("aa")) {
	response.sendRedirect("jspex7main.html");
}

// request set, get Attribute 방식은 jsp 서블릿 파일마다 보내는 것이 불편하다 
session.setAttribute("mykey", id); // session : 내장 객체 - 세션 자체에 저장시킨 값은 각 jsp 서블릿 파일에서 접근이 가능해 사용이 편하다
session.setMaxInactiveInterval(10); // 유효시간 기본값 30분
// 세션하이재킹등의 보안문제들을 대비하기 위해 세션 수명을 정해줘야한다. 서버 자원 사용이 매우 증가할 수 있다. 성능 저하의 원인이 될 수 있다.
application.setAttribute("mykey", id);
// 세션에 저장시킨 정보는 세션 사용자에게만 접근 가능한 정보다 
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>세션 연습</title>
</head>
<body>
<form action="jspex7show.jsp">
	<input type="radio" name="movie" value="미키17" checked="checked">미키17&nbsp;&nbsp;
	<input type="radio" name="movie" value="백설공주" checked="checked">백설공주&nbsp;&nbsp;
	<input type="radio" name="movie" value="콘클라베" checked="checked">콘클라베&nbsp;&nbsp;
	<input type="submit" value="결과보기">
</form>
</body>
</html>