package pack.mvc.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import pack.mvc.model.ProcessManager;

public class DeleteController implements Controller {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		String userid = request.getParameter("userid");
		
		int re = ProcessManager.instance().delete(userid);
		
		ModelAndView modelAndView = new ModelAndView();
		if(re>0) modelAndView.setViewName("list.m2");
		else modelAndView.setViewName("fail.html");
		modelAndView.setRedirect(true);
		return modelAndView;
	}
}