package com.ais.movie.model.dto;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.ais.movie.model.entity.Integrante;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FilmeDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String nome;
	private String sinopse;
	private int avaliacao;
	private int duracao;
	private List<String> idiomaDisponivel;
	private List<String> legendaDisponivel;
	private List<IntegranteDTO> integrantes;
	private Date dataLancamento;
	

}
