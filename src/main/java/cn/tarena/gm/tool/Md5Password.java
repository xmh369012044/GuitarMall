package cn.tarena.gm.tool;

import org.apache.shiro.crypto.hash.Md5Hash;

public class Md5Password {
	
	public static String getMd5HashPassword(String password,String userName){
		
		Md5Hash md5Hash = new Md5Hash(password,userName , 3);
		
		return md5Hash.toString();
	}
}
