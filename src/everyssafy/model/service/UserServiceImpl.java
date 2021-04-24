package everyssafy.model.service;

import everyssafy.model.UserDto;
import everyssafy.model.dao.UserDaoImpl;

public class UserServiceImpl implements UserService {
	private static UserService userService;
	private UserServiceImpl() {}
	public static UserService getUserService() {
		if(userService==null) userService=new UserServiceImpl();
		return userService;
	}
	@Override
	public UserDto login(String userId, String userPwd) {
		// TODO Auto-generated method stub
		return UserDaoImpl.getUserDao().login(userId, userPwd);
	}

	@Override
	public boolean register(UserDto userDto) {
		// TODO Auto-generated method stub
		return UserDaoImpl.getUserDao().register(userDto);
	}
	@Override
	public boolean chkId(String userId) {
		// TODO Auto-generated method stub
		return UserDaoImpl.getUserDao().chkId(userId);
	}
	@Override
	public void chNick(String userId, String userNickName) throws Exception{
		// TODO Auto-generated method stub
		UserDaoImpl.getUserDao().chNick(userId, userNickName);
	}
	@Override
	public void chPass(String userId, String userPwd, String usernewPwd) throws Exception {
		// TODO Auto-generated method stub
		UserDaoImpl.getUserDao().chPass(userId, userPwd, usernewPwd);
	}
	@Override
	public void delUser(String userId, String userPwd) throws Exception {
		// TODO Auto-generated method stub
		UserDaoImpl.getUserDao().delUser(userId, userPwd);
	}

}
