package kr.library.core.util;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;

import kr.library.core.dto.ErrorResponse;

public class JsonResponseUtils<T> extends ResponseEntity<T>{

	public JsonResponseUtils(HttpStatus status) {
		super(status);
	}
	
	public JsonResponseUtils(T data, HttpStatus status) {
		super(data, status);
	}
	
	public JsonResponseUtils(T data) {
		super(data, HttpStatus.OK);
	}
	
	public JsonResponseUtils(T data, MultiValueMap<String, String> headers, HttpStatus status) {
		super(data, headers, status);
	}
	
	public static ResponseEntity<Map<String, Object>> success(String string) {
		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.put("data", string);
		return new JsonResponseUtils(dataMap, HttpStatus.OK);
	}
	
	public static ResponseEntity<Map<String, Object>> success(int number) {
		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.put("data", number);
		return new JsonResponseUtils(dataMap, HttpStatus.OK);
	}

	public static ResponseEntity<Map<String, Object>> success(boolean b) {
		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.put("data", b);
		return new JsonResponseUtils(dataMap, HttpStatus.OK);
	}
	
	public static ResponseEntity<Map<String, Object>> success(Object obj) {
		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.put("data", obj);
		return new JsonResponseUtils(dataMap, HttpStatus.OK);
	}
	
	public static ResponseEntity<Map<String, Object>> error(Object obj) {
		if(obj instanceof ErrorResponse) {
			return new JsonResponseUtils(obj, ((ErrorResponse) obj).getStatus());
		}
		
		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.put("data", obj);
		return new JsonResponseUtils(dataMap, HttpStatus.BAD_REQUEST);
	}

	public static ResponseEntity<Map<String, Object>> error(String string) {
		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.put("data", string);
		return new JsonResponseUtils(dataMap, HttpStatus.BAD_REQUEST);
	}
	
	public static ResponseEntity<Map<String, Object>> error(int number) {
		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.put("data", number);
		return new JsonResponseUtils(dataMap, HttpStatus.BAD_REQUEST);
	}

	public static ResponseEntity<Map<String, Object>> error(boolean b) {
		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.put("data", b);
		return new JsonResponseUtils(dataMap, HttpStatus.BAD_REQUEST);
	}
}
