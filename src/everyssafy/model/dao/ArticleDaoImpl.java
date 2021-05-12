package everyssafy.model.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.plaf.synth.SynthSeparatorUI;

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
	public void registerArticle(ArticleDto articleDto) {
		Connection conn=null;
		PreparedStatement pstmt=null;
		int rs=0;

		try {
			conn=DBUtil.getConnect();
			String sql ="insert into article (articleTitle,articleContent,boardId,userId)";
			sql+= "values (?,?,?,?)";

			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, articleDto.getArticleTitle());
			pstmt.setString(2, articleDto.getArticleContent());
			pstmt.setInt(3, articleDto.getBoardId());
			pstmt.setString(4, articleDto.getUserId());
			int result=pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtil.close( conn , pstmt);
		}

	}

	@Override
	public void modifyArticle( ArticleDto articleDto) {
		Connection conn=null;
		PreparedStatement pstmt=null;

		try {
			conn=DBUtil.getConnect();
			String sql = "update article set  articleContent = ?";
			sql += "where articleId = ? ";

			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, articleDto.getArticleContent());
			pstmt.setInt(2, articleDto.getArticleId());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtil.close( conn , pstmt);
		}

	}

	@Override
	public ArticleDto getArticle(int ArticleId) {
		ArticleDto articleDto = new ArticleDto();

		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;

		try {
			conn=DBUtil.getConnect();
			String sql="select * from article"; 
			sql += "where articleId = ?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, ArticleId);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				articleDto.setArticleId(rs.getInt("ArticleId"));
				articleDto.setArticleDate(rs.getDate("ArticleDate"));
				articleDto.setArticleContent(rs.getString("articleContent"));
				articleDto.setArticleLike(rs.getInt("ArticelLike"));
				articleDto.setArticleTitle(rs.getString("ArticleTitle"));
				articleDto.setBoardId(rs.getInt("BoardId"));
				articleDto.setUserId(rs.getString("userId"));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtil.close(rs, conn , pstmt);
		}
		return articleDto;
	}

	@Override
	public void deleteArticle(int ArticleId) {

		Connection conn=null;
		PreparedStatement pstmt=null;

		try {
			conn=DBUtil.getConnect();
			String sql="delete from article where ArticleId= ?";

			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, ArticleId);
			int result=pstmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public ArrayList<ArticleDto> getListArticle( int BoardId) {
		ArrayList<ArticleDto> articleList = new ArrayList<>();

		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs =null;

		ArticleDto articleDto = null;

		try {
			conn = DBUtil.getConnect();
			String sql = "select a.articleId ,articleTitle ,articleContent ,articleDate ,articleLike,boardId,a.userId, count(commentId) as Comcnt ";
					sql+="from article a left outer join comment c ";
					sql+="on a.articleId= c.articleId ";
					sql+="where boardId=? ";
					sql+="group by articleId";
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, BoardId);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				articleDto = new  ArticleDto();
				articleDto.setArticleId(rs.getInt("ArticleId"));
				articleDto.setArticleDate(rs.getDate("ArticleDate"));
				articleDto.setArticleContent(rs.getString("articleContent"));
				articleDto.setArticleLike(rs.getInt("ArticleLike"));
				articleDto.setArticleTitle(rs.getString("ArticleTitle"));
				articleDto.setBoardId(rs.getInt("BoardId"));
				articleDto.setUserId(rs.getString("userId"));
				articleDto.setComcnt(rs.getInt("Comcnt"));
				articleList.add(articleDto);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return articleList;
	}
	@Override
	public List<ArticleDto> getMyrticle(String userId) {
		// TODO Auto-generated method stub
		ArrayList<ArticleDto> articleList = new ArrayList<>();
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs =null;
		ArticleDto articleDto = null;
		System.out.println(userId);
		try {
			conn = DBUtil.getConnect();
			String sql = "select a.articleId ,articleTitle ,articleContent ,articleDate ,articleLike,boardId,a.userId, count(commentId) as Comcnt ";
					sql+="from article a left outer join comment c ";
					sql+="on a.articleId= c.articleId ";
					sql+="where a.userId=? ";
					sql+="group by articleId";
			
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				articleDto = new  ArticleDto();
				articleDto.setArticleId(rs.getInt("ArticleId"));
				articleDto.setArticleDate(rs.getDate("ArticleDate"));
				articleDto.setArticleContent(rs.getString("articleContent"));
				articleDto.setArticleLike(rs.getInt("ArticleLike"));
				articleDto.setArticleTitle(rs.getString("ArticleTitle"));
				articleDto.setBoardId(rs.getInt("BoardId"));
				articleDto.setUserId(rs.getString("userId"));
				articleDto.setComcnt(rs.getInt("Comcnt"));
				articleList.add(articleDto);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return articleList;
	}
}
