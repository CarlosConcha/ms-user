package com.nisum.controller.dto.mapper;

import com.nisum.controller.dto.Notification;
import com.nisum.controller.dto.UserDTO;
import com.nisum.controller.dto.UserResponse;
import com.nisum.entity.User;

import lombok.Builder;

@Builder
public class UserResponseMapper implements ResponseMapper<UserResponse, User>{
	
	private Notification notification;
	
	@Override
	public UserResponse getApiModel(User model) {
		UserDTO dto = new UserDTO(model.getKey(), model.getCreadtedDate(), model.getUpdatedDate(), model.getLastLogin(),
				model.getToken(), model.getIsActive());
		
		return UserResponse.builder().user(dto).notification(notification).build();
	}

}
