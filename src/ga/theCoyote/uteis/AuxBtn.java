package ga.theCoyote.uteis;

import java.awt.Component;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class AuxBtn {
	/* vou escrever um metodo para ajudar na montagem dos botoes do sistema							*/
	/* comessando com os butoes na posição vertical													*/
	public static void montarBotaoV(JButton nome, JPanel local, int linha) {
		int x[] = {5, 40, 166, 48};
		nome.setHorizontalAlignment(SwingConstants.LEFT);
		nome.setBounds(x[0], x[1]+((x[3]+4)* linha), x[2], x[3]);
		nome.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		local.add(nome);
	}
	
	/* agora na horizontal																			*/
	public static void montarButaoH(JButton nome,JPanel local, int posicao) {
		int x[] = {10, 7, 100, 46};
		nome.setHorizontalAlignment(SwingConstants.CENTER);
		nome.setBounds((x[0]+((x[2]* posicao)+5)), x[1], x[2], x[3]);
		nome.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		local.add(nome);
	}

	/* na segunda vou adicionar uma opcao coluna e colocar os botoes um pouco maior.				*/
	/* neste caso vou usar a coluna como indece ou seja, comece com 0 para que a soma dê certo		*/
	public static void montarButao(JButton nome, JPanel local, int coluna, int linha) {
		int x[] = {5, 5, 150, 48};
		nome.setHorizontalAlignment(SwingConstants.LEFT);
		nome.setBounds(x[0]+((x[2]* coluna)+5), x[1]+((x[3]+4)* linha), x[2], x[3]);
		nome.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		local.add(nome);
		
	}
	
	/* vou criar um metodo para desativar todos os botoes de um painel								*/
	public static void desativarBotoes(JPanel painel) {
		Component[] c = painel.getComponents();        		
		for (int i=0; i < painel.getComponentCount(); i++) {
			if (c[i] instanceof JButton) {
				JButton butao = (JButton) c[i];
				butao.setEnabled(false);
			}
		}
	}
	/* agora o metodo para ativar todos os botoes de um painel */
	public static void ativarBotoes(JPanel painel) {
		Component[] c = painel.getComponents();        		
		for (int i=0; i < painel.getComponentCount(); i++) {
			if (c[i] instanceof JButton) {
				JButton butao = (JButton) c[i];
				butao.setEnabled(true);
			}
		}
	}
}
