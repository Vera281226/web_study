<%@page import="pack.business.DataDto"%>
<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
    <jsp:useBean id="processDao" class="pack.business.ProcessDao"/>
    <% ArrayList<DataDto> list = (ArrayList<DataDto>)processDao.selectMemberAll(); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>회원 정보(mybatis)</h2>
<a href="ins.jsp">회원 추가</a>
<table>
	<tr>
		<th>id</th><th>name</th><th>passwd</th><th>regdate</th>
	</tr>
	<c:set var="list" value="<%=list %>"/>
	<c:if test="${empty list}">
	<tr>
		<td colspan="4">자료 없음</td>
	</tr>
	</c:if>
	<c:forEach var="i" items="<%=list%>">
	<tr>
	<td><a href="del.jsp?id=${i.id}">${i.id}</a></td><td><a href="up.jsp?id=${i.id}">${i.name}</a></td><td>${i.passwd}</td><td>${fn:substring(i.regdate,0,10)}</td>
	</tr>
	</c:forEach>
	<tr>
	 	<td colspan="4">id 클릭은 삭제 name 클릭은 수정</td>
	</tr>
</table>
</body>
</html>