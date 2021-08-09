package kr.library.core.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Repository;

/**
 * properties 값을 읽는다
 * @author haneul
 *
 */
@Repository
public class GetPropertyUtils {
	private static Environment environment;
	
	@Autowired
	public void setEnvironment(Environment env) {
		environment = env;
	}
	public static String getProperty(String key) {
		return environment == null ? null : environment.getProperty(key);
	}
}