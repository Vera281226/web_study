<%@page import="java.util.Date"%>
<%@page import="java.util.HashMap"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL</title>
</head>
<body>
Java Strandard Tag Library : 변수 제어문 사용이 가능 일반적으로 EL과 함께 사용<br>
변수 처리<br>
<c:set var="irum" value="이승준" scope="page"/>
이름 : <c:out value="${irum}"/>
<c:set var="ir">
치즈버거
</c:set><c:out value="${ir}"/>
<c:remove var="irum"/>
<c:out value="${irum}"/>
<c:set var="abc" value="${header['User-Agent']}"/>
현재 사용중인 브라우저 정보 : <c:out value="${abc}"/>
<br>
<c:set var="su1" value="10"/>
<c:set var="su2" value="20"/>
합은 : ${su1+su2}
<hr>
<c:set var="nice" value="star"/>
<c:if test="${nice eq 'star'}">
if 연습 nice 값은 <c:out value="${nice}"></c:out>
</c:if>
<c:if test="${nice != 'star'}">
if 연습 조건이 참이 아닌 경우
</c:if>
<c:choose>
	<c:when test="${nice eq 'moon'}">달</c:when>
	<c:when test="${nice eq 'star'}">별</c:when>
	<c:when test="${nice eq 'sun'}">해</c:when>
</c:choose>
반복문 foreach <br>
<c:forEach var="i" begin="2" end="9" step="2">
	${i}&nbsp;
</c:forEach>
<table border="1">
  <c:forEach var="i" begin="2" end="9">
    <tr>
      <c:forEach var="j" begin="1" end="9">
        <td>
          ${i} x ${j} = ${i * j}
        </td>
      </c:forEach>
    </tr>
  </c:forEach>
</table>
header 내장객체 값 출력
<c:forEach var="h" items="${headerValues}">
	속성 : ${h.key}<br>
	<c:forEach var="a" items="${h.value}">
		${a}&nbsp;
	</c:forEach>
</c:forEach>
<%
HashMap<String, Object> map = new HashMap<>();
map.put("name", "손오공");
map.put("today", new Date());
%>
<c:set var="m" value="<%=map %>"/>
<c:forEach var="k" items="${m}">
	${k.key} : ${k.value}<br>
</c:forEach>
<c:set var="arr" value="<%=new int[]{1,2,3,4,5} %>"/>
<c:forEach var="j" items="${arr}">
${j}
</c:forEach>
<c:forTokens var="animal" items="horse,dog,cat,tiger,lion" delims=",">
동물 : ${animal}
</c:forTokens>
<c:forTokens var="city" items="서울,인천,수원*춘천,제주" delims=",*" varStatus="num"> <!-- 구분자는 여러개 줄 수 있다 -->
${num.count}) ${city}
</c:forTokens>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
숫자 : <fmt:formatNumber value="12345.678" type="number"/><br>
숫자 : <fmt:formatNumber value="12345.678" type="currency"/><br>
숫자 : <fmt:formatNumber value="12345.678" type="percent"/><br>
숫자 : <fmt:formatNumber value="1.678" pattern="0,000.0"/><br>
숫자 : <fmt:formatNumber value="1.678" pattern="#,##0.0"/><br>
숫자 : <fmt:formatNumber value="0" pattern="0,000.0"/><br>
숫자 : <fmt:formatNumber value="0" pattern="#,##0.0"/><br>
숫자 : <fmt:formatNumber value="0" pattern="#,###.#"/><br>
<c:set var="now" value="<%=new Date() %>"/><br>
<c:out value="${now}"/><br>
<fmt:formatDate value="${now}" type="date"/><br>
<fmt:formatDate value="${now}" type="time"/><br>
<fmt:formatDate value="${now}" type="both"/><br>
<fmt:formatDate value="${now}" type="both" pattern="yyyy년 MM월 dd일 hh시 mm분 ss초"/><br>

</body>
</html>