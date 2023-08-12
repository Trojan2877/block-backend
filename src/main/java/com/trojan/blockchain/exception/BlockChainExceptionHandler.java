package com.trojan.blockchain.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class BlockChainExceptionHandler {

	private static String FAILURE = "FAILED";
	
	@ExceptionHandler(value = MethodArgumentNotValidException.class)
	public ResponseEntity<ResponseBuilder> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
		String message = ex.getBindingResult().getFieldError().getDefaultMessage();
		return new ResponseEntity<>( new ResponseBuilder(HttpStatus.BAD_REQUEST.value(), message, FAILURE) ,HttpStatus.BAD_REQUEST);
	}
		
}
