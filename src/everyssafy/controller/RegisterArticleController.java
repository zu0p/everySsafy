package everyssafy.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import everyssafy.model.ArticleDto;
import everyssafy.model.UserDto;
import everyssafy.model.service.ArticleServiceImpl;

public class RegisterArticleController implements Controller {

	@Override
	public String requestHandle(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			// 디스패처 ->포워드할 url 값을 스트링으로 리턴
			//비동기 제이슨 처리는 널 갑 리턴 
		
		
		String PATH = null;
		ArticleDto articleDto = new ArticleDto();
		
		
			articleDto.setUserId(request.getParameter("userId"));
			articleDto.setArticleTitle(request.getParameter("articletitle"));
			articleDto.setArticleContent(request.getParameter("articleContent"));
			articleDto.setBoardId(Integer.parseInt(request.getParameter("boardId")));
			
			ArticleServiceImpl.getArticleService().registerArticle(articleDto);
			
			response.setCharacterEncoding("utf-8");
			PrintWriter out = response.getWriter();
			out.println("등록성공");
			out.flush();
			
			
		
		
		return null;
	}

}
