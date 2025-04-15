<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("utf-8"); %>

<jsp:useBean id="formBean" class="pack.SangpumFormBean"/> <!-- formBean 사용-->
<jsp:useBean id="dbConnPooling" class="pack.DbConnPooling"/>
<jsp:setProperty property="*" name="formBean"/>

<%
// boolean b = dbConnPooling.updateData(formBean);
if(dbConnPooling.updateData(formBean))
	response.sendRedirect("jspex16dbcp.jsp"); // 수정 후 목록보기 매우 좋은 방식
else
	response.sendRedirect("jspex16fail.html");
%>