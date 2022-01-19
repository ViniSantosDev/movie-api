package br.com.movieapi.movieapi.dto;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import br.com.movieapi.movieapi.entity.Filme;

public class FilmeDTO {
	private Long id;
	private String nome;
	private String categoria;
	private Date dataLancamento;

	public FilmeDTO() {

	}

	public FilmeDTO(Filme filme) {
		this.id = filme.getId();
		this.nome = filme.getNome();
		this.categoria = filme.getCategoria();
		this.dataLancamento = filme.getDataLancamento();
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

	public Date getDataLancamento() {
		return dataLancamento;
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

	public void setDataLancamento(Date dataLancamento) {
		this.dataLancamento = dataLancamento;
	}

	public static List<FilmeDTO> converter(List<Filme> filmes) {
		return filmes.stream().map(FilmeDTO::new).collect(Collectors.toList());
	}

}
