package everyssafy.model.service;

import java.util.List;

import everyssafy.model.ArticleDto;
import everyssafy.model.dao.ArticleDaoImpl;
import everyssafy.model.dao.BoardDaoImpl;

public class ArticleServiceImpl implements ArticleService{

	private static ArticleService articleService;
	private ArticleServiceImpl() {}
	public static ArticleService getArticleService()
	{
		if(articleService == null) articleService = new ArticleServiceImpl();
		return articleService;
	}
	
	@Override
	public void registerArticle(ArticleDto ArticleDto) {
		ArticleDaoImpl.getArticleDao().registerArticle(ArticleDto);
	}

	@Override
	public void modifyArticle(int ArticleId, int BoardId) {
		ArticleDaoImpl.getArticleDao().modifyArticle(ArticleId, BoardId);
	}

	@Override
	public ArticleDto getArticle(int ArticleId, int BoardId) {
		return ArticleDaoImpl.getArticleDao().getArticle(ArticleId, BoardId);
	}

	@Override
	public void deleteArticle(int ArticleId, int BoardId) {
		ArticleDaoImpl.getArticleDao().deleteArticle(ArticleId, BoardId);
	}

	@Override
	public List<ArticleDto> getListArticle(int ArticleId, int BoardId) {
		return ArticleDaoImpl.getArticleDao().getListArticle(ArticleId, BoardId);
	}

}
