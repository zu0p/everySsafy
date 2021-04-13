package everyssafy.model.service;
import everyssafy.model.ArticleDto;

public interface BoardService {
	
	int getBoardId(ArticleDto articleDto);
	String getBoardTitle(int BoardId);
	
}
