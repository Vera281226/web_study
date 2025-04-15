<%@page import="pack.Student"%>
<%@page import="pack.Person"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%request.setCharacterEncoding("utf-8"); %>
안녕 ${requestScope.irum} ${irum}

<% 
Person p  = (Person)request.getAttribute("person"); 
out.println(p.getName());
%>
${person.name}

<% 
Student s  = (Student)request.getAttribute("student"); 
%>
${student.age}

동물의 종류 : ${animal[0]}, ${animal[1]}, ${animal[2]}

<c:if test="${list != null}">
	<c:forEach var="a" items="${list}">
		${a[0]} ${a[1]} ${a[2]}
	</c:forEach>
</c:if>
<c:if test="${list != null}">
	<c:forEach var="a" items="${list}">
		<c:forEach var="b" items="${a}">
			${b}
		</c:forEach>
	</c:forEach>
</c:if>

<c:choose>
	<c:when test="${list eq null}">list 자료 없음</c:when>
	<c:otherwise>list 자료 있어요</c:otherwise>
</c:choose>
<c:catch var="err">
<% int a = 10/0; out.println(a); %>
</c:catch>
<c:if test="${err != null }">
	에러 발생 ${err.message}
</c:if>
<%@include file="poham.jsp" %>
<jsp:include page="poham.jsp"/>
<c:import url="poham.jsp"/>
<c:import url="https://www.daum.net"/>
</body>
</html>