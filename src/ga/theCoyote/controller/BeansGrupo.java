package ga.theCoyote.controller;

import java.io.Serializable;
import java.util.List;

import ga.theCoyote.Dao.DaoGrupo;
import ga.theCoyote.model.ModGrupo;

public class BeansGrupo implements Serializable{
	
	private final DaoGrupo tipoProduto = new DaoGrupo();
	
/****************************************************************************************************/	
	public ModGrupo salvarGrupoController(ModGrupo pGrupo) {
		return this.tipoProduto.salvarGrupoDao(pGrupo);
	}

/****************************************************************************************************/
	public boolean atualizarGrupoController(ModGrupo pGrupo) {
		return this.tipoProduto.atualizarGrupoDao(pGrupo);
	}
	
/****************************************************************************************************/
	public boolean deletarGrupoController(int pGrupo) {
		return this.tipoProduto.deletarGrupoDao(pGrupo);
	}
	
/****************************************************************************************************/
	public List<ModGrupo> listarGrupoController(){
		return this.tipoProduto.listarGrupoDao();
	}
	
/****************************************************************************************************/
	public List<ModGrupo> pocurarContemNomeGrupoController(String pGrupo){
		return this.tipoProduto.procurarContemNomeGrupoDao(pGrupo);
	}
}
