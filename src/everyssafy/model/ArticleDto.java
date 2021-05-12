package everyssafy.model;
import java.util.Date;

public class ArticleDto {
	private int articleId;
	private String articleTitle;

	private String articleContent;

	private int articleLike;
	private Date articleDate;
	private int boardId;
	private String userId;
  
	public ArticleDto() {
		// TODO Auto-generated constructor stub
	}

	public ArticleDto(String articleTitle) {
		this.articleTitle=articleTitle;
	}
	public ArticleDto(String articleTitle, java.sql.Date articleDate) {
		this.articleTitle=articleTitle;
		this.articleDate=articleDate;
	}
	private int Comcnt;
	
	
	public int getComcnt() {
		return Comcnt;
	}
	public void setComcnt(int comcnt) {
		Comcnt = comcnt;
	}
  
	public String getArticleContent() {
		return articleContent;
	}
	public void setArticleContent(String articleContent) {
		this.articleContent = articleContent;
	}
	public int getArticleId() {
		return articleId;
	}
	public void setArticleId(int articleId) {
		this.articleId = articleId;
	}
	public String getArticleTitle() {
		return articleTitle;
	}
	public void setArticleTitle(String articleTitle) {
		this.articleTitle = articleTitle;
	}
	public int getArticleLike() {
		return articleLike;
	}
	public void setArticleLike(int articleLike) {
		this.articleLike = articleLike;
	}
	public Date getArticleDate() {
		return articleDate;
	}
	public void setArticleDate(Date articleDate) {
		this.articleDate = articleDate;
	}
	public int getBoardId() {
		return boardId;
	}
	public void setBoardId(int boardId) {
		this.boardId = boardId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	
}
