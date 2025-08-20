package controller;

import model.Produto;

public class ProdutoController {
	private Produto produto;
	
	public ProdutoController(Produto produto) {
		this.produto = produto;
	}
	
	public void exibirProdutoComDesconto (double desconto){
		double precoComDesconto = this.produto.aplicarDesconto(desconto);
		System.out.printf("Produto: %s, Preço original: R$ %.2f, Com desconto: R$ %.2f", produto.getNome(), produto.getPreco(), precoComDesconto);
	}
}