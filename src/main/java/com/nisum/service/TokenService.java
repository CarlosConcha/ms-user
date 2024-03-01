package com.nisum.service;

import org.springframework.beans.factory.annotation.Value;

import org.springframework.stereotype.Service;
import com.nisum.util.JwtUtil;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TokenService implements TokenAdapter {
	
	@Value("${app.token.secret}")
	private String secret;
	@Value("${app.token.expiration}")
	private String expiration;

	@Override
	public String tokenizer(String uuid) {
		return JwtUtil.tokenize(uuid, secret,Long.valueOf(expiration));
	}

	
}
