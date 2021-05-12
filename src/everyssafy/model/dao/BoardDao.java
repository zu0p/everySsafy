package everyssafy.model.dao;
import java.util.List;

import everyssafy.model.ArticleDto;
import everyssafy.model.BoardDto;

public interface BoardDao {
	String getBoardTitle(int BoardId);	
	List<ArticleDto> getList(int BoardId);
}
