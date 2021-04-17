package everyssafy.model.dao;
import everyssafy.model.ArticleDto;

public interface BoardDao {
	
	int getBoardId(ArticleDto articleDto);
	String getBoardTitle(int BoardId);
	
}
