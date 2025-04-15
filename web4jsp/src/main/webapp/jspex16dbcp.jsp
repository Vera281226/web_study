<%@page import="pack.SangpumDto"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <jsp:useBean id="dbConnPooling" class="pack.DbConnPooling"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
function funcUpdate() {
	let code = prompt("수정할 코드 입력","");
	if(code !== "" && code !== null){ //  공백이 아니고 null이 아닐때 수정 시작
		location.href="jspex16up.jsp?code="+code;
	}
}
function funcDelete() {
	let code = prompt("삭제할 코드 입력","");
	if(code !== "" && code !== null){ //  공백이 아니고 null이 아닐때 삭제 시작
		if(confirm("정말 삭제할까요?")){ // 프로젝트엔 confirm은 사용하지 않는다.
		location.href="jspex16del.jsp?code="+code;
		}
	}
}
</script>
</head>
<body>
<h2>상품 정보(Beans - paging)</h2>
<a href="jspex16ins.html">추가</a>
<a href="javascript:funcUpdate()">수정</a>
<a href="javascript:funcDelete()">삭제</a> <!-- 확인 작업이 필요하다 -->
<br>
<table border="1">
	<tr>
		<th>코드</th><th>품명</th><th>수량</th><th>단가</th>
	</tr>
<%
	ArrayList<SangpumDto> slist = dbConnPooling.getDataAll();
	for(SangpumDto s:slist){
%>
		<tr>
			<td><%=s.getCode() %></td>
			<td><%=s.getSang() %></td>
			<td><%=s.getSu() %></td>
			<td><%=s.getDan() %></td>
		</tr>
	<%
	}
	%>
</table>
</body>
</html>