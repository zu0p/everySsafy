package everyssafy.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import everyssafy.model.UserDto;
import everyssafy.model.service.UserServiceImpl;

public class MyPageController implements Controller {

	private class Returns{
		UserDto user;
		String path;
		public Returns(UserDto user, String path) {
			super();
			this.user = user;
			this.path = path;
		}
	}
	
	@Override
	public String requestHandle(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//user info 가져오기
		String PATH="";
		HttpSession session = request.getSession();
		String userId = ((UserDto)session.getAttribute("user")).getUserId();
		try {
			UserDto userDto = UserServiceImpl.getUserService().getUserInfo(userId);
			//request.setAttribute("userInfo", userDto);
			//System.out.println("get id:"+userDto.getUserId());
			PATH="/userinfo.jsp";
			Returns returns = new Returns(userDto, PATH);
			
			Gson gson = new Gson();
			String result = gson.toJson(returns);
			PrintWriter out = response.getWriter();
			out.println(result);
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
