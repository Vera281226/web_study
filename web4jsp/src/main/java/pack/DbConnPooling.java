package pack;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class DbConnPooling {
private Connection connection;
private PreparedStatement preparedStatement;
private ResultSet resultSet;
private DataSource ds;

	public DbConnPooling() {
		// DBCP 사용
		try {
			// JNDI : Java Naming and Directory Interface
			// 서비스가 제공하는 데이터 및 객체 참조(lookup)하기 위한 API
			Context context = new InitialContext();
			ds = (DataSource) context.lookup("java:comp/env/jdbc_maria");
		} catch (Exception e) {
			System.out.println("DbConnPooling error" +e.getMessage());
		}
	}
	public ArrayList<SangpumDto> getDataAll() {
		ArrayList<SangpumDto> list = new ArrayList<SangpumDto>();
		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement("SELECT*FROM sangdata");
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				SangpumDto dto = new SangpumDto();
			    dto.setCode(resultSet.getString("code"));
			    dto.setSang(resultSet.getString("sang"));
			    dto.setSu(resultSet.getString("su"));
			    dto.setDan(resultSet.getString("dan"));
			    list.add(dto);
			}
		} catch (Exception e) {
			System.out.println("getDataAll error" +e.getMessage());
		}finally {
			try {
				if(resultSet != null) resultSet.close();
				if(preparedStatement != null) preparedStatement.close();
				if(connection != null) connection.close();
			} catch (Exception e) {
				System.out.println("getDataAll error" +e.getMessage());
			}
		}
		return list;
	}
	
	public boolean insertData(SangpumFormBean formBean) {
		boolean b = false;
		try {
			connection = ds.getConnection();
			// 신상 code 구하기
			String sql = "SELECT MAX(code) FROM sangdata";
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			int maxCode = 0;
			if(resultSet.next()) maxCode=resultSet.getInt(1);
			maxCode+=1;
			
			// 추가
			sql = "INSERT INTO sangdata VALUES(?,?,?,?)";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, maxCode);
			preparedStatement.setString(2, formBean.getSang());
			preparedStatement.setString(3, formBean.getSu());
			preparedStatement.setString(4, formBean.getDan());
			int result = preparedStatement.executeUpdate();
			if(result == 1) b =true;
		} catch (Exception e) {
		System.out.println("insertData err : " +e.getMessage());
		} finally {
			try {
				if(resultSet != null) resultSet.close();
				if(preparedStatement != null) preparedStatement.close();
				if(connection != null) connection.close();
			} catch (Exception e) {
			System.out.println("insertData err : " +e.getMessage());
			}
		}	
		return b;
	}
	
	public SangpumDto updateDataRead(String code) {
		SangpumDto dto = null;
		String sql = "SELECT*FROM sangdata WHERE code=?";
		try (
				Connection connection = ds.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(sql)
					) {
					preparedStatement.setString(1, code);
					ResultSet resultSet = preparedStatement.executeQuery();
					if(resultSet.next()) { dto = new SangpumDto(); 
					dto.setCode(resultSet.getString(1));
					dto.setSang(resultSet.getString(2));
					dto.setSu(resultSet.getString(3));
					dto.setDan(resultSet.getString(4));
					}
		} catch (Exception e) {
			System.out.println("updateDataRead err : " +e.getMessage());
		}
		return dto;
	}
	
	public boolean updateData(SangpumFormBean bean) {
		boolean b = false;
		String sql = "UPDATE sangdata SET sang=?, su=?, dan=? WHERE code=?";
		try (
				Connection connection = ds.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(sql)
					) {
					preparedStatement.setString(1, bean.getSang());
					preparedStatement.setString(2, bean.getSu());
					preparedStatement.setString(3, bean.getDan());
					preparedStatement.setString(4, bean.getCode());
					if(preparedStatement.executeUpdate() > 0) b=true;				
		} catch (Exception e) {
			System.out.println("updateData err : " +e.getMessage());
		}
		return b;
	}
	public boolean deleteData(String code) {
		boolean b = false;
		String sql = "DELETE FROM sangdata WHERE code=?";
		try (
				Connection connection = ds.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(sql)
					) {
					preparedStatement.setString(1, code);
					if(preparedStatement.executeUpdate() >0) b=true;
		
		} catch (Exception e) {
			System.out.println("updateData err : " +e.getMessage());
		}
		return b;
	}
}