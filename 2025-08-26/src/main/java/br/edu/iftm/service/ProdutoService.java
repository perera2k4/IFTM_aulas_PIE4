package br.edu.iftm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.iftm.model.Produto;
import br.edu.iftm.repositories.ProdutoRepository;

@Service
public class ProdutoService {
	@Autowired
	private ProdutoRepository produtoRepository;
	
	public Produto buscarPorId(Long id) {
		Produto p = this.produtoRepository.findById(id).get();
		return p;
	}
}
