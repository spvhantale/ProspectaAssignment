package com.prospecta.exception;

import java.time.LocalTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalException {

	
	
	@ExceptionHandler(CategoryException.class)
	public ResponseEntity<MyError> getCategoryException(CategoryException ce,WebRequest req){
		
		MyError mr=new MyError(LocalTime.now(), ce.getMessage(), req.getDescription(false));
		return new ResponseEntity<MyError>(mr, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<MyError> getException(Exception e,WebRequest req){
		
		MyError mr=new MyError(LocalTime.now(), e.getMessage(), req.getDescription(false));
		return new ResponseEntity<MyError>(mr, HttpStatus.BAD_REQUEST);
	}
	
}
