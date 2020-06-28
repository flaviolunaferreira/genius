package ga.theCoyote.controller;

import java.util.List;

import ga.theCoyote.Dao.DaoSituacaoCliente;
import ga.theCoyote.model.ModSituacaoCliente;

public class BeansSituacaoCliente {

	private final DaoSituacaoCliente situacaoCliente = new DaoSituacaoCliente();
	
/****************************************************************************************************/    
    public ModSituacaoCliente salvarSituacaoClienteController(ModSituacaoCliente pSituacaoCliente){
    		return this.situacaoCliente.salvarSituacaoCliente(pSituacaoCliente);
    }

/****************************************************************************************************/
    public List<ModSituacaoCliente> listarSituacaoClienteController(){
        	return situacaoCliente.listaTodasSituacoesClientes();
    }
    
/****************************************************************************************************/
    public List<ModSituacaoCliente> procurarSituacaoClienteController(String pSituacaoCliente){
        	return situacaoCliente.procurarSituacaoCliente(pSituacaoCliente);
    }
}
