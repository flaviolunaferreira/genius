package ga.theCoyote.controller;

import java.io.Serializable;
import java.util.List;

import ga.theCoyote.Dao.DaoFamiliaTributaria;
import ga.theCoyote.model.ModFamiliaTributaria;

public class BeansFamiliaTributaria implements Serializable{
	
	private final DaoFamiliaTributaria tipoProduto = new DaoFamiliaTributaria();
	
/****************************************************************************************************/	
	public ModFamiliaTributaria salvarFamiliaTributariaController(ModFamiliaTributaria pFamiliaTributaria) {
		return this.tipoProduto.salvarFamiliaTributariaDao(pFamiliaTributaria);
	}

/****************************************************************************************************/
	public boolean atualizarFamiliaTributariaController(ModFamiliaTributaria pFamiliaTributaria) {
		return this.tipoProduto.atualizarFamiliaTributariaDao(pFamiliaTributaria);
	}
	
/****************************************************************************************************/
	public boolean deletarFamiliaTributariaController(int pFamiliaTributaria) {
		return this.tipoProduto.deletarFamiliaTributariaDao(pFamiliaTributaria);
	}
	
/****************************************************************************************************/
	public List<ModFamiliaTributaria> listarFamiliaTributariaController(){
		return this.tipoProduto.listarFamiliaTributariaDao();
	}
	
/****************************************************************************************************/
	public List<ModFamiliaTributaria> pocurarContemNomeFamiliaTributariaController(String pFamiliaTributaria){
		return this.tipoProduto.procurarContemNomeFamiliaTributariaDao(pFamiliaTributaria);
	}
}
