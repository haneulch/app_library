package kr.stam.core.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import kr.stam.core.authorities.service.AuthoritiesRepository;
import kr.stam.core.dto.UserRequest;
import kr.stam.core.entity.Authorities;
import kr.stam.core.entity.User;

@Service
public class UserServiceImpl implements UserService {
	
	private final UserRepository userRepository;
	private final AuthoritiesRepository authoritiesRepository;
	private final PasswordEncoder passwordEncoder;
	
	@Autowired
	public UserServiceImpl(UserRepository userRepository
			, PasswordEncoder passwordEncoder
			, AuthoritiesRepository authoritiesRepository) {
		this.userRepository = userRepository;
		this.passwordEncoder = passwordEncoder;
		this.authoritiesRepository = authoritiesRepository;
	}

	@Override
	public void save(UserRequest userRequest) {
		
		if( userRepository.findByUsername(userRequest.getUsername()) == null) {
		
			User user = userRequest.toEntity();
			user.setPassword(passwordEncoder.encode(user.getPassword()));
			userRepository.save(user);
			
			Authorities authorities = userRequest.toAuthoritiesEntity("ROLE_USER");
			authoritiesRepository.save(authorities);
		}
	}

	@Override
	public User findById(String username) {
		return userRepository.findByUsername(username);
	}

	@Override
	public List<User> findAll() {
		return userRepository.findAll();
	}

	@Override
	public void delete(UserRequest userRequest) {
		userRepository.delete(userRequest.toEntity());
	}

	@Override
	public User login(User user) {
		User userCheck = userRepository.findByUsername(user.getUsername());
		
		if(userCheck != null) {
			boolean checked = passwordEncoder.matches(user.getPassword(), userCheck.getPassword());
			if(checked) {
				return userCheck;
			}
		}
		
		return null;
	}
}