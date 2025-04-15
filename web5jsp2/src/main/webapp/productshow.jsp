<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<style type="text/css">
.expensive{
color: red;
}
</style>
</head>
<body>
<h2>상품 정보</h2>
<c:choose> 
<c:when test="${empty products}">
상품이 없습니다
</c:when>
<c:otherwise>
	<table>
	<thead>
		<tr>
			<th>상품명</th><th>가격</th><th>설명</th><th>출시일</th>
		</tr>
</thead>
<tbody>
	<c:forEach var="product" items="${products}">
		<tr>
			<td>${product.name}</td>
			<td class="<c:if test='${product.price>5000}'>expensive</c:if>">${product.price}</td>
			<td>${product.description}</td>
			<td><fmt:formatDate value="${product.releaseDate}" pattern="yyyy년 MM월 dd일"/></td>
		</tr>
	</c:forEach>
</tbody>
	</table>
</c:otherwise>
</c:choose>
<c:set var="totalProducts" value="${fn:length(products)}"/>
<c:set var="totalPrice" value="0"/>
<c:forEach var="pro" items="${products}">
	<c:set var="totalPrice" value="${totalPrice + pro.price}"></c:set>
</c:forEach>
전체 건수 : ${totalProducts}
총 금액 : ${totalPrice}
평균가격 : <fmt:formatNumber value="${totalPrice / totalProducts}" type="currency"/>
<ul>
	<c:forEach var="p" items="${products}" varStatus="status">
	<li>
		${status.count}. <c:out value="${fn:substring(p.description,0,3)}...더보기"/>
	</li>
	</c:forEach>
</ul>
</body>
</html>