package kr.stam.app.share_info.controller;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import kr.stam.app.dto.SeqRequest;
import kr.stam.app.dto.ShareInfoRequest;
import kr.stam.app.share_info.service.ShareInfoService;
import kr.stam.core.annotation.AccessTokenCheck;
import kr.stam.core.util.JsonResponseUtils;

@Api(tags = "ShareInfo")
@ApiOperation(value = "api")
@RestController
@RequestMapping("/v1/api/share_info")
public class ShareInfoController {
	private final ShareInfoService shareInfoService;
	
	public ShareInfoController(
			ShareInfoService shareInfoService) {
		this.shareInfoService = shareInfoService;
	}
	
	@PostMapping("/list")
	public ResponseEntity<Map<String, Object>> list(
			@RequestBody ShareInfoRequest request) {
		return JsonResponseUtils.success(shareInfoService.findAll(request));
	}

	@AccessTokenCheck
	@PostMapping("/save")
	public ResponseEntity<Map<String, Object>> save(
			@RequestBody ShareInfoRequest request) {
		return JsonResponseUtils.success(shareInfoService.save(request));
	}
	
	@PostMapping("/get")
	public ResponseEntity<Map<String, Object>> get(
			@RequestBody SeqRequest request) {
		return JsonResponseUtils.success(shareInfoService.findById(request.getSeq()));
	}
}
