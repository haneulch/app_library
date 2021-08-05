package kr.stam.core.util;

import java.util.UUID;

public class CommonUtils {

	/**
	 * random uuid를 생성한다.
	 * @return
	 */
	public static String randomValue() {
		return UUID.randomUUID().toString().replaceAll("-", "");
	}
}
