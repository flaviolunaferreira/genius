package ga.theCoyote.controller;

import java.io.Serializable;
import java.util.List;

import ga.theCoyote.Dao.DaoFuncionarios;
import ga.theCoyote.model.ModFuncionarios;

public class BeansFuncionarios implements Serializable{
	
    private final DaoFuncionarios funcionarios = new DaoFuncionarios();

/****************************************************************************************************/    
    public ModFuncionarios salvarFuncionarioController(ModFuncionarios pFuncionario){
    		return this.funcionarios.salvarFuncionario(pFuncionario);
    }
/****************************************************************************************************/
    public boolean atualizarFuncionariosController(ModFuncionarios pFuncionarios) {
    	return this.funcionarios.atualizarFuncionarioDao(pFuncionarios);
    }
    
/****************************************************************************************************/
    public List<ModFuncionarios> listarFuncionariosController(){ 	
    	return funcionarios.listarFuncionariosDao();
    }

/****************************************************************************************************/
    public List<ModFuncionarios> procurarContemNomeFuncionariosController(String pFuncionario){
    	return funcionarios.procurarContemNomeFuncionariosDao(pFuncionario);
    }
    
/****************************************************************************************************/
    public List<ModFuncionarios> procurarNomeFuncionariosController(String pFuncionario){
    	return funcionarios.procurarNomeFuncionariosDao(pFuncionario);
    }
 
/****************************************************************************************************/
    public List<ModFuncionarios> procurarCpfCgcFuncionariosController(String pFuncionario){
    	return funcionarios.procurarCpfCgcFuncionariosDao(pFuncionario);
    }
/****************************************************************************************************/    
    public boolean deletarFuncionarioController(int pFuncionario) {
    	return this.funcionarios.deleteFuncionarioDao(pFuncionario);
    }

/****************************************************************************************************/    
    public ModFuncionarios procurarIdFuncionarioController(int idFuncionario) {
    	return this.funcionarios.procurarIdFuncionarioDao(idFuncionario);
    }
    
    public List<ModFuncionarios> verSeExisteFuncionariosController(String pNome, String pCpfCgc) {
    	return this.funcionarios.verSeExisteFuncionarioDao(pNome, pCpfCgc);
    }
    
}
