package everyssafy.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import everyssafy.model.ArticleDto;
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
	public int getBoardId(ArticleDto articleDto) {
		int boardid = 0;

		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;

		try {
			conn=DBUtil.getConnect();
			//sql문 삽입필요..
			String sql = " ";
			
			pstmt=conn.prepareStatement(sql);
			pstmt.executeQuery();
			
			if(rs.next()) {
				boardid = Integer.parseInt(rs.getString(1));
			}
				
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.close(rs ,conn , pstmt);
		}

		return boardid;
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
			String sql = " ";
			pstmt=conn.prepareStatement(sql);
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

}
