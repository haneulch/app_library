package kr.stam.core.util;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import kr.stam.app.entity.FileTest;

/**
 * 파일 업로드
 * @author haneul
 *
 */
public class FileUploadUtils {
	private static final Logger log = LoggerFactory.getLogger(FileUploadUtils.class);

	private static final String FILE_UPLOAD_PATH = GetPropertyUtils.getProperty("tomcat.docbase.dir");

	public static FileTest[] uploadFiles(MultipartFile[] files) {
		List<FileTest> fileNames = new ArrayList<FileTest>();

		for (MultipartFile multipartFile : files) {
			fileNames.add(uploadFile(multipartFile));
		}
		
		FileTest[] fileTests = fileNames.toArray(new FileTest[fileNames.size()]);
		fileNames = null;

		return fileTests;
	}

	public static FileTest uploadFile(MultipartFile multipartFile) {
		FileTest fileTest = null;

		try {
			String orgFileName = multipartFile.getOriginalFilename();

			String saveFileName = CommonUtils.randomValue();

			fileTest = FileTest.builder()
				.fileName(orgFileName)
				.orgFileName(saveFileName)
				.build();

			byte[] fileByte = multipartFile.getBytes();

			File file = new File(String.format("%s/%s", FILE_UPLOAD_PATH, saveFileName));

			File dir = new File(FILE_UPLOAD_PATH);

			if (!dir.exists()) {
				dir.mkdirs();
			}

			FileCopyUtils.copy(fileByte, file);

		} catch (Exception e) {
			log.error(e.getMessage());
		}

		return fileTest;
	}
}
