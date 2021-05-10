package everyssafy.model.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import everyssafy.model.ArticleDto;
import everyssafy.model.BoardDto;
import util.DBUtil;

public class BoardDaoImpl implements BoardDao{

	private static BoardDao boardDao;
	private BoardDaoImpl() {}
	public static BoardDao getBoardDao()
	{
		if(boardDao == null) boardDao = new BoardDaoImpl();
		return boardDao;
	}
	
	@Override
	public String getBoardTitle(int BoardId) {
		String BoardTitle="";
		
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;

		try {
			conn=DBUtil.getConnect();
			//sql문 삽입필요..
			// select boardTitle from board where boardid = 101;
			String sql = "select boardTitle from board where boardid = ?";
			
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, BoardId);
			
			pstmt.executeQuery();
			if(rs.next()) {
				BoardTitle = rs.getString(1);
			}
				
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.close(rs ,conn , pstmt);
		}
		return BoardTitle;
	}
	@Override
	public List<ArticleDto> getList(int BoardId) {
		List<ArticleDto> list=new ArrayList<>();
		
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sql="select articleTitle, articleDate \n" + 
				"from article a join board b \n" + 
				"on a.boardId=b.boardId \n" + 
				"where a.boardId=?  order by articleDate desc limit 4";
		
		try {
			conn=DBUtil.getConnect();
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, BoardId);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				String articleTitle=rs.getString("articleTitle");
				Date articleDate=rs.getDate("articleDate");
				System.out.println(articleTitle);
				System.out.println(articleDate);
				list.add(new ArticleDto(articleTitle, articleDate));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DBUtil.close(conn, pstmt,rs);
		return list;
	}

}
