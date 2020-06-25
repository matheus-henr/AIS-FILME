package com.ais.movie.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.ais.movie.enums.Categoria;
import com.ais.movie.exception.NotFoundException;
import com.ais.movie.model.dto.FilmeDTO;
import com.ais.movie.model.dto.FilmePreviewDTO;
import com.ais.movie.model.entity.Filme;
import com.ais.movie.model.mapper.FilmeMapper;
import com.ais.movie.model.mapper.FilmePreviewMapper;
import com.ais.movie.repository.FilmeRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FilmeService {

	private final FilmeRepository filmeRepository;
	private final FilmeMapper filmeMapper;
	private final FilmePreviewMapper filmePreviewMapper;
	private final AvaliacaoService avaliacaoService;
	
	@Transactional()
	public FilmeDTO salvar(FilmeDTO dto) {
		
		final Filme filme = filmeMapper.toEntity(dto);
		
		return filmeMapper.toDTO(filmeRepository.save(filme));
	}
	
	public Page<FilmePreviewDTO> buscarFilmePorCategoriaPreview(Categoria categoria, int totalElmentos, int pagina) {
		Pageable page = PageRequest.of(pagina, totalElmentos, Sort.Direction.ASC, "nome");
		
		final Page<Filme> filmesPage = filmeRepository.findByCategoria(categoria, page)
					.orElseThrow(() -> new NotFoundException("Nenhum recurso encontrado"));
		
		List<FilmePreviewDTO> filmes = filmePreviewMapper.toDTO(filmesPage.getContent());
		setarAvaliacao(filmes);
		
		return new PageImpl<>(filmes, page, filmesPage.getTotalElements());
	} 
	
	public FilmeDTO buscarFilmePorId(long id) {
		
		final Filme filme = filmeRepository.findById(id)
					.orElseThrow(() -> new NotFoundException("Nenhum recurso encontrado"));
		
		
		FilmeDTO filmeDTO = filmeMapper.toDTO(filme);
		setarAvaliacao(filmeDTO);
		
		return filmeDTO;
	} 
	
	
	@Transactional()
	public FilmeDTO atualizar(long id , FilmeDTO dto) {
		
		buscarFilmePorId(id);
		
		final Filme filme = filmeMapper.toEntity(dto);
		
		return filmeMapper.toDTO(filmeRepository.save(filme));
	}
	
	@Transactional()
    public void deletar(Long id) {
    	buscarFilmePorId(id);
    	
    	filmeRepository.deleteById(id);
    }
	
	private void setarAvaliacao(List<FilmePreviewDTO> filmes) {
			filmes.parallelStream().forEach(filme -> filme.setAvaliacao(avaliacaoService.consultarNota(filme.getId())));
		
	}

	private void setarAvaliacao(FilmeDTO filme) {
		filme.setAvaliacao(avaliacaoService.consultarNota(filme.getId()));
	}
}
