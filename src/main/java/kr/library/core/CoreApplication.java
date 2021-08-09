package kr.library.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableAutoConfiguration
@EntityScan(basePackages = {"kr.library.**.entity"})
@EnableAspectJAutoProxy
@ComponentScan(basePackages = {"kr.library.**"})
@EnableJpaRepositories(basePackages = "kr.library.**.service")
@PropertySource("classpath:config.properties")
@EnableCaching
public class CoreApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(CoreApplication.class, args);
	}
}