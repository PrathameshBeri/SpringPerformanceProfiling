package io.shakespeare.playwright.Controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import io.shakespeare.playwright.dto.ExceptionResponse;
import io.shakespeare.playwright.utilities.Exceptions.EntityNotFoundException;

@ControllerAdvice
public class ExceptionInterceptor extends ResponseEntityExceptionHandler {

	@ExceptionHandler(EntityNotFoundException.class)
	public ResponseEntity<ExceptionResponse> handleException(EntityNotFoundException e) {

		ExceptionResponse er = new ExceptionResponse("Entity not found", e.getMessage());

		return new ResponseEntity<ExceptionResponse>(er, HttpStatus.NO_CONTENT);
	}

}
