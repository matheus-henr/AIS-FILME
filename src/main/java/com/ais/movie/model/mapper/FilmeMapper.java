package com.ais.movie.model.mapper;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.ais.movie.model.dto.FilmeDTO;
import com.ais.movie.model.entity.Filme;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class FilmeMapper implements IMapper<Filme, FilmeDTO>{

	private final ModelMapper modelMapper;
	
	@Override
	public Filme toEntity(FilmeDTO dto) {
		return modelMapper.map(dto, Filme.class);
	}

	@Override
	public FilmeDTO toDTO(Filme entity) {
		return modelMapper.map(entity, FilmeDTO.class);
	}

	@Override
	public List<Filme> toEntity(List<FilmeDTO> dtos) {
		List<Filme> filmes = new ArrayList<>();
		modelMapper.map(dtos, filmes);
		return filmes;
	}

	@Override
	public List<FilmeDTO> toDTO(List<Filme> entities) {
		List<FilmeDTO> filmesDto = new ArrayList<>();
		modelMapper.map(entities, filmesDto);
		return filmesDto;
	}

	
}
