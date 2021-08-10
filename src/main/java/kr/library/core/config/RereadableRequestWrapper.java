package kr.library.core.config;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

import javax.servlet.ReadListener;
import javax.servlet.ServletInputStream;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringUtils;

public class RereadableRequestWrapper extends HttpServletRequestWrapper {
	private final Charset encoding;
	private byte[] rawData;
	
	public RereadableRequestWrapper(HttpServletRequest request) throws IOException {
		super(request);
		
		String characterEncoding = request.getCharacterEncoding();
		if(StringUtils.isBlank(characterEncoding)) {
			characterEncoding = StandardCharsets.UTF_8.name();
		}
		
		this.encoding = Charset.forName(characterEncoding);
		
		InputStream is = request.getInputStream();
		this.rawData = IOUtils.toByteArray(is);
	}
	
	@Override
	public ServletInputStream getInputStream() throws IOException {
		final ByteArrayInputStream bais = new ByteArrayInputStream(this.rawData);
		ServletInputStream sis = new ServletInputStream() {
			
			@Override
			public int read() throws IOException {
				return bais.read();
			}
			
			@Override
			public void setReadListener(ReadListener listener) {
				
			}
			
			@Override
			public boolean isReady() {
				return false;
			}
			
			@Override
			public boolean isFinished() {
				return false;
			}
		};
		
		return sis;
	}
	
	@Override
	public BufferedReader getReader() throws IOException {
		return new BufferedReader(new InputStreamReader(this.getInputStream(), this.encoding));
	}
	
	@Override
	public ServletRequest getRequest() {
		return super.getRequest();
	}
}
