package ga.theCoyote.controller;

import java.io.Serializable;
import java.util.List;

import ga.theCoyote.Dao.DaoCep;
import ga.theCoyote.model.ModCep;

public class BeansCep implements Serializable{
	
    private final DaoCep cep = new DaoCep();

/****************************************************************************************************/    
    public ModCep salvarCepController(ModCep pCep){
        cep.salvarCep(pCep);
        return pCep;
    }
    
/****************************************************************************************************/
    public ModCep atualizarCepController(ModCep pCep) {
    	cep.atualizarCepDao(pCep);
    	return pCep;
    }
    
/****************************************************************************************************/    
    public boolean deleteCepController(int pCep) {
    	return cep.deleteCepDao(pCep);
    }
    
/****************************************************************************************************/    
    public List<ModCep> pesquisaCepController(){ 	
    	return cep.listarCepDao();
    }
    
/****************************************************************************************************/
    public List<ModCep> procurarCepController(String pCep){ 	
    	return cep.procurarCepDao(pCep);
    }

/****************************************************************************************************/
    public List<ModCep> procurarEnderecoController(String pEndereco){
    	return cep.procurarEnderecoDao(pEndereco);
    }
/****************************************************************************************************/    
    public List<ModCep> verSeExisteEnderecoController(String pRua, String pCep){
    	return cep.verSeExisteEnderecoDao(pRua, pCep);
    }
        
}
