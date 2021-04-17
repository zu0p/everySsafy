package everyssafy.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import everyssafy.model.service.UserServiceImpl;

public class ChkIdController implements Controller{

	@Override
	public String requestHandle(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
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
		return "/registerUser.jsp";
	}

}
