package view;

import controller.ProdutoController;
import model.Produto;

public class Principal {
	public static void main(String[] args) {
		Produto p = new Produto("Notebook", 4500.00);
		ProdutoController controller = new ProdutoController(p);

		controller.exibirProdutoComDesconto(10);
	}
}