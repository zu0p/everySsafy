package everyssafy.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import everyssafy.model.UserDto;
import util.DBUtil;

public class UserDaoImpl implements UserDao {
	private static UserDao userDao;
	private UserDaoImpl() {}
	public static UserDao getUserDao() {
		if(userDao==null) userDao=new UserDaoImpl();
		return userDao;
	}
	@Override
	public UserDto login(String userId, String userPwd) {
		// TODO Auto-generated method stub
		UserDto userDto=null;
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			conn=DBUtil.getConnect();
			String sql="select userName,userNickName from user where userId=? and userPwd=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			pstmt.setString(2, userPwd);
			pstmt.executeQuery();
			if(rs.next()) {
				userDto.setUserId(userId);
				userDto.setUserPwd(userPwd);
				userDto.setUserName(rs.getString("userName"));
				userDto.setUserNickName("userNickName");
			}
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
		return userDto;
	}

	@Override
	public boolean register(UserDto userDto) {
		// TODO Auto-generated method stub
		Connection conn=null;
		PreparedStatement pstmt=null;
		try {
			conn=DBUtil.getConnect();
			String sql="insert into user(userId,userPwd,userName,userNickName) values(?,?,?,?)";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, userDto.getUserId());
			pstmt.setString(2, userDto.getUserPwd());
			pstmt.setString(3, userDto.getUserName());
			pstmt.setString(4, userDto.getUserNickName());
			int result=pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
			return false;
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
		return true;
	}
	@Override
	public boolean chkId(String userId) {
		// TODO Auto-generated method stub
		return false;
	}

}
