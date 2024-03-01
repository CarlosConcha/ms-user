package com.nisum.controller.exception;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.nisum.controller.dto.Notification;
import com.nisum.controller.factory.NotificationFactory;

import io.jsonwebtoken.security.WeakKeyException;
import lombok.RequiredArgsConstructor;

@RestControllerAdvice
@RequiredArgsConstructor
public class ControllerAdvisor {
	
	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity<Notification> duplicateExceptionHandler(ConstraintViolationException exception){
		Notification notif = NotificationFactory.buildNotification("El correo ya esta registrado."); //TODO i18n could be applied
		return new ResponseEntity<>(notif, HttpStatus.CONFLICT);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Notification> mailExceptionHandler(MethodArgumentNotValidException exception){
		Notification notif = NotificationFactory.buildNotification(exception.getFieldError().getDefaultMessage());
		return new ResponseEntity<>(notif, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(WeakKeyException.class)
	public ResponseEntity<Notification> weakKeyExceptionHandler(WeakKeyException exception){
		Notification notif = NotificationFactory.buildNotification("La clave secreta del token no cumple con los minimos de seguridad.");
		return new ResponseEntity<>(notif, HttpStatus.FORBIDDEN);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<Notification> genericExceptionHandler(Exception exception){
		Notification notif = NotificationFactory.buildNotification("Ha ocurrido un error inesperado.");
		return new ResponseEntity<>(notif, HttpStatus.NOT_IMPLEMENTED);
	}
}
