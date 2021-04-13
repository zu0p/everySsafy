package everyssafy.model.dao;
import java.util.List;
import everyssafy.model.ArticleDto;

public interface ArticleDao {
	//글 작성
		void registerArticle(ArticleDto ArticleDto);
		
		//글 수정
		void modifyArticle(int ArticleId, int BoardId);
		//수정을 위한 글 얻어오기
		ArticleDto getArticle(int ArticleId, int BoardId);
		
		//글 삭제
		void deleteArticle(int ArticleId, int BoardId);
		
		//글 조회
		List<ArticleDto> getListArticle(int ArticleId, int BoardId);
}
