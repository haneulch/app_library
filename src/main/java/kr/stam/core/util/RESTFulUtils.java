package kr.stam.core.util;

import java.net.URI;
import java.nio.charset.Charset;
import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.google.gson.Gson;
import com.google.gson.internal.LinkedTreeMap;

/**
 * ==========================================================
 * @package_name				:	kr.stam.core.util
 * @file_name					:	RestfulUtils.java
 * @author						:	haneul
 * @date						:	2021.05.20
 * ==========================================================
 * 
 * HISTORY
 * ==========================================================
 * DATE			AUTHOR			MEMO
 * ==========================================================
 * 2021.05.20		haneul		init
 *
 *
 */
public class RESTFulUtils {

	private static final RESTFulUtils INSTANCE = new RESTFulUtils();

	private RESTFulUtils() {}

	public static RESTFulUtils getInstance() {
		return INSTANCE;
	}

	/**
	 * ==========================================================
	 * @author						:	haneul
	 * @date						:	2021.05.21
	 * @enclosing_method			:	callGet
	 * @enclosing_type				:	RESTFulUtils
	 * @return_type					:	Map<String,Object>
	 * @tags						:	@param url
	 * @tags						:	@param requestData
	 * @tags						:	@return
	 * ==========================================================
	 * 
	 * HISTORY
	 * ==========================================================
	 * DATE			AUTHOR			MEMO
	 * ==========================================================
	 * 2021.05.21		haneul		init
	 *
	 *
	 */
	public Map<String, Object> callGet(String url, Map<String, Object> requestData) {

		UriComponentsBuilder uriComp = UriComponentsBuilder.fromUriString(url);

		if (!requestData.isEmpty()) {
			requestData.keySet().stream().forEach(key -> uriComp.queryParam(key, requestData.get(key)));
		}

		URI uri = uriComp.build(true).toUri();

		RestTemplate restTemplate = new RestTemplate();

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));

		HttpEntity<String> requestEntity = new HttpEntity<String>(headers);

		String responseEntity = restTemplate.getForObject(uri, String.class);
		
		Gson gson = new Gson();

		LinkedTreeMap<String, Object> resultMap = new LinkedTreeMap<String, Object>();
		resultMap = (LinkedTreeMap<String, Object>)gson.fromJson(responseEntity, resultMap.getClass());
		
		gson = null;

		return resultMap;
	}

	/**
	 * ==========================================================
	 * @author						:	haneul
	 * @date						:	2021.05.21
	 * @enclosing_method			:	callPost
	 * @enclosing_type				:	RESTFulUtils
	 * @return_type					:	Map<String,Object>
	 * @tags						:	@param url
	 * @tags						:	@param method
	 * @tags						:	@param requestData
	 * @tags						:	@return
	 * ==========================================================
	 * 
	 * HISTORY
	 * ==========================================================
	 * DATE			AUTHOR			MEMO
	 * ==========================================================
	 * 2021.05.21		haneul		init
	 *
	 *
	 */
	public Map<String, Object> callPost(String url, String method, Map<String, Object> requestData) {

		String jsonParams = new Gson().toJson(requestData, Map.class);

		RestTemplate restTemplate = new RestTemplate();

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));

		HttpEntity<String> requestEntity = new HttpEntity<String>(headers);

		String responseEntity = restTemplate.postForObject(url, requestEntity, String.class);
		
		Gson gson = new Gson();

		LinkedTreeMap<String, Object> resultMap = new LinkedTreeMap<String, Object>();
		resultMap = (LinkedTreeMap<String, Object>)gson.fromJson(responseEntity, resultMap.getClass());
		
		gson = null;
		
		return resultMap;
	}
}