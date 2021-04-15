package everyssafy.model.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import everyssafy.model.ArticleDto;
import util.DBUtil;

public class ArticleDaoImpl implements ArticleDao{

	private static ArticleDao articleDao;
	private ArticleDaoImpl() {}
	public static ArticleDao getArticleDao() {
		if(articleDao ==null ) articleDao = new ArticleDaoImpl();
		return articleDao;
	}
	
	@Override
	public void registerArticle(ArticleDto ArticleDto) {
		Connection conn=null;
		PreparedStatement pstmt=null;
		int rs=0;
		
		try {
			conn=DBUtil.getConnect();
			//insert into article (articleId,articleTitle,articleContent,articleDate,articleLike,boardId,userId)
			//values (1,"안녕하세요","안녕하세요 여기가 자유 게시판 인가요?",now(),0,101,"dbtlwns");
//			String sql=;
//			pstmt=conn.prepareStatement(sql);
//			pstmt.setString(1, ArticleDto.getUserId());
//			pstmt.setString(2, ArticleDto.getUserPwd());
//			pstmt.setString(3, ArticleDto.getUserName());
//			pstmt.setString(4, ArticleDto.getUserNickName());
			
			int result=pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtil.close( conn , pstmt);
		}

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
