package com.sms.exceptions;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalException 
{

	@ExceptionHandler
	public ResponseEntity<?> resourceNotFoundExHandling(ResourceNotFoundException resourceException,
			WebRequest webRequest) {

		ErrorDetails errorDetails = new ErrorDetails(new Date(), resourceException.getMessage(),
				webRequest.getDescription(false));
		return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);

	}
}