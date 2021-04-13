package everyssafy.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import everyssafy.model.UserDto;
import everyssafy.model.service.UserService;
import everyssafy.model.service.UserServiceImpl;

/**
 * Servlet implementation class UserController
 */
@WebServlet(urlPatterns= {"/user", "/my"})
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		doGet(request, response);
	}
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String act = request.getParameter("act");
		if("logout".equals(act)) {
			logout(request, response);
		} else if("register".equals(act)) {
			register(request,response);
		}
	}

	private void register(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session=request.getSession();
		String userId=request.getParameter("userId");
		String userPwd=request.getParameter("userPwd");
		String userName=request.getParameter("userName");
		String userNickName=request.getParameter("userNickName");
		UserService service=UserServiceImpl.getUserService();
		UserDto userDto=new UserDto(userId, userPwd, userName, userNickName);
		String PATH=null;
		if(service.register(userDto)) {
			session.setAttribute("user", userDto); //세션정보 넘겨서
			PATH="/index.jsp";
		}else{
			request.setAttribute("msg", "회원가입 실패 문의요망");
			PATH="/error/error500";
		}
		RequestDispatcher disp=request.getRequestDispatcher(PATH); //로그인 넘겨보내기
		disp.forward(request, response);
		
	}

	private void logout(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// do logout
		HttpSession session = request.getSession();
		session.invalidate();
		
		response.sendRedirect(request.getContextPath()+"index.jsp");
	}

}
