<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<pre>
<h2>JSP의 9가지 내장 객체</h2>
1. request: 클라이언트의 요청 정보를 저장<br>
2. response: 응답 정보 저장 객체<br>
3. out: 페이지 출력 스트림 객체<br>
4. session: 세션 정보 저장 객체<br>
5. application: 웹 애플리케이션의 컨텍스트 정보를 저장<br>
6. pageContext: JSP 페이지에 대한 정보를 저장<br>
7. page: JSP 페이지를 구현한 자바 클래스 객체<br>
8. config: JSP 페이지의 설정 정보<br>
9. exception: 예외 발생 시 사용되는 객체<br>
</pre>
회원 가입
<form action="jspex4etc.jsp" method="post" name="frmMem">
아이디 : <input type="text" name="id"><br>
비밀번호 : <input type="password" name="pwd"><br>
<input type="submit" value="전송">
</form>
</body>
</html>