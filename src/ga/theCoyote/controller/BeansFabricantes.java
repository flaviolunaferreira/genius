package ga.theCoyote.controller;

import java.io.Serializable;
import java.util.List;

import ga.theCoyote.Dao.DaoFabricantes;
import ga.theCoyote.model.ModFabricantes;


public class BeansFabricantes implements Serializable{

	private final DaoFabricantes fabricantes = new DaoFabricantes();
	
/****************************************************************************************************/    
    public ModFabricantes salvarFabricantesController(ModFabricantes pFabricantes){
    		return this.fabricantes.salvarFabricantesDao(pFabricantes);
    }

/****************************************************************************************************/
    public List<ModFabricantes> listarFabricantesController(){
        	return fabricantes.listarFabricantesDao();
    }
    
/****************************************************************************************************/
    public List<ModFabricantes> procurarFabricantesController(String pCliente){
        	return fabricantes.procurarFabricantesDao(pCliente);
    }
}
