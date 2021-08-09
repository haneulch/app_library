package kr.library.core.user.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kr.library.core.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
	User findByUsername(String username);
}