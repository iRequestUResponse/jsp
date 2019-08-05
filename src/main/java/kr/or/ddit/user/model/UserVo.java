package kr.or.ddit.user.model;

public class UserVo {
	private String userName;		// 사용자 이름
	private String userId;
	private String pass;
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public UserVo() {
		
	}
	
	public UserVo(String userId) {
		this.userId = userId;
	}

	public UserVo(String userName, String userId, String pass) {
		this.userName = userName;
		this.userId = userId;
		this.pass = pass;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "UserVo [userName=" + userName + ", userId=" + userId + ", pass=" + pass + "]";
	}
}
