package pack.mvc.controller;

import java.util.ArrayList;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import pack.mvc.model.ProcessManager;
import pack.mvc.model.UserDto;

public class LoginController implements Controller {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String userid = request.getParameter("userid");
		String password = request.getParameter("password");
		
		boolean b = ProcessManager.instance().login(userid, password);
		ModelAndView modelAndView = new ModelAndView();
		if(b) {
			HttpSession httpSession = request.getSession(true);
			httpSession.setAttribute("userid", userid);
			modelAndView.setViewName("list.m2");
		} else {
			modelAndView.setViewName("fail.html");
		}
		modelAndView.setRedirect(true);
		return modelAndView;
	}
}