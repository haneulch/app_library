package kr.library.core.user.controller;

import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import kr.library.core.constant.MessageConstants;
import kr.library.core.dto.ErrorResponse;
import kr.library.core.dto.SignInResponse;
import kr.library.core.dto.UserRequest;
import kr.library.core.entity.User;
import kr.library.core.user.service.UserService;
import kr.library.core.util.JsonResponseUtils;
import kr.library.core.util.JwtUtils;

@Api(tags = "User")
@ApiOperation(value = "api")
@RestController
@RequestMapping("/v1/api/user")
public class UserController {

	private final UserService userService;
	private final JwtUtils jwtUtils;

	public UserController(UserService userService, JwtUtils jwtUtils) {
		this.userService = userService;
		this.jwtUtils = jwtUtils;
	}
	
	@PostMapping("/signIn")
	public ResponseEntity<Map<String, Object>> signIn(@RequestBody UserRequest userRequest) {
		User user = userService.login(userRequest.toEntity());
		
		if(user != null) {
			String accessToken = jwtUtils.createAccessToken(user.getUsername());
			String refreshToken = jwtUtils.createRefreshToken(accessToken);
			
			SignInResponse response = SignInResponse.builder()
											.accessToken(accessToken)
											.refreshToken(refreshToken)
											.build();
			
			return JsonResponseUtils.success(response);
		}
		
		ErrorResponse error = ErrorResponse
								.builder()
								.message(MessageConstants.CHECK_ID_AND_PW)
								.status(HttpStatus.BAD_REQUEST)
								.build();
		
		return JsonResponseUtils.error(error);
	}

	@PostMapping("/create")
	public ResponseEntity<Map<String, Object>> create(@RequestBody UserRequest userRequest) {

		userService.save(userRequest);
		return JsonResponseUtils.success(true);
	}

	@PostMapping("/findById")
	public ResponseEntity<User> findById(@RequestBody UserRequest userRequest) {

		User user = userService.findById(userRequest.getUsername());
		return new JsonResponseUtils<User>(user);
	}

	@PostMapping("/findAll")
	public ResponseEntity<List<User>> findAll() {

		List<User> users = userService.findAll();
		return new JsonResponseUtils<List<User>>(users);
	}

	@PostMapping("/delete")
	public ResponseEntity<Map<String, Object>> delete(@RequestBody UserRequest userRequest) {

		userService.delete(userRequest);
		return JsonResponseUtils.success(true);
	}
}