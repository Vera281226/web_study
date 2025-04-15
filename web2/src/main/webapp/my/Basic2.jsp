<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/plain; charset=UTF-8" pageEncoding="UTF-8"%>

{"jikwon":
[
<%
Connection conn = null;
PreparedStatement pstmt = null;
ResultSet rs = null;

String number = request.getParameter("number");
String name = request.getParameter("name");


String result = "";

try {
  Class.forName("org.mariadb.jdbc.Driver");
  conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/test", "root", "123");
} catch (Exception e) {
  System.out.println("연결 오류:" + e.getMessage());
  return;
}
try {

  pstmt = conn.prepareStatement("SELECT gogekname, gogektel, CASE WHEN MOD(SUBSTR(gogekjumin,8,1),2)=0 THEN '여' ELSE '남' END AS gogekgen FROM gogek INNER JOIN jikwon ON gogekdamsano=jikwonno WHERE jikwonno=?");
  pstmt.setInt(1,1);
  rs = pstmt.executeQuery();
  
  while (rs.next()) {
    result += "{";
    result += "\"gogekname\":" + "\"" + rs.getString("gogekname") + "\",";
    result += "\"gogektel\":" + "\"" + rs.getString("gogektel") + "\",";
    result += "\"gogekgen\":" + "\"" + rs.getString("gogekgen") + "\"";
    result += "},";
  }
  if (result.length() > 0) { result = result.substring(0, result.length() - 1); }
     out.print(result);}
	catch (Exception e)  { System.out.println("처리 오류:" + e.getMessage()); }
%>]}