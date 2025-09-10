package br.edu.iftm.service;

import java.time.Instant;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.edu.iftm.dto.ProdutoDTO;
import br.edu.iftm.model.Produto;
import br.edu.iftm.repositories.ProdutoRepository;

@Service
public class ProdutoService {
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Transactional(readOnly = true)
	public ProdutoDTO buscarPorId(Long id) {
		Produto p = this.produtoRepository.findById(id).get();
		ProdutoDTO pDTO = new ProdutoDTO(p);
		return pDTO;
	}	

	@Transactional(readOnly = true)
	public List<ProdutoDTO> buscarTodos() {		
		List<Produto> lista = this.produtoRepository.findAll();
		return lista.stream().map(x -> new ProdutoDTO(x)).toList();
	}
	
	@Transactional
	public ProdutoDTO inserir(ProdutoDTO produto) {
		Produto entidade = new Produto();
		copiaDTOparaEntidade(produto, entidade);
		entidade.setDate(Instant.now());
		entidade = this.produtoRepository.save(entidade);
		return new ProdutoDTO(entidade);
	}
	
	@Transactional
	public ProdutoDTO atualizar(long id, ProdutoDTO produto) {
		Produto entidade = this.produtoRepository.getOne(id);
		copiaDTOparaEntidade(produto, entidade);
		entidade = this.produtoRepository.save(entidade);
		return new ProdutoDTO(entidade);
	}
	
	@Transactional
	public void deletar(Long id) {
		this.produtoRepository.deleteById(id);
	}
	
	public void copiaDTOparaEntidade(ProdutoDTO produto, Produto entidade) {
		// entidade.setId(produto.getId());
		entidade.setNome(produto.getDescricao());
		entidade.setDescricao(produto.getDescricao());
		entidade.setImgUrl(produto.getImgUrl());
		entidade.setPreco(produto.getPreco());
	}
}
