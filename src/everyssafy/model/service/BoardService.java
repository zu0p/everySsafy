package everyssafy.model.service;

import java.util.List;

import everyssafy.model.ArticleDto;
import everyssafy.model.BoardDto;

public interface BoardService {
	String getBoardTitle(int BoardId);
	List<ArticleDto> getList(int BoardId);
}
