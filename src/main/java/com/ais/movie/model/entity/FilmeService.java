package com.ais.movie.model.entity;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.ais.movie.model.dto.FilmeDTO;
import com.ais.movie.model.mapper.FilmeMapper;
import com.ais.movie.repository.FilmeRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FilmeService {

	private final FilmeRepository filmeRepository;
	private final FilmeMapper filmeMapper;
	
	@Transactional()
	public FilmeDTO salvar(FilmeDTO dto) {
		
		final Filme filme = filmeMapper.toEntity(dto);
		
		return filmeMapper.toDTO(filmeRepository.save(filme));
	}
}
