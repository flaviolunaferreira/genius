package ga.theCoyote.view;

import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import ga.theCoyote.model.forms.ModeloCadastro;
import ga.theCoyote.uteis.AuxData;
import ga.theCoyote.uteis.ProximoCampo;

public class ProdutosView extends ModeloCadastro{

	public ProdutosView() {
		inicializa();
		setVisible(true);
		lblTitulo.setText("Cadastro de Produtos");
	}
	
	public final void inicializa() {
		
		numero = NumberFormat.getInstance();
		numero.setMinimumFractionDigits(2);
		
		lblId = new JLabel("Id Produto");
		lblCadastro = new JLabel("Cadastro");
		lblDescricao = new JLabel("Descrição");
		lblFabricante = new JLabel("Fabricante");
		lblTipo = new JLabel("Tipo");
		lblGrupo = new JLabel("Grupo");
		lblSubGrupo = new JLabel("SubGrupo");
		lblPesoBruto = new JLabel("Peso Bruto");
		lblPesoLiquido = new JLabel("Peso Liq.");
		lblUnidade = new JLabel("Un"); 
		lblFamilia = new JLabel("F. Tribut.");
		lblPrecoVenda = new JLabel("Venda R$");
		
		txtId = new JTextField();
		txtCadastro = new JFormattedTextField() ;
		txtDescricao = new JTextField();
		txtFabricante = new JTextField();
		txtTipo = new JTextField();
		txtGrupo = new JTextField();
		txtSubGrupo = new JTextField();
		txtPesoBruto = new JFormattedTextField();
		txtPesoLiquido = new JFormattedTextField(2);
		txtUnidade = new JTextField(); 
		txtFamilia = new JTextField();
		txtPrecoVenda = new JTextField();
		
		
		txtPesoBruto.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,##0.0000"))));
		txtPesoLiquido.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,##0.0000"))));
		
		txtPesoBruto.setHorizontalAlignment(SwingConstants.RIGHT);
		txtPesoBruto.setColumns(10);
		
		txtPesoLiquido.setHorizontalAlignment(SwingConstants.RIGHT);
		txtPesoLiquido.setColumns(10);
		
		
		lblId.setBounds(30, 80, 100, 25); 															// largura total 648
		lblCadastro.setBounds(350, 80, 100, 25);
		lblDescricao.setBounds(30, 110, 100, 25);
		lblFabricante.setBounds(30, 140, 100, 25);
		lblTipo.setBounds(30, 170, 100, 25);
		lblFamilia.setBounds(350, 170, 80, 25);
		lblGrupo.setBounds(30, 200, 100, 25);
		lblSubGrupo.setBounds(350, 200, 80, 25);
		lblUnidade.setBounds(30, 230, 100, 25);
		lblPrecoVenda.setBounds(350, 230, 80, 25);
		lblPesoBruto.setBounds(30, 260, 200, 25);
		lblPesoLiquido.setBounds(350, 260, 80, 25);

		txtId.setBounds(110, 80, 100, 25); 															// largura total 648
		txtCadastro.setBounds(411, 80, 205, 25);
		txtDescricao.setBounds(110, 110, 508, 25);
		txtFabricante.setBounds(110, 140, 508, 25);
		txtTipo.setBounds(110, 170, 200, 25);
		txtFamilia.setBounds(410, 170, 208, 25);
		txtGrupo.setBounds(110, 200, 200, 25);
		txtSubGrupo.setBounds(410, 200, 208, 25);
		txtUnidade.setBounds(110, 230, 200, 25);
		txtPrecoVenda.setBounds(410, 230, 208, 25);
		txtPesoBruto.setBounds(110, 260, 200, 25);
		txtPesoLiquido.setBounds(410, 260, 208, 25);
	 	
		pnlCadastro.add(lblId);
		pnlCadastro.add(lblCadastro);
		pnlCadastro.add(lblDescricao);
		pnlCadastro.add(lblFabricante);
		pnlCadastro.add(lblTipo);
		pnlCadastro.add(lblFamilia);
		pnlCadastro.add(lblGrupo);
		pnlCadastro.add(lblSubGrupo);
		pnlCadastro.add(lblUnidade);
		pnlCadastro.add(lblPrecoVenda);
		pnlCadastro.add(lblPesoBruto);
		pnlCadastro.add(lblPesoLiquido);
		
		pnlCadastro.add(txtId);
		pnlCadastro.add(txtCadastro);
		pnlCadastro.add(txtDescricao);
		pnlCadastro.add(txtFabricante);
		pnlCadastro.add(txtTipo);
		pnlCadastro.add(txtFamilia);
		pnlCadastro.add(txtGrupo);
		pnlCadastro.add(txtSubGrupo);
		pnlCadastro.add(txtUnidade);
		pnlCadastro.add(txtPrecoVenda);
		pnlCadastro.add(txtPesoBruto);
		pnlCadastro.add(txtPesoLiquido);		

/****************************************************************************************************/
/* comecando os eventos																				*/
/****************************************************************************************************/	
		 
		txtId.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
			public void keyPressed(java.awt.event.KeyEvent evt) {
				ProximoCampo.enter(evt, txtCadastro);
	        }
	     });

		 txtCadastro.addKeyListener(new java.awt.event.KeyAdapter() {
             @Override
			 public void keyPressed(java.awt.event.KeyEvent evt) {
				 ProximoCampo.enter(evt, txtDescricao);
	         }
	     });
		 txtDescricao.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
			public void keyPressed(java.awt.event.KeyEvent evt) {
				ProximoCampo.enter(evt, txtFabricante);
	        }
	     });
		 txtFabricante.addKeyListener(new java.awt.event.KeyAdapter() {
             @Override
			 public void keyPressed(java.awt.event.KeyEvent evt) {
				 ProximoCampo.enter(evt, txtTipo);
	         }
	      });
		 txtTipo.addKeyListener(new java.awt.event.KeyAdapter() {
             @Override
			 public void keyPressed(java.awt.event.KeyEvent evt) {
				 ProximoCampo.enter(evt, txtFamilia);
	         }
	      });
		 txtFamilia.addKeyListener(new java.awt.event.KeyAdapter() {
             @Override
			 public void keyPressed(java.awt.event.KeyEvent evt) {
				 ProximoCampo.enter(evt, txtGrupo);
	         }
	      });

		 txtGrupo.addKeyListener(new java.awt.event.KeyAdapter() {
             @Override
			 public void keyPressed(java.awt.event.KeyEvent evt) {
				 ProximoCampo.enter(evt, txtSubGrupo);
	         }
	      });
		 txtSubGrupo.addKeyListener(new java.awt.event.KeyAdapter() {
             @Override
			 public void keyPressed(java.awt.event.KeyEvent evt) {
				 ProximoCampo.enter(evt, txtUnidade);
	         }
	      });
		 txtUnidade.addKeyListener(new java.awt.event.KeyAdapter() {
             @Override
			 public void keyPressed(java.awt.event.KeyEvent evt) {
				 ProximoCampo.enter(evt, txtPrecoVenda);
	         }
	      });
		 txtPrecoVenda.addKeyListener(new java.awt.event.KeyAdapter() {
             @Override
			 public void keyPressed(java.awt.event.KeyEvent evt) {
				 ProximoCampo.enter(evt, txtPesoBruto);
	         }
	      });
		 
		 txtPesoBruto.addKeyListener(new java.awt.event.KeyAdapter() {
             @Override
			 public void keyPressed(java.awt.event.KeyEvent evt) {
				 ProximoCampo.enter(evt, txtPesoLiquido);
	         }
	      });
		 
		 txtPesoLiquido.addKeyListener(new java.awt.event.KeyAdapter() {
             @Override
			 public void keyPressed(java.awt.event.KeyEvent evt) {
				 ProximoCampo.enter(evt, btnSalvar);
	         }
	      });
		 
