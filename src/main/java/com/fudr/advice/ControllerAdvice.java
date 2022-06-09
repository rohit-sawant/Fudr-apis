package com.fudr.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fudr.bean.Response;
import com.fudr.bean.Status;
import com.fudr.exception.BadRequestException;
import com.fudr.exception.EntityNotFoundException;
import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;
@org.springframework.web.bind.annotation.ControllerAdvice
public class ControllerAdvice {

	@ResponseBody
	@ExceptionHandler(BadRequestException.class)
	public ResponseEntity<Response> handleBadRequestException(BadRequestException badRequestException){
		return new ResponseEntity<Response>(new Response(Status.error.name(),badRequestException.getMessage(),null),HttpStatus.BAD_REQUEST);
	}
	
	@ResponseBody
	@ExceptionHandler(EntityNotFoundException.class)
	public ResponseEntity<Response> handleEntityNotFoundException(EntityNotFoundException entityNotFoundException){
		return new ResponseEntity<Response>(new Response(Status.error.name(),entityNotFoundException.getMessage(),null),HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(MySQLIntegrityConstraintViolationException.class)
	public  ResponseEntity<Response> handleEntityNotFoundException(MySQLIntegrityConstraintViolationException mySQLIntegrityConstraintViolationException){
		return new ResponseEntity<Response>(new Response(Status.error.name(),mySQLIntegrityConstraintViolationException.getMessage(),null),HttpStatus.BAD_REQUEST);
	}
}
