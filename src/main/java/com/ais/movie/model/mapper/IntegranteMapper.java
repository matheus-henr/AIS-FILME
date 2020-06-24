package com.ais.movie.model.mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.ais.movie.model.dto.IntegranteDTO;
import com.ais.movie.model.entity.Integrante;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class IntegranteMapper implements IMapper<Integrante, IntegranteDTO> {

	private final ModelMapper modelMapper;
	
	@Override
	public Integrante toEntity(IntegranteDTO dto) {
		return modelMapper.map(dto, Integrante.class);
	}

	@Override
	public IntegranteDTO toDTO(Integrante entity) {
		return modelMapper.map(entity, IntegranteDTO.class);
	}

	@Override
	public List<Integrante> toEntity(List<IntegranteDTO> dtos) {
		return dtos
				.stream()
				.map(filme -> toEntity(filme))
				.collect(Collectors.toList());
	}

	@Override
	public List<IntegranteDTO> toDTO(List<Integrante> entities) {
		return entities
				.stream()
				.map(filme -> toDTO(filme))
				.collect(Collectors.toList());
	}



}
