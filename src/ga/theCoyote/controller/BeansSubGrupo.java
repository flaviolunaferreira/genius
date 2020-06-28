package ga.theCoyote.controller;

import java.io.Serializable;
import java.util.List;

import ga.theCoyote.Dao.DaoSubGrupo;
import ga.theCoyote.model.ModSubGrupo;

public class BeansSubGrupo implements Serializable{
	
	private final DaoSubGrupo tipoProduto = new DaoSubGrupo();
	
/****************************************************************************************************/	
	public ModSubGrupo salvarSubGrupoController(ModSubGrupo pSubGrupo) {
		return this.tipoProduto.salvarSubGrupoDao(pSubGrupo);
	}

/****************************************************************************************************/
	public boolean atualizarSubGrupoController(ModSubGrupo pSubGrupo) {
		return this.tipoProduto.atualizarSubGrupoDao(pSubGrupo);
	}
	
/****************************************************************************************************/
	public boolean deletarSubGrupoController(int pSubGrupo) {
		return this.tipoProduto.deletarSubGrupoDao(pSubGrupo);
	}
	
/****************************************************************************************************/
	public List<ModSubGrupo> listarSubGrupoController(){
		return this.tipoProduto.listarSubGrupoDao();
	}
	
/****************************************************************************************************/
	public List<ModSubGrupo> pocurarContemNomeSubGrupoController(String pSubGrupo){
		return this.tipoProduto.procurarContemNomeSubGrupoDao(pSubGrupo);
	}
}
