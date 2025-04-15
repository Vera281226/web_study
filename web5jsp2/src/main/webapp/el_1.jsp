<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EL 배우기</title>
</head>
<body>
<pre>
EL(Expression Language) : JSP의 스크립트를 표현식을 대신해 출력하도록 고안된 언어
JSP 페이지에서 데이터를 쉽게 표현하고 접근할 수 있게 해주는 언어로, 다양한 내장 객체를 제공
JSP 코드를 더 간결하고 가독성 있게 만들 수 있다
<!-- 대신 $표현식으로 처리 -->
</pre>
<h2>EL 사용 시작</h2>
<%
if(request.getParameter("userName") == null) {
%>
<jsp:forward page="el_1.html"/>
<%	
} else {
%>
<th>사용자가 전송한 userName : ${param.userName}</th>
<%
}
%>
</body>
</html>