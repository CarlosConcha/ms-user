/**
 * 
 */
package com.nisum.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.sql.SQLException;

import org.hibernate.exception.ConstraintViolationException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.nisum.controller.dto.UserDTO;
import com.nisum.entity.User;
import com.nisum.mock.MockFactory;
import com.nisum.repository.UserRepository;

/**
 * 
 */
@ExtendWith(MockitoExtension.class)
class UserServiceTest {

	@InjectMocks
	private UserService userService;
	@Mock
	private UserRepository userRepository;
	@Mock
	private PasswordEncoder passwordEncoder;
	@Mock
	private TokenAdapter tokenAdapter;
	
	public UserDTO user;
	
	@BeforeEach
	void setUp() {
		user = Mockito.mock(UserDTO.class);
	}
	/**
	 * Test method for {@link com.nisum.service.UserService#create(com.nisum.controller.dto.UserDTO)}.
	 */
	@Test
	void userServiceTest_create_ok() {
		
		when(userRepository.save(any(User.class))).thenReturn(MockFactory.userMock());
		when(tokenAdapter.tokenizer(anyString())).thenReturn(MockFactory.TOKEN);
		
		User result = userService.create(user);
		
		verify(userRepository,times(1)).save(any(User.class));
		assertEquals(MockFactory.TOKEN,result.getToken());
	}
	
	/**
	 * Test method for {@link com.nisum.service.UserService#create(com.nisum.controller.dto.UserDTO)}.
	 */
	@Test
	void userServiceTest_create_mail_nok() {
		
		doThrow(new ConstraintViolationException(MockFactory.CONSTRAINT_MESSAGE, new SQLException(),
				MockFactory.CONSTRAINT_KEY)).when(userRepository).save(any(User.class));
		when(tokenAdapter.tokenizer(anyString())).thenReturn(MockFactory.TOKEN);

		assertThrows(ConstraintViolationException.class, () -> userService.create(user));
	}
	
	

}
