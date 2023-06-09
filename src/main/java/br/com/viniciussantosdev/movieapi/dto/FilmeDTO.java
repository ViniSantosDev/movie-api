package br.com.viniciussantosdev.movieapi.dto;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import br.com.viniciussantosdev.movieapi.entity.Filme;

public class FilmeDTO {
	private Long id;
	private String nome;
	private String categoria;

	public FilmeDTO() {

	}

	public FilmeDTO(Filme filme) {
		this.id = filme.getId();
		this.nome = filme.getNome();
		this.categoria = filme.getCategoria();
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public static List<FilmeDTO> converter(List<Filme> filmes) {
		return filmes.stream().map(FilmeDTO::new).collect(Collectors.toList());
	}

}
