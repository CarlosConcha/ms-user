package com.nisum.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nisum.constant.RequestConstant;
import com.nisum.constant.SwaggerConstant;
import com.nisum.controller.dto.Notification;
import com.nisum.controller.dto.UserDTO;
import com.nisum.controller.dto.UserResponse;
import com.nisum.controller.dto.mapper.UserResponseMapper;
import com.nisum.service.UserAdapter;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;


@Tag(name = SwaggerConstant.TAG_NAME, description = SwaggerConstant.TAG_DESCRIPTION)
@RestController
@RequestMapping(value = RequestConstant.CONTEXT_URL_USER)
@RequiredArgsConstructor
public class UserController extends BaseController{

	private final UserAdapter userAdapter;
	
	@Operation(summary = SwaggerConstant.OPERATION_SUMMARY, description = SwaggerConstant.OPERATION_DESCRIPTION)
	@ApiResponses({
	      @ApiResponse(responseCode = "201", content = { @Content(schema = @Schema(implementation = UserResponse.class), mediaType = "application/json") }),
	      @ApiResponse(responseCode = "400", content = { @Content(schema = @Schema( implementation = Notification.class)) }, description = SwaggerConstant.RESPONSE_BAD_REQUEST_DESCRIPTION),
	      @ApiResponse(responseCode = "403", content = { @Content(schema = @Schema( implementation = Notification.class)) }, description = SwaggerConstant.RESPONSE_FORBIDDEN_DESCRIPTION),
	      @ApiResponse(responseCode = "409", content = { @Content(schema = @Schema( implementation = Notification.class)) }, description = SwaggerConstant.RESPONSE_CONFLICT_DESCRIPTION),
	      @ApiResponse(responseCode = "501", content = { @Content(schema = @Schema( implementation = Notification.class)) }) })
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UserResponse> create(@Valid @RequestBody UserDTO user) {
		return result(UserResponseMapper.builder().build()
				.getApiModel(userAdapter.create(user))
				, HttpStatus.CREATED);
	}
	
}
