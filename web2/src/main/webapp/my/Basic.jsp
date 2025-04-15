<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/plain; charset=UTF-8" pageEncoding="UTF-8"%>

{"jikwon":
[
<%
Connection conn = null;
PreparedStatement pstmt = null;
ResultSet rs = null;

String result = "";

try {
  Class.forName("org.mariadb.jdbc.Driver");
  conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/test", "root", "123");
} catch (Exception e) {
  System.out.println("연결 오류:" + e.getMessage());
  return;
}
try {
  int gender;
  pstmt = conn.prepareStatement("SELECT jikwonno, jikwonname,jikwonjik,SUBSTR(jikwonibsail,1,4) AS jikwonibsail,jikwongen FROM jikwon WHERE jikwongen=?");
  rs = pstmt.executeQuery();
  pstmt.setInt(1,1);
  while (rs.next()) {
    result += "{";
    result += "\"jikwonno\":" + "\"" + rs.getString("jikwonno") + "\",";
    result += "\"jikwonname\":" + "\"" + rs.getString("jikwonname") + "\",";
    result += "\"jikwonjik\":" + "\"" + rs.getString("jikwonjik") + "\",";
    result += "\"jikwonibsail\":" + "\"" + rs.getString("jikwonibsail") + "\",";
    result += "},";
  }
  if (result.length() > 0) { result = result.substring(0, result.length() - 1); }
     out.print(result);}
	catch (Exception e)  { System.out.println("처리 오류:" + e.getMessage()); }
%>]}