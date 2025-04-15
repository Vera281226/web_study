<%@page import="pack.Jspex9Gugu"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
int dan = Integer.parseInt(request.getParameter("dan"));
out.println(dan + "단 출력<br>");
Jspex9Gugu gugu = Jspex9Gugu.getInstance();
int result[] = gugu.compute(dan);
for(int i=0; i<result.length; i++) { 
out.println(dan+"*"+(i+1)+"="+result[i]+"<br>");
}
%>
<hr>
<!-- beans 사용 -->
<jsp:useBean id="gugu2" class="pack.Jspex9Gugu"/> <!--  별도의 인스턴스 생성 절차조차 필요없다. -->
<% int result2[] = gugu2.compute(dan);
for(int i=0; i<result2.length; i++) { 
out.println(dan+"*"+(i+1)+"="+result2[i]+"<br>");
}
%>
</body>
</html>