package cn.tarena.gm.mapper;

import cn.tarena.gm.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface UserMapper {


	public User findUserByUP(String username, String password);

	public List<User> findAll();

	public void saveRegist(User user);

	public User findUserByUsername(String username);

	public User userUniqueness(String username);
	public User findUserById(Integer userId);


}
