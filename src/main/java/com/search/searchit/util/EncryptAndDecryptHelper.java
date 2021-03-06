package com.search.searchit.util;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class EncryptAndDecryptHelper {
	
	private static final String salt = "sambasairamjagajaAES";
	public static String encrypt(String strClearText,String strKey) throws Exception{
	    String strData="";
	    int maxKeyLen = Cipher.getMaxAllowedKeyLength("AES");
	    try {
	        SecretKeySpec skeyspec=new SecretKeySpec(strKey.getBytes(),salt);
	        Cipher cipher=Cipher.getInstance(salt);
	        cipher.init(Cipher.ENCRYPT_MODE, skeyspec);
	        byte[] encrypted=cipher.doFinal(strClearText.getBytes());
	        strData=new String(encrypted);

	    } catch (Exception e) {
	        e.printStackTrace();
	        throw new Exception(e);
	    }
	    return strData;
	}
	
	public static String decrypt(String strEncrypted,String strKey) throws Exception{
	    String strData="";

	    try {
	        SecretKeySpec skeyspec=new SecretKeySpec(strKey.getBytes(),salt);
	        Cipher cipher=Cipher.getInstance(salt);
	        cipher.init(Cipher.DECRYPT_MODE, skeyspec);
	        byte[] decrypted=cipher.doFinal(strEncrypted.getBytes());
	        strData=new String(decrypted);

	    } catch (Exception e) {
	        e.printStackTrace();
	        throw new Exception(e);
	    }
	    return strData;
	}

}
