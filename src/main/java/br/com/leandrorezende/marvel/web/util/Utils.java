package br.com.leandrorezende.marvel.web.util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Utils {

	public static String toMd5(String str) {
		MessageDigest m;
		String md5 = "";
		try {
			m = MessageDigest.getInstance("MD5");
			m.update(str.getBytes(), 0, str.length());
			md5 = new BigInteger(1, m.digest()).toString(16);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return md5;
	}

}
