<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="java.sql.*"%>
{"jikwon":
[
<%
request.setCharacterEncoding("utf-8");
String name = request.getParameter("name");
Connection conn = null;
PreparedStatement pstmt, pstmt2 = null;
ResultSet rs, rs2 = null;
String result = "";

try {
  Class.forName("org.mariadb.jdbc.Driver");
  conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/test", "root", "123");
} catch (Exception e) {
  System.out.println("연결 오류:" + e.getMessage());
  return;
}
try {
  pstmt = conn.prepareStatement("select * from jikwon INNER JOIN buser ON busernum=buserno WHERE busername like ?");
  pstmt.setString(1, name+"%");
  rs = pstmt.executeQuery();

  while (rs.next()) {
	 // 담당 직원의 관리 고객 수
	 String sql = "SELECT COUNT(*) FROM jikwon INNER JOIN gogek ON jikwonno = gogekdamsano WHERE jikwonno=?";
    result += "{";
    result += "\"jikwonno\":" + "\"" + rs.getString("jikwonno") + "\",";
	 pstmt2 = conn.prepareStatement(sql);
	 pstmt2.setString(1, rs.getString("jikwonno"));
	 rs2=pstmt2.executeQuery();
	 rs2.next();
    result += "\"jikwonname\":" + "\"" + rs.getString("jikwonname") + "\",";
    result += "\"jikwonjik\":" + "\"" + rs.getString("jikwonjik") + "\",";
    result += "\"jikwongogek\":" + "\"" + rs2.getString(1) + "\"";
    result += "},";
  }

  if (result.length() > 0) result = result.substring(0, result.length() - 1);
     out.print(result);
  } catch (Exception e) { System.out.println("처리 오류:" + e.getMessage()); }
%>]}