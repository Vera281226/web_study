<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
  <%
  request.setCharacterEncoding("utf-8");
  // String name = request.getParameter("name"); // 내장 객체 이용 방식
  %>
<jsp:useBean id="formBean" class ="pack.Jspex11FormBean" />
<%-- <jsp:setProperty property="name" name="formBean"/> <%-- 한 개일땐 set get Property로 충분하다 --%>
<jsp:setProperty property="*" name="formBean"/> <%-- SQL SELECT * FROM 처럼 모든 값이 setter로 통해 저장됨
클래스에서 변수 선언 순서에 따라 순서대로 저장된다 --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
폼빈에 저장된 자료 출력
이름 <jsp:getProperty property="name" name="formBean"/>
국어 <jsp:getProperty property="kor" name="formBean"/>
영어 <jsp:getProperty property="eng" name="formBean"/>
<%-- 계산 클래스를 Beans 사용 --%>
<jsp:useBean id="logic" class="pack.Jspex11logic"/>
<jsp:setProperty property="formBean" name="logic" value="<%=formBean %>"/>
총점 <jsp:getProperty property="tot" name="logic"/>
평균 <jsp:getProperty property="avg" name="logic"/>
</body>
</html>