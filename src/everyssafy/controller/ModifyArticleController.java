package everyssafy.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import everyssafy.model.ArticleDto;
import everyssafy.model.service.ArticleServiceImpl;

public class ModifyArticleController implements Controller{

	@Override
	public String requestHandle(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String path = "";
		int articleId = Integer.parseInt(request.getParameter("articleId"));
		ArticleDto articleDto = (ArticleDto) ArticleServiceImpl.getArticleService().getArticle(articleId);
		path = "/page/arricleform.jsp";
		
		try{
			ArticleServiceImpl.getArticleService().modifyArticle(articleDto);
		}catch (Exception e) {
			request.setAttribute("msg", "수정  중 문제가 발생했습니다.");
		}
		
		return path;
	}

}
