package kr.stam.core.user.service;

import java.util.List;

import kr.stam.core.dto.UserRequest;
import kr.stam.core.entity.User;

public interface UserService {
	public void save(UserRequest userRequest);
	public User findById(String username);
	public List<User> findAll();
	public void delete(UserRequest userRequest);
	public User login(User user);
}
