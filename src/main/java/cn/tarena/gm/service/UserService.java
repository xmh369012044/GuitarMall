package cn.tarena.gm.service;

import cn.tarena.gm.pojo.User;

import java.util.List;

public interface UserService {

	public User findUserByUP(String username, String password);

	public List<User> findAll();

	public void saveRegist(User user);

	public User findUserById(Integer userId);
	public User findUserByUsername(String username);

	public User findUserUniqueness(String username);
}
