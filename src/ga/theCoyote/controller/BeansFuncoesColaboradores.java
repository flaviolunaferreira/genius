package ga.theCoyote.controller;

import java.io.Serializable;
import java.util.List;

import ga.theCoyote.Dao.DaoFuncoesColaboradores;
import ga.theCoyote.model.ModFuncoesColaboradores;

public class BeansFuncoesColaboradores implements Serializable{
	
    private final DaoFuncoesColaboradores funcoesColaboradores = new DaoFuncoesColaboradores();

/****************************************************************************************************/    
    public ModFuncoesColaboradores salvarFuncaoColaboradorController(ModFuncoesColaboradores pFuncaoColaborador){
    		return this.funcoesColaboradores.salvarFuncoesColaboradores(pFuncaoColaborador);
    }
/****************************************************************************************************/
    public boolean atualizarFuncoesColaboradoresController(ModFuncoesColaboradores pFuncoesColaboradores) {
    	return this.funcoesColaboradores.atualizarFuncaoCalaboradorDao(pFuncoesColaboradores);
    }
    
/****************************************************************************************************/
    public List<ModFuncoesColaboradores> listarFuncoesColaboradoresController(){ 	
    	return funcoesColaboradores.listarFuncoesColaboradoresDao();
    }

/****************************************************************************************************/
    public List<ModFuncoesColaboradores> procurarContemNomeFuncoesColaboradoresController(String pFuncaoColaborador){
    	return funcoesColaboradores.procurarContemNomeFuncoesColaboradoresDao(pFuncaoColaborador);
    }
    
/****************************************************************************************************/
    public List<ModFuncoesColaboradores> procurarNomeFuncoesColaboradoresController(String pFuncaoColaborador){
    	return funcoesColaboradores.procurarNomeFuncoesColaboradoresDao(pFuncaoColaborador);
    }
 
/****************************************************************************************************/
    public boolean deletarFuncaoColaboradorController(int pFuncaoColaborador) {
    	return this.funcoesColaboradores.deleteFuncaoColaboradorDao(pFuncaoColaborador);
    }

/****************************************************************************************************/    
    
}
