package kr.stam.core.util;

import java.util.Calendar;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class JwtUtils {
	private static final String SECRET = "library"; 
	private static final String REFRESH_TOKEN = "REFRESH_TOKEN";
	private static final int EXPIRE_SECONDS = 60 * 60;
	
	@Autowired
	private CacheManager cacheManager;
	
	public String createAccessToken(String userId) {
		
		Calendar cale = Calendar.getInstance();
		cale.add(Calendar.SECOND, EXPIRE_SECONDS);
		
		return Jwts.builder()
				.setSubject(userId)
				.signWith(SignatureAlgorithm.HS256, SECRET)
				.setExpiration(cale.getTime())
				.compact();
	}
	
	public void isVaildAccessToken(String token, String userId) {
		try {
			Jwts
				.parser()
				.requireSubject(userId)
				.setSigningKey(SECRET)
				.parseClaimsJws(token);
		} catch(Exception e) {
			log.error(String.format("JWT EXPIRED [TOKEN : %s] : ", token, e.getMessage()));
		}
	}
	
	public String createRefreshToken(String accessToken) {
		String refreshToken = UUID.randomUUID().toString();
		Cache cache = cacheManager.getCache(REFRESH_TOKEN);
		cache.put(refreshToken, accessToken);
		return refreshToken;
	}
}
