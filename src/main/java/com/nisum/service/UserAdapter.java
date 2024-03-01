package com.nisum.service;

import com.nisum.controller.dto.UserDTO;
import com.nisum.entity.User;

public interface UserAdapter {

	public User create(UserDTO user);
}
