package everyssafy.model;

public class UserDto {
	String userId;
	String userPwd;
	String userName;
	String userNickName;
	public UserDto() {}
	public UserDto(String userId, String userPwd, String userName, String userNickName) {
		super();
		this.userId = userId;
		this.userPwd = userPwd;
		this.userName = userName;
		this.userNickName = userNickName;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserPwd() {
		return userPwd;
	}
	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserNickName() {
		return userNickName;
	}
	public void setUserNickName(String userNickName) {
		this.userNickName = userNickName;
	}
	@Override
	public String toString() {
		return "UserDto [userId=" + userId + ", userPwd=" + userPwd + ", userName=" + userName + ", userNickName="
				+ userNickName + "]";
	}
	
}
