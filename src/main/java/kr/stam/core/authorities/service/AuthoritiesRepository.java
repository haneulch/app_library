package kr.stam.core.authorities.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kr.stam.core.entity.Authorities;

@Repository
public interface AuthoritiesRepository extends JpaRepository<Authorities, String>{

}
