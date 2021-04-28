package everyssafy.model.dao;

import java.sql.SQLException;

import everyssafy.model.UserDto;

public interface UserDao {
	UserDto login(String userId,String userPwd);
	boolean register(UserDto userDto);
	boolean chkId(String userId);
	UserDto chNick(String userId, String usernickName);
	void chPass(String userId, String userPwd, String usernewPwd);
	UserDto getUserInfo(String userId)throws SQLException;
}
