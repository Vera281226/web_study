<%-- page 지시어 : 현재 문서의 속성이나 정보 등을 선언 또는 지시하는 역할을 한다. 맨위 지시어 위에 뭐가 있으면 안된다 --%>

<%@page import="java.time.ZoneId"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
import="java.time.LocalDate, java.sql.Connection, java.sql.ResultSet" 
session="true"
buffer="8kb"
autoFlush="true"
isThreadSafe="true"
info="jsp 문서정보 기록"
errorPage="jspex2err.jsp"
%>

<%-- 웹페이지 지시어 내의 각종 설정들 왠만하면 쓰지않는다 --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>page 지시어</title>
</head>
<body>
<h2>page 지시어</h2>
현재 날짜 :
<%
LocalDate now = LocalDate.now(ZoneId.of("Asia/Seoul"));
out.println(now.getYear()+"년 "+now.getMonthValue()+"월 "+now.getDayOfMonth()+"일 ");
%>
<hr>
<%=10/0 %> <%-- 문법에러 , 런타임에러, 등은 개발자가 수정한다. 
이외의 클라이언트에게 발생할 수 있는 에러의 알림 위한 페이지를 따로 작성해 주어야한다. --%>

</body>
</html>