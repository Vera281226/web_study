package pack;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class GuestDbConPool {
	private DataSource ds;
	
	public GuestDbConPool() {
		try {
			Context context = new InitialContext();
			ds = (DataSource) context.lookup("java:comp/env/jdbc_maria");
		} catch (Exception e) {
			System.out.println("DbConnPooling error" +e.getMessage());
		}
	}
	public ArrayList<GuestbookDto> getDataAll() {
		ArrayList<GuestbookDto> list = new ArrayList<GuestbookDto>();
		try(
				Connection connection = ds.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement("SELECT*FROM guestbook");
				ResultSet resultSet = preparedStatement.executeQuery()		
				) {
			while(resultSet.next()) {
				GuestbookDto dto = new GuestbookDto();
			    dto.setCode(resultSet.getInt(1));
			    dto.setName(resultSet.getString(2));
			    dto.setTitle(resultSet.getString(3));
			    dto.setContent(resultSet.getString(4));
			    list.add(dto);
			}
		} catch (Exception e) {
			System.out.println("getDataAll error" +e.getMessage());
		}
		return list;
	}
	public boolean insertData(GuestbookFormBean formBean) {
		boolean b = false;
		String sql = "SELECT MAX(code) FROM guestbook";
		try(Connection connection = ds.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(sql);
				ResultSet resultSet = preparedStatement.executeQuery()		) {
			int maxCode = 0;
	        if (resultSet.next()) {
	            maxCode = resultSet.getInt(1);
	        }
	        maxCode += 1;
	        sql = "INSERT INTO guestbook VALUES(?,?,?,?)";
	        try (PreparedStatement insertStatement = connection.prepareStatement(sql)) {
	            insertStatement.setInt(1, maxCode);
	            insertStatement.setString(2, formBean.getName());
	            insertStatement.setString(3, formBean.getTitle());
	            insertStatement.setString(4, formBean.getContent());
	            
	            int result = insertStatement.executeUpdate();
	            if (result == 1) {
	                b = true;
	            }
	        }
	    } catch (Exception e) {
		System.out.println("insertData err : " +e.getMessage());
		}	
		return b;
	}
	public GuestbookDto updateDataRead(int code) {
		GuestbookDto dto = null;
		String sql = "SELECT*FROM guestbook WHERE code=?";
		try (
				Connection connection = ds.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(sql)
					) {
					preparedStatement.setInt(1, code);
					ResultSet resultSet = preparedStatement.executeQuery();
					if(resultSet.next()) { dto = new GuestbookDto(); 
					dto.setCode(resultSet.getInt(1));
					dto.setName(resultSet.getString(2));
					dto.setTitle(resultSet.getString(3));
					dto.setContent(resultSet.getString(4));
					}
		} catch (Exception e) {
			System.out.println("updateDataRead err : " +e.getMessage());
		}
		return dto;
	}
	public boolean updateData(GuestbookFormBean bean) {
		boolean b = false;
		try (
				Connection connection = ds.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement("UPDATE guestbook SET name=?, title=?, content=? WHERE code=?")
					) {
					preparedStatement.setString(1, bean.getName());
					preparedStatement.setString(2, bean.getTitle());
					preparedStatement.setString(3, bean.getContent());
					preparedStatement.setInt(4, bean.getCode());
					if(preparedStatement.executeUpdate() > 0) b=true;				
		} catch (Exception e) {
			System.out.println("updateData err : " +e.getMessage());
		}
		return b;
	}
	public boolean deleteData(int code) {
		boolean b = false;
		String sql = "DELETE FROM guestbook WHERE code=?";
		try (
				Connection connection = ds.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(sql)
					) {
					preparedStatement.setInt(1, code);
					if(preparedStatement.executeUpdate() >0) b=true;
		
		} catch (Exception e) {
			System.out.println("deleteData err : " +e.getMessage());
		}
		return b;
	}
}