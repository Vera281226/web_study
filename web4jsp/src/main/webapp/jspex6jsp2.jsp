<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
jsp에 의해 호출된 파일
<%
//String data=request.getParameter("mydata");
//out.println("redirect : " +data);

String data = (String)request.getAttribute("mydata"); // 그냥 받으면 형식 오류 오브젝트 타입이다.
out.println("forward : "+data);

out.println("<br> 길동이 출력 : ");
ArrayList<String> list = (ArrayList)request.getAttribute("listdata");
for(String i:list){
	out.println(i);
}
%>
</body>
</html>