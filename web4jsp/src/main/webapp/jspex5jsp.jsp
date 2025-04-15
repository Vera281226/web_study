<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>서블릿에 의해 호출된 파일</title>
</head>
<body>
수신 자료 :
<%
//request.setCharacterEncoding("utf-8");
//String data = request.getParameter("mydata");
//out.println("Redirect : "+data);
// 호출하기 2
String data = (String)request.getAttribute("mydata"); // 그냥 받으면 형식 오류 오브젝트 타입이다.
out.println("forward : "+data);
%>
</body>
</html>