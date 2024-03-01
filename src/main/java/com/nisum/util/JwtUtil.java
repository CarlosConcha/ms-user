package com.nisum.util;

import java.util.Date;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

public class JwtUtil {
	
	private static final String ISSUER_CLAIM = "challenge-nisum";
	
	public static String tokenize(String uuid, String secret, Long expiration) {
		return Jwts.builder()
				.issuer(ISSUER_CLAIM)
				.expiration(new Date(System.currentTimeMillis() + expiration))
				.subject(uuid)
				.issuedAt(new Date())
				.signWith(Keys.hmacShaKeyFor(Decoders.BASE64URL.decode(secret)))
				.compact();

	}
	
}
