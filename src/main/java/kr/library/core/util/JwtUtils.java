package kr.library.core.util;

import java.util.Calendar;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import kr.library.core.constant.MessageConstants;
import kr.library.core.exception.ExpiredTokenException;
import kr.library.core.exception.InvalidTokenException;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class JwtUtils {
	private static final String SECRET = "library"; 
	private static final String REFRESH_TOKEN = "REFRESH_TOKEN";
	private static final int EXPIRE_SECONDS = 60 * 60;
	
	@Autowired
	private CacheManager cacheManager;
	
	public String createAccessToken(String username) {
		
		Calendar cale = Calendar.getInstance();
		cale.add(Calendar.SECOND, EXPIRE_SECONDS);
		
		return Jwts
				.builder()
				.setSubject(username)
				.signWith(SignatureAlgorithm.HS256, SECRET)
				.setExpiration(cale.getTime())
				.compact();
	}
	
	public void isVaildAccessToken(String token, String username) {
		try {
			
			String jwtUsername = Jwts.parser()
									.setSigningKey(SECRET)
									.parseClaimsJws(token)
									.getBody()
									.getSubject();
			
			if(!jwtUsername.equals(username)) {
				throw new InvalidTokenException(MessageConstants.INVALID_TOKEN);
			}
			
		} catch(ExpiredJwtException e) {
			log.error(String.format("JWT EXPIRED [TOKEN : %s] : ", token, e.getMessage()));
			throw new ExpiredTokenException(MessageConstants.EXPIRED_TOKEN);
		} catch(JwtException e) {
			log.error(String.format("JWT INVALID [TOKEN : %s] : ", token, e.getMessage()));
			throw new InvalidTokenException(MessageConstants.INVALID_TOKEN);
		}
	}
	
	public String createRefreshToken(String accessToken) {
		String refreshToken = UUID.randomUUID().toString();
		Cache cache = cacheManager.getCache(REFRESH_TOKEN);
		cache.put(refreshToken, accessToken);
		return refreshToken;
	}
}
