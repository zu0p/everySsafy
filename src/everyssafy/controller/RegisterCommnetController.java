package everyssafy.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import everyssafy.model.CommentDto;
import everyssafy.model.UserDto;
import everyssafy.model.service.CommentServiceImpl;

public class RegisterCommnetController implements Controller{

	@Override
	public String requestHandle(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String PATH = null;
		CommentDto commentDto = new CommentDto(); 
		HttpSession session = request.getSession();
		UserDto userdto = (UserDto) session.getAttribute("user");
		String id=request.getParameter("article");
		System.out.println(id);
		int articleId=Integer.parseInt(id);
		if(userdto !=null)
		{
			commentDto.setUserId(userdto.getUserId());
			commentDto.setCommentContent(request.getParameter("content"));
			commentDto.setArticleId(articleId);
			
			try {
				CommentServiceImpl.getCommentService().registerComment(commentDto);
				PrintWriter out=response.getWriter();
				out.print("1");
				out.flush();
			}catch (Exception e) {
				request.setAttribute("msg", "댓긓 작성 중  문제가 발생했습니다.");
				PATH="/error/error500"; 
			}
			
		}
		
		else
		{
			request.setAttribute("msg", "로그인후 작성");
			PATH="/error/error500";
			return PATH;
		}
		return null;
	}

}
