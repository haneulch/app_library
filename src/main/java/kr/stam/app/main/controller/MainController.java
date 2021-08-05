package kr.stam.app.main.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.stam.app.dto.DataTestRequest;
import kr.stam.app.dto.FileTestRequest;
import kr.stam.app.main.service.MainService;
import kr.stam.core.util.JsonResponseUtils;

@Controller
@RequestMapping("/")
public class MainController {

	final MainService mainService;

	public MainController(MainService mainService) {
		this.mainService = mainService;
	}

	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@GetMapping("main")
	public String main() {

		return "/main/view";
	}
	
	@GetMapping("vue")
	public String vue() {
		
		return "/main/vue_test";
	}

	@PostMapping("testDto")
	public JsonResponseUtils<DataTestRequest> test(@RequestBody DataTestRequest data, HttpServletRequest request) {

		log.info(data.toString());

		return new JsonResponseUtils(data, HttpStatus.OK);
	}

	@PostMapping("testDto2")
	public ResponseEntity<Map<String, Object>> test2(@RequestBody DataTestRequest data) {

		log.info(data.toString());

		return JsonResponseUtils.success(data.getStr());
	}

	@PostMapping("testMap")
	public ResponseEntity<Map<String, Object>> test2(@RequestBody Map<String, Object> data) {

		log.info(data.toString());

		return JsonResponseUtils.success(data);
	}

	@PostMapping("/uploadFile")
	public ResponseEntity<Map<String, Object>> upload(FileTestRequest fileTestRequest) {

		mainService.save(fileTestRequest);

		return JsonResponseUtils.success(true);
	}

}
