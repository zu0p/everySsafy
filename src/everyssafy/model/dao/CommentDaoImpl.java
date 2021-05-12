package everyssafy.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import everyssafy.model.CommentDto;
import util.DBUtil;

public class CommentDaoImpl implements CommentDao {

	private static CommentDao commentDao;
	private CommentDaoImpl() {}
	public static CommentDao getCommentDao() {
		if(commentDao == null) commentDao = new CommentDaoImpl();
		return commentDao;
	}
	@Override
	public void registerComment(CommentDto commentDto) {
		Connection conn=null;
		PreparedStatement pstmt=null;

		try {
			conn=DBUtil.getConnect();
			String sql =" insert into comment (commentContent,articleId,userId) ";
			sql+= "values (?,?,?)";

			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1,commentDto.getCommentContent());
			pstmt.setInt(2,commentDto.getArticleId());
			pstmt.setString(3,commentDto.getUserId());

			int result=pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtil.close( conn , pstmt);
		}
	}

	@Override
	public CommentDto getComment(int commentId) {
		CommentDto commentDto = new CommentDto();

		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;

		try {
			conn=DBUtil.getConnect();
			String sql="select * from comment"; 
			sql+="where commentId =? ";

			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, commentId);

			rs = pstmt.executeQuery();

			if(rs.next()) {
				commentDto.setArticleId(rs.getInt("articleId"));
				commentDto.setCommentContent(rs.getString("commentContent"));
				commentDto.setCommentDate(rs.getDate("commentDate"));
				commentDto.setCommentId(commentId);
				commentDto.setUserId(rs.getString("userId"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			DBUtil.close(rs, conn , pstmt);
		}

		return commentDto;
	}

	@Override
	public void modifyComment(CommentDto commentDto) {
		Connection conn=null;
		PreparedStatement pstmt=null;

		try {
			conn=DBUtil.getConnect();
			String sql = "update comment set  commentContent = ?";
			sql += "where commentId = ? ";

			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, commentDto.getCommentContent());
			pstmt.setInt(2, commentDto.getCommentId());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtil.close( conn , pstmt);
		}
	}

	@Override
	public void deleteComment(int commentId) {
		Connection conn=null;
		PreparedStatement pstmt=null;

		try {
			conn=DBUtil.getConnect();
			String sql="delete from comment where commentId= ?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, commentId);
			pstmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtil.close( conn , pstmt);
		}
	}

	@Override
	public List<CommentDto> getCommentList(int articleId) {
		List<CommentDto> commentList = new ArrayList<>();

		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs =null;

		CommentDto commentDto = null;

		try {
			conn = DBUtil.getConnect();

			String sql = "select * from comment" ;
			sql +=" where articleId = ?";

			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, articleId);

			rs = pstmt.executeQuery();
			while(rs.next()) {
				commentDto = new CommentDto();
				
				commentDto.setArticleId(rs.getInt("articleId"));
				commentDto.setCommentContent(rs.getString("commentContent"));
				commentDto.setCommentDate(rs.getDate("commentDate"));
				commentDto.setCommentId(rs.getInt("commentId"));
				commentDto.setUserId(rs.getString("userId"));
				
				commentList.add(commentDto);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtil.close(rs ,pstmt, conn);
		}
		return commentList;
	}

}
