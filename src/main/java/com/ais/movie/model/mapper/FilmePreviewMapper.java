package com.ais.movie.model.mapper;

import java.util.ArrayList;
import java.util.List;

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
		List<Filme> filmes = new ArrayList<>();
		modelMapper.map(dtos, filmes);
		return filmes;
	}

	@Override
	public List<FilmePreviewDTO> toDTO(List<Filme> entities) {
		List<FilmePreviewDTO> filmesDTO = new ArrayList<>();
		modelMapper.map(entities, filmesDTO);
		return filmesDTO;
	}

	
}
