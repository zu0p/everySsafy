package everyssafy.model.service;

import everyssafy.model.UserDto;

public class EveryssafyServiceImpl implements EveryssafyService {
	private static EveryssafyService everyssafyService;
	private EveryssafyServiceImpl() {}
	public static EveryssafyService getEveryssafy() {
		if(everyssafyService==null) everyssafyService=new EveryssafyServiceImpl();
		return everyssafyService;
	}
	@Override
	public UserDto login(String userId, String userPwd) {
		// TODO Auto-generated method stub
		UserDto ret=null;
		return ret;
	}

	@Override
	public void register(String userId, String userPwd, String userName, String userNickName) {
		// TODO Auto-generated method stub

	}

}