/****************************************************************************************************/
/* defenindo os eventos do mause																	*/		 
/****************************************************************************************************/

		  
		 
/****************************************************************************************************/
/* Trabalhando com opainel de botões do cadastro de Produtos.									*/
/****************************************************************************************************/		 
		 
		 btnSalvar.addKeyListener(new java.awt.event.KeyAdapter() {		
             @Override
			 public void keyPressed(java.awt.event.KeyEvent evt) {
				 ProximoCampo.enter(evt, btnNovo);
				 acaoBtnSalvar(pnlCadastro);

	         }
	      });
		 btnSalvar.addActionListener((ActionEvent evt) -> {
				 ProximoCampo.enter(evt, btnNovo);
		});
		 
		 btnNovo.addKeyListener(new java.awt.event.KeyAdapter() {
             @Override
			 public void keyPressed(java.awt.event.KeyEvent evt) {
				ProximoCampo.enter(evt, txtId);
				acaoBtnNovo(pnlCadastro);

			 }
	     });
		 
		 btnNovo.addActionListener((ActionEvent evt) -> {
				ProximoCampo.enter(evt, txtId);
				acaoBtnNovo(pnlCadastro);

		});
		 
/****************************************************************************************************/
/* Trabalhando a ajuda para o cadastro de produtos													*/
/****************************************************************************************************/		 
		 pnlBotoes.addMouseListener(new MouseAdapter() {
             @Override
			 public void mouseEntered(MouseEvent evt) {
				 PrincipalView.lblTituloAjuda.setText("");
				 PrincipalView.lblMensagemAjuda.setText("");
			 }
		});
		 btnNovo.addMouseListener(new MouseAdapter() {
            @Override
			public void mouseEntered(MouseEvent evt) {
				PrincipalView.lblTituloAjuda.setText("Botãoo Novo");
				PrincipalView.lblMensagemAjuda.setText("<html>Use esta opinião para incluir um novo produto no cadastro.");
			}
		});
		 
		btnSalvar.addMouseListener(new MouseAdapter() {
            @Override
			public void mouseEntered(MouseEvent evt) {
				PrincipalView.lblTituloAjuda.setText("Botãoo Salvar");
				PrincipalView.lblMensagemAjuda.setText("<html>Salva as informaçãoes digitadas no cadastro de produtos no banco de dados.");
			}
		});
		
		btnFechar.addMouseListener(new MouseAdapter() {
            @Override
			public void mouseEntered(MouseEvent evt) {
				PrincipalView.lblTituloAjuda.setText("Botão Fechar");
				PrincipalView.lblMensagemAjuda.setText("<html>Fecha a tela de cadastro.");
			}
		});
		 
