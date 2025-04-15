<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
int code = Integer.parseInt(request.getParameter("code"));
%>

<jsp:useBean id="dbConPool" class="pack.GuestDbConPool"/>

<%
if(dbConPool.deleteData(code))
	response.sendRedirect("jspex17guestbook.jsp");
else
	response.sendRedirect("jspex17fail.html");
%>