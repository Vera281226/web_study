<%@page import="pack.business.SangpumDto"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <jsp:useBean id="processDao" class="pack.business.ProcessDao"/>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<a href="ins.html">상품추가</a>
<% ArrayList<SangpumDto> list = (ArrayList<SangpumDto>)processDao.selectDataALL(); %>
<table>
	<tr>
		<th>번호</th><th>상품명</th><th>수량</th><th>단가</th>
	</tr>
	<c:forEach var="s" items="<%=list %>">
	<tr>
		<td>${s.code}</td><td>${s.sang}</td><td>${s.su}</td><td>${s.dan}</td>
	</tr>
	</c:forEach>
</table>
</body>
</html>