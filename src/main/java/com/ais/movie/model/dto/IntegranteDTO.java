package com.ais.movie.model.dto;

import java.io.Serializable;
import java.util.Set;

import com.ais.movie.enums.Funcao;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class IntegranteDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private Long id;
	private String nome;
	private String sobreNome;
	private String dataNascimento;
	private Set<FilmePreviewDTO> filmes;
	private Funcao funcao;
}
