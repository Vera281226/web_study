<%@page import="pack.GuestbookDto"%>
<%@page import="pack.SangpumDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
int code = Integer.parseInt(request.getParameter("code"));
%>
<jsp:useBean id="dbConPool" class="pack.GuestDbConPool"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 수정</title>
<link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
<% GuestbookDto dto = dbConPool.updateDataRead(code); 
%>
<form action="jspex17upok.jsp" method="post">
코드 : <%=dto.getCode() %><br><!-- 코드는 수정 불가능 기본키를 확인해야한다 히든을 사용해 출력만 하는 값도 넘겨야한다 -->
<input type="hidden" name="code" value="<%=dto.getCode() %>">
작성자 : <input type="text" name="name" value="<%=dto.getName()%>"> <br>
제목 : <input type="text" name="title" value="<%=dto.getTitle()%>"> <br>
내용 : <input type="text" name="content" value="<%=dto.getContent() %>"> <br>
<input type="submit" value="자료 수정">
<input type="button" value="수정 취소" onclick="javascript:location.href='jspex17guestbook.jsp'">
</form>
</body>
</html>