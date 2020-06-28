package ga.theCoyote.uteis;

import java.awt.Color;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class AuxCard {
	public static void montarCard(JPanel pnl) {
		pnl.setBorder(javax.swing.BorderFactory.createEtchedBorder());
		pnl.setLayout(null);
	}
	
	public static void chamarCard(JPanel pnlNovo, JPanel pnlDestino, String titulo, JLabel lblDestino) {
		pnlNovo.setBorder(javax.swing.BorderFactory.createEtchedBorder());
		pnlNovo.setLayout(null);
		pnlDestino.removeAll();
		pnlDestino.add(pnlNovo);
		pnlDestino.validate();
		pnlDestino.repaint();

		lblDestino.setBounds(5, 15, 166, 60);
		lblDestino.setBorder(javax.swing.BorderFactory.createEtchedBorder());
		lblDestino.setForeground(new Color(0, 90, 0));
		lblDestino.setFont(new java.awt.Font("Arial", 3, 24)); 
		lblDestino.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		lblDestino.setVerticalTextPosition(javax.swing.SwingConstants.CENTER);
		lblDestino.setText(titulo);

		pnlNovo.add(lblDestino);

	}
	public static void chamarCard(JPanel pnlNovo, JPanel pnlDestino) {
		pnlDestino.removeAll();
		pnlDestino.add(pnlNovo);
		pnlDestino.validate();
		pnlDestino.repaint();
	}
	
    public static void abrirCard(JPanel cardSaida, JPanel cardEntrada){
        int x = 163;
        int y = 662;
        Thread abrir = new Thread(){
            @Override
            public void run(){
                for(int i = x; i > 0; i--){
                    cardSaida.setSize(i, y);
                    cardSaida.repaint();
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(AuxCard.class.getName()).log(Level.SEVERE, null, ex);
                    }
                        
                }
                cardSaida.setVisible(false);
                cardEntrada.setSize(0, y);
                cardEntrada.setVisible(true);
                for(int i = 0; i <= x; ++i){
                    cardEntrada.setSize(i, y);
                    cardEntrada.repaint();
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(AuxCard.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }                
            }
        };
        abrir.start();
    }

	
}
