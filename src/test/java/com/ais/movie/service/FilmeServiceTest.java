package com.ais.movie.service;


import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.ais.movie.model.entity.Filme;
import com.ais.movie.repository.FilmeRepository;

@SpringBootTest
public class FilmeServiceTest {
	
	
	@Autowired
	private FilmeService filmeService;
	@MockBean
	private FilmeRepository filmeRepository;
	

	
	@Test
	public void testa_mensagem_de_erro_buscar_por_id() {
		Optional<Filme> filmes = Optional.ofNullable(null);
		Mockito.when(filmeRepository.findById(9L)).thenReturn(filmes);
		
		Exception exception = assertThrows(RuntimeException.class, () -> {
	       filmeService.buscarFilmePorId(9);
	    });
	 
	    String expectedMessage = "Nenhum recurso encontrado";
	    String actualMessage = exception.getMessage();
	 
	    assertTrue(actualMessage.contains(expectedMessage));
	}
	
}
