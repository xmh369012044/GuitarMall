package cn.tarena.gm.pojo;

import cn.tarena.gm.exception.MsgException;
import cn.tarena.gm.tool.WebUtil;

public class User {
	private int Id;
	private String username;
	private String password;
	private String nickname;
	private String email;
	private String password2;

	public void check() throws MsgException {
		if (WebUtil.check(username)) {

			throw new MsgException("用户名不能为空");
		}
		if (WebUtil.check(password)) {
			throw new MsgException("密码不能为空");
		}
		if (WebUtil.check(password2)) {
			throw new MsgException("确认密码不能为空");
		}
		if (!password.equals(password2)) {
			throw new MsgException("2次密码要一致");
		}
		if (WebUtil.check(nickname)) {
			throw new MsgException("昵称不能为空");
		}
		if (WebUtil.check(email)) {
			throw new MsgException("邮箱不能为空");
		}
		if (!email.matches("^\\w+@\\w+(\\.\\w+)+$")) {
			throw new MsgException("邮箱格式不正确");
		}
	}

	public String getPassword2() {
		return password2;
	}

	public void setPassword2(String password2) {
		this.password2 = password2;
	}

	

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
