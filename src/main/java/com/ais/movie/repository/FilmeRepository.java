package com.ais.movie.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ais.movie.enums.Categoria;
import com.ais.movie.model.entity.Filme;

@Repository
public interface FilmeRepository  extends JpaRepository<Filme, Long>{

	Optional<Page<Filme>> findByCategoria(Categoria categoria, Pageable page);

	Optional<Page<Filme>> findByAvalicaoOrderByCreatedASC(Pageable page);

}
