package everyssafy.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import everyssafy.model.ArticleDto;
import everyssafy.model.service.ArticleServiceImpl;

public class GetListArticleController implements Controller{

	@Override
	public String requestHandle(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String path = "";
		int boardId = Integer.parseInt(request.getParameter("boardId"));
		
		List<ArticleDto> ArticleList = null;
		
		path = "/page/arricleform.jsp";
		try {
			ArticleList = (List<ArticleDto>) ArticleServiceImpl.getArticleService().getListArticle(boardId);
			request.setAttribute("ArticleList", ArticleList);
		}catch (Exception e) {
			request.setAttribute("msg", "글을 읽어오던  중 문제가 발생했습니다.");
			path = "/error/error500.jsp";
		}
		
		return path;
	}

}
