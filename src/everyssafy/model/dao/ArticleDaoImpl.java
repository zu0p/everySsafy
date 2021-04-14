package everyssafy.model.dao;
import java.util.List;
import everyssafy.model.ArticleDto;

public class ArticleDaoImpl implements ArticleDao{

	private static ArticleDao articleDao;
	private ArticleDaoImpl() {}
	public static ArticleDao getArticleDao() {
		if(articleDao ==null ) articleDao = new ArticleDaoImpl();
		return articleDao;
	}
	
	@Override
	public void registerArticle(ArticleDto ArticleDto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modifyArticle(int ArticleId, int BoardId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArticleDto getArticle(int ArticleId, int BoardId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteArticle(int ArticleId, int BoardId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<ArticleDto> getListArticle(int ArticleId, int BoardId) {
		// TODO Auto-generated method stub
		return null;
	}

}
