package com.nisum.mock;

import java.time.LocalDateTime;
import java.util.UUID;

import com.nisum.entity.User;

public class MockFactory {

	public static final String TOKEN = "eyJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJjaGFsbGVuZ2UtbmlzdW0iLCJleHAiOjE3MDkyNjM2MDksInN1YiI6ImE5YWFkYzBlLWY3ODUtNGRiZC05NDBiLTIxYjMzNzA5OWFjNSIsImlhdCI6MTcwOTI2MzAwOX0.w9wnzii-Gel2oMrM9Pzk5VC4iD9CnhzaXNobe76jgCY";
	public static final String CONSTRAINT_MESSAGE = "duplicada";
	public static final String CONSTRAINT_KEY = "UQ_USR_MAIL";
	
	public static User userMock() {
		return User.builder().token(TOKEN).isActive(true).key(UUID.randomUUID().toString())
				.creadtedDate(LocalDateTime.now()).lastLogin(LocalDateTime.now()).build();
	}
	
}
