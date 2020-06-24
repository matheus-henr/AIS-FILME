package com.ais.movie.controller;

import java.net.URI;

import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.ais.movie.enums.Categoria;
import com.ais.movie.model.dto.FilmeDTO;
import com.ais.movie.model.dto.FilmePreviewDTO;
import com.ais.movie.service.FilmeService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;

@Api(tags = "Cliente")
@RestController
@RequestMapping("/filme")
@RequiredArgsConstructor
public class FilmeController {
	
	private final FilmeService filmeService;
	
	@PostMapping
	@ApiOperation(value = "salvar um novo filme")
	public ResponseEntity<FilmeDTO> salvar(@RequestBody FilmeDTO filme) {
		FilmeDTO filmeDTO = filmeService.salvar(filme);
		
		 URI uri = ServletUriComponentsBuilder
					.fromCurrentRequest()
					.path("/id/{id}")
					.buildAndExpand(filmeDTO.getId())
					.toUri();
		 
		 return ResponseEntity.created(uri).build();
	}
	
	@PutMapping("/id/{id}")
	@ApiOperation(value = "Atualiza um filme existente")
	public ResponseEntity<FilmeDTO> atualizar(@PathVariable Long id, @RequestBody FilmeDTO filme) {
		FilmeDTO filmeDTO = filmeService.atualizar(id, filme);
		
		 URI uri = ServletUriComponentsBuilder
					.fromCurrentRequest()
					.path("/id/{id}")
					.buildAndExpand(filmeDTO.getId())
					.toUri();
		 
		 return ResponseEntity.created(uri).build();
	}
	
	@GetMapping("/categoria/{categoria}/page/{page}/total/{totalElementos}")
	@ApiOperation(value = "Obtém uma lista paginada de filmes por categoria")
	public ResponseEntity<Page<FilmePreviewDTO>> obterFilmesPorCategoria(@PathVariable Categoria categoria, @PathVariable Integer page,
			@PathVariable Integer totalElementos) {
		Page<FilmePreviewDTO> filmes = filmeService.buscarFilmePorCategoriaPreview(categoria, totalElementos, page);
		
		return ResponseEntity.ok(filmes);
	}
	
	@GetMapping("/id/{id}")
	public ResponseEntity<FilmeDTO> obterFilmePorId(@PathVariable Long id) {
		FilmeDTO filme = filmeService.buscarFilmePorId(id);
		
		return ResponseEntity.ok(filme);
	}
	
	@GetMapping("/avaliacao/page/{page}/total/{totalElementos}")
	@ApiOperation(value = "Obtém uma lista paginada de filmes ordenada por avaliação")
	public ResponseEntity<Page<FilmePreviewDTO>> obterFilmesPorCategoria(@PathVariable int page, @PathVariable int totalElementos) {
		Page<FilmePreviewDTO> filmes = filmeService.buscarFilmeOrdenadoPorAvalicao(totalElementos, page);
		
		return ResponseEntity.ok(filmes);
	}
	
	@DeleteMapping("/id/{id}")
	@ApiOperation(value = "Deletar um filme existente")
	public ResponseEntity<Void> deletarFilme(@PathVariable Long id) {
		filmeService.deletar(id);
		
		return ResponseEntity.noContent().build();
	}
}
