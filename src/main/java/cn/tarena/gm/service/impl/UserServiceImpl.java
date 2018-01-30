package cn.tarena.gm.service.impl;

import cn.tarena.gm.mapper.UserMapper;
import cn.tarena.gm.pojo.User;
import cn.tarena.gm.service.UserService;
import cn.tarena.gm.tool.Md5Password;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserMapper userMapper;
	
	@Override
	public List<User> findAll() {
		
		return userMapper.findAll();
	}

	@Override
	public void saveRegist(User user) {
		String password = Md5Password.getMd5HashPassword(user.getPassword(),user.getUsername());

		user.setPassword(password);
		userMapper.saveRegist(user);

	}
	@Override
	public User findUserByUsername(String username) {
		return userMapper.findUserByUsername(username);
	}

	@Override
	public User findUserUniqueness(String username) {

		return userMapper.userUniqueness(username);
	}

	@Override
	public User findUserByUP(String username, String password) {
		return userMapper.findUserByUP(username,password);
	}

	public User findUserById(Integer userId) {

		return userMapper.findUserById(userId);
	}

}
