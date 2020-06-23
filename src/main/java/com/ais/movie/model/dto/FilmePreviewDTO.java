package com.ais.movie.model.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FilmePreviewDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private String nome;
	private String sinopse;
	private int avaliacao;
	private int duracao;

}
