package everyssafy.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import everyssafy.model.CommentDto;
import everyssafy.model.service.CommentServiceImpl;

public class GetListCommentController implements Controller {

	@Override
	public String requestHandle(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String path ="";
		int articleId = Integer.parseInt(request.getParameter("articleId"));
		
		List<CommentDto> CommnetList = null;
		try {
			CommnetList = (List<CommentDto>) CommentServiceImpl.getCommentService().getCommentList(articleId);
			request.setAttribute("CommentList", CommnetList);
			path ="/page/article.jsp";
		}catch (Exception e) {
			request.setAttribute("msg", "글을 읽어오던  중 문제가 발생했습니다.");
			path = "/error/error500.jsp";
		}
		return path;
	}

}
