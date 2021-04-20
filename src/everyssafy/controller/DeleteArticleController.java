package everyssafy.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import everyssafy.model.service.ArticleServiceImpl;

public class DeleteArticleController implements Controller {

	@Override
	public String requestHandle(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String path = "";
		int articleId = Integer.parseInt(request.getParameter("articleId"));
		
		path = "/page/arricleform.jsp";
		
		try{
			ArticleServiceImpl.getArticleService().deleteArticle(articleId);
		}catch (Exception e) {
			request.setAttribute("msg", "삭제  중 문제가 발생했습니다.");
			path = "/error/error500.jsp";
		}
		
		return path;
	}

}
