<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    <%@page import="java.sql.*"%>
{"jikwon":
[
<%
request.setCharacterEncoding("utf-8");
String name = request.getParameter("name");
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
  pstmt = conn.prepareStatement("SELECT jikwonno, jikwonname, jikwonjik, jikwonpay FROM jikwon WHERE jikwonname LIKE ?");
  pstmt.setString(1, name+"%");
  rs = pstmt.executeQuery();

  while (rs.next()) {
    result += "{";
    result += "\"jikwonno\":" + "\"" + rs.getString("jikwonno") + "\",";
    result += "\"jikwonname\":" + "\"" + rs.getString("jikwonname") + "\",";
    result += "\"jikwonjik\":" + "\"" + rs.getString("jikwonjik") + "\",";
    result += "\"jikwonpay\":" + "\"" + rs.getInt("jikwonpay") + "\"";
    result += "},";
  }

  if (result.length() > 0) result = result.substring(0, result.length() - 1);
     out.print(result);
  } catch (Exception e) { System.out.println("처리 오류:" + e.getMessage()); }
%>]}