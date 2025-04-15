<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>수정</title>
</head>
<body>
<form action="update.m2" method="post">
아 이 디  : <input type="hidden" name="userid" value="${user.userid}">${user.userid}<br>
비밀번호 : <input type="text" name="password" value="${user.password}"><br>
이      름 : <input type="text" name="name" value="${user.name}"><br>
이 메 일  : <input type="text" name="email" value="${user.email}"><br>
<input type="submit" value="수정">
</body>
</html>