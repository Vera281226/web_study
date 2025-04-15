package pack;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DbConnPaging { // DB 처리용 Business Logic
	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;
	
	int recordTotal = 0; // 행의 총 갯수
	int pageSize = 5; // 각 페이지당 출력 행의 수
	int totalPage = 0; // 전체 페이지 수
	
	public DbConnPaging() {
		try {
			Class.forName("org.mariadb.jdbc.Driver");
		} catch (Exception e) {
			System.out.println("class err : " +e.getMessage());
		}
	}
	/*
	public ArrayList<SangpumDto> getDataAll(String pa) { // 해당 페이지의 자료만 반환
		ArrayList<SangpumDto> list = new ArrayList<SangpumDto>();
		try {
			conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/test","root","123");
			String sql = "SELECT*FROM sangdata ORDER BY code DESC";
			ps = conn.prepareStatement(sql);
			rs=ps.executeQuery();
			int startNum = (Integer.parseInt(pa)-1)*pageSize +1;
			for(int p=1; p<startNum; p++) {
				rs.next(); // 레코드 포인터 위치를 해당 페이지 시작 지점으로 위치 지정
			}
			for (int i = 0; rs.next() && i < pageSize; i++) {
			    SangpumDto dto = new SangpumDto();
			    dto.setCode(rs.getString("code"));
			    dto.setSang(rs.getString("sang"));
			    dto.setSu(rs.getString("su"));
			    dto.setDan(rs.getString("dan"));
			    list.add(dto);
			}
			
		} catch (Exception e) {
			System.out.println("getDataAll err : " +e.getMessage());
		}finally {
			try {
				if(rs!=null) rs.close();
				if(ps!=null) ps.close();
				if(conn!=null) conn.close();
			} catch (Exception e) {
				System.out.println("getDataAll err : " +e.getMessage());
			}
		}
		return list;
	}
	*/
	public ArrayList<SangpumDto> getDataAll(String pa) { // 람다식으로 사용해보기
		ArrayList<SangpumDto> list = new ArrayList<SangpumDto>();
		String url="jdbc:mariadb://localhost:3306/test";
		
		// try with resources 구문 사용
		try( Connection conn = DriverManager.getConnection(url,"root","123");	
				PreparedStatement ps = conn.prepareStatement("SELECT*FROM sangdata ORDER BY code DESC");
				ResultSet rs=ps.executeQuery()) {	
			int startNum = (Integer.parseInt(pa)-1)*pageSize +1;
			rs.absolute(startNum-1);
			
			list = Stream.iterate(1, i -> i+1) //1부터 시작하는 스트림 생성
					.limit(pageSize) // 스트림의 크기를 페이지사이즈만큼 제한
					.map(i -> {
						try {
							if(rs.next()) { // 레코드 이동하며 SangpumDto에 값 저장
								SangpumDto dto = new SangpumDto();
								dto.setCode(rs.getString("code"));
							    dto.setSang(rs.getString("sang"));
							    dto.setSu(rs.getString("su"));
							    dto.setDan(rs.getString("dan"));
							    return dto;
							}
						} catch (Exception e) {
							System.out.println("getDataAll map err : " +e.getMessage());
						}
						return null;
					})
					.filter(Objects::nonNull) // null이 아닌 객체만 필터링 
					.collect(Collectors.toCollection(ArrayList::new)); // collect() 스트림 결과를 ArrayList로 수집
		} catch (Exception e) {
			System.out.println("getDataAll err : " +e.getMessage());
		}
		
		return list;
	}
	public int prepareTotalPage() {
		try {
			conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/test","root","123");
			String sql = "SELECT count(*) FROM sangdata";
			ps = conn.prepareStatement(sql);
			rs=ps.executeQuery();
			if(rs.next()) recordTotal = rs.getInt(1); // 전체 레코드 수 구하기
			// 전체 페이지 수 계산
			totalPage = recordTotal/pageSize; // 페이지 수를 위한 몫을 구하기
			if(recordTotal % pageSize != 0) totalPage += 1; // 자투리 계산후 페이지 추가 나머지 계산
		} catch (Exception e) {
			System.out.println("prepareTotalPage err : " +e.getMessage());
		}finally {
			try {
				if(rs!=null) rs.close();
				if(ps!=null) ps.close();
				if(conn!=null) conn.close();
			} catch (Exception e) {
				System.out.println("getDataAll err : " +e.getMessage());
			}
		}
		return totalPage;
	}
	
	public void sangpumInsert(SangpumFormBean formBean) {
		try {
			conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/test","root","123");
			String sql = "SELECT max(code) FROM sangdata";
			ps = conn.prepareStatement(sql);
			rs=ps.executeQuery();
			rs.next();
			int maxCode = rs.getInt(1);
			
			sql = "INSERT INTO sangdata VALUES(?,?,?,?);";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, maxCode+1); // auto increment를 자바로 구현해낸 것 이렇게 해주는 것이 좋다.
			ps.setString(2, formBean.getSang());
			ps.setString(3, formBean.getSu());
			ps.setString(4, formBean.getDan());
			ps.executeUpdate(); // 반환값을 통해 받아 처리할 수 있다.
	}catch (Exception e) {
		System.out.println("getDataAll err : " +e.getMessage());
	}finally {
		try {
			if(rs!=null) rs.close();
			if(ps!=null) ps.close();
			if(conn!=null) conn.close();
		} catch (Exception e) {
			System.out.println("getDataAll err : " +e.getMessage());
			}
		}
	} 
}