<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>전송 성공</title>
</head>
<body>
<%
request.setCharacterEncoding("utf-8"); //한글 깨짐 방지

String pwd= request.getParameter("pwd");
if(!pwd.equals("kor")) // 비밀번호가 kor이 아닌 경우 html로 회귀
	response.sendRedirect("js39jquerycheck.html");

String id = request.getParameter("userid");
String age = request.getParameter("age");

out.println(id+"님의 나이는"+age);
%>
</body>
</html>