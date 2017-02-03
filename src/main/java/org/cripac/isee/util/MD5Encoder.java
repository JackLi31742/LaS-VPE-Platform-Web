package org.cripac.isee.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Encoder {
	
	private final static String[] hexDigits = {"0", "1", "2", "3", "4",  
	        "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f"};
	
	public static String encode(String str) {
		String result = "";
		if (!StringUtil.isBlank(str)) {
			try {
				MessageDigest md5 = MessageDigest.getInstance("MD5");
				byte[] bytes = md5.digest(str.trim().getBytes());
				result = byteArrayToHexString(bytes);
			} catch (NoSuchAlgorithmException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
		
		private static String byteArrayToHexString(byte[] b){
	        StringBuffer resultSb = new StringBuffer();
	        for (int i = 0; i < b.length; i++){
	            resultSb.append(byteToHexString(b[i]));
	        }
	        return resultSb.toString();
	    }
		
		private static String byteToHexString(byte b){  
	        int n = b;  
	        if (n < 0)  
	            n = 256 + n;  
	        int d1 = n / 16;  
	        int d2 = n % 16;  
	        return hexDigits[d1] + hexDigits[d2];  
	    }

		public static void main(String[] args) {
			System.out.println(encode("admin1234"));
		}
}
