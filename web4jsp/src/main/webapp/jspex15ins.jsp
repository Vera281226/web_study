<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
// 해당 jsp의 용도 수신된 입력자료를 DB 저장 후 상품 정보 보기 창으로 이동
request.setCharacterEncoding("utf-8");
%>
<jsp:useBean id="dbConnPaging" class="pack.DbConnPaging"/>
<jsp:useBean id="formBean" class="pack.SangpumFormBean"/>
<jsp:setProperty property="*" name="formBean" />
<%-- 자바에서도 입력자료 검사를 권장한다 --%>
<%
if(formBean.getSang().equals("") || formBean.getSang() == null){ //sang, su dan, 수량 단가는 숫자
	response.sendRedirect("jspex15insert.html");
	return;
}
dbConnPaging.sangpumInsert(formBean);

// 상품 추가 후 목록 보기로 이동에는 서버내에서 포워드로 정보 처리하면 안된다.
// request.getRequestDispatcher("jspex15paging.jsp").forward(request, response);

// 상품 추가 후 목록 보기로 이동 = 리다이렉트를 사용한다
response.sendRedirect("jspex15paging.jsp");
%>
