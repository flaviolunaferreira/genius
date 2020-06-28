package ga.theCoyote.controller;

import java.io.Serializable;
import java.util.List;

import ga.theCoyote.Dao.DaoClientes;
import ga.theCoyote.model.ModClientes;

public class BeansClientes implements Serializable{
	
    private final DaoClientes clientes = new DaoClientes();

/****************************************************************************************************/    
    public ModClientes salvarClienteController(ModClientes pCliente){
    		return this.clientes.salvarCliente(pCliente);
    }
/****************************************************************************************************/
    public boolean atualizarClientesController(ModClientes pClientes) {
    	return this.clientes.atualizarClienteDao(pClientes);
    }
    
/****************************************************************************************************/
    public List<ModClientes> listarClientesController(){ 	
    	return clientes.listarClientesDao();
    }

/****************************************************************************************************/
    public List<ModClientes> procurarContemNomeClientesController(String pCliente){
    	return clientes.procurarContemNomeClientesDao(pCliente);
    }
    
/****************************************************************************************************/
    public List<ModClientes> procurarNomeClientesController(String pCliente){
    	return clientes.procurarNomeClientesDao(pCliente);
    }
 
/****************************************************************************************************/
    public List<ModClientes> procurarCpfCgcClientesController(String pCliente){
    	return clientes.procurarCpfCgcClientesDao(pCliente);
    }
/****************************************************************************************************/    
    public boolean deletarClienteController(int pCliente) {
    	return this.clientes.deleteClienteDao(pCliente);
    }

/****************************************************************************************************/    
    public ModClientes procurarIdClienteController(int idCliente) {
    	return this.clientes.procurarIdClienteDao(idCliente);
    }
    
    public List<ModClientes> verSeExisteClientesController(String pNome, String pCpfCgc) {
    	return this.clientes.verSeExisteClienteDao(pNome, pCpfCgc);
    }
    
}
