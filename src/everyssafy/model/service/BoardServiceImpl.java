package everyssafy.model.service;
import java.util.List;

import everyssafy.model.ArticleDto;
import everyssafy.model.BoardDto;
import everyssafy.model.dao.BoardDaoImpl;

public class BoardServiceImpl implements BoardService{

	private static BoardService boardService;
	private BoardServiceImpl() {}
	public static BoardService getBoardService()
	{
		if(boardService ==null) boardService = new BoardServiceImpl();
		return boardService;
	}
	

	@Override
	public String getBoardTitle(int BoardId) {
		return  BoardDaoImpl.getBoardDao().getBoardTitle(BoardId);
	}
	@Override
	public List<ArticleDto> getList(int BoardId) {
		return BoardDaoImpl.getBoardDao().getList(BoardId);
	}

}
