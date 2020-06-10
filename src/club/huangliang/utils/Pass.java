package club.huangliang.utils;

import org.apache.commons.codec.digest.DigestUtils;

public class Pass {
	
	public static String mad5(String pass) {
		
		String md5=DigestUtils.md5Hex(pass);
		return md5;
		
	}
	
	
	
}
