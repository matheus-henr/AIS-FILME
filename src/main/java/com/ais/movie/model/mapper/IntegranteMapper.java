package com.ais.movie.model.mapper;

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



}
