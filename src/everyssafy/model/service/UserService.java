package everyssafy.model.service;

import everyssafy.model.UserDto;

public interface UserService {
	UserDto login(String userId,String userPwd);
	boolean register(UserDto userDto);
	boolean chkId(String userId);
	UserDto chNick(String userId, String userNickName);
	void chPass(String userId, String userPwd, String usernewPwd);
}
