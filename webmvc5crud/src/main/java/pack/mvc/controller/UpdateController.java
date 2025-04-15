package pack.mvc.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import pack.mvc.model.ProcessManager;
import pack.mvc.model.UserDto;

public class UpdateController implements Controller {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		
		UserForm userForm = new UserForm();
		userForm.setUserid(request.getParameter("userid"));
		userForm.setPassword(request.getParameter("password"));
		userForm.setName(request.getParameter("name"));
		userForm.setEmail(request.getParameter("email"));
		
		int re = ProcessManager.instance().update(userForm);
		
		ModelAndView modelAndView = new ModelAndView();
		if(re>0) modelAndView.setViewName("list.m2");
		else modelAndView.setViewName("fail.html");
		modelAndView.setRedirect(true);
		return modelAndView;
	}

}
