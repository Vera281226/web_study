<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
내장 객체 사용
<%
request.setCharacterEncoding("utf-8"); // request : client의 http 요청정보 수신
String id = request.getParameter("id");
String pwd = request.getParameter("pwd");

if(!(id.equals("aa") && pwd.equals("11"))) {response.sendRedirect("jspex4object.jsp");} 
// sendRedirect String 객체만을 보내고 받을 수 있다
//response: 응답 정보 저장 객체
%>
입력된 회원 정보 출력<br>
아이디는 <% out.println(id+"<br>"); // 3. out: 페이지 출력 스트림 객체 %>
protocol : <%= request.getProtocol() %>
Server buffer size : <%= response.getBufferSize() %>

Context path : <%= application.getContextPath()%>
Session : <%= pageContext.getSession() %>
</body>
</html>