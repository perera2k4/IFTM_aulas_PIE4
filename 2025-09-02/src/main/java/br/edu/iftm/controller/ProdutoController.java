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
	
	@GetMapping
	public ResponseEntity<List<Produto>> buscarTodos(){
		List<Produto> lista = produtoService.buscarTodos();
		return ResponseEntity.ok().body(lista);		
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Produto> buscaPorId(@PathVariable Long id){
		Produto produto = produtoService.buscarPorId(id);
		return ResponseEntity.ok().body(produto);
	}
	
	@PostMapping
	public ResponseEntity<Produto> inserir(@RequestBody Produto produto){
		Produto entidade = produtoService.inserir(produto);
		return ResponseEntity.status(HttpStatus.CREATED).body(entidade);
		//return new ResponseEntity<>(produto, HttpStatus.CREATED);
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Produto> atualizar(@PathVariable Long id, @RequestBody Produto produto){
		Produto produtoAtualizado = produtoService.atualizar(id, produto);
		return  ResponseEntity.ok().body(produtoAtualizado);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		produtoService.deletar(id);
		return ResponseEntity.noContent().build();
	}
}
