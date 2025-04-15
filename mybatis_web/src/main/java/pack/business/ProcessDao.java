package pack.business;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import pack.mybatis.SqlMapConfig;

public class ProcessDao { // 비즈니스 로직
	private static ProcessDao processDao = new ProcessDao();
	public static ProcessDao getInstance() {
		return processDao;
	}
	
	private SqlSessionFactory sqlSessionFactory = SqlMapConfig.getSqlSession();
	
	public List<SangpumDto> selectDataALL() throws SQLException{
		SqlSession sqlSession = sqlSessionFactory.openSession();
		List<SangpumDto> list = sqlSession.selectList("selectDataAll");
		sqlSession.close();
		return list;
	}
	
	public SangpumDto selectDataPart(String code) throws SQLException{
		SqlSession sqlSession = sqlSessionFactory.openSession();
		SangpumDto dto = sqlSession.selectOne("selectDataByCode", code);
		sqlSession.close();
		return dto;
	}
	
	public void insertData(SangpumBean bean) throws SQLException{ // 수동 Commit이라 바로 적용되거나 하지 않는다 commit이 필요
		SqlSession sqlSession = sqlSessionFactory.openSession();
		sqlSession.insert("insertData", bean);
		sqlSession.commit();
		sqlSession.close();
	}
	public void updateData(SangpumDto bean) throws SQLException{
		SqlSession sqlSession = sqlSessionFactory.openSession(true);
		sqlSession.update("updateData", bean);
		sqlSession.close();
	}
	public boolean deleteData(String code) throws SQLException{
		SqlSession sqlSession = sqlSessionFactory.openSession();
		boolean b=false;
		try {
			int count = sqlSession.delete("deleteData", code);
			if(count > 0) b=true;
			sqlSession.commit();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			sqlSession.rollback();
		}finally {
			if(sqlSession != null) sqlSession.close();
		}
		return b;
	}
}