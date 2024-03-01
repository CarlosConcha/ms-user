package com.nisum.controller.dto;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.nisum.constant.RegexConstant;
import com.nisum.validator.annotation.Password;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(Include.NON_NULL)
public class UserDTO {

	private String id;
	private String name;
	@Email(regexp = RegexConstant.MAIL_PATTERN)
	private String email;
	@Password
	private String password;
	private LocalDateTime created;
	private LocalDateTime modified;
	@JsonProperty("last_login")
	private LocalDateTime lastLogin;
	private String token;
	@JsonProperty("isactive")
	private Boolean isActive;
	@NotEmpty
	private List<PhoneDTO> phones;
	
	public UserDTO(String id,LocalDateTime created, LocalDateTime modified, LocalDateTime lastLogin, String token, Boolean isActive) {
		this.id = id;
		this.created = created;
		this.modified = modified;
		this.lastLogin = lastLogin;
		this.token = token;
		this.isActive = isActive;
	}
}
