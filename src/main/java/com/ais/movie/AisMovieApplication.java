package com.ais.movie;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.ais.movie.service.FilmeDBService;

import lombok.extern.slf4j.Slf4j;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@Slf4j
public class AisMovieApplication {
	
	@Autowired
	private FilmeDBService filmeDBService;
	
	public static void main(String[] args) {
		SpringApplication.run(AisMovieApplication.class, args);
		log.info("Aplicação inicializada");
	}

	@Bean
	public ModelMapper modelMapper() {
	    return new ModelMapper();
	}
	@Bean
    public Docket api() { 
        return new Docket(DocumentationType.SWAGGER_2)  
          .select()                                  
          .apis(RequestHandlerSelectors.any())              
          .paths(PathSelectors.any())                          
          .build();                                           
    }
	
	@Bean
	public void cargaInicialBanco() {
		filmeDBService.cargaInicial();
	}
	
}
