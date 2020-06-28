package ga.theCoyote.model.forms;

import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.plaf.basic.BasicInternalFrameUI;

import ga.theCoyote.uteis.AuxBtn;
import ga.theCoyote.view.PrincipalView;

public abstract class ModeloCadastro extends JInternalFrame{	
	
	public String acao = null;
	
	public ModeloCadastro() {
		inicialize();	
	}
	
	protected final void inicialize() {
		
		pnlContainer = new JPanel(null);
		pnlCadastro = new JPanel(null);
		pnlApoio = new JPanel(null);
		pnlTitulo = new JPanel(null);
		pnlBotoes = new JPanel(null);
		lblTitulo = new JLabel("Teste");
		btnFechar = new JButton("Fechar", new ImageIcon(getClass().getResource("icons/voltar.png")));
		btnNovo = new JButton("Novo", new ImageIcon(getClass().getResource("icons/novo.png")));
		btnSalvar = new JButton("Salvar", new ImageIcon(getClass().getResource("icons/salvar.png")));
		btnEditar = new JButton("Editar", new ImageIcon(getClass().getResource("icons/editar.png")));
		btnCancelar = new JButton("Cancelar", new ImageIcon(getClass().getResource("icons/cancelar.png")));
		btnApagar = new JButton("Apagar", new ImageIcon(getClass().getResource("icons/apagar.png")));
		btnPesquisa = new JButton(new ImageIcon(getClass().getResource("icons/procurar.png")));
		txtPesquisa = new JTextField();
		pnlInformacoes = new JPanel(null);
		tabApoio = new JTable();
		pnlTabela = new JPanel();
		jsTabApoio = new JScrollPane(tabApoio);
		
		setBounds(0, 0, 1169, 643);
		((BasicInternalFrameUI)this.getUI()).setNorthPane(null);
		
		pnlContainer.setBounds(0, 0, 1169, 643);
		getContentPane().add(pnlContainer);
		
		pnlCadastro.setBounds(5, 5, 648, 560);
        pnlCadastro.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        
        pnlTitulo.setBounds(5, 5, 638, 50);
        pnlTitulo.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        pnlCadastro.add(pnlTitulo);
        
        pnlApoio.setBounds(658, 5, 494, 560);
        pnlApoio.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        
        pnlBotoes.setBounds(5, 570, 1147, 60);
        pnlBotoes.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        
        pnlInformacoes.setBorder(javax.swing.BorderFactory.createEtchedBorder());
		pnlInformacoes.setBounds(5, 5, 484, 243);
		
		pnlTabela.setLayout(new GridLayout(1, 1));
		pnlTabela.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		pnlTabela.setBounds(4, 250, 486, 305);
		jsTabApoio.setBounds(4, 250, 486, 305);
		tabApoio.setBounds(4, 250, 486, 304);			
		txtPesquisa.setBounds(670, 15, 400, 30);	
		btnPesquisa.setBounds(1075, 10, 40, 40);
		
		
			AuxBtn.montarButaoH(btnNovo, pnlBotoes, 1);
        		btnNovo.addActionListener((ActionEvent e) -> {
        			acaoBtnNovo(pnlCadastro);        			
        		});
        		btnNovo.addKeyListener(new java.awt.event.KeyAdapter() {
        			@Override
        			public void keyPressed(java.awt.event.KeyEvent evt) {
        				if(evt.getKeyCode() == 10) {
        					acaoBtnNovo(pnlCadastro);
        				}
        			}
        		});
        	AuxBtn.montarButaoH(btnSalvar, pnlBotoes, 2);
        		btnSalvar.addActionListener((ActionEvent e) -> {
        			acaoBtnSalvar(pnlCadastro);
        		});
        		btnSalvar.addKeyListener(new java.awt.event.KeyAdapter() {
        			@Override
        			public void keyPressed(java.awt.event.KeyEvent evt) {
        				if(evt.getKeyCode() == 10) {
        					acaoBtnSalvar(pnlCadastro);
        				}
        			}
        		});

        	AuxBtn.montarButaoH(btnEditar, pnlBotoes, 3);
        		btnEditar.addActionListener((ActionEvent e) -> {
        			acaoBtnEditar(pnlCadastro);
        		});
        	AuxBtn.montarButaoH(btnCancelar, pnlBotoes, 4);
        		btnCancelar.addActionListener((ActionEvent e) -> {
        			acaoBtnCancelar(pnlCadastro);
        		});
        	AuxBtn.montarButaoH(btnApagar, pnlBotoes, 5);
        		btnApagar.addActionListener((ActionEvent e) -> {
        			acaoBtnApagar(pnlCadastro);
        		});
        	AuxBtn.montarButaoH(btnFechar, pnlBotoes, 0);
        		btnFechar.addActionListener((ActionEvent e) -> {
        			AuxBtn.ativarBotoes(PrincipalView.menuCadastro);
        			this.dispose();
        		});
        	pnlBotoes.add(txtPesquisa);
        	pnlBotoes.add(btnPesquisa);
        
        pnlContainer.add(pnlCadastro);
        pnlContainer.add(pnlApoio);
        pnlContainer.add(pnlBotoes);
        
		lblTitulo.setBounds(20, 10, 600, 45);
        lblTitulo.setFont(new java.awt.Font("Yu Gothic", 2, 28)); 
        lblTitulo.setForeground(new Color(0, 0, 55));
        lblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo.setText("Paine de Título");
        lblTitulo.setFocusable(false);
        lblTitulo.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
		pnlTitulo.add(lblTitulo);
		
		pnlApoio.add(pnlInformacoes);
		
		pnlApoio.add(pnlTabela);
		pnlTabela.add(jsTabApoio);
				
        btnNovo.setEnabled(true);
        btnSalvar.setEnabled(false);
        btnEditar.setEnabled(false);
        btnCancelar.setEnabled(false);
        btnApagar.setEnabled(false);
        
/* definindo os eventos do mouse																	*/
        
		btnFechar.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent evt) {
				if(btnFechar.isEnabled() == true) {
					PrincipalView.lblTituloAjuda.setText("Botão Fechar");
					PrincipalView.lblMensagemAjuda.setText("<html>Fecha o formulário de cadastro atual.");
				} else {
					PrincipalView.lblTituloAjuda.setText("Botão Inativo");
					PrincipalView.lblMensagemAjuda.setText("<html>Esse botão não esta liberado agora.");
				}
			}
		});
        
		btnNovo.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent evt) {
				PrincipalView.lblTituloAjuda.setText("Botão Novo");
				PrincipalView.lblMensagemAjuda.setText("<html>Abre os campos de cadastro para incluir um novo.");
			}
		});

		btnSalvar.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent evt) {
				PrincipalView.lblTituloAjuda.setText("Botão Salvar");
				PrincipalView.lblMensagemAjuda.setText("<html>Salva o formulário atual no banco de dados.");
			}
		});
		
		btnEditar.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent evt) {
				PrincipalView.lblTituloAjuda.setText("Botão Editar");
				PrincipalView.lblMensagemAjuda.setText("<html>Possibilita a alteração no cadastro.");
			}
		});
		
		btnCancelar.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent evt) {
				PrincipalView.lblTituloAjuda.setText("Botão Cancelar");
				PrincipalView.lblMensagemAjuda.setText("<html>Cancela a edição atual do cadastro. Isso não apaga o cadastro que já foi salvo.");
			}
		});
		
		btnApagar.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent evt) {
				PrincipalView.lblTituloAjuda.setText("Botão Apagar");
				PrincipalView.lblMensagemAjuda.setText("<html>Apaga o cadastro atual do banco de dados.");
			}
		});
       
	}
	
	protected JPanel pnlContainer;
	protected JPanel pnlCadastro;
	protected JPanel pnlApoio;
	protected JPanel pnlBotoes;
	protected JPanel pnlTitulo;
	protected JButton btnFechar;
	protected JButton btnNovo;
	protected JButton btnSalvar;
	protected JButton btnEditar;
	protected JButton btnCancelar;
	protected JButton btnApagar;
	protected JButton btnPesquisa;
	protected JLabel lblTitulo;
	protected JTable tabApoio;
	protected JPanel pnlInformacoes;
	protected JScrollPane jsTabApoio;
	protected JPanel pnlTabela;
	protected JTextField txtPesquisa;


	public JLabel getLblTitulo() {
		return lblTitulo;
	}

	public void setLblTitulo(JLabel lblTitulo) {
		this.lblTitulo = lblTitulo;
	}
	
	/**
	 * Ativa os botões salvar, cancelar e deixa os campos editáveis.
	 * @param Painel que contém os campos de edição.
	 */
	protected void acaoBtnNovo(JPanel pnl) {
        btnNovo.setEnabled(false);
        btnSalvar.setEnabled(true);
        btnCancelar.setEnabled(true);
        btnFechar.setEnabled(false);
        acao = "novo";
        txtPesquisa.setText("");
        Component[] c = pnl.getComponents();        		
        for (int i=0; i < pnl.getComponentCount(); i++) {
            if (c[i] instanceof JTextField) {
                JTextField field = (JTextField) c[i];
                field.setText("");
                field.setEnabled(true);
            }
        }
        for( int i=0; i < pnl.getComponentCount(); i++) {
        	if(c[i] instanceof JCheckBox) {
        		JCheckBox field = (JCheckBox) c[i];
        		field.setEnabled(true);
        	}
        }
	}
	
	/**
	 * Ativa os botões novo, fechar e deixa os campos editáveis.
	 * @param Painel que contém os campos de edição.
	 */
	protected void acaoBtnSalvar(JPanel pnl) {
        btnNovo.setEnabled(true);
        btnSalvar.setEnabled(false);
        btnCancelar.setEnabled(false);
        btnFechar.setEnabled(true);
        txtPesquisa.setText("");
        acao = null;
        Component[] c = pnl.getComponents();        		
        for (int i=0; i < pnl.getComponentCount(); i++) {
            if (c[i] instanceof JTextField) {
                JTextField field = (JTextField) c[i];
                field.setEnabled(false);
                
            }    
            if(c[i] instanceof JCheckBox) {
            	JCheckBox field = (JCheckBox) c[i];
            	field.setEnabled(false);
            }
        }
	}
	
	protected void acaoBtnCancelar(JPanel pnl) {
        btnNovo.setEnabled(true);
        btnSalvar.setEnabled(false);
        btnCancelar.setEnabled(false);
        btnFechar.setEnabled(true);
        txtPesquisa.setText("");
        acao = null;
        Component[] c = pnl.getComponents();        		
        for (int i=0; i < pnl.getComponentCount(); i++) {
            if (c[i] instanceof JTextField) {
                JTextField field = (JTextField) c[i];
                field.setEnabled(false);
                
            }    
            if(c[i] instanceof JCheckBox) {
            	JCheckBox field = (JCheckBox) c[i];
            	field.setEnabled(false);
            }
        }
	}

	/**
	 * @param pnl
	 */
	protected void acaoBtnApagar(JPanel pnl) {
        btnNovo.setEnabled(true);
        btnSalvar.setEnabled(false);
        btnCancelar.setEnabled(false);
        btnFechar.setEnabled(true);
        txtPesquisa.setText("");
		acao = "salvar";
        Component[] c = pnl.getComponents();        		
        for (int i=0; i < pnl.getComponentCount(); i++) {
            if (c[i] instanceof JTextField) {
                JTextField field = (JTextField) c[i];
                field.setEnabled(false);;
            }    
        }
	}
	
	/**
	 * Ativa os Botões e deixa os campos selecionados editaveis.
	 * @param painel que contém os compos a serem desativados
	 */
	protected void acaoBtnEditar(JPanel pnl) {
        btnNovo.setEnabled(false);
        btnSalvar.setEnabled(true);
        btnCancelar.setEnabled(true);
        btnFechar.setEnabled(false);
        txtPesquisa.setText("");
        acao = "editar";
        
        Component[] c = pnl.getComponents();        		
        for (int i=0; i < pnl.getComponentCount(); i++) {
            if (c[i] instanceof JTextField) {
                JTextField field = (JTextField) c[i];
                field.setEnabled(true);
            }
        }    
	}

}
