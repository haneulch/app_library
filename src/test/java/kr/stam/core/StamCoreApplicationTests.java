package kr.stam.core;

import static org.springframework.restdocs.operation.preprocess.Preprocessors.preprocessRequest;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.preprocessResponse;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.prettyPrint;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.documentationConfiguration;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.multipart;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import java.io.File;
import java.io.FileInputStream;
import java.nio.file.Paths;
import org.apache.commons.io.IOUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.restdocs.ManualRestDocumentation;
import org.springframework.restdocs.RestDocumentationContextProvider;
import org.springframework.restdocs.RestDocumentationExtension;
import org.springframework.restdocs.mockmvc.RestDocumentationResultHandler;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import com.fasterxml.jackson.databind.ObjectMapper;
import kr.stam.app.dto.DataTestRequest;


@ExtendWith({SpringExtension.class, RestDocumentationExtension.class})
@SpringBootTest
public class StamCoreApplicationTests {
	
	@Autowired
	protected ObjectMapper objectMapper;
	
	protected MockMvc mockMvc;
	
	private RestDocumentationResultHandler document;
	
	protected ManualRestDocumentation restDocumentation = new ManualRestDocumentation();
	
	@BeforeEach
	public void setUp( WebApplicationContext context
			, RestDocumentationContextProvider restDocumentation) {
		
		
		this.document = document(
					"{class-name}/{method-name}"
					, preprocessRequest(prettyPrint())
					, preprocessResponse(prettyPrint())
				);
		
		this.mockMvc = MockMvcBuilders.webAppContextSetup(context)
				.apply(documentationConfiguration(restDocumentation))
				.alwaysDo(document)
				.build();
	}
	
	@Test
	public void testDataRequest() throws Exception {
		
		DataTestRequest data = DataTestRequest.builder().str("string").booleanValue(true).number(2).build();
		
		mockMvc.perform(post("/testDto")
					.contentType(MediaType.APPLICATION_JSON)
					.content(objectMapper.writeValueAsString(data))
				).andExpect(status().isOk());
	}

	@Test
	public void testFileUpload() throws Exception {
		File file = new File(Paths.get("").toAbsolutePath().toString(), "\\src\\main\\resources\\static\\img\\back-btn.png");
		
	    FileInputStream fis = new FileInputStream(file);
		
		mockMvc.perform(multipart("/uploadFile")
					.file("file", IOUtils.toByteArray(fis))
					.param("fileName", file.getName())
				).andExpect(status().isOk());
	}
}
