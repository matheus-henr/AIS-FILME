package com.ais.movie.controller.exception;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ErrorHandler implements Serializable {

	
	private static final long serialVersionUID = 1L;

	private Integer status;
	private String msg;
	private long timestamp;
	
}
