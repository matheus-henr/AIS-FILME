package com.ais.movie.model.mapper;

public interface IMapper<E, D> {

	E toEntity(D dto);
	
	D toDTO(E entity);
}
