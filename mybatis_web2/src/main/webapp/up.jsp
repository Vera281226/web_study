<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="pack.business.DataDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <jsp:useBean id="processDao" class="pack.business.ProcessDao"/>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
    <%
    request.setCharacterEncoding("utf-8");
    String id = request.getParameter("id");
    
    ArrayList<DataDto> list = (ArrayList<DataDto>)processDao.selectDataPart(id);
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>회원 수정</h2>
<c:set var="list" value="<%=list %>"/>
<form action="upok.jsp" method="post">
<c:forEach var="i" items="<%=list%>">
id      : <input type="hidden" name="id" value="${i.id}">${i.id}
name: <input type="text" name="name" value="${i.name}">
pwd  : <input type="text" name="passwd" value="${i.passwd}">
<input type="submit" value="수정">
</c:forEach>
</form>
</body>
</html>