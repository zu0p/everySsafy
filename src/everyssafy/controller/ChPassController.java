package everyssafy.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import everyssafy.model.service.UserService;
import everyssafy.model.service.UserServiceImpl;
public class ChPassController implements Controller{

	@Override
	public String requestHandle(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		String userId=(String)(session.getAttribute("userId"));
		String userPwd=request.getParameter("userPwd");
		String usernewPwd=request.getParameter("newuserPwd");
		String PATH=null;

		UserService service=UserServiceImpl.getUserService();
		service.chPass(userId, userPwd, usernewPwd);
		PATH="/user/login.jsp";
		return PATH;
	}

}
