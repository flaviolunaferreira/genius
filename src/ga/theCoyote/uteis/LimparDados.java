package ga.theCoyote.uteis;

import java.awt.Component;

import javax.swing.JPanel;
import javax.swing.JTextField;

public class LimparDados {

	public static void limparDados(JPanel pnl) {
		/* limpa todos os campos de edicao 															*/
		Component[] c = pnl.getComponents();
		for (int i=0; i < pnl.getComponentCount(); i++) {
			if (c[i] instanceof JTextField) {
				JTextField field = (JTextField) c[i];
				field.setText("");
				field.setBorder(null);
			}
		}
	}
}
