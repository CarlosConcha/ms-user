package com.nisum.validator;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.nisum.validator.annotation.Password;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

@Component
public class PasswordValidator implements ConstraintValidator<Password, Object>{

	@Value("${app.password.regex}")
	private String passwordPattern;
	
	@Override
	public boolean isValid(Object value, ConstraintValidatorContext context) {
		String password = (String)value;
		return password.matches(passwordPattern);
	}

}
