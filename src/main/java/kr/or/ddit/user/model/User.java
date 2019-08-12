package kr.or.ddit.user.model;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class User {
	private static final Logger logger = LoggerFactory.getLogger(User.class);
	
	private String userNm;		// 사용자 이름
	private String pass;		// 사용자 비밀번호
	private String userId;		// 사용자 아이디
	private String alias;		// 별명
	private Date reg_dt;		// 등록일
	
	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	public Date getReg_dt() {
		return reg_dt;
	}
	
	public String getReg_dt_sdf() {
		logger.debug("getReg_dt_sdf method call");
		return new SimpleDateFormat("yyyy-MM-dd").format(reg_dt);
	}

	public void setReg_dt(Date reg_dt) {
		this.reg_dt = reg_dt;
	}

	public String getUserNm() {
		return userNm;
	}

	public void setUserNm(String userName) {
		this.userNm = userName;
	}

	public User() {}
	
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
