package com.nisum.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class BaseController {

	protected <T> ResponseEntity<T> result(T response, HttpStatus status) {
		return new ResponseEntity<T>(response, status);
	}
	
}
