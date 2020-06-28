package ga.theCoyote.controller;

import java.io.Serializable;

import ga.theCoyote.Dao.DaoProdutos;
import ga.theCoyote.model.ModProdutos;

public class BeansProdutos implements Serializable{
	
	private final DaoProdutos produtos = new  DaoProdutos();
	
	public ModProdutos salvarProdutosController(ModProdutos pProduto) {
		return this.produtos.salvarProdutosDao(pProduto);
	}
	
}
