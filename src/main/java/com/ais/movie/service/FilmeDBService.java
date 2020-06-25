package com.ais.movie.service;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.ais.movie.enums.Categoria;
import com.ais.movie.enums.Funcao;
import com.ais.movie.enums.Sexo;
import com.ais.movie.model.dto.AvaliacaoDTO;
import com.ais.movie.model.entity.Avaliacao;
import com.ais.movie.model.entity.Filme;
import com.ais.movie.model.entity.Integrante;
import com.ais.movie.repository.FilmeRepository;
import com.ais.movie.repository.IntegranteRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class FilmeDBService {

	private final FilmeRepository filmeRepository;
	private final IntegranteRepository integranteRepository;
	private final AvaliacaoService avaliacaoService;
	
	@Transactional()
	public void cargaInicial() {
		
		log.debug("-- Salvando carga inicial");
		
		Integrante scarlettJohansson = Integrante.builder()
				.nome("Scarlett Johansson")
				.funcao(Funcao.ATOR)
				.sexo(Sexo.F)
				.build();
		
		Integrante robertDowney  = Integrante.builder()
				.nome("Robert Downey Jr")
				.funcao(Funcao.ATOR)
				.sexo(Sexo.M)
				.build();
		
		
		Integrante chrisHemsworth  = Integrante.builder()
				.nome("Chris Hemsworth")
				.funcao(Funcao.ATOR)
				.sexo(Sexo.M)
				.build();	
		
		Integrante jeffFowler  = Integrante.builder()
				.nome("Jeff Fowler")
				.funcao(Funcao.DIRETOR)
				.sexo(Sexo.M)
				.build();	
		
		Integrante jimCarrey  = Integrante.builder()
				.nome("Jim Carrey")
				.funcao(Funcao.ATOR)
				.sexo(Sexo.M)
				.build();	
		
		
		List<Integrante> integrantes = Arrays.asList(scarlettJohansson, robertDowney, chrisHemsworth, jeffFowler, jimCarrey);
		
		Filme osVingadores = Filme.builder()
					.nome("Marvel's The Avengers: Os Vingadores")
					.sinopse("Loki, o irmão de Thor, ganha acesso ao poder ilimitado do cubo cósmico ao roubá-lo de dentro das instalações da S.H.I.E.L.D. Nick Fury, o diretor desta agência internacional que mantém a paz, logo reúne os únicos super-heróis que serão capazes de defender a Terra de ameaças sem precedentes. Homem de Ferro, Capitão América, Hulk, Thor, Viúva Negra e Gavião Arqueiro formam o time dos sonhos de Fury, mas eles precisam aprender a colocar os egos de lado e agir como um grupo em prol da humanidade")
					.dataLancamento(LocalDate.of(2012, 04, 27))
					.categoria(Categoria.FICCAO_CIENTIFICA)
					.legendaDisponivel(Arrays.asList("PORTUGUÊS", "INGLÊS", "ESPANHOL"))
					.idiomaDisponivel(Arrays.asList("PORTUGUÊS", "INGLÊS", "ESPANHOL"))
					.integrantes(Arrays.asList(scarlettJohansson, robertDowney, chrisHemsworth))
					.build();
		

		Filme eraUltron = Filme.builder()
					.nome("Vingadores: Era de Ultron")
					.sinopse("Ao tentar proteger o planeta de ameaças, Tony Stark constrói um sistema de inteligência artificial que cuidaria da paz mundial. O projeto acaba dando errado e gera o nascimento do Ultron. Com o destino da Terra em jogo, Capitão América, Homem de Ferro, Thor, Hulk, Viúva Negra e Gavião Arqueiro terão que se unir para mais uma vez salvar a raça humana da extinção")
					.dataLancamento(LocalDate.of(2015, 04, 23))
					.categoria(Categoria.FICCAO_CIENTIFICA)
					.legendaDisponivel(Arrays.asList("PORTUGUÊS", "INGLÊS", "ESPANHOL"))
					.idiomaDisponivel(Arrays.asList("PORTUGUÊS", "INGLÊS", "ESPANHOL"))
					.integrantes(Arrays.asList(scarlettJohansson, robertDowney, chrisHemsworth))
					.build();
		
		
		Filme guerraInfinita = Filme.builder()
				.nome("Vingadores: Guerra Infinita")
				.sinopse("Homem de Ferro, Thor, Hulk e os Vingadores se unem para combater seu inimigo mais poderoso, o maligno Thanos. Em uma missão para coletar todas as seis pedras infinitas, Thanos planeja usá-las para infligir sua vontade maléfica sobre a realidade.")
				.dataLancamento(LocalDate.of(2018, 04, 26))
				.categoria(Categoria.FICCAO_CIENTIFICA)
				.legendaDisponivel(Arrays.asList("PORTUGUÊS", "INGLÊS", "ESPANHOL"))
				.idiomaDisponivel(Arrays.asList("PORTUGUÊS", "INGLÊS", "ESPANHOL"))
				.integrantes(Arrays.asList(scarlettJohansson, robertDowney, chrisHemsworth))
				.build();
		
		Filme sonic = Filme.builder()
				.nome("Sonic: O Filme")
				.sinopse("Sonic, o porco-espinho azul mais famoso do mundo, se junta com os seus amigos para derrotar o terrível Doutor Eggman, um cientista louco que planeja dominar o mundo, e o Doutor Robotnik, responsável por aprisionar animais inocentes em robôs")
				.dataLancamento(LocalDate.of(2020, 02, 13))
				.categoria(Categoria.ANIMACAO)
				.legendaDisponivel(Arrays.asList("PORTUGUÊS", "INGLÊS", "ESPANHOL"))
				.idiomaDisponivel(Arrays.asList("PORTUGUÊS", "INGLÊS", "ESPANHOL"))
				.integrantes(Arrays.asList(jeffFowler, jimCarrey))
				.build();
		
	  List<Filme> filmes = Arrays.asList(osVingadores, eraUltron, guerraInfinita, sonic);
	  
	  List<Filme> trilogiaVingadores = Arrays.asList(osVingadores, eraUltron, guerraInfinita);
	  
	  scarlettJohansson.setFilmes(trilogiaVingadores);
	  robertDowney.setFilmes(trilogiaVingadores);
	  chrisHemsworth.setFilmes(trilogiaVingadores);
	  
	  jeffFowler.setFilmes(Arrays.asList(sonic));
	  jimCarrey.setFilmes(Arrays.asList(sonic));
	  
	  
	  filmeRepository.saveAll(filmes);
	  integranteRepository.saveAll(integrantes);
	
 		
	}
	
	
}
