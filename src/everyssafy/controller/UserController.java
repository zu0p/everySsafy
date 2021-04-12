package everyssafy.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
		} else if("".equals(act)) {
			
		}
	}

	private void logout(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// do logout
		HttpSession session = request.getSession();
		session.invalidate();
		
		response.sendRedirect(request.getContextPath()+"index.jsp");
	}

}
