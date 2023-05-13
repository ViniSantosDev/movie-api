package br.com.viniciussantosdev.movieapi.backend.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import br.com.viniciussantosdev.movieapi.dto.FilmeDTO;
import br.com.viniciussantosdev.movieapi.entity.Filme;

@SpringBootTest(webEnvironment = WebEnvironment.DEFINED_PORT)
public class FilmeControllerTest extends BaseTest {

	private static final String FILME = "/filmes/";
	private static final Long ID = 1L;
	private static final Long FAKE = 100L;
	private static StringBuilder path = new StringBuilder(URL);

	@BeforeEach
	void inicializar() {
	FilmeDTO dto = new FilmeDTO();
		path.append(FILME);
	}

	@AfterEach
	void finalizar() {
		path = new StringBuilder(URL);
	}

	@Test
	void esperaEncontrarFilmePorId() {

		String pathFilme = path.toString() + ID;

		ParameterizedTypeReference<FilmeDTO> responseType = new ParameterizedTypeReference<>() {
		};
		ResponseEntity<FilmeDTO> response = this.restTemplate.exchange(pathFilme.toString(), HttpMethod.GET, null,
				responseType);

		Filme filme = filmeRepository.findById(ID).get();
		assertEquals(ID, filme.getId());
		assertEquals(HttpStatus.OK, response.getStatusCode());
	}

	@Test
	void esperaNaoEncontrarFilmePorID() {

		String pathFilme = path.toString() + FAKE;

		ParameterizedTypeReference<FilmeDTO> responseType = new ParameterizedTypeReference<>() {
		};
		ResponseEntity<FilmeDTO> response = this.restTemplate.exchange(path.toString(), HttpMethod.GET, null,
				responseType);

		assertEquals(HttpStatus.OK, response.getStatusCode());

	}

}
