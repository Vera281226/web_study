package pack.business;

import java.sql.SQLException;
import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import pack.mybatis.SqlMapConfig;

public class ProcessDao {
	private static ProcessDao processDao = new ProcessDao();
	public static ProcessDao getInstance() {
		return processDao;
	}
	private SqlSessionFactory sessionFactory = SqlMapConfig.getSqlSession();
	
	public List<DataDto> selectMemberAll(){
		 List<DataDto> list = null;
		SqlSession sqlSession = sessionFactory.openSession();
		try {
			SqlMapperInter inter = sqlSession.getMapper(SqlMapperInter.class);
			list = inter.selectMemberAll();
			inter = null;
		} catch (Exception e) {
			System.out.println("selectMemberAll"+e.getMessage());
		} finally {
			if(sqlSession != null) sqlSession.close();
		}
		return list;
	}
	
	public DataDto selectDataPart(String id) throws SQLException{
		DataDto dto = null;
		SqlSession sqlSession = sessionFactory.openSession();
		try {
			SqlMapperInter inter = sqlSession.getMapper(SqlMapperInter.class);
			dto = inter.selectMemberPart(id);
			inter = null;
		} catch (Exception e) {
			System.out.println("selectMemberAll"+e.getMessage());
		} finally {
			if(sqlSession != null) sqlSession.close();
		}
		return dto;
	}
	
	public boolean insertMember(DataFormBean bean) {
		boolean b = false;
		SqlSession sqlSession = sessionFactory.openSession();
		try {
			SqlMapperInter inter = sqlSession.getMapper(SqlMapperInter.class);
			if(inter.insertMemberData(bean)>0) b=true;
			sqlSession.commit();
			inter = null;
		} catch (Exception e) {
			System.out.println("insertMember"+e.getMessage());
			sqlSession.rollback();
		} finally {
			if(sqlSession != null) sqlSession.close();
		}

		return b;
	}

	public boolean updateMember(DataFormBean bean) {
		boolean b = false;
		SqlSession sqlSession = sessionFactory.openSession();
		try {
			SqlMapperInter inter = sqlSession.getMapper(SqlMapperInter.class);
			if(inter.updateMemberData(bean) > 0) b=true;
			sqlSession.commit();
			inter = null;
		} 
		catch (Exception e) {
			System.out.println("updateMember"+e.getMessage());
			sqlSession.rollback();
		} finally {
			if(sqlSession != null) sqlSession.close();
		}
		return b;
	}

	public boolean deleteMember(String id) {
		boolean b = false;
		SqlSession sqlSession = sessionFactory.openSession();
		try {
			SqlMapperInter inter = sqlSession.getMapper(SqlMapperInter.class);
			if(inter.deleteMemberData(id) > 0) b=true;
			sqlSession.commit();
			inter = null;
		} catch (Exception e) {
			System.out.println("updateMember"+e.getMessage());
			sqlSession.rollback();
		} finally {
			if(sqlSession != null) sqlSession.close();
		}
		return b;
	}
}