package com.ais.movie.exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class NotFoundException extends RuntimeException{


	private static final long serialVersionUID = 1L;
	
	public NotFoundException(String mensagem) {
		super(mensagem);
	}

}
