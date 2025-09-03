package br.edu.iftm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.iftm.model.Produto;
import br.edu.iftm.service.ProdutoService;

@RestController
@RequestMapping(value = "/produtos")
public class ProdutoController {
	@Autowired
	private ProdutoService produtoService;
	
	// GET
	@GetMapping()
	public ResponseEntity<List<Produto>> buscarTodos(){
		List<Produto> p = produtoService.buscarTodos();
		return ResponseEntity.ok().body(p);
	}
	
	// GET/id
	@GetMapping(value = "/{id}")
	public ResponseEntity<Produto> buscarPorId(@PathVariable Long id){
		Produto p = produtoService.buscarPorId(id);
		return ResponseEntity.ok(p);
	}
	
	// POST
	@PostMapping()
	public ResponseEntity<Produto> inserir(@RequestBody Produto produto){
		Produto p = this.produtoService.inserir(produto);
		return new ResponseEntity<>(p, HttpStatus.CREATED);
	}
	
	// PUT / PATCH
	@PutMapping(value = "/{id}")
	public ResponseEntity<Produto> atualizar(@PathVariable Long id, @RequestBody Produto produto) {
		Produto p = this.produtoService.atualizar(id, produto);
		return ResponseEntity.ok().body(p);
	}
	
	// DELETE
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> deletar(@PathVariable Long id) {
		produtoService.deletar(id);
		return ResponseEntity.noContent().build();
	}
	
}
