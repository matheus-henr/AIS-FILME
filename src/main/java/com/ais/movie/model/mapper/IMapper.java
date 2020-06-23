package com.ais.movie.model.mapper;

import java.util.List;

public interface IMapper<E, D> {

	E toEntity(D dto);
	
	D toDTO(E entity);
	
	List<E> toEntity(List<D> dtos);
	
	List<D> toDTO(List<E> entities);
}
