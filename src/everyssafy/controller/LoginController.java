package everyssafy.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import everyssafy.model.UserDto;
import everyssafy.model.service.UserService;
import everyssafy.model.service.UserServiceImpl;

public class LoginController implements Controller{

	@Override
	public String requestHandle(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String userId=request.getParameter("userId");
		String userPwd=request.getParameter("userPwd");
		String PATH=null;
		UserService service=UserServiceImpl.getUserService();
		UserDto userDto=service.login(userId, userPwd);
		if(userDto!=null) {
			HttpSession session = request.getSession();
			session.setAttribute("user", userDto);
		}else {
			request.setAttribute("msg", "로그인 실패 문의요망");
			PATH="/error/error500";
		}
		return PATH;
	}

}
