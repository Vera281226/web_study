<%@page import="pack.JikwonDto"%>
<%@page import="pack.SangpumDto"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="dbConn" class="pack.JikDbConn"/>
<% dbConn.setBname(request.getParameter("name")); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table border="1">
	<tr>
		<th>사번</th><th>직원명</th><th>직급</th><th>성별</th>
	</tr>
	<% ArrayList<JikwonDto> list = dbConn.getDataAll(); 
		for(JikwonDto s:list){
			%>
				<tr>
		<td><%=s.getNo()%></td><td><%=s.getName()%></td><td><%=s.getJik() %></td><td><%=s.getGen() %></td>
	</tr>
			<%}%>
</table>
</body>
</html>