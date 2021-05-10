package everyssafy.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import everyssafy.model.service.BoardService;
import everyssafy.model.service.BoardServiceImpl;

public class GetBoardTitleController  implements Controller{

	@Override
	public String requestHandle(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int boardId = Integer.parseInt(request.getParameter("boardId"));
		String title = "";
		
		title = BoardServiceImpl.getBoardService().getBoardTitle(boardId);
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		out.println(title);
		out.flush();
		
		return null;
	}

}
