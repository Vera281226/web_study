<%@page import="pack.GuestbookDto"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <jsp:useBean id="dbConPool" class="pack.GuestDbConPool"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>미니 방명록 작성 문제</title>
<link rel="stylesheet" type="text/css" href="style.css">
<script type="text/javascript">
function funcDelete(code) {
		if(confirm("정말 삭제할까요?")) {// 프로젝트엔 confirm은 사용하지 않는다.
		location.href="jspex17del.jsp?code="+code;
		}
	}
</script>
</head>
<body>
<h2>* 방명록 내용 *</h2>

<table border="1">
<tr>
	<td colspan="4"><a href="jspex17ins.html" class="button"
	>글쓰기</a></td>
</tr>
	<tr>
		<th>코드</th><th>작성자</th><th>제목</th><th>내용</th>
	</tr>
<%
	ArrayList<GuestbookDto> glist = dbConPool.getDataAll();
	for(GuestbookDto g:glist){
%>
		<tr>
			<td><a href="javascript:funcDelete(<%=g.getCode()%>)" class="button"><%=g.getCode()%></a></td>
			<td><a href="jspex17up.jsp?code=<%=g.getCode()%>" class="button"><%=g.getName()%></a></td>
			<td><%=g.getTitle()%></td>
			<td><%=g.getContent()%></td>
		</tr>
	<%
	}
	%>
</table>
</body>
</html>