package everyssafy.model.service;
import everyssafy.model.ArticleDto;
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

}
