package everyssafy.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import everyssafy.model.CommentDto;
import everyssafy.model.service.CommentServiceImpl;

public class ModifyCommentController implements Controller {

	@Override
	public String requestHandle(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String path = "";
		int commentId = Integer.parseInt(request.getParameter("commentId"));
		CommentDto commentDto = (CommentDto) CommentServiceImpl.getCommentService().getComment(commentId);
		
		try {
			CommentServiceImpl.getCommentService().modifyComment(commentDto);
			path = "/page/article.jsp";
		}catch (Exception e) {
			request.setAttribute("msg", "수정  중 문제가 발생했습니다.");
		}
		return path;
	}

}
