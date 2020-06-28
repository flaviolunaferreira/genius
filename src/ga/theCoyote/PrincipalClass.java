package ga.theCoyote;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

import ga.theCoyote.view.PrincipalView;

public class PrincipalClass {

	public static void main(String[] args) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    UIManager.put( "nimbusFocus", new Color(  0, 255, 50 ) );   					// vou mudar um pouco a cor do focus
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PrincipalClass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null,"erro carregando o modelo da tela! -> PrincipalClass.");
        }
		PrincipalView principal = new PrincipalView();
		principal.setExtendedState(principal.getExtendedState()|JFrame.MAXIMIZED_BOTH);
		principal.setVisible(true);

	}

}
