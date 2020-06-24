package com.ais.movie.controller.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.ais.movie.exception.NotFoundException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@ControllerAdvice
public class ControllerExceptionHandler  extends ResponseEntityExceptionHandler{

	

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ErrorHandler> notFound(NotFoundException e, HttpServletRequest request) {
    	log.error(e.getMessage());
		ErrorHandler err = new ErrorHandler(HttpStatus.NOT_FOUND.value(), e.getMessage(), System.currentTimeMillis());

		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
	}

 
}
