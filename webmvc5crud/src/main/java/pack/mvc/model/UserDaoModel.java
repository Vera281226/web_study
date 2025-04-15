package pack.mvc.model;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import pack.mvc.controller.UserForm;

public class UserDaoModel { // userinfo 테이블 관련 BL
	private SqlSessionFactory factory = SqlMapConfig.getSqlSession();
	
	public UserDaoModel() {
		// TODO Auto-generated constructor stub
	}
	
	public ArrayList<UserDto> getUserAll() {
		List<UserDto> list = null;
		SqlSession sqlSession = factory.openSession();
		try {
			list = sqlSession.selectList("selectDataAll");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			if(sqlSession != null) sqlSession.close();
		}
		return (ArrayList<UserDto>)list;
	}
	
	public UserDto findUser(String userid) {
		UserDto dto = null;
		SqlSession sqlSession = factory.openSession();
		try {
			dto = sqlSession.selectOne("findUser", userid);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			if(sqlSession != null) sqlSession.close();
		}
		return dto;
	}

	public int insertData(UserForm userForm) {
		int re = 0;
		SqlSession sqlSession = factory.openSession();
		try {
			re = sqlSession.insert("insertData",userForm);
			sqlSession.commit();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			sqlSession.rollback();
		} finally {
			if(sqlSession != null) sqlSession.close();
		}
		return re;
	}
	
	public int updateData(UserForm userForm) {
		int re = 0;
		SqlSession sqlSession = factory.openSession();
		try {
			re = sqlSession.insert("updateData",userForm);
			sqlSession.commit();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			sqlSession.rollback();
		} finally {
			if(sqlSession != null) sqlSession.close();
		}
		return re;
	}
	public int deleteData(String userid) {
		int re = 0;
		SqlSession sqlSession = factory.openSession();
		try {
			re = sqlSession.insert("deleteData",userid);
			sqlSession.commit();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			sqlSession.rollback();
		} finally {
			if(sqlSession != null) sqlSession.close();
		}
		return re;
	}
	
}