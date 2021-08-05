package kr.stam.app.dto;

import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FileTestRequest {
	String fileName;
	MultipartFile file;
}
