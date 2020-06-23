package com.ais.movie.enums;

import lombok.Getter;

@Getter
public enum Genero {

	M("Masculino"), F("Feminino");
	
	private String descricao;
	
	private Genero(String descricao) {
		this.descricao = descricao;
	}
}
