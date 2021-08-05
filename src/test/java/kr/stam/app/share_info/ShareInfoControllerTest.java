package kr.stam.app.share_info;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;

import com.fasterxml.jackson.databind.ObjectMapper;

import kr.stam.app.dto.ShareInfoRequest;
import kr.stam.core.StamCoreApplication;

@SpringBootTest(classes=StamCoreApplication.class)
public class ShareInfoControllerTest {
	
	@Autowired
	private ObjectMapper objectMapper;
	
	protected MockMvc mockMvc;
	
	@BeforeEach
	private void setUp(WebApplicationContext context) {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(context)
				.addFilters(new CharacterEncodingFilter("UTF-8", true))
				.alwaysDo(print())
				.build();
	}
	
	@Test
	@DisplayName("판매 리스트 전체")
	void list() throws Exception {

		mockMvc.perform(post("/v1/api/share_info/list")
				.contentType(MediaType.APPLICATION_JSON)
		).andExpect(status().is(400));
	}
	
	@Test
	@DisplayName("사용자별 판매 리스트 전체")
	void list2() throws Exception {
		ShareInfoRequest request = ShareInfoRequest.builder()
				.userSeq(1)
				.build();

		mockMvc.perform(post("/v1/api/share_info/list")
				.contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(request))
		).andExpect(status().isOk());
	}
}
