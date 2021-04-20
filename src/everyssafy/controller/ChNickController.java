package everyssafy.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import everyssafy.model.UserDto;
import everyssafy.model.service.UserService;
import everyssafy.model.service.UserServiceImpl;

public class ChNickController implements Controller {

	@Override
	public String requestHandle(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String userId=request.getParameter("userId");
		String userNickName=request.getParameter("changeNick");
		String PATH=null;
		UserService service=UserServiceImpl.getUserService();
		UserDto userDto=service.chNick(userId, userNickName);
		if(userDto!=null) {
			HttpSession session = request.getSession();
			session.setAttribute("user", userDto);
			PATH="/userinfo.jsp";
		}else {
			request.setAttribute("msg", "로그인 실패");
			PATH="/error/error500.jsp";
		}
		return PATH;
	}

}
