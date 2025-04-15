<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="pack.*, java.util.*" %>
<%
    String bname = request.getParameter("bname");

    JikDbConn dbConn = new JikDbConn();
    dbConn.setBname(bname);
    ArrayList<JikwonDto> jikwonList = dbConn.getDataAll();

    int employeeCount = 0;
    int minPay = Integer.MAX_VALUE;
    int maxPay = Integer.MIN_VALUE;

    StringBuilder tableContent = new StringBuilder();
    tableContent.append("<!DOCTYPE html>");
    tableContent.append("<html><head><meta charset='UTF-8'><title>부서별 직원 정보</title></head><body>");

    if (jikwonList != null && !jikwonList.isEmpty()) {
        employeeCount = jikwonList.size();
        tableContent.append("<h2>").append(bname).append(" 부서 직원 정보</h2>");
        tableContent.append("<table border='1'>");
        tableContent.append("<thead><tr><th>사번</th><th>이름</th><th>직급</th><th>성별</th><th>연봉</th></tr></thead>");
        tableContent.append("<tbody>");

        for (JikwonDto jikwon : jikwonList) {
            int pay = 0;
            minPay = Math.min(minPay, pay);
            maxPay = Math.max(maxPay, pay);

            tableContent.append("<tr>");
            tableContent.append("<td>").append(jikwon.getNo()).append("</td>");
            tableContent.append("<td>").append(jikwon.getName()).append("</td>");
            tableContent.append("<td>").append(jikwon.getJik()).append("</td>");
            tableContent.append("<td>").append(jikwon.getGen()).append("</td>");
            tableContent.append("</tr>");
        }

        tableContent.append("</tbody></table>");
    } else {
        tableContent.append("<p>해당 부서의 직원 정보가 없습니다.</p>");
    }

    tableContent.append("<p>인원 수: ").append(employeeCount).append("</p>");
    if (employeeCount > 0) {
        tableContent.append("<p>최저 연봉: ").append(minPay).append("</p>");
        tableContent.append("<p>최고 연봉: ").append(maxPay).append("</p>");
    }
    tableContent.append("</body></html>");

    String script = "<script>document.getElementById('resultFrame').contentWindow.document.body.innerHTML = '" + tableContent.toString().replace("'", "\\'") + "'</script>";
    out.println(script);
%>