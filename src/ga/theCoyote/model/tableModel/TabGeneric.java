package ga.theCoyote.model.tableModel;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

/**
 * AbstractTableModel Genérico
 *
 * @author Iúri Batista Teles 06/2012
 * emails:iuribtt@gmail.com
 * **/
public class TabGeneric extends AbstractTableModel {
	/**
	 *
	 */
	private static final long serialVersionUID = 637459879152140396L;
	private ArrayList<ArrayList<String>> arrLinhas;// Linhas da tabela
	private ArrayList<String> arrColunas;// Titulo da Tabela

	// _____________________________________________________________________________________________________________
	public TabGeneric(ArrayList<ArrayList<String>> linhas, ArrayList<String> colunas) {
		arrLinhas = new ArrayList<ArrayList<String>>();// linhas
		arrColunas = new ArrayList<String>();// Colunas
		// Adiciona os valores aos respectivos arrayLists
		arrLinhas.addAll(linhas);
		arrColunas.addAll(colunas);
	}

	// _____________________________________________________________________________________________________________
	public TabGeneric() {
		arrLinhas = new ArrayList<ArrayList<String>>();// linhas
		arrColunas = new ArrayList<String>();// Colunas
	}

	// _____________________________________________________________________________________________________________
	/** sets e gets, linhas e colunas **/
	public ArrayList<ArrayList<String>> getArrLinhas() {
		return arrLinhas;
	}

	// _____________________________________________________________________________________________________________
	public void setArrLinhas(ArrayList<ArrayList<String>> list) {
		this.arrLinhas = list;
	}

	// _____________________________________________________________________________________________________________
	public ArrayList<String> getArrColunas() {
		return arrColunas;
	}

	// _____________________________________________________________________________________________________________
	public void setArrColunas(ArrayList<String> Column) {
		this.arrColunas = Column;
	}

	/** fim gets e sets para linhas e colunas **/
	// _____________________________________________________________________________________________________________
	/** quantidade de linhas **/
	@Override
	public int getRowCount() {
		// Quantas linhas tem a tabela
		return arrLinhas.size();
	}

	// _____________________________________________________________________________________________________________
	/** quantidade de colunas **/
	@Override
	public int getColumnCount() {
		// Número de colunas da tabela
		return arrColunas.size();
	}

	// _____________________________________________________________________________________________________________
	/** retorna o titulo da coluna **/
	public String getColumnName(int columnIndex) {
		// Informa o nome das colunas
		String colunas[] = (String[]) arrColunas.toArray(new String[arrColunas.size()]);
		return colunas[columnIndex];
	}

	// _____________________________________________________________________________________________________________
	/** retornar os valores das coluna column nas linhas row **/
	@Override
	public Object getValueAt(int row, int column) {
		return arrLinhas.get(row).get(column);
	}

	// _____________________________________________________________________________________________________________
	/** seta os valores iniciais da coluna **/
	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		arrLinhas.get(rowIndex).set(columnIndex, aValue.toString());
		// avisa que os dados mudaram
		fireTableDataChanged();// informa alteração de dados
	}

	// _____________________________________________________________________________________________________________
	/** define como todas as celulas editaveis **/
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		// editáveis, entao retorna true pra todas
		return true;
	}

	// _____________________________________________________________________________________________________________
	/** adicionar linha **/
	public void adicionarLinha() {
		ArrayList<String> array = new ArrayList<String>();
		for (int i = 0; i < arrColunas.size(); i++) {// colunas....
			array.add("");
		}
		arrLinhas.add(array);
		int ultimoIndice = getRowCount() - 1;
		fireTableRowsInserted(ultimoIndice, ultimoIndice);
	}

	// _____________________________________________________________________________________________________________
	/** adicionar linha com posição **/
	public void adicionarLinha(int posicao) {
		ArrayList<String> array = new ArrayList<String>();
		for (int i = 0; i < arrColunas.size(); i++) {// colunas....
			array.add("");
		}
		arrLinhas.add(posicao + 1, array);
		int ultimoIndice = getRowCount() - 1;
		fireTableRowsInserted(ultimoIndice, ultimoIndice);
	}

	// _____________________________________________________________________________________________________________
	/** remoção de linha **/
	public void removerLinha(int posicao) {
		arrLinhas.remove(posicao);
		fireTableRowsDeleted(posicao, posicao);// reoganização da tabela
	}

	// _____________________________________________________________________________________________________________
	/** adicionar coluna **/
	public void adicionarColuna(String titulo) {
		arrColunas.add(titulo);// Informa o titulo da nova coluna
		for (int i = 0; i < arrLinhas.size(); i++) {
			arrLinhas.get(i).add("");
		}
		fireTableDataChanged();// informa ateração de dados
		fireTableStructureChanged();// Informa que a tabela foi modificada
	}

	// _____________________________________________________________________________________________________________
	/** adicionar coluna com posição **/
	public void adicionarColuna(int posicao, String titulo) {
		arrColunas.add(posicao + 1, titulo);// Informa a posição e o titulo da
		// nova coluna
		for (int i = 0; i < arrLinhas.size(); i++) {
			arrLinhas.get(i).add(posicao + 1, "");// Informa a posição e o valor
		}
		fireTableDataChanged();// informa ateração de dados
		fireTableStructureChanged();// Informa que a tabela foi modificada
	}

	// _____________________________________________________________________________________________________________
	/** remover coluna **/
	public void removerColuna(int coluna) {
		if (coluna > -1) { // verifica se alguma coluna está selecionada
			arrColunas.remove(coluna);// remove a coluna do titulo
			for (int i = 0; i < arrLinhas.size(); i++) {
				arrLinhas.get(i).remove(coluna);
			}
			fireTableDataChanged();// informa ateração de dados
			fireTableStructureChanged();// Informa que a tabela foi modificada
		}
	}
	
	
}
