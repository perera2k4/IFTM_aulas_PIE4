package br.edu.iftm.dto;

import java.io.Serializable;
import java.time.Instant;

import br.edu.iftm.model.Produto;

public class ProdutoDTO implements Serializable{
	private static final long serialVersionUID = 3833699101145385666L;
	
	private Long id;
	private String nome;
	private String descricao;
	private Double preco;
	private String imgUrl;
	private Instant date;
	
	public ProdutoDTO() {}

	public ProdutoDTO(Long id, String nome, String descricao, Double preco, String imgUrl, Instant date) {
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.preco = preco;
		this.imgUrl = imgUrl;
		this.date = date;
	}
	
	public ProdutoDTO(Produto entidade) { 
		this.id = entidade.getId();
		this.nome = entidade.getNome();
		this.descricao = entidade.getDescricao();
		this.preco = entidade.getPreco();
		this.imgUrl = entidade.getImgUrl();
		this.date = entidade.getDate();
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

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public Instant getDate() {
		return date;
	}

	public void setDate(Instant date) {
		this.date = date;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}	
}
