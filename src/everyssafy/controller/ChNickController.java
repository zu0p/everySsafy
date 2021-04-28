package everyssafy.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import everyssafy.model.UserDto;
import everyssafy.model.service.UserServiceImpl;

public class ChNickController implements Controller {

	@Override
	public String requestHandle(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		String userId=((UserDto)session.getAttribute("user")).getUserId();
		String userNickName=request.getParameter("changeNick");
		String PATH=null;
		try {
			UserServiceImpl.getUserService().chNick(userId, userNickName);
			PATH="/index.jsp";
		} catch (Exception e) {
			PATH="/error/error500.jsp";
			e.printStackTrace();
			return PATH;
		}
		UserDto userDto=((UserDto) session.getAttribute("user"));
		userDto.setUserNickName(userNickName);
		session.setAttribute("user", userDto);
		return PATH;
	}

}
