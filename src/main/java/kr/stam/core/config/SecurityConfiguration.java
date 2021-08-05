package kr.stam.core.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import kr.stam.core.user.service.UserService;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{
//	private final UserService userService;
//	
//	SecurityConfiguration(UserService userService) {
//		this.userService = userService; 
//		
//	}

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/static/**");
    }
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {
    	http.csrf().disable()
    			.headers().frameOptions().disable()
    			.and()
    				.authorizeRequests()
    				.anyRequest().permitAll()
    			.and()
	    			.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
//		    	.and()
//		    		.oauth2Login()
//		    			.userInfoEndpoint()
//		    				.userService(userService);
    	
		/* TODO : token 추가 */
//	    		.addFilterBefore(null, new LoginSuccessHandler());
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}