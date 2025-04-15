package pack;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class JikDbConn { // DB 처리용 Business Logic

    private Connection connection;
    private PreparedStatement prestatement;
    private ResultSet resultset;
    private String bname;

    public void setBname(String bname) {
        this.bname = bname;
    }

    public String getBname() {
        return bname;
    }

    public JikDbConn() {
        try {
            Class.forName("org.mariadb.jdbc.Driver");
        } catch (Exception e) {
            System.out.println("class err : " + e.getMessage());
        }
    }

    public ArrayList<JikwonDto> getDataAll() {
        ArrayList<JikwonDto> list = new ArrayList<>();
        try {
            connection = DriverManager.getConnection("jdbc:mariadb://localhost:3306/test", "root", "123");
            String sql = "SELECT jikwonno, jikwonname, jikwonjik, jikwongen FROM jikwon INNER JOIN buser ON buserno = buserno WHERE busername=?";
            prestatement = connection.prepareStatement(sql);
            prestatement.setString(1, bname);
            resultset = prestatement.executeQuery();
            while (resultset.next()) {
                JikwonDto dto = new JikwonDto();
                dto.setNo(resultset.getString("jikwonno"));
                dto.setName(resultset.getString("jikwonname"));
                dto.setJik(resultset.getString("jikwonjik"));
                dto.setGen(resultset.getString("jikwongen"));
                list.add(dto);
            }
        } catch (Exception e) {
            System.out.println("getDataAll err : " + e.getMessage());
        } finally {
            try {
                if (resultset != null) resultset.close();
                if (prestatement != null) prestatement.close();
                if (connection != null) connection.close();
            } catch (Exception e) {
                System.out.println("getDataAll err : " + e.getMessage());
            }
        }
        return list;
    }
}