package br.edu.iftm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.iftm.model.Produto;
import br.edu.iftm.service.ProdutoService;

@RestController
@RequestMapping(value = "/produtos")
public class ProdutoController {
	@Autowired
	private ProdutoService produtoService;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Produto> buscaPorId(@PathVariable Long id){
		Produto p = produtoService.buscarPorId(id);
		return ResponseEntity.ok(p);
	}
}
