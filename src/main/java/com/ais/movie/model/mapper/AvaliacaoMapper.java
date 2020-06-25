package com.ais.movie.model.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.ais.movie.model.dto.AvaliacaoDTO;
import com.ais.movie.model.entity.Avaliacao;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class AvaliacaoMapper implements IMapper<Avaliacao, AvaliacaoDTO>{

	private final ModelMapper modelMapper;
	
	@Override
	public Avaliacao toEntity(AvaliacaoDTO dto) {
		return modelMapper.map(dto, Avaliacao.class);
	}

	@Override
	public AvaliacaoDTO toDTO(Avaliacao entity) {
		return modelMapper.map(entity, AvaliacaoDTO.class);
	}

	@Override
	public List<Avaliacao> toEntity(List<AvaliacaoDTO> dtos) {
		return dtos
				.stream()
				.map(avaliacao -> toEntity(avaliacao))
				.collect(Collectors.toList());
	}

	@Override
	public List<AvaliacaoDTO> toDTO(List<Avaliacao> entities) {
		return entities
				.stream()
				.map(avaliacao -> toDTO(avaliacao))
				.collect(Collectors.toList());
	}

	
}
