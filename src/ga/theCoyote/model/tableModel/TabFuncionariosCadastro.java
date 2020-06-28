package ga.theCoyote.model.tableModel;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import ga.theCoyote.model.ModFuncionarios;

public class TabFuncionariosCadastro extends AbstractTableModel{

	private List<ModFuncionarios> funcionarios;

	private String[] colunas = new String[] {"Id","Nome", "Cpf - CGC"};
	
	public TabFuncionariosCadastro(List<ModFuncionarios> funcionarios) {
		this.funcionarios = funcionarios;
	}
	
	public TabFuncionariosCadastro() {
		this.funcionarios = new ArrayList<ModFuncionarios>();
	}
	
	public int getRowCount() {
		return funcionarios.size();
	}

	public int getColumnCount() {
		return colunas.length;
	}

    @Override
    public String getColumnName(int columnIndex){
      return colunas[columnIndex];
    }    
     
     @Override  
    public Class<?> getColumnClass(int columnIndex) {  
        return String.class;  
    }
     
     public void setValueAt(ModFuncionarios aValue, int rowIndex) {  
         ModFuncionarios funcionario = funcionarios.get(rowIndex);
          
         funcionario.setId(aValue.getId());
         funcionario.setNome(aValue.getNome());
         funcionario.setCpfCgc(aValue.getCpfCgc());        
    
         fireTableCellUpdated(rowIndex, 0);  
         fireTableCellUpdated(rowIndex, 1);  
         fireTableCellUpdated(rowIndex, 2);  
    
     } 
     
//	@Override
//	public Object getValueAt(int linha, int coluna) {
//		ModFuncionarios modFuncionarios = clientes.get(linha);
//		if(coluna == 0) {
//			return modFuncionarios.getId();
//		} else if (coluna == 1){
//			return modFuncionarios.getNome();
//		} else if (coluna == 2) {
//			return modFuncionarios.getCpfCgc();
//		} 
//		return null;
//	}

	@Override  
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {  
      ModFuncionarios funcionario = funcionarios.get(rowIndex);
     switch (columnIndex) {
         case 0:  
             funcionario.setId(Integer.parseInt(aValue.toString()));
         case 1:  
             funcionario.setNome(aValue.toString());             
         case 2:  
             funcionario.setCpfCgc(aValue.toString());             
   
         default:  
             System.err.println("Índice da coluna inválido");
     }  
     fireTableCellUpdated(rowIndex, columnIndex);  
     }      
	
    
    public Object getValueAt(int rowIndex, int columnIndex) {
        ModFuncionarios funcionarioSelecionado = funcionarios.get(rowIndex);
        String valueObject = null;
        switch(columnIndex){
            case 0: valueObject = funcionarioSelecionado.getId().toString(); break;
            case 1: valueObject = funcionarioSelecionado.getNome(); break;
            case 2 : valueObject = funcionarioSelecionado.getCpfCgc(); break;
            default: System.err.println("Índice inválido para propriedade do bean Usuario.class");
        }
         
        return valueObject;
    }
	
    @Override  
    public boolean isCellEditable(int rowIndex, int columnIndex) {  
        return false;  
    }  
   
   
    public ModFuncionarios getFuncionarios(int indiceLinha) {  
        return funcionarios.get(indiceLinha);  
    }  
     
    public void addFuncionarios(ModFuncionarios u) {      
        funcionarios.add(u);  
        int ultimoIndice = getRowCount() - 1;  
        fireTableRowsInserted(ultimoIndice, ultimoIndice);  
    }  
     
    public void removeFuncionario(int indiceLinha) {  
        funcionarios.remove(indiceLinha);  
        fireTableRowsDeleted(indiceLinha, indiceLinha);  
    }  
     
     
    public void addListaDeFuncionarios(List<ModFuncionarios> novosFuncionarios) {  
        int tamanhoAntigo = getRowCount();      
        funcionarios.addAll(novosFuncionarios);    
        fireTableRowsInserted(tamanhoAntigo, getRowCount() - 1);  
    }  
     
    public void limpar() {  
        funcionarios.clear();    
        fireTableDataChanged();  
    }  
   
    public boolean isEmpty() {  
        return funcionarios.isEmpty();  
    }  

}
