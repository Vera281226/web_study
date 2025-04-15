<%@page import="java.util.Date"%>
<%@ page 
language="java"
contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<pre>
<%--
JSP Element 종류
1) 지시어 : <%@ %>
2) 선언 : <%! %> 전역변수 및 메소드 선언
3) 표현식 <%= %> 클라이언트 값 전송 한개만
4) 스크립트릿 <% %> 자바 코드 작성
5) 액션 태그 : <jsp: />
 --%>
<h2>JSP 문서 기본 이해</h2>
<%
// 자바코드 작성 영역
String irum = "홍길동";
out.println(irum+"의 홈페이지입니다"); // 내장객체 out으로 브라우저에 메세지 출력

for(int i=1; i<7; i++){
	out.print("<h"+i+">");
	out.print("jsp 만세");
	out.print("</h"+i+">");
}
%>
여기는 HTML<br>
<%
Date date = new Date();
out.println(date);
%>
<i><%= date %></i> <%-- 표현식은 출력 내용 한 개만 적는다. 뒤에 ; 주지않는다 --%>
<%= new Date() %>
HTML
<%
int a=0, sum=0;
do{
	a++;
	sum+=a;
}while(a<10);
%>
<%="10까지의 합은 "+ sum %>
<%=irum +"님의 전화 번호는" + tel %>
<%! // 선언문 에서는 전역 변수 선언 먼저 읽어온다 선언문 내부 이외의 변수 선언은 지역변수다 
	   // 왜냐하면 HttpServlet을 상속받은 클래스이며 오버라이딩된 service 메소드 내에 코드를 작성한 문서 
String tel = "111-1111";
%>
<%! // 클래스의 멤버 메소드 작성 메소드를 만들려면 느낌표를 붙이지 않으면 메소드 안에 메소드가 되므로 
public int addMethod(int m, int n){
	return m+n;
}
%>
<%=addMethod(4,5) %>
</pre>
</body>
</html>