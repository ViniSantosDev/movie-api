package br.com.viniciussantosdev.movieapi.dto;

import java.util.Date;

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
	 @NotNull(message = "data de lançamento deve ser informada")
	private Date dataLancamento;

	public FilmeInsertDTO() {

	}

	public FilmeInsertDTO(@NotEmpty(message = "nome deve ser informado") String nome,
			@NotEmpty(message = "categoria deve ser informada") String categoria, Date dataLancamento) {
		super();
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

	public Date getDataLancamento() {
		return dataLancamento;
	}

	public void setDataLancamento(Date dataLancamento) {
		this.dataLancamento = dataLancamento;
	}

}

