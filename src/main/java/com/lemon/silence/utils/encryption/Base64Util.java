package com.lemon.silence.utils.encryption;

import org.apache.commons.codec.binary.Base64;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.security.SecureRandom;



/**
 * AES算法加密工具
 *
 * @author zhangxueqi
 * @version 1.0
 * @date 2020/11/5 15:46
 */
public class Base64Util {

	public static final String CONFIG_KEY = "wdcfs446bdfra434c";

	public static final String ALGORITHM = "AES";

	/**
	 *初始化
	 *
	 */
	public static String initKey(String seed) throws Exception{
		SecureRandom secureRandom = null;
		if (seed != null){
			byte[] seedByte = seed.getBytes();
			secureRandom = SecureRandom.getInstance("SHA1PRNG");
			secureRandom.setSeed(encode64(seedByte).getBytes());
		}else {
			secureRandom = new SecureRandom();
		}
		KeyGenerator keyGenerator = KeyGenerator.getInstance(ALGORITHM);
		keyGenerator.init(secureRandom);
		SecretKey secretKey = keyGenerator.generateKey();
		return encode64(secretKey.getEncoded());
	}

	/**
	 *BASE64加密
	 *
	 */
	public static String encode64(byte[] data) {
		return Base64.encodeBase64String(data);
	}

	/**
	 *BASE64解密
	 *
	 */
	public static byte[] decode64(byte[] data) {
		return Base64.decodeBase64(data);
	}
	/**
	 *AES加密
	 *
	 */
	public static byte[] encode(byte[] data, String key) throws Exception {
		Key k = toKey(decode64(key.getBytes()));
		Cipher cipher = Cipher.getInstance(ALGORITHM);
		cipher.init(Cipher.ENCRYPT_MODE,k);
		return cipher.doFinal(data);
	}

	/**
	 *AES解密
	 *
	 */
	public static byte[] decode(byte[] data, String key) throws Exception {
		Key k = toKey(decode64(key.getBytes()));
		Cipher cipher = Cipher.getInstance(ALGORITHM);
		cipher.init(Cipher.DECRYPT_MODE,k);
		return cipher.doFinal(data);
	}

	/**
	 *转换秘钥
	 *
	 */
	public static Key toKey(byte[] key) throws Exception {
		SecretKey secretKey = new SecretKeySpec(key, ALGORITHM);
		return secretKey;
	}

//	public static void main(String[] args) throws Exception {
//
//		String see = "AESBase64";
//		String key = initKey(Base64Util.CONFIG_KEY);
//		//加密
//		byte[] inputdata = see.getBytes();
//		inputdata = Base64Util.encode(inputdata, key);
//		String in = new String(inputdata);
//
//		System.out.println("加密后：\t"+in);
//
//		//解密
//		byte[] outdata = Base64Util.decode(inputdata, key);
//		String out = new String(outdata);
//
//		System.out.println("解密后：\t"+out);
//
//		System.out.println(see.equals(out));
//
//	}
}
