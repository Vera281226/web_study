<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="formBean" class="pack.GuestbookFormBean"/>
<jsp:setProperty property="*" name="formBean"/>
<jsp:useBean id="dbConPool" class="pack.GuestDbConPool"/>
<%
// insert 후 목록 보기로 이동
request.setCharacterEncoding("utf-8");
%>
<% 
boolean b = dbConPool.insertData(formBean);

if(b) response.sendRedirect("jspex17guestbook.jsp"); // 추가 성공 후 상품 보기
else response.sendRedirect("jspex17fail.html"); // 추가 실패 시 이동
%>