package everyssafy.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import everyssafy.model.UserDto;
import util.DBUtil;

public class EveryssafyDaoImpl implements EveryssafyDao {
	private static EveryssafyDao everyssafyDao;
	private EveryssafyDaoImpl() {}
	public static EveryssafyDao getEveryssafyDao() {
		if(everyssafyDao==null) everyssafyDao=new EveryssafyDaoImpl();
		return everyssafyDao;
	}
	@Override
	public UserDto login(String userId, String userPwd) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void register(String userId, String userPwd, String userName, String userNickName) {
		// TODO Auto-generated method stub
		UserDto userDto=null;
		Connection conn=null;
		PreparedStatement pstmt=null;
		try {
			conn=DBUtil.getConnect();
			String sql="insert into user(userId,userPwd,userName,userNickName) values(?,?,?,?)";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			pstmt.setString(2, userPwd);
			pstmt.setString(3, userName);
			pstmt.setString(4, userNickName);
			int result=pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(pstmt!=null) {
				try {
					pstmt.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}
			if(conn!=null) {
				try {
					conn.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
