package com.nisum.service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.nisum.repository.UserRepository;
import com.nisum.controller.dto.UserDTO;
import com.nisum.entity.Phone;
import com.nisum.entity.User;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService implements UserAdapter {

	private static final Logger logger = LoggerFactory.getLogger(UserService.class);
	
	private final UserRepository userRepository;
	private final PasswordEncoder passwordEncoder;
	private final TokenAdapter tokenAdapter;
	
	@Override
	public User create(UserDTO dto) {
		logger.info("request -> "+dto.toString());
		//uuid for key and token purpose
		String generateUuid = UUID.randomUUID().toString();
		
		User user = User.builder()
				.key(generateUuid)
				.name(dto.getName())
				.mail(dto.getEmail())
				.token(tokenAdapter.tokenizer(generateUuid))
				.password(passwordEncoder.encode(dto.getPassword()))
				.isActive(Boolean.TRUE)
				.phones(dto
				.getPhones().stream().map(phone -> Phone.builder()
						.number(phone.getNumber())
						.cityCode(phone.getCityCode())
						.countryCode(phone.getCountryCode())
						.build())
				.collect(Collectors.toList()))
				.build();
		
		List<Phone> phones = dto
				.getPhones().stream().map(phone -> Phone.builder()
						.number(phone.getNumber())
						.cityCode(phone.getCityCode())
						.countryCode(phone.getCountryCode())
						.user(user)
						.build())
				.collect(Collectors.toList());
		
		user.setPhones(phones);
		
		return userRepository.save(user);
		
	}

	
}
