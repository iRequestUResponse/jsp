package kr.or.ddit.user.model;

public class User {
	private String userNm;		// 사용자 이름
	private String userId;
	private String pass;
	
	public String getUserNm() {
		return userNm;
	}

	public void setUserNm(String userName) {
		this.userNm = userName;
	}

	public User() {
		
	}
	
	public User(String userName) {
		this.userNm = userName;
	}

	public User(String userName, String userId, String pass) {
		this.userNm = userName;
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
		return "UserVo [userName=" + userNm + ", userId=" + userId + ", pass=" + pass + "]";
	}
	
	public boolean checkLoginValidate(String userId, String pass) {
		return userId.equals(this.getUserId()) && pass.equals(this.getPass());
	}
}
