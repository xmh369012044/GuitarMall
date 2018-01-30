package cn.tarena.gm.shiro;

import org.apache.shiro.crypto.hash.Md5Hash;

public class Encrpty {
	
	public static String getMD5Hash(String password, String username){
		Md5Hash md5password = new Md5Hash(password, username, 3);
		return md5password.toString();
	}
	/*public static void main(String[] args) {
		// md5hash
		*//**
		 * source	代表明文
		 * salt		盐	添加作料
		 * hashIterations	hash次数
		/ *//*
		Md5Hash password = new Md5Hash("admin", "admin", 3);
		System.out.println(password);
	}*/
}
