package everyssafy.model.service;

import java.util.ArrayList;
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
	public void modifyArticle( ArticleDto articleDto) {
		ArticleDaoImpl.getArticleDao().modifyArticle( articleDto);
	}

	@Override
	public ArticleDto getArticle(int ArticleId) {
		return ArticleDaoImpl.getArticleDao().getArticle(ArticleId);
	}

	@Override
	public void deleteArticle(int ArticleId) {
		ArticleDaoImpl.getArticleDao().deleteArticle(ArticleId);
	}

	@Override
	public List<ArticleDto> getListArticle( int BoardId) {
		return ArticleDaoImpl.getArticleDao().getListArticle(BoardId);
	}
	@Override
	public List<ArticleDto> getMyrticle(String userId) {
		// TODO Auto-generated method stub
		return ArticleDaoImpl.getArticleDao().getMyrticle(userId);
	}

}
