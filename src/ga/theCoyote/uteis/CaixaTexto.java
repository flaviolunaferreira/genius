package ga.theCoyote.uteis;

import java.awt.Component;

import javax.swing.JCheckBox;
import javax.swing.JFormattedTextField;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CaixaTexto {
	
/**	
 * @param painel que contém os campos de edição à serem abilitados
 */
	public static void ativar(JPanel painel) {
		Component[] c = painel.getComponents();        		
		for (int i=0; i < painel.getComponentCount(); i++) {
			if (c[i] instanceof JTextField) {
				JTextField field = (JTextField) c[i];
				field.setEnabled(true);
				field.setText("");
			}
			if (c[i] instanceof JFormattedTextField) {
				JFormattedTextField field = (JFormattedTextField) c[i];
				field.setEnabled(true);
				field.setText("");
			}
			if (c[i] instanceof JCheckBox) {
				JCheckBox field = (JCheckBox) c[i];
				field.setEnabled(true);
				field.setSelected(false);
			}			
		}
	}
	
/**
 * {@code}
 * @param painel que contém os campos de edição a serem desabilitados
 * @return -> Void
 */ 
	public static void desativar(JPanel painel) {
		Component[] c = painel.getComponents();        		
		for (int i=0; i < painel.getComponentCount(); i++) {
			if (c[i] instanceof JTextField) {
				JTextField field = (JTextField) c[i];
				field.setEnabled(false);
				field.setText("");
			}
			if (c[i] instanceof JFormattedTextField) {
				JFormattedTextField field = (JFormattedTextField) c[i];
				field.setEnabled(false);
				field.setText("");
			}
			if (c[i] instanceof JCheckBox) {
				JCheckBox field = (JCheckBox) c[i];
				field.setEnabled(false);
			}			
		}
	}

}
