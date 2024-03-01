/**
 * 
 */
package com.nisum.service;

import static org.junit.jupiter.api.Assertions.*;
import java.lang.reflect.Field;
import java.util.UUID;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import io.jsonwebtoken.security.WeakKeyException;

/**
 * 
 */
@ExtendWith(MockitoExtension.class)
class TokenServiceTest {

	
	/**
	 * Test method for {@link com.nisum.service.TokenService#tokenizer(String)}.
	 * @throws Exception 
	 */
	@Test
	void tokenServiceTest_tokenizer_ok() throws Exception {
		
		Class<?> serviceClass = Class.forName("com.nisum.service.TokenService");
		TokenService mockTokenService = (TokenService) serviceClass.getDeclaredConstructor().newInstance();
		Field expirationField = serviceClass.getDeclaredField("expiration");
		expirationField.setAccessible(true);
		expirationField.set(mockTokenService,"600000");
		Field secretField = serviceClass.getDeclaredField("secret");
		secretField.setAccessible(true);
		secretField.set(mockTokenService,"MxcCcDn-tEmNh2MuUUJbhLibleKeI_fJG4BCWPXYXNc");
		
		String token = mockTokenService.tokenizer(UUID.randomUUID().toString());
		
		assertNotNull(token);
	}
	
	/**
	 * Test method for {@link com.nisum.service.TokenService#tokenizer(String)}.
	 * @throws Exception 
	 */
	@Test
	void tokenServiceTest_tokenizer_weak_secret_nok() throws Exception {
		
		Class<?> serviceClass = Class.forName("com.nisum.service.TokenService");
		TokenService mockTokenService = (TokenService) serviceClass.getDeclaredConstructor().newInstance();
		Field expirationField = serviceClass.getDeclaredField("expiration");
		expirationField.setAccessible(true);
		expirationField.set(mockTokenService,"600000");
		Field secretField = serviceClass.getDeclaredField("secret");
		secretField.setAccessible(true);
		secretField.set(mockTokenService,"aaaa");
		
		assertThrows(WeakKeyException.class, () -> mockTokenService.tokenizer(UUID.randomUUID().toString()));
	}
		

}
