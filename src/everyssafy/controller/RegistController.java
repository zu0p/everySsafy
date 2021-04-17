package everyssafy.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import everyssafy.model.UserDto;
import everyssafy.model.service.UserService;
import everyssafy.model.service.UserServiceImpl;

public class RegistController implements Controller {

	@Override
	public String requestHandle(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session=request.getSession();
		String userId=request.getParameter("userId");
		String userPwd=request.getParameter("userPwd");
		String userName=request.getParameter("userName");
		String userNickName=request.getParameter("userNickName");
		UserService service=UserServiceImpl.getUserService();
		UserDto userDto=new UserDto(userId, userPwd, userName, userNickName);
		String PATH=request.getContextPath();
		if(service.register(userDto)) {
			session.setAttribute("user", userDto); //세션정보 넘겨서
			PATH+="/index.jsp";
		}else{
			request.setAttribute("msg", "회원가입 실패 문의요망");
			PATH+="/error/error500.jsp";
		}	
		return PATH;
	}

}
