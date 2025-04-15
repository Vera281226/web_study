<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상세보기</title>
<%@include file="logincheck.jsp" %>
<script type="text/javascript">
window.onload = function () {
	document.getElementById("btnUpdate").onclick = () => {
		if(confirm("정말 수정 할까요?")) {
			f.action = "updateform.m2";
			f.submit();
	}
}
	document.getElementById("btnDelete").onclick = () => {
		if(confirm("정말 삭제 할까요?")) {
			f.action = "delete.m2";
			f.submit();
	}
	}
	document.getElementById("btnList").onclick = () => {
		f.action = "list.m2";
		f.submit();
	}
}
</script>
</head>
<body>
<table>
<tr>
<td>${user.userid}</td>
<td>${user.password}</td>
</tr>
<tr>
<td>${user.name}</td>
<td>${user.email}</td>
</tr>
<tr>
<td colspan="4">
	<button id="btnUpdate">수정</button>
	<button id="btnDelete">삭제</button>
	<button id="btnList">목록</button>
</td>
</tr>
</table>
<form name="f" method="post">
	<input type="hidden" name="userid" value="${user.userid}">
</form>
</body>
</html>