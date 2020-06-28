package ga.theCoyote.controller;

import java.io.Serializable;
import java.util.List;

import ga.theCoyote.Dao.DaoTipoProduto;
import ga.theCoyote.model.ModTipoProduto;

public class BeansTipoProduto implements Serializable{
	
	private final DaoTipoProduto tipoProduto = new DaoTipoProduto();
	
/****************************************************************************************************/	
	public ModTipoProduto salvarTipoProdutoController(ModTipoProduto pTipoProduto) {
		return this.tipoProduto.salvarTipoProdutoDao(pTipoProduto);
	}

/****************************************************************************************************/
	public boolean atualizarTipoProdutoController(ModTipoProduto pTipoProduto) {
		return this.tipoProduto.atualizarTipoProdutoDao(pTipoProduto);
	}
	
/****************************************************************************************************/
	public boolean deletarTipoProdutoController(int pTipoProduto) {
		return this.tipoProduto.deletarTipoProdutoDao(pTipoProduto);
	}
	
/****************************************************************************************************/
	public List<ModTipoProduto> listarTipoProdutoController(){
		return this.tipoProduto.listarTipoProdutoDao();
	}
	
/****************************************************************************************************/
	public List<ModTipoProduto> pocurarContemNomeTipoProdutoController(String pTipoProduto){
		return this.tipoProduto.procurarContemNomeTipoProdutoDao(pTipoProduto);
	}
}
