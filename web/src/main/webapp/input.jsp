<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    // 이 구역은 자바
    String irum = request.getParameter("irum");
    String age = request.getParameter("nai");
    System.out.println("이름은 "+irum+", 나이는 "+age);
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 여기는 자바 안에 포함된 HTML 구역 -->
</body>
</html>