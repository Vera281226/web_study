<?xml version="1.0" encoding="UTF-8"?>
<%@ page language="java" contentType="text/xml; charset=UTF-8"
    pageEncoding="UTF-8"
%>
<%@page import="java.sql.*"%>
<sangpums>
<%
Connection conn = null;
PreparedStatement pstmt = null;
ResultSet rs = null;

try{
           Class.forName("org.mariadb.jdbc.Driver");
           conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/test", "root", "123");
}catch(Exception e){
           System.out.println("연결 오류 : " + e.getMessage());
           return;
}
try{
           pstmt = conn.prepareStatement("select * from sangdata");
           rs = pstmt.executeQuery();
           while(rs.next()){
%>
                     <sangpum>
                                <code><%=rs.getString("code") %></code>
                                <sang><%=rs.getString("sang") %></sang>
                                <su><%=rs.getString("su") %></su>
                                <dan><%=rs.getString("dan") %></dan>
                     </sangpum>
<%
	}
}catch(Exception e){
           System.out.println("처리 오류 : " + e.getMessage());
           return;
}
%>
</sangpums>