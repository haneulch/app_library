package kr.stam.core.constant;

public class RESTContants {
	private RESTContants() {}
	
	public static final String METHOD_POST = "POST";	// POST를 통해 해당 URI를 요청하면 리소스를 생성합니다.
	public static final String METHOD_GET = "GET";		// GET를 통해 해당 리소스를 조회합니다. 리소스를 조회하고 해당 도큐먼트에 대한 자세한 정보를 가져온다.
	public static final String METHOD_PUT = "PUT";		// PUT를 통해 해당 리소스를 수정합니다.
	public static final String METHOD_DEL = "DELETE";	// DELETE를 통해 리소스를 삭제합니다.
	
	public static final String PROTOCOL_HTTP = "HTTP";
	public static final String PROTOCOL_HTTPS = "HTTPS";
}
