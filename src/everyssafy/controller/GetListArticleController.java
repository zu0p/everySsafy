package everyssafy.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import everyssafy.model.ArticleDto;
import everyssafy.model.service.ArticleServiceImpl;

public class GetListArticleController implements Controller{

	private class Returns{
		List<ArticleDto> list;
		String path;
		
		public Returns(List<ArticleDto> list, String path) {
			super();
			this.list = list;
			this.path = path;
		}
	}
	@Override
	public String requestHandle(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String path = "";
		int boardId = Integer.parseInt(request.getParameter("boardId"));
		
		List<ArticleDto> ArticleList = null;
		
		path = "/articleform.jsp";
		try {
			ArticleList = (List<ArticleDto>) ArticleServiceImpl.getArticleService().getListArticle(boardId);
			//request.setAttribute("ArticleList", ArticleList);
			Returns returns = new Returns(ArticleList, path);
			
			Gson gson = new Gson();
			String result = gson.toJson(returns);
			PrintWriter out = response.getWriter();
			out.println(result);
			out.flush();
		}catch (Exception e) {
			request.setAttribute("msg", "글을 읽어오던  중 문제가 발생했습니다.");
			path = "/error/error500.jsp";
			return path;
		}
		
		return null;
	}

}
