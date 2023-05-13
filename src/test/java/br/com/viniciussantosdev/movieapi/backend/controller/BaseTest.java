package br.com.viniciussantosdev.movieapi.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;

import br.com.viniciussantosdev.movieapi.repository.FilmeRepository;

public abstract class BaseTest {

	public static final String PORT = "8080";
	public static final String URL = "http://localhost:" + PORT;

	@Autowired
	protected TestRestTemplate restTemplate;


	@Autowired
	protected FilmeRepository filmeRepository;

}
