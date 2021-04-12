package everyssafy.model.service;

import everyssafy.model.UserDto;

public interface EveryssafyService {
	UserDto login(String userId,String userPwd);
	void register(String userId,String userPwd,String userName,String userNickName);
}
