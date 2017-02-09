package lib.common;

import java.security.MessageDigest;
import java.util.List;
import java.util.Properties;

import procesing.Util;

public class CommonUltils {
	public static Properties prop;

	/**
	 * Generate password in MD5.
	 * 
	 * @param password
	 * @return MD5
	 * @throws Exception
	 */
	public static String generatePassword(String password) throws Exception {
		MessageDigest md = MessageDigest.getInstance("MD5");
		md.update(password.getBytes());

		byte byteData[] = md.digest();

		// convert the byte to hex format method 1
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < byteData.length; i++) {
			sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
		}

		// convert the byte to hex format method 2
		StringBuffer hexString = new StringBuffer();
		for (int i = 0; i < byteData.length; i++) {
			String hex = Integer.toHexString(0xff & byteData[i]);
			if (hex.length() == 1)
				hexString.append('0');
			hexString.append(hex);
		}
		return hexString.toString();
	}

	public static String convertToJSon(List<Object> obj) {
		return "";
	}

	public static List<Object> convertToObjects(String json) {
		return null;
	}

	public static String readProperties(String key) {
		if (prop == null) {
			prop = Util.readSetting("");
		}
		return prop.getProperty(key);
	}
}
