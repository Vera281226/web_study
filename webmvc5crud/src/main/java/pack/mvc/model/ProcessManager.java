package pack.mvc.model;

import java.util.ArrayList;

import pack.mvc.controller.UserForm;

public class ProcessManager { // DAO(Business Logic) 관리 역할
	private static ProcessManager manager = new ProcessManager();
	
	public static ProcessManager instance() {
		return manager;
	}
	private UserDaoModel getUserDaoModel() {
		return new UserDaoModel();
	}
	public ArrayList<UserDto> getUserDataAll() {
		return getUserDaoModel().getUserAll();
	}
	
	public boolean login(String user_id, String user_password) {
		UserDto dto =  getUserDaoModel().findUser(user_id);
		
		if(dto == null) return false;
		if(dto.getPassword().equals(user_password)) return true;
		else return false;
	}
	
	public int insert(UserForm userForm) {	
		return getUserDaoModel().insertData(userForm);
	}
	public UserDto findUser(String userid) {
		return getUserDaoModel().findUser(userid);
	}
	
	public int update(UserForm userForm) {	
		return getUserDaoModel().updateData(userForm);
	}
	
	public int delete(String userid) {
		return getUserDaoModel().deleteData(userid);
	}
}