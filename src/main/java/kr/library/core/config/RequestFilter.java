package kr.library.core.config;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class RequestFilter implements Filter {
	@Override
	public void doFilter(
			ServletRequest request
			, ServletResponse response
			, FilterChain chain) throws IOException, ServletException {
		RereadableRequestWrapper wrapper 
				= new RereadableRequestWrapper((HttpServletRequest) request);
		
		chain.doFilter(wrapper, response);
	}
}