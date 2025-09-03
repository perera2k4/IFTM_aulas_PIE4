package br.edu.iftm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.edu.iftm.model.Produto;
import br.edu.iftm.repositories.ProdutoRepository;

@Service
public class ProdutoService {
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Transactional(readOnly = true)
	public Produto buscarPorId(Long id) {
		Produto p = this.produtoRepository.findById(id).get();
		return p;
	}	

	@Transactional(readOnly = true)
	public List<Produto> buscarTodos() {		
		return this.produtoRepository.findAll();
	}
	
	@Transactional
	public Produto inserir(Produto produto) {
		Produto entidade = this.produtoRepository.save(produto);
		return entidade;
	}
	
	@Transactional
	public Produto atualizar(long id, Produto produto) {
		Produto entidade = this.produtoRepository.getOne(id);
		entidade = this.produtoRepository.save(entidade);
		return entidade;		
	}
	
	@Transactional
	public void deletar(Long id) {
		this.produtoRepository.deleteById(id);
	}
}
