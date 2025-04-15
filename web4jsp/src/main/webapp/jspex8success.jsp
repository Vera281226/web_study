<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% // 세션 읽기 
if(session.getAttribute("userid") != null) { // 인가작업을 위한 세션의 id 확인
	%>
<!-- 그냥 두면 인가가 아니다 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>축하합니다 인가(Authorization)</h2>
작업 권한을 여기서 부여함
<a href="jspex8logout.jsp">로그아웃</a>
</body>
</html>

<%
}else {
	// 사용자 정보 없이 호출한 경우
	response.sendRedirect("jspex8login.html");
}
%>