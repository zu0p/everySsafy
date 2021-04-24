package everyssafy.model.dao;

import java.sql.SQLException;

import everyssafy.model.UserDto;

public interface UserDao {
	UserDto login(String userId,String userPwd);
	boolean register(UserDto userDto);
	boolean chkId(String userId);
	void chNick(String userId, String usernickName) throws SQLException;
	void chPass(String userId, String userPwd, String usernewPwd) throws SQLException;
	void delUser(String userId, String userPwd) throws SQLException;
}
