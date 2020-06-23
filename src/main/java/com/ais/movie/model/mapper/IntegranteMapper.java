package com.ais.movie.model.mapper;

import java.util.ArrayList;
import java.util.List;

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
		List<Integrante> integrantes = new ArrayList<>();
		modelMapper.map(dtos, integrantes);
		return integrantes;
	}

	@Override
	public List<IntegranteDTO> toDTO(List<Integrante> entities) {
		List<IntegranteDTO> integrantesDto = new ArrayList<>();
		modelMapper.map(entities, integrantesDto);
		return integrantesDto;
	}



}
