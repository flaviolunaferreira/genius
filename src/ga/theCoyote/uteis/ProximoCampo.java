package ga.theCoyote.uteis;

import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFormattedTextField;
import javax.swing.JTextField;

public class ProximoCampo {

	public static void enter(java.awt.event.KeyEvent evt ,JTextField campo){
		if(evt.getKeyCode() == 10) {
			campo.requestFocus();
		}
	}	
	public static void enter(java.awt.event.KeyEvent evt, JCheckBox campo){
		if(evt.getKeyCode() == 10) {
			campo.requestFocus();
		}
	}
	public static void enter(java.awt.event.KeyEvent evt ,JFormattedTextField campo){
		if(evt.getKeyCode() == 10) {
			campo.requestFocus();
		}
	}
	public static void enter(java.awt.event.KeyEvent evt ,JButton campo){
		if(evt.getKeyCode() == 10) {
			campo.requestFocus();
		}
	}
	
	public static void enter(ActionEvent evt ,JTextField campo){
			campo.requestFocus();
	}	
	public static void enter(ActionEvent evt ,JFormattedTextField campo){
			campo.requestFocus();
	}
	public static void enter(ActionEvent evt ,JButton campo){
			campo.requestFocus();
	}
}
