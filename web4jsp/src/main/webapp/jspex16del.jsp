<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String code = request.getParameter("code");
%>

<jsp:useBean id="dbConnPooling" class="pack.DbConnPooling"/>

<%
if(dbConnPooling.deleteData(code))
	response.sendRedirect("jspex16dbcp.jsp");
else
	response.sendRedirect("jspex16fail.html");
%>