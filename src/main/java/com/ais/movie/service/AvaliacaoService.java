package com.ais.movie.service;

import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.ais.movie.exception.NotFoundException;
import com.ais.movie.model.dto.AvaliacaoDTO;
import com.ais.movie.model.entity.Avaliacao;
import com.ais.movie.model.entity.AvaliacaoRepository;
import com.ais.movie.model.entity.Filme;
import com.ais.movie.model.mapper.AvaliacaoMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AvaliacaoService {

	private final AvaliacaoRepository avaliacaoRepository;
	private final AvaliacaoMapper avaliacaoMapper;
	
	@Transactional
	public boolean avaliar(AvaliacaoDTO avaliacaoDTO, Long idFilme) {
		Avaliacao avaliacao = avaliacaoMapper.toEntity(avaliacaoDTO);
		Filme filme = Filme.builder()
				.id(idFilme)
				.build();
		
		avaliacao.setFilme(filme);
		
		if(avaliacao.getNota() < 0 || avaliacao.getNota() > 10) {
			throw new IllegalArgumentException("Nota deve está entre 0 e 10");
		}
		
		avaliacaoRepository.save(avaliacao);
		
		return true;
	}
	
	public double consultarNota(Long idFilme) {
		  Optional<List<Avaliacao>> optionalAvaliacao = avaliacaoRepository.findByFilmeId(idFilme);
		  
		  if(!optionalAvaliacao.isPresent()) {
			  return 0;
		  }
		  
		  List<Avaliacao> avaliacoes = optionalAvaliacao.get();
		 
		  OptionalDouble media = avaliacoes.stream()
		 	.mapToInt(avaliacao -> avaliacao.getNota())
		 	.average();
		 
		 
		 return media.orElseThrow(() -> new NotFoundException("Nenhum recurso encontrado"));
					 
	}
}
