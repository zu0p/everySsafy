package everyssafy.controller;

import java.io.IOException;

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
		HttpSession session = request.getSession();
		UserDto userdto = (UserDto) session.getAttribute("userinfo");
		
		if(userdto != null) {
			articleDto.setUserId(userdto.getUserId());
			articleDto.setArticleTitle(request.getParameter("title"));
			articleDto.setArticleContent(request.getParameter("content"));
			articleDto.setBoardId(Integer.parseInt(request.getParameter("boardId")));
			PATH = "/page/arricleform.jsp";
			try {
			ArticleServiceImpl.getArticleService().registerArticle(articleDto);
			}catch (Exception e) {
				request.setAttribute("msg", "글 작성중 문제가 발생했습니다.");
				PATH="/error/error500";
			}
		}
		else
		{
			request.setAttribute("msg", "로그인후 작성");
			PATH="/error/error500";
		}
		return PATH;
	}

}
