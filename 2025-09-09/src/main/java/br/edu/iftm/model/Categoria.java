package br.edu.iftm.model;

import java.io.Serializable;
import java.time.Instant;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_categoria")
public class Categoria implements Serializable{	
	private static final long serialVersionUID = 4485355889736263619L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	
	@Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
	private Instant dataCriacao;
	
	@Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
	private Instant dataAtualizacao;
	
	public Categoria() {}
	
	public Categoria(Long id, String nome) {		
		this.id = id;
		this.nome = nome;		
	}
	
	@PrePersist
	public void prePrersist() {
	dataCriacao = Instant.now();
	}
	
	@PreUpdate
	public void preUpdate() {
		dataAtualizacao = Instant.now();
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

	public Instant getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(Instant dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public Instant getDataAtualizacao() {
		return dataAtualizacao;
	}

	public void setDataAtualizacao(Instant dataAtualizacao) {
		this.dataAtualizacao = dataAtualizacao;
	}
}
