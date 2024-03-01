package com.nisum.controller.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder
@JsonInclude(Include.NON_NULL)
public class UserResponse {

	@JsonProperty("usuario")
	private UserDTO user;
	@JsonProperty("notification")
	private Notification notification;
}
