package pack.mvc.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class LogoutController implements Controller{
	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession httpSession = request.getSession(false);
		httpSession.removeAttribute("userid");
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("login.html");
		modelAndView.setRedirect(true);
		return modelAndView;
	}
}