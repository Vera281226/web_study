<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="bean" class="pack.business.DataFormBean"/>
<jsp:setProperty property="*" name="bean"/>

<jsp:useBean id="processDao" class="pack.business.ProcessDao"/>

<%
boolean b = processDao.updateMember(bean);

if(b) response.sendRedirect("test.jsp");
else response.sendRedirect("fail.jsp");
%>