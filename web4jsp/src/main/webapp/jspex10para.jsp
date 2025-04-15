<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
//String message = request.getParameter("message");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>Beans를 이용한 클래스 멤버 필드에 값 설정하고 참조하기</h3>
<jsp:useBean id="myClass2" class="pack.Jspex10Para" scope="page" />
<jsp:setProperty property="message" name="myClass2"/> 
<jsp:getProperty property="message" name="myClass2"/>
<!-- 클라이언트의 ?message=good 전달이 Jspex10Para.java의 setter를 타고들어감 getter와 setter는 필수적으로 존재해야한다 id 속성은 getter setter 메소드의 이름을 따라 간다 -->
<!--   page:
현재 JSP 페이지 내에서만 사용
페이지가 종료되면 Bean도 함께 소멸
가장 좁은 범위이며, 일반적으로 한 페이지 내에서만 필요한 데이터를 처리할 때 사용 -->
<jsp:useBean id="myClass" class="pack.Jspex10Para" scope="page" />

<!--request:
현재 HTTP 요청 내에서만 사용
요청이 처리되고 응답이 전송되면 Bean도 함께 소멸
주로 서블릿에서 request 속성에 저장된 Bean을 JSP에서 사용할 때 활용
session:
특정 사용자의 세션 동안 유지
사용자가 웹 브라우저를 닫거나, 세션이 만료될 때까지 Bean이 유지
로그인 정보, 사용자 설정 등 사용자별로 유지해야 하는 데이터를 저장할 때 사용

application:
웹 애플리케이션 전체에서 공유
서버가 실행되는 동안 Bean이 유지
애플리케이션 전반에 걸쳐 공유되는 데이터나 자원을 관리할 때 사용 -->

<%
//myClass.setMessage(message);
//out.println(myClass.getMessage());
%>
</body>
</html>