<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored="false"
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
EL 연산자와 내장객체<br>
\${3 + 4} = ${3 + 4}<br>
\${5 / 4} = ${5 / 4}<br> <!-- ${5 div 4}<br>  -->
\${5 / 0} = ${5 / 0}<br> <!-- ${5 div 0}<br> 0 나누기가 오류가 뜨지 않는다 -->

\${5 > 4} = ${5 > 4} ${5 gt 4}<br>
\${5 <= 4} = ${5 <= 4} ${5 le 4}<br>

\${5 > 4 and 3 < 2} = ${5 > 4 and 3<2} <br>
\${5 >= 4 or 3 < 2} = \${5 >= 4 or 3 < 2}<br>

\${5>=4?10 : 5+20 } = ${5>=4?10 : 5+20 }
<br>
내장 객체<br>
<%
request.setAttribute("aa", "air");
session.setAttribute("bb", "burger");
application.setAttribute("cc", "cat");

request.getAttribute("aa");
session.getAttribute("bb");
application.getAttribute("cc");
%>
${requestScope.aa}, ${aa}<br>
${sessionScope.bb}, ${bb}<br>
${applicationScope.cc}, ${cc}<br>

jsp header : <%=request.getHeader("host") %> %><br>
EL로 header : ${header.host}  ${header["host"]}<br>

<%ArrayList<String> list = new ArrayList<>(); 
list.add("치즈버거");
list.add("치킨버거");
list.add("불고기버거");
request.setAttribute("burgerlist", list);
ArrayList<String> list2 = new ArrayList<>(); 
list2 = (ArrayList)request.getAttribute("burgerlist");

out.println("jsp 출력 : " + list2.get(0));
out.println("jsp 출력 : " + list2.get(1));
out.println("jsp 출력 : " + list2.get(2));
%>
<br>
${burgerlist[0]} ${burgerlist[1]} ${burgerlist["2"]}
<hr>
HTML 문서의 자료 받기<br>
<a href="el_2.html">el_2 호출</a><br>
<%String irum = request.getParameter("irum") ;
if(irum != null){
	out.print(irum);
}
%><br>

<% String[] sungs = request.getParameterValues("sung");
if(sungs != null) {
	for(String s:sungs){
		out.println(s+ " ");
	}
}
%>
<br>
${param.irum}<br>
${paramValues.sung[0]}, ${paramValues.sung[1]}
</body>
</html>