package everyssafy.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import everyssafy.model.UserDto;
import everyssafy.model.service.UserServiceImpl;

public class MyPageController implements Controller {

	@Override
	public String requestHandle(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//user info 가져오기
		String PATH="";
		HttpSession session = request.getSession();
		String userId = ((UserDto)session.getAttribute("user")).getUserId();
		try {
			UserDto userDto = UserServiceImpl.getUserService().getUserInfo(userId);
			request.setAttribute("userInfo", userDto);
			PATH="/userinfo.jsp";
			PrintWriter out = response.getWriter();
			out.println(PATH);
			out.flush();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			PATH="/error/error500.jsp";
			return PATH;
		}
		return null;
	}

}
