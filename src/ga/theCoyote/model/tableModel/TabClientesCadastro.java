package ga.theCoyote.model.tableModel;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import ga.theCoyote.model.ModClientes;

public class TabClientesCadastro extends AbstractTableModel{

	private List<ModClientes> clientes;

	private String[] colunas = new String[] {"Id","Nome", "Cpf - CGC"};
	
	public TabClientesCadastro(List<ModClientes> clientes) {
		this.clientes = clientes;
	}
	
	public TabClientesCadastro() {
		this.clientes = new ArrayList<ModClientes>();
	}
	
	public int getRowCount() {
		return clientes.size();
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
     
     public void setValueAt(ModClientes aValue, int rowIndex) {  
         ModClientes cliente = clientes.get(rowIndex);
          
         cliente.setId(aValue.getId());
         cliente.setNome(aValue.getNome());
         cliente.setCpfCgc(aValue.getCpfCgc());        
    
         fireTableCellUpdated(rowIndex, 0);  
         fireTableCellUpdated(rowIndex, 1);  
         fireTableCellUpdated(rowIndex, 2);  
    
     } 
     	
    @Override  
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {  
      ModClientes cliente = clientes.get(rowIndex);
     switch (columnIndex) {
         case 0:  
             cliente.setId(Integer.parseInt(aValue.toString()));
         case 1:  
             cliente.setNome(aValue.toString());             
         case 2:  
             cliente.setCpfCgc(aValue.toString());             
   
         default:  
             System.err.println("Índice da coluna inválido");
     }  
     fireTableCellUpdated(rowIndex, columnIndex);  
     }      
    public Object getValueAt(int rowIndex, int columnIndex) {
        ModClientes clienteSelecionado = clientes.get(rowIndex);
        String valueObject = null;
        switch(columnIndex){
            case 0: valueObject = clienteSelecionado.getId().toString(); break;
            case 1: valueObject = clienteSelecionado.getNome(); break;
            case 2 : valueObject = clienteSelecionado.getCpfCgc(); break;
            default: System.err.println("Índice inválido para propriedade do bean Usuario.class");
        }
        return valueObject;
    }
	
    @Override  
    public boolean isCellEditable(int rowIndex, int columnIndex) {  
        return false;  
    }  
   
   
    public ModClientes getClientes(int indiceLinha) {  
        return clientes.get(indiceLinha);  
    }  
     
    public void addClientes(ModClientes u) {      
        clientes.add(u);  
        int ultimoIndice = getRowCount() - 1;  
        fireTableRowsInserted(ultimoIndice, ultimoIndice);  
    }  
     
    public void removeCliente(int indiceLinha) {  
        clientes.remove(indiceLinha);  
        fireTableRowsDeleted(indiceLinha, indiceLinha);  
    }  
     
     
    public void addListaDeClientes(List<ModClientes> novosClientes) {  
        int tamanhoAntigo = getRowCount();      
        clientes.addAll(novosClientes);    
        fireTableRowsInserted(tamanhoAntigo, getRowCount() - 1);  
    }  
     
    public void limpar() {  
        clientes.clear();    
        fireTableDataChanged();  
    }  
   
    public boolean isEmpty() {  
        return clientes.isEmpty();  
    }  

}
