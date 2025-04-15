<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>상품 정보(MVC 패턴)</h3>
<table>
	<thead>
		<tr>
			<th>코드</th><th>품명</th><th>수량</th><th>단가</th>
		</tr>
	</thead>
	<tbody>
	<c:forEach var="s" items="${datas}">
		<tr>
			<td>${s.code}</td><td>${s.sang}</td><td>${s.su}</td><td>${s.dan}</td>
		</tr>
	</c:forEach>
	</tbody>
</table>
</body>
</html>