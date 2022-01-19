package br.com.movieapi.movieapi.controller;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.movieapi.movieapi.dto.*;
import br.com.movieapi.movieapi.services.FilmeServices;
import javassist.NotFoundException;

@RestController
@RequestMapping("filmes")
public class FilmeController {

	@Autowired
	FilmeServices filmeServices;

	@GetMapping
	public ResponseEntity<Page<FilmeDTO>> getAllFilme() throws Exception {
		try {
			Page<FilmeDTO> result = filmeServices.findAllFilme();
			return ResponseEntity.status(HttpStatus.OK).body(result);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
		}
	}

	@GetMapping("/{codigo}")
	public ResponseEntity<FilmeDTO> getOneFilme(@PathVariable("codigo") long id) throws Exception {
		try {
			FilmeDTO result = filmeServices.findOneFilme(id);
			return ResponseEntity.status(HttpStatus.OK).body(result);
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
		} catch (NotFoundException e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}

	@PostMapping
	public ResponseEntity<FilmeDTO> postFilmes(@RequestBody @Valid FilmeInsertDTO body) throws Exception {
		try {
			FilmeDTO result = filmeServices.postFilmes(body);
			return ResponseEntity.status(HttpStatus.CREATED).body(result);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
		}

	}

	@PutMapping("/{id}")
	public ResponseEntity<FilmeDTO> putFilme(@RequestBody @Valid FilmeUpdateDTO body) throws Exception {
		try {
			FilmeDTO result = filmeServices.putFilme(body);
			return ResponseEntity.status(HttpStatus.OK).body(result);
		} catch (NotFoundException e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<FilmeDTO> deleteFilme(@PathVariable long id) throws Exception {
		try {
			FilmeDTO result = filmeServices.deleteFilme(id);
			return ResponseEntity.status(HttpStatus.OK).body(result);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
		}
	}

}
