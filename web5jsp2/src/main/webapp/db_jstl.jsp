<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql"  prefix="s"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
JSTL의 sql을 사용해 상품 자료 읽기
<c:catch var="dbErr">
	<s:setDataSource var="ds"
		url="jdbc:mariadb://localhost:3306/test"
		driver="org.mariadb.jdbc.Driver"
		user="root"
		password="123"
	/>
	<s:query var="rs" dataSource="${ds}">
	SELECT*FROM sangdata WHERE code >= ? AND code <= ?
	<s:param value="1"/>
	<s:param value="5"/>
	</s:query>
	<table>
		<tr>
			<th>코드</th><th>품명</th><th>수량</th><th>단가</th>
		</tr>
			<c:forEach var="s" items="${rs.rows}">
		<tr>
			<td>${s.code}</td>			
			<td>${s.sang}</td>	
			<td>${s.su}</td>	
			<td>${s.dan}</td>	
		</tr>
			</c:forEach>
	</table>
</c:catch>
<c:if test="${dbErr != null}">
DB 에러 발생 : ${dbErr.message}
</c:if>
</body>
</html>