package ga.theCoyote.model.tableModel;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import ga.theCoyote.model.ModProdutos;

public class TabProdutosCadastro extends AbstractTableModel{

	private List<ModProdutos> lProdutos;

	private String[] colunas = new String[] {"Id","Descrição", "Preço R$"};

	public TabProdutosCadastro(List<ModProdutos> pProdutos) {
		this.lProdutos = pProdutos;
	}

	public TabProdutosCadastro() {
		this.lProdutos = new ArrayList<ModProdutos>();
	}

	public int getRowCount() {
		return lProdutos.size();
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

	public void setValueAt(ModProdutos aValue, int rowIndex) {  
		ModProdutos produtos = lProdutos.get(rowIndex);

		produtos.setIdProduto(aValue.getIdProduto());
		produtos.setDescricao(aValue.getDescricao());
		produtos.setPrecoVenda(aValue.getPrecoVenda());        

		fireTableCellUpdated(rowIndex, 0);  
		fireTableCellUpdated(rowIndex, 1);  
		fireTableCellUpdated(rowIndex, 2);  

	} 

	@Override  
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {  
		ModProdutos produtos = lProdutos.get(rowIndex);
		switch (columnIndex) {
		case 0:  
			produtos.setIdProduto(aValue.toString());
		case 1:  
			produtos.setDescricao(aValue.toString());             
		case 2:  
			produtos.setPrecoVenda(new BigDecimal(Integer.parseInt(aValue.toString())));             

		default:  
			System.err.println("Índice da coluna inválido");
		}  
		fireTableCellUpdated(rowIndex, columnIndex);  
	}      
	public Object getValueAt(int rowIndex, int columnIndex) {
		ModProdutos produtoSelecionado = lProdutos.get(rowIndex);
		String valueObject = null;
		switch(columnIndex){
		case 0: valueObject = produtoSelecionado.getIdProduto(); break;
		case 1: valueObject = produtoSelecionado.getDescricao(); break;
		case 2 : valueObject = produtoSelecionado.getPrecoVenda().toString(); break;
		default: System.err.println("Índice inválido para propriedade do bean Usuario.class");
		}
		return valueObject;
	}

	@Override  
	public boolean isCellEditable(int rowIndex, int columnIndex) {  
		return false;  
	}  


	public ModProdutos getProdutos(int indiceLinha) {  
		return lProdutos.get(indiceLinha);  
	}  

	public void addProdutos(ModProdutos u) {      
		lProdutos.add(u);  
		int ultimoIndice = getRowCount() - 1;  
		fireTableRowsInserted(ultimoIndice, ultimoIndice);  
	}  

	public void removeProdutos(int indiceLinha) {  
		lProdutos.remove(indiceLinha);  
		fireTableRowsDeleted(indiceLinha, indiceLinha);  
	}  


	public void addListaDeProdutos(List<ModProdutos> novosProdutos) {  
		int tamanhoAntigo = getRowCount();      
		lProdutos.addAll(novosProdutos);    
		fireTableRowsInserted(tamanhoAntigo, getRowCount() - 1);  
	}  

	public void limpar() {  
		lProdutos.clear();    
		fireTableDataChanged();  
	}  

	public boolean isEmpty() {  
		return lProdutos.isEmpty();  
	}  


}
