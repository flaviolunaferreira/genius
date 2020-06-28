package ga.theCoyote.model.tableModel;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import ga.theCoyote.model.ModFornecedores;

public class TabFornecedoresCadastro extends AbstractTableModel{

	private List<ModFornecedores> fornecedores;

	private String[] colunas = new String[] {"Id","Nome", "Cpf - CGC"};
	
	public TabFornecedoresCadastro(List<ModFornecedores> fornecedores) {
		this.fornecedores = fornecedores;
	}
	
	public TabFornecedoresCadastro() {
		this.fornecedores = new ArrayList<ModFornecedores>();
	}
	
	public int getRowCount() {
		return fornecedores.size();
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
     
     public void setValueAt(ModFornecedores aValue, int rowIndex) {  
         ModFornecedores fornecedor = fornecedores.get(rowIndex);
          
         fornecedor.setId(aValue.getId());
         fornecedor.setNome(aValue.getNome());
         fornecedor.setCpfcgc(aValue.getCpfcgc());        
    
         fireTableCellUpdated(rowIndex, 0);  
         fireTableCellUpdated(rowIndex, 1);  
         fireTableCellUpdated(rowIndex, 2);  
    
     } 
     
//	@Override
//	public Object getValueAt(int linha, int coluna) {
//		ModFornecedores modFornecedores = clientes.get(linha);
//		if(coluna == 0) {
//			return modFornecedores.getId();
//		} else if (coluna == 1){
//			return modFornecedores.getNome();
//		} else if (coluna == 2) {
//			return modFornecedores.getCpfCgc();
//		} 
//		return null;
//	}

	@Override  
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {  
      ModFornecedores fornecedor = fornecedores.get(rowIndex);
     switch (columnIndex) {
         case 0:  
             fornecedor.setId(Integer.parseInt(aValue.toString()));
         case 1:  
             fornecedor.setNome(aValue.toString());             
         case 2:  
             fornecedor.setCpfcgc(aValue.toString());             
   
         default:  
             System.err.println("Índice da coluna inválido");
     }  
     fireTableCellUpdated(rowIndex, columnIndex);  
     }      
	
    
    public Object getValueAt(int rowIndex, int columnIndex) {
        ModFornecedores fornecedorSelecionado = fornecedores.get(rowIndex);
        String valueObject = null;
        switch(columnIndex){
            case 0: valueObject = fornecedorSelecionado.getId().toString(); break;
            case 1: valueObject = fornecedorSelecionado.getNome(); break;
            case 2 : valueObject = fornecedorSelecionado.getCpfcgc(); break;
            default: System.err.println("Índice inválido para propriedade do bean Usuario.class");
        }
         
        return valueObject;
    }
	
    @Override  
    public boolean isCellEditable(int rowIndex, int columnIndex) {  
        return false;  
    }  
   
   
    public ModFornecedores getFornecedores(int indiceLinha) {  
        return fornecedores.get(indiceLinha);  
    }  
     
    public void addFornecedores(ModFornecedores u) {      
        fornecedores.add(u);  
        int ultimoIndice = getRowCount() - 1;  
        fireTableRowsInserted(ultimoIndice, ultimoIndice);  
    }  
     
    public void removeFornecedor(int indiceLinha) {  
        fornecedores.remove(indiceLinha);  
        fireTableRowsDeleted(indiceLinha, indiceLinha);  
    }  
     
     
    public void addListaDeFornecedores(List<ModFornecedores> novosFornecedores) {  
        int tamanhoAntigo = getRowCount();      
        fornecedores.addAll(novosFornecedores);    
        fireTableRowsInserted(tamanhoAntigo, getRowCount() - 1);  
    }  
     
    public void limpar() {  
        fornecedores.clear();    
        fireTableDataChanged();  
    }  
   
    public boolean isEmpty() {  
        return fornecedores.isEmpty();  
    }  

}
