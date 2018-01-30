package cn.tarena.gm.shiro;

import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.SimpleCredentialsMatcher;

public class AuthCredential extends SimpleCredentialsMatcher {
	
	@Override
	public boolean doCredentialsMatch(AuthenticationToken token, AuthenticationInfo info) {
		UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) token;
		String username = usernamePasswordToken.getUsername();
		String password = String.valueOf(usernamePasswordToken.getPassword());
		password = Encrpty.getMD5Hash(password, username);
		usernamePasswordToken.setPassword(password.toCharArray());
		return super.doCredentialsMatch(token, info);
	}
}