/*__________________________________________________________________________________________________*/		
/*	 Agora vou trabalhar o focus de cada componente													*/
/*__________________________________________________________________________________________________*/		

		 txtCadastro.addFocusListener(new java.awt.event.FocusAdapter() {
				public void focusGained(java.awt.event.FocusEvent evt) {
					Date data = new Date();
					SimpleDateFormat out = new SimpleDateFormat("dd/MM/yyyy");
					String resultado = out.format(data);
					txtCadastro.setText(resultado);

					PrincipalView.lblTituloAjuda.setText("Data Cadastro");
					PrincipalView.lblMensagemAjuda.setText("<html>Informe ou confirme a data do cadastro do produto.");
				}
				public void focusLost(java.awt.event.FocusEvent evt) {
					if(!AuxData.dataCerta(txtCadastro.getText())) {
						JOptionPane.showMessageDialog(null, "Você precisa informar uma data de cadastro VALIDA!!!");
						txtCadastro.requestFocus();
					}
				}
			}); 
	
		 
	}
	
	public NumberFormat numero;	
	
	private JLabel lblId;
	private JLabel lblCadastro;
	private JLabel lblDescricao;
	private JLabel lblFabricante;
	private JLabel lblTipo;
	private JLabel lblGrupo;
	private JLabel lblSubGrupo;
	private JLabel lblPesoBruto;
	private JLabel lblPesoLiquido;
	private JLabel lblUnidade; 
	private JLabel lblFamilia;
	private JLabel lblPrecoVenda;
	
	private JTextField txtId;
	private JFormattedTextField txtCadastro;
	private JTextField txtDescricao;
	private JTextField txtFabricante;
	private JTextField txtTipo;
	private JTextField txtGrupo;
	private JTextField txtSubGrupo;
	private JFormattedTextField txtPesoBruto;
	private JFormattedTextField txtPesoLiquido;
	private JTextField txtUnidade; 
	private JTextField txtFamilia;
	private JTextField txtPrecoVenda;

/************************************************************************************************/
/* Essa é a área dos eventos que devem ser usados mais de uma vêz								*/
/************************************************************************************************/

}
