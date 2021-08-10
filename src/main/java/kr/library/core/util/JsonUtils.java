package kr.library.core.util;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonUtils {
	
	public static JSONObject toJson(String str) throws ParseException {
		JSONParser parser = new JSONParser();
		Object obj = parser.parse(str);

		return (JSONObject) obj;
	}
}