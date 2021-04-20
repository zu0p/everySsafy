package everyssafy.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import everyssafy.model.ArticleDto;
import everyssafy.model.UserDto;
import everyssafy.model.service.ArticleServiceImpl;


@WebServlet("/articletemp")
public class articletemp extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public articletemp() {
        super();
        // TODO Auto-generated constructor stub
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String root = request.getContextPath();
		String act = request.getParameter("act");
		
		//수정 삭제 조회  둥록
		if("/registArticle.do".equals(act))
		{
			registArticle(request,response);
		}else if("deleteArticle".equals(act)) {
			deleteArticle(request,response);
		}else if("modifyArticle".equals(act)) {
			modifyArticle(request,response);
		}else if("getListArticle".equals(act)) {
			getListArticle(request,response);
		}
		
	
	}
	protected void registArticle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = "";
		ArticleDto articleDto = new ArticleDto();
		HttpSession session = request.getSession();
		UserDto userdto = (UserDto) session.getAttribute("userinfo");
		
		if(userdto != null) {
			articleDto.setUserId(userdto.getUserId());
			articleDto.setArticleTitle(request.getParameter("title"));
			articleDto.setArticleContent(request.getParameter("content"));
			articleDto.setBoardId(Integer.parseInt(request.getParameter("boardId")));
			
			ArticleServiceImpl.getArticleService().registerArticle(articleDto);
			path = "/page/arricleform.jsp";
			request.getRequestDispatcher(path).forward(request, response);
			
		}
		
	}
	protected void deleteArticle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = "";
		int articleId = Integer.parseInt(request.getParameter("articleId"));
		ArticleServiceImpl.getArticleService().deleteArticle(articleId);
		path = "/page/arricleform.jsp";
		request.getRequestDispatcher(path).forward(request, response);
		
	}
	protected void modifyArticle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = "";
		int articleId = Integer.parseInt(request.getParameter("articleId"));
		ArticleDto articleDto = (ArticleDto) ArticleServiceImpl.getArticleService().getArticle(articleId);
		
		ArticleServiceImpl.getArticleService().modifyArticle(articleDto);
		
		path = "/page/arricleform.jsp";
		request.getRequestDispatcher(path).forward(request, response);
		
	}
	protected void getListArticle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = "";
		int boardId = Integer.parseInt(request.getParameter("boardId"));
		
		List<ArticleDto> ArticleList = null;
		
		ArticleList = (List<ArticleDto>) ArticleServiceImpl.getArticleService().getListArticle(boardId);
		request.setAttribute("ArticleList", ArticleList);
		
		path = "/page/arricleform.jsp";
		request.getRequestDispatcher(path).forward(request, response);
		
	}
}
