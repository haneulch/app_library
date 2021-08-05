package kr.stam.core;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import kr.stam.app.redis.RedisTestService;

@SpringBootTest(classes = StamCoreApplication.class)
public class RedisTest {
	@Autowired
	RedisTest(RedisTestService redisService) {
		this.redisService = redisService;
	}
	
	private final RedisTestService redisService;

	@Test
	public void redisTest() throws Exception {
		redisService.save(0);
		long count = redisService.count("20210709");
		
		System.out.println(count);
	}
}
