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
			list = sqlSession.selectList("selectDataAll");
		} catch (Exception e) {
			System.out.println("selectMemberAll"+e.getMessage());
		} finally {
			if(sqlSession != null) sqlSession.close();
		}
		return list;
	}
	
	public List<DataDto> selectDataPart(String id) throws SQLException{
		List<DataDto> list = null;
		SqlSession sqlSession = sessionFactory.openSession();
		try {
			list = sqlSession.selectList("selectDataPart", id);
		} catch (Exception e) {
			System.out.println("selectMemberAll"+e.getMessage());
		} finally {
			if(sqlSession != null) sqlSession.close();
		}
		return list;
	}
	
	public boolean insertMember(DataFormBean bean) {
		boolean b = false;
		SqlSession sqlSession = sessionFactory.openSession();
		try {
			if(sqlSession.insert("insertData", bean)>0) b=true;
			sqlSession.commit();
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
			if(sqlSession.insert("updateData", bean)>0) b=true;
			sqlSession.commit();
		} catch (Exception e) {
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
			if(sqlSession.delete("deleteData", id)>0) b=true;
			sqlSession.commit();
		} catch (Exception e) {
			System.out.println("updateMember"+e.getMessage());
			sqlSession.rollback();
		} finally {
			if(sqlSession != null) sqlSession.close();
		}
		return b;
	}
}