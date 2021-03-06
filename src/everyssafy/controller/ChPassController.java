package everyssafy.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import everyssafy.model.UserDto;
import everyssafy.model.service.UserServiceImpl;
public class ChPassController implements Controller{

	@Override
	public String requestHandle(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		String userId=((UserDto)session.getAttribute("user")).getUserId();
		String userPwd=request.getParameter("userPwd");
		String usernewPwd=request.getParameter("newuserPwd");
		String PATH=null;

		try {
			UserServiceImpl.getUserService().chPass(userId, userPwd, usernewPwd);
			PATH="/user/login.jsp";
		} catch (Exception e) {
			PATH="/error/error500.jsp";
			e.printStackTrace();
			return PATH;
		}
		return PATH;
	}

}
