<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>리스트</title>
</head>
<body>
<%@include file="logincheck.jsp" %>
<a href="insert.html">사용자 추가</a>
<table>
	<tr>
		<th>아이디</th><th>이름</th><th>이메일</th>
	</tr>
	<c:forEach var="u" items="${list}">
		<tr>
			<td><a href="view.m2?userid=${u.userid}">${u.userid}</a></td><td>${u.name}</td><td>${u.email}</td>
		</tr>
	</c:forEach>
</table>
<a href="logout.m2">로그아웃</a>
</body>
</html>