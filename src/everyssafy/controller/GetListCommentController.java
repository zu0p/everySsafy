package everyssafy.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import everyssafy.model.CommentDto;
import everyssafy.model.service.CommentServiceImpl;

public class GetListCommentController implements Controller {
	private class Pair{
		List<CommentDto> list;
		String path;
		public Pair(List<CommentDto> list, String path) {
			super();
			this.list = list;
			this.path = path;
		}
		
	}
	@Override
	public String requestHandle(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String path ="";
		int articleId = Integer.parseInt(request.getParameter("articleId"));
		List<CommentDto> commentList = null;
		try {
			commentList =CommentServiceImpl.getCommentService().getCommentList(articleId);
			System.out.println(commentList.size());
			for(CommentDto c:commentList) {
				System.out.println(c.getArticleId());
			}
			path="/page/article.jsp";
			Gson gson = new Gson();
			Pair p=new Pair(commentList,path);
			String ret=gson.toJson(p);
			response.setCharacterEncoding("UTF-8");
			PrintWriter out=response.getWriter();
			System.out.println(ret);
			out.print(ret);
			out.flush();
		}catch (Exception e) {
			request.setAttribute("msg", "글을 읽어오던  중 문제가 발생했습니다.");
			path = "/error/error500.jsp";
			return path;
		}
		return null;
	}

}
