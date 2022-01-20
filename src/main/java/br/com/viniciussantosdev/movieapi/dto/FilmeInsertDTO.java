package br.com.viniciussantosdev.movieapi.dto;

import java.time.LocalDate;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

public class FilmeInsertDTO {
	@NotEmpty(message = "nome deve ser informado")
	@JsonProperty("nome")
	private String nome;
	@NotEmpty(message = "categoria deve ser informada")
	@JsonProperty("categoria")
	private String categoria;
	private LocalDate dataLancamento;

	public FilmeInsertDTO() {

	}

	public FilmeInsertDTO(@NotEmpty(message = "nome deve ser informado") String nome,
			@NotEmpty(message = "categoria deve ser informada") String categoria, LocalDate dataLancamento) {
		this.nome = nome;
		this.categoria = categoria;
		this.dataLancamento = dataLancamento;
	}
	

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public LocalDate getDataLancamento() {
		return dataLancamento;
	}

	public void setDataLancamento(LocalDate dataLancamento) {
		this.dataLancamento = dataLancamento;
	}

}
