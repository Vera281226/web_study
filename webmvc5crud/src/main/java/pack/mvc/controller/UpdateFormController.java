package pack.mvc.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import pack.mvc.model.ProcessManager;
import pack.mvc.model.UserDto;

public class UpdateFormController implements Controller {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		String userid =  request.getParameter("userid");
		
		// 모델 호출
		UserDto userDto = ProcessManager.instance().findUser(userid);
		request.setAttribute("user", userDto);
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("update.jsp");
		modelAndView.setRedirect(false);
		return modelAndView;
	}
}