package com.ais.movie.model.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.ais.movie.model.entity.Filme;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class FilmePreviewMapper implements IMapper<Filme, FilmePreviewMapper>{

	private final ModelMapper modelMapper;
	
	@Override
	public Filme toEntity(FilmePreviewMapper dto) {
		return modelMapper.map(dto, Filme.class);
	}

	@Override
	public FilmePreviewMapper toDTO(Filme entity) {
		return modelMapper.map(entity, FilmePreviewMapper.class);
	}

	
}
