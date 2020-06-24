package com.ais.movie.model.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.ais.movie.model.dto.FilmePreviewDTO;
import com.ais.movie.model.entity.Filme;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class FilmePreviewMapper implements IMapper<Filme, FilmePreviewDTO>{

	private final ModelMapper modelMapper;
	
	@Override
	public Filme toEntity(FilmePreviewDTO dto) {
		return modelMapper.map(dto, Filme.class);
	}

	@Override
	public FilmePreviewDTO toDTO(Filme entity) {
		return modelMapper.map(entity, FilmePreviewDTO.class);
	}

	@Override
	public List<Filme> toEntity(List<FilmePreviewDTO> dtos) {
		return dtos
				.stream()
				.map(filme -> toEntity(filme))
				.collect(Collectors.toList());
	}

	@Override
	public List<FilmePreviewDTO> toDTO(List<Filme> entities) {
		return entities
				.stream()
				.map(filme -> toDTO(filme))
				.collect(Collectors.toList());
	}

	
}
