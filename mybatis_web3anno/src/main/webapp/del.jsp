<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="processDao" class="pack.business.ProcessDao"/>
<% request.setCharacterEncoding("utf-8"); %>
<%String id = request.getParameter("id");


boolean b = processDao.deleteMember(id);

if(b) response.sendRedirect("test.jsp");
else response.sendRedirect("fail.jsp");
%>