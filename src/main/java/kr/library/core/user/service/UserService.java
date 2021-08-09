package kr.library.core.user.service;

import java.util.List;

import kr.library.core.dto.UserRequest;
import kr.library.core.entity.User;

public interface UserService {
	public void save(UserRequest userRequest);
	public User findById(String username);
	public List<User> findAll();
	public void delete(UserRequest userRequest);
	public User login(User user);
}
