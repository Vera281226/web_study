<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>파일 포함 연습</title>
</head>
<body>
<%@ include file="jspex3top.jsp" %>
<pre>
여
기
는

본
문
</pre>
<%-- 파일 포함을 위한 JSP action tag 연습 jsp 액션태그의 대상은 jsp, 서블릿, html 모두 가능--%>
<%-- 페이지 include는 소스 코드를 불러와 사용하고 액션 태그 include는 코드 결과값을 가져와 사용하는 것 --%>
<jsp:include page="jspex3action1.jsp"/> <%-- 한줄짜리 태그 속성 코드는 이렇게 써도된다 --%>
<jsp:include page="jspex3action2.jsp">
	<jsp:param value="korea" name="msg"/>
</jsp:include>
<br>
<%@ include file="jspex3bottom.jsp" %>
</body>
</html>