package kr.library.core.config;

import java.util.Arrays;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CoreConfiguration {
	@Bean
	public FilterRegistrationBean reReadableRequestFilter() {
		FilterRegistrationBean bean = new FilterRegistrationBean(new RequestFilter());
		bean.setUrlPatterns(Arrays.asList("/*"));
		return bean;
	}
}