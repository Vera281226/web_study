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
    
    DataDto dto = processDao.selectDataPart(id);
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>회원 수정</h2>
<c:set var="dto" value="<%=dto %>"/>
<form action="upok.jsp" method="post">
id      : <input type="hidden" name="id" value="${dto.id}">${dto.id}
name: <input type="text" name="name" value="${dto.name}">
pwd  : <input type="text" name="passwd" value="${dto.passwd}">
<input type="submit" value="수정">
</form>
</body>
</html>