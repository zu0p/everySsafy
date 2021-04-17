package everyssafy.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import everyssafy.model.UserDto;
import everyssafy.model.service.UserService;
import everyssafy.model.service.UserServiceImpl;

public class UserController implements Controller{
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		doGet(request, response);
	}
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String act = request.getParameter("act");
		System.out.println(request.getLocalName());
		if("logout".equals(act)) {
			logout(request, response);
		} else if("register".equals(act)) {
			register(request,response);
		} else if("login".equals(act)) {
			login(request,response);
		}else if("chkUserId".equals(act)) {
			chkId(request,response);
		}
		
	}

	private void chkId(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		response.setContentType("application/json; charset=utf8");
		String userId=request.getParameter("userId");
		System.out.println("ID:" + userId);
		String ans="";
		if(UserServiceImpl.getUserService().chkId(userId)) {
			ans="1";
		}else {
			ans="0";
		}
		Gson gson=new Gson();
		String ret=gson.toJson(ans);
		PrintWriter out=response.getWriter();
		out.print(ret);
	}

	private void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String userId=request.getParameter("userId");
		String userPwd=request.getParameter("userPwd");
		String PATH=null;
		UserService service=UserServiceImpl.getUserService();
		UserDto userDto=service.login(userId, userPwd);
		if(userDto!=null) {
			HttpSession session = request.getSession();
			session.setAttribute("user", userDto);
			PATH="/index.jsp";
		}else {
			request.setAttribute("msg", "로그인 실패 문의요망");
			PATH="/error/error500";
		}
		RequestDispatcher disp=request.getRequestDispatcher(PATH); //로그인 넘겨보내기
		disp.forward(request, response);
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
		
		response.sendRedirect(request.getContextPath()+"/index.jsp");
	}

	@Override
	public String requestHandle(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		return null;
	}

}
