package kr.stam.core.dto;

import org.springframework.lang.Nullable;

import kr.stam.core.entity.Authorities;
import kr.stam.core.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserRequest {
	
	String username;
	
	@Nullable
	String nickname;
	
	@Nullable
	String password;

    public User toEntity() {
        return User.builder()
        			.username(username)
        			.password(password)
        			.nickname(nickname)
        			.enabled('Y')
        			.build();
    }
    
    public Authorities toAuthoritiesEntity(String authorities) {
    	return new Authorities(username, authorities);
    }
}