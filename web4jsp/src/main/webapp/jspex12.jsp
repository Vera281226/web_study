<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
  <%
  request.setCharacterEncoding("utf-8");
  %>
<jsp:useBean id="formBean" class ="pack.Jspex12FormBean" />

<jsp:setProperty property="*" name="formBean"/> 
<jsp:useBean id="logic" class="pack.Jspex12logic"/>
<jsp:setProperty property="formBean" name="logic" value="<%=formBean %>"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

과일 <jsp:getProperty property="name" name="formBean"/>
구매가격은 <jsp:getProperty property="tot" name="logic"/>

</body>
</html>