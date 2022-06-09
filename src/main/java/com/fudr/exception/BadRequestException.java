package com.fudr.exception;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Component
@ToString
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class BadRequestException extends RuntimeException{

	String message;
	int status;
	
	
}
