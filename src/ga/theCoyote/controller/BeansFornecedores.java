package ga.theCoyote.controller;

import java.io.Serializable;
import java.util.List;

import ga.theCoyote.Dao.DaoFornecedores;
import ga.theCoyote.model.ModFornecedores;

public class BeansFornecedores implements Serializable{
	
    private final DaoFornecedores fornecedores = new DaoFornecedores();

/****************************************************************************************************/    
    public ModFornecedores salvarFornecedorController(ModFornecedores pFornecedor){
    	return this.fornecedores.salvarFornecedores(pFornecedor);
}
/****************************************************************************************************/
    public boolean atualizarFornecedoresController(ModFornecedores pFornecedores) {
    	return this.fornecedores.atualizarFornecedorDao(pFornecedores);
    }
    
/****************************************************************************************************/
    public List<ModFornecedores> listarFornecedoresController(){ 	
    	return fornecedores.listarFornecedoresDao();
    }

/****************************************************************************************************/
    public List<ModFornecedores> procurarContemNomeFornecedoresController(String pFornecedor){
    	return fornecedores.procurarContemNomeFornecedoresDao(pFornecedor);
    }
    
/****************************************************************************************************/
    public List<ModFornecedores> procurarNomeFornecedoresController(String pFornecedor){
    	return fornecedores.procurarNomeFornecedoresDao(pFornecedor);
    }
 
/****************************************************************************************************/
    public List<ModFornecedores> procurarCpfCgcFornecedoresController(String pFornecedor){
    	return fornecedores.procurarCpfCgcFornecedoresDao(pFornecedor);
    }
/****************************************************************************************************/    
    public boolean deletarFornecedorController(int pFornecedor) {
    	return this.fornecedores.deleteFornecedorDao(pFornecedor);
    }

/****************************************************************************************************/    
    public ModFornecedores procurarIdFornecedorController(int idFornecedor) {
    	return this.fornecedores.procurarIdFornecedorDao(idFornecedor);
    }
    
    public List<ModFornecedores> verSeExisteFornecedoresController(String pNome, String pCpfCgc) {
    	return this.fornecedores.verSeExisteFornecedorDao(pNome, pCpfCgc);
    }
    
}
