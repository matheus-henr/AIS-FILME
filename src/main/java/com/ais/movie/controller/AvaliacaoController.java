package com.ais.movie.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ais.movie.model.dto.AvaliacaoDTO;
import com.ais.movie.service.AvaliacaoService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;

@RestController()
@RequestMapping("/avaliacao")
@Api(tags = "Avaliação")
@RequiredArgsConstructor
public class AvaliacaoController {

	private final AvaliacaoService avaliacaoService;
	
	@PostMapping("/id-filme/{idFilme}")
	@ApiOperation(value = "Adicionar uma nova avaliação")
	public ResponseEntity<Void> avaliar(@RequestBody AvaliacaoDTO avaliacaoDTO, @PathVariable Long idFilme) {
		avaliacaoService.avaliar(avaliacaoDTO, idFilme);
		
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}
	
	@GetMapping("/id-filme/{idFilme}")
	@ApiOperation(value = "Consultar avaliação de um filme")
	public ResponseEntity<Double> obterNotaFilme(@PathVariable Long idFilme) {
		double avaliacao = avaliacaoService.consultarNota(idFilme);
		
		return ResponseEntity.ok(avaliacao);
	} 
}
