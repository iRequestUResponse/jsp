package kr.or.ddit.user.model;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
* User.java
*
* @author PC-17
* @version 1.0
* @see
*
* <pre>
* << 개정이력(Modification Information) >>
*
* 수정자 수정내용
* ------ ------------------------
* PC-17 최초 생성
*
* </pre>
*/
public class User {
	private static final Logger logger = LoggerFactory.getLogger(User.class);
	
	private String userNm;		// 사용자 이름
	private String pass;		// 사용자 비밀번호
	private String userId;		// 사용자 아이디
	private String alias;		// 별명
	private Date reg_dt;		// 등록일
	private String addr1;		// 주소1
	private String addr2;		// 주소2
	private String zipcode;		// 우편번호
	
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

	public User(String userId, String userNm, String alias, Date reg_dt, String addr1, String addr2,
			String zipcode, String pass) {
		this.userId = userId;
		this.userNm = userNm;
		this.alias = alias;
		this.reg_dt = reg_dt;
		this.addr1 = addr1;
		this.addr2 = addr2;
		this.zipcode = zipcode;
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

	public String getAddr1() {
		return addr1;
	}

	public void setAddr1(String addr1) {
		this.addr1 = addr1;
	}

	public String getAddr2() {
		return addr2;
	}

	public void setAddr2(String addr2) {
		this.addr2 = addr2;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	
	@Override
	public String toString() {
		return "User [userNm=" + userNm + ", pass=" + pass + ", userId=" + userId + ", alias=" + alias + ", reg_dt="
				+ reg_dt + ", addr1=" + addr1 + ", addr2=" + addr2 + ", zipcode=" + zipcode + "]";
	}

	public boolean checkLoginValidate(String userId, String pass) {
		return userId.equals(this.getUserId()) && pass.equals(this.getPass());
	}
}
