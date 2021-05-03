package everyssafy.model.service;

import java.sql.SQLException;

import everyssafy.model.UserDto;

public interface UserService {
	UserDto login(String userId,String userPwd);
	boolean register(UserDto userDto);
	boolean chkId(String userId);
	void chNick(String userId, String userNickName) throws Exception;
	void chPass(String userId, String userPwd, String usernewPwd) throws Exception;
	void delUser(String userId, String userPwd) throws Exception;
	UserDto getUserInfo(String userId)throws Exception ;
}
