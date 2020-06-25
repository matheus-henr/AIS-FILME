package com.ais.movie.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.ais.movie.model.dto.AvaliacaoDTO;
import com.ais.movie.model.entity.Avaliacao;
import com.ais.movie.model.entity.AvaliacaoRepository;

@SpringBootTest
public class AvaliacaoServiceTest {

	@Autowired
	private AvaliacaoService avaliacaoService;
	@MockBean
	private AvaliacaoRepository avaliacaoRepository;

	
	@Test
	public void teste_intervalo_nota_invalida() {
		Mockito.when(avaliacaoRepository.save(new Avaliacao())).thenReturn(new Avaliacao());
		Exception exception = assertThrows(RuntimeException.class, () -> {
			avaliacaoService.avaliar(new AvaliacaoDTO(15), 3L);
		    });
		
		 String expectedMessage = "Nota deve está entre 0 e 10";
		    String actualMessage = exception.getMessage();
		 
		    assertTrue(actualMessage.contains(expectedMessage));
	}
	
	@Test
	public void testa_intervalo_nota_valida() {
		Mockito.when(avaliacaoRepository.save(new Avaliacao())).thenReturn(new Avaliacao());
		assertTrue(avaliacaoService.avaliar(new AvaliacaoDTO(8), 3L));
	}
	
	@Test
	public void testa_media() {
		
		Avaliacao ava1 = Avaliacao.builder().nota(8).build();
		Avaliacao ava2 = Avaliacao.builder().nota(6).build();
		Avaliacao ava3 = Avaliacao.builder().nota(9).build();
		
		
		Optional<List<Avaliacao>> avaliacoes = Optional.of(Arrays.asList(ava1, ava2, ava3));
		Mockito.when(avaliacaoRepository.findByFilmeId(1L)).thenReturn(avaliacoes);
		
		assertEquals(7.66, avaliacaoService.consultarNota(1L), 0.01);
	}
}
