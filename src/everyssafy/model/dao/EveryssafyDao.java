package everyssafy.model.dao;

import everyssafy.model.UserDto;

public interface EveryssafyDao {
	UserDto login(String userId,String userPwd);
	void register(String userId,String userPwd,String userName,String userNickName);
}
