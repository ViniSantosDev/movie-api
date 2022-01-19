package br.com.movieapi.movieapi.dto;

import java.util.Date;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class FilmeUpdateDTO {
	@NotNull(message = "id deve ser informado")
	private Long id;
	@NotEmpty(message = "nome deve ser informado")
	private String nome;
	@NotEmpty(message = "categoria deve ser informada")
	private String categoria;
	@NotNull(message = "data de lançamento deve ser informada")
	private Date dataLancamento;

	public FilmeUpdateDTO() {

	}

	public FilmeUpdateDTO(@NotEmpty(message = "nome deve ser informado") String nome,
			@NotEmpty(message = "categoria deve ser informada") String categoria,
			@NotNull(message = "data de lançamento deve ser informada") Date dataLancamento) {
		super();
		this.nome = nome;
		this.categoria = categoria;
		this.dataLancamento = dataLancamento;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
