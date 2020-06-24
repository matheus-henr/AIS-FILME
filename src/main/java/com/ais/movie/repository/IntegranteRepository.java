package com.ais.movie.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ais.movie.model.entity.Integrante;

@Repository
public interface IntegranteRepository  extends JpaRepository<Integrante, Long>{


	
}
