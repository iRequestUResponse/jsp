package kr.or.ddit.encrypt.kisa.sha256;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class KIKSA_SHA256Test {
	private static final Logger logger = LoggerFactory.getLogger(KIKSA_SHA256Test.class);
	
	@Test
	public void encryptTest() {
		/***Given***/
		String pass = "brown1234";

		/***When***/
		String encryptedPass = KISA_SHA256.encrypt(pass);
		logger.debug("encryptedPass : {}", encryptedPass);

		/***Then***/
	}

}
