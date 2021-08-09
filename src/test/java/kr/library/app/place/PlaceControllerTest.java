package kr.library.app.place;

import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.documentationConfiguration;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.preprocessRequest;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.preprocessResponse;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.prettyPrint;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.Test;
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
import kr.library.app.dto.PlaceRequest;
import kr.library.app.place.service.PlaceService;
import kr.library.core.CoreApplication;

@ExtendWith({SpringExtension.class, RestDocumentationExtension.class})
@SpringBootTest(classes = CoreApplication.class)
public class PlaceControllerTest {
	
	@Autowired
	PlaceControllerTest(PlaceService placeService) {
		this.placeService = placeService;
	}
	
	private final PlaceService placeService;

	@Autowired
	protected ObjectMapper objectMapper;

	protected MockMvc mockMvc;

	private RestDocumentationResultHandler document;

	protected ManualRestDocumentation restDocumentation = new ManualRestDocumentation();
	
	private PlaceRequest placeRequest;

	@BeforeEach
	public void setUp(WebApplicationContext context, RestDocumentationContextProvider restDocumentation) {

		this.document = document(
			"{class-name}/{method-name}", preprocessRequest(prettyPrint()), preprocessResponse(prettyPrint()));

		this.mockMvc = MockMvcBuilders.webAppContextSetup(context)
			.apply(documentationConfiguration(restDocumentation))
			.alwaysDo(document)
			.build();
	}

	@Test
	public void testCreate() throws Exception {
		
		placeRequest = PlaceRequest.builder().name("test1").address("서울시 금천구").build();
		
		mockMvc.perform(post("/place/create")
			.contentType(MediaType.APPLICATION_JSON)
			.content(objectMapper.writeValueAsString(placeRequest))
		).andExpect(status().isOk());
	}
	
	@Test
	public void testFindByName() throws Exception {
		
		placeRequest = PlaceRequest.builder().name("김").build();
		
		mockMvc.perform(post("/place/findByName")
			.contentType(MediaType.APPLICATION_JSON)
			.content(objectMapper.writeValueAsString(placeRequest))
			).andExpect(status().isOk());
	}
	
	@Test
	public void testFindByNameWithPage() throws Exception {
		
		placeRequest = PlaceRequest.builder().search("김").page(0).build();
		
		mockMvc.perform(post("/place/findByNameWithPage")
			.contentType(MediaType.APPLICATION_JSON)
			.content(objectMapper.writeValueAsString(placeRequest))
			).andExpect(status().isOk());
	}
	
	@Test
	public void testDelete() throws Exception {
		
		placeRequest = PlaceRequest.builder().name("test1").address("address").build();
		
		int seq = placeService.save(placeRequest);
		
		placeRequest.setSeq(seq);
		
		mockMvc.perform(post("/place/delete")
			.contentType(MediaType.APPLICATION_JSON)
			.content(objectMapper.writeValueAsString(placeRequest))
			).andExpect(status().isOk());
	}
}
