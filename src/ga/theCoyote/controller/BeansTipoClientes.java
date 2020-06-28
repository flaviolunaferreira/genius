package ga.theCoyote.controller;

import java.io.Serializable;
import java.util.List;

import ga.theCoyote.Dao.DaoTipoCliente;
import ga.theCoyote.model.ModTipoCliente;

public class BeansTipoClientes implements Serializable{

	private final DaoTipoCliente tipoCliente = new DaoTipoCliente();
	
/****************************************************************************************************/    
    public ModTipoCliente salvarTipoClienteController(ModTipoCliente pTipoCliente){
    		return this.tipoCliente.salvarTipoClienteDao(pTipoCliente);
    }

/****************************************************************************************************/
    public List<ModTipoCliente> listarTipoClienteController(){
        	return tipoCliente.listarTipoClienteDao();
    }
    
/****************************************************************************************************/
    public List<ModTipoCliente> procurarTipoClienteController(String pTipoCliente){
        	return tipoCliente.procurarTipoClienteDao(pTipoCliente);
    }
}
