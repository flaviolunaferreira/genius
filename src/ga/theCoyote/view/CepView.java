package ga.theCoyote.view;

import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import ga.theCoyote.controller.BeansCep;
import ga.theCoyote.model.ModCep;
import ga.theCoyote.model.forms.ModeloCadastro;
import ga.theCoyote.uteis.CaixaTexto;
import ga.theCoyote.uteis.CorrigeTexto;
import ga.theCoyote.uteis.FormartarCampo;
import ga.theCoyote.uteis.ProximoCampo;
import ga.theCoyote.uteis.TextoGeral;

public class CepView extends ModeloCadastro{
	
	BeansCep beansCep = new BeansCep();
	
	public CepView() {
		inicializa();
		setVisible(true);

		lblTitulo.setText("Cadastro de Endereços");
		
	}
	
	public final void inicializa() {
		
		
		/* inicializando nome dos campos  															*/
		lblEndereco = new JLabel("Endereço");
		lblBairro = new JLabel("Bairro");
		lblCidade = new JLabel("Cidade");
		lblCep = new JLabel("Cep");
		lblUf = new JLabel("UF");
		lblReferencia = new JLabel("Referencia");
		
		/* agora os campos de edição																*/
		txtEndereco = new JTextField(64);
		txtBairro = new JTextField(32);
		txtCidade = new JTextField(32);
		txtCep = new JFormattedTextField();
		txtUf = new JTextField(2);
		txtReferencia = new JTextField(64);

		/* vou usar esta rotina para limitar o tamanho dos campos e fazer uma pre-validação.			*/
		txtEndereco.setDocument(new TextoGeral(64));
		txtBairro.setDocument(new TextoGeral(32));
		txtCidade.setDocument(new TextoGeral(32));
		txtUf.setDocument(new TextoGeral(2));
		txtReferencia.setDocument(new TextoGeral(64));			
		
		FormartarCampo.formatarCep(txtCep);
		
		lblEndereco.setBounds(30, 140, 100, 27);
		lblBairro.setBounds(30, 170, 80, 27);
		lblCidade.setBounds(350, 170, 100, 27);
		lblCep.setBounds(30, 200, 80, 27);
		lblUf.setBounds(350, 200, 100, 27);
		lblReferencia.setBounds(30, 230, 80, 27);
		
		txtEndereco.setBounds(110, 140, 508, 27);
		txtBairro.setBounds(110, 170, 200, 27);
		txtCidade.setBounds(410, 170, 208, 27);
		txtCep.setBounds(110, 200, 200, 27);
		txtUf.setBounds(410, 200, 208, 27);
		txtReferencia.setBounds(110, 230, 508, 27);
				
		pnlCadastro.add(lblEndereco);
		pnlCadastro.add(lblBairro);
		pnlCadastro.add(lblCidade);
		pnlCadastro.add(lblCep);
		pnlCadastro.add(lblUf);
		pnlCadastro.add(lblReferencia);
		
		pnlCadastro.add(txtEndereco);
		pnlCadastro.add(txtBairro);
		pnlCadastro.add(txtCidade);
		pnlCadastro.add(txtCep);
		pnlCadastro.add(txtUf);
		pnlCadastro.add(txtReferencia);

/****************************************************************************************************/
/* comecando os eventos																				*/
/****************************************************************************************************/	
		/* vou colocar todos os campos de edicao com a propriedade enabled = false					
		 *  e ativar a medida que for precisando*/
		CaixaTexto.desativar(pnlCadastro);		

		tabApoio.setEnabled(false);
		List<ModCep> listaCep = new ArrayList<ModCep>();											// definindo uma lista com base no nosso modelo
		listaCep = beansCep.pesquisaCepController();												// essa e nossa lista de clientes
		popularTabelaCep(listaCep);																	// vamos popular a tabela com essa lista
		
/* quando uma tecla enter for pressionada nos campos de edicao										*/		
		txtEndereco.addKeyListener(new java.awt.event.KeyAdapter() {
			@Override
			public void keyPressed(java.awt.event.KeyEvent evt) {
				int tabLinha = 0;
				List<ModCep> procurarEndereco = new ArrayList<ModCep>();
				procurarEndereco = beansCep.procurarEnderecoController(txtEndereco.getText());
				popularTabelaCep(procurarEndereco);
				if(evt.getKeyCode() == 10) {
					txtBairro.requestFocus();
					if(procurarEndereco.size()>0) {													// pega sempre o primeiro
						txtEndereco.setText(procurarEndereco.get(tabLinha).getRua());
						txtBairro.setText(procurarEndereco.get(tabLinha).getBairro());
						txtCidade.setText(procurarEndereco.get(tabLinha).getCidade());
						txtReferencia.setText(procurarEndereco.get(tabLinha).getReferencia());
						txtUf.setText(procurarEndereco.get(tabLinha).getUf());
						txtCep.setText(procurarEndereco.get(tabLinha).getCep());
					}
				}
			}
		});			
		
		txtBairro.addKeyListener(new java.awt.event.KeyAdapter() {
			@Override
			public void keyPressed(java.awt.event.KeyEvent evt) {ProximoCampo.enter(evt, txtCidade);}
		});			

		txtCidade.addKeyListener(new java.awt.event.KeyAdapter() {
			@Override
			public void keyPressed(java.awt.event.KeyEvent evt) {ProximoCampo.enter(evt, txtCep);}
		});			

		txtCep.addKeyListener(new java.awt.event.KeyAdapter() {
			@Override
			public void keyPressed(java.awt.event.KeyEvent evt) {ProximoCampo.enter(evt, txtUf);}
		});			

		txtUf.addKeyListener(new java.awt.event.KeyAdapter() {
			@Override
			public void keyPressed(java.awt.event.KeyEvent evt) {ProximoCampo.enter(evt, txtReferencia);}
		});			

		txtReferencia.addKeyListener(new java.awt.event.KeyAdapter() {
			@Override
			public void keyPressed(java.awt.event.KeyEvent evt) {ProximoCampo.enter(evt, btnSalvar);}
		});			
		
/* Agora vou trabalhar o focus de cada componente													*/
        
        txtEndereco.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
				PrincipalView.lblTituloAjuda.setText("Endereco");
				PrincipalView.lblMensagemAjuda.setText("<html>Informe o endereço do cliente.");

				List<ModCep> listaCep = new ArrayList<ModCep>();
				listaCep = beansCep.pesquisaCepController();
				popularTabelaCep(listaCep);
				
            }
            @Override
            public void focusLost(java.awt.event.FocusEvent evt) {
                String novo = CorrigeTexto.corrige(txtEndereco.getText());                				// pega o texto digitado e mandar para a correção
                txtEndereco.setText(novo);                                                				// retorna o texto digitado já corrigido                
            }
        });
        
        txtBairro.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
				PrincipalView.lblTituloAjuda.setText("Bairro");
				PrincipalView.lblMensagemAjuda.setText("<html>Informe o nome do bairro referente ao endereço.");
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                String novo = CorrigeTexto.corrige(txtBairro.getText());                			// pega o texto digitado e mandar para a correção
                txtBairro.setText(novo);                                                			// retorna o texto digitado já corrigido
            }
        });
        
        txtCidade.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
				PrincipalView.lblTituloAjuda.setText("Cidade");
				PrincipalView.lblMensagemAjuda.setText("<html>Informe o nome da cidade referente ao endereço do cliente.");
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                String novo = CorrigeTexto.corrige(txtCidade.getText());              				// pega o texto digitado e mandar para a correção
                txtCidade.setText(novo);                                               				// retorna o texto digitado já corrigido

            }
        });
        
        txtCep.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
				PrincipalView.lblTituloAjuda.setText("Cep");
				PrincipalView.lblMensagemAjuda.setText("<html>Informe o CEP referente ao endereço do cliente.");
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                
            }
        });
        
        txtUf.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
				PrincipalView.lblTituloAjuda.setText("Estado");
				PrincipalView.lblMensagemAjuda.setText("<html>Informe o Estado referente ao endereço do Cliente.");
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
            	txtUf.setText(txtUf.getText().toUpperCase());
            }
        });
        
        txtReferencia.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
				PrincipalView.lblTituloAjuda.setText("Referencia");
				PrincipalView.lblMensagemAjuda.setText("<html>Informe uma referencia para o endereço do cliente. EX: perto da lona do Sr. manoel.");
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                String novo = CorrigeTexto.corrige(txtReferencia.getText());              				// pega o texto digitado e mandar para a correção
                txtReferencia.setText(novo);                                               				// retorna o texto digitado já corrigido            	
            }
        });
        
		
/****************************************************************************************************/
/* Trabalhando com o painel de botões do cadastro de Enderecos										*/
/****************************************************************************************************/		
		/* mudando a cor do focus */
		//txtId.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0,0,255)));
		//txtId.setBorder(null);
		        
        
		btnSalvar.addActionListener((ActionEvent evt) -> {
			ProximoCampo.enter(evt, btnNovo);
	        String tRua = getDadosInterfaceCep().getRua();
	        String tCep = getDadosInterfaceCep().getCep();
	        if(beansCep.verSeExisteEnderecoController(tRua, tCep ).isEmpty()) {
	        	ModCep modCep = getDadosInterfaceCep();
	        	beansCep.salvarCepController(modCep);
	        }	
	        tabApoio.updateUI();
			List<ModCep> lCep = new ArrayList<ModCep>();											// definindo uma lista com base no nosso modelo
			lCep = beansCep.pesquisaCepController();												// essa e nossa lista de clientes
			popularTabelaCep(lCep);	
		});

        
		btnSalvar.addKeyListener(new java.awt.event.KeyAdapter() {
			@Override
			public void keyPressed(java.awt.event.KeyEvent evt) {
				ProximoCampo.enter(evt, btnNovo);
		        String tRua = getDadosInterfaceCep().getRua();
		        String tCep = getDadosInterfaceCep().getCep();
		        if(beansCep.verSeExisteEnderecoController(tRua, tCep ).isEmpty()) {
		        	ModCep modCep = getDadosInterfaceCep();
		        	beansCep.salvarCepController(modCep);
		        }
				List<ModCep> listaCep = new ArrayList<ModCep>();											// definindo uma lista com base no nosso modelo
				listaCep = beansCep.pesquisaCepController();												// essa e nossa lista de clientes
				popularTabelaCep(listaCep);	
		        tabApoio.updateUI();   
		     }
		});
		
		btnNovo.addKeyListener(new java.awt.event.KeyAdapter() {
			@Override
			public void keyPressed(java.awt.event.KeyEvent evt) {
				ProximoCampo.enter(evt, txtEndereco);
				acaoBtnNovo(pnlCadastro);
			}
		});	
		
		 btnNovo.addActionListener((ActionEvent evt) -> {
			ProximoCampo.enter(evt, txtEndereco);
			acaoBtnNovo(pnlCadastro);
		 });
		 		
		btnCancelar.addActionListener((ActionEvent evt) ->{
			ProximoCampo.enter(evt, btnNovo);
			acaoBtnCancelar(pnlCadastro);
			CaixaTexto.desativar(pnlCadastro);
		});

		btnCancelar.addKeyListener(new java.awt.event.KeyAdapter() {
			@Override
			public void keyPressed(java.awt.event.KeyEvent evt) {
				ProximoCampo.enter(evt, btnCancelar);
				acaoBtnSalvar(pnlCadastro);
				CaixaTexto.desativar(pnlCadastro);
			}
		});	
		
		
/****************************************************************************************************/
/* vamos trabalhar com a tabela agora																*/
/****************************************************************************************************/		
		
	}
	
	private JLabel lblEndereco;
	private JLabel lblBairro;
	private JLabel lblCidade;
	private JLabel lblCep;
	private JLabel lblUf;
	private JLabel lblReferencia;
	
	private JTextField txtEndereco;
	private JTextField txtBairro;
	private JTextField txtCidade;
	private JFormattedTextField txtCep;
	private JTextField txtUf;
	private JTextField txtReferencia;
	
/****************************************************************************************************/
/* Essa é a área dos eventos que devem ser usados mais de uma vêz									*/
/****************************************************************************************************/

	private ModCep getDadosInterfaceCep(){
		ModCep modCep = new ModCep();
		modCep.setRua(this.txtEndereco.getText());
		modCep.setBairro(this.txtBairro.getText());
		modCep.setCidade(this.txtCidade.getText());
		modCep.setCep(this.txtCep.getText());
		modCep.setUf(this.txtUf.getText());
		modCep.setReferencia(this.txtReferencia.getText());
		return modCep;        
	}	   
	
	    private void popularTabelaCep(List<ModCep> pListaDeCep){
	        DefaultTableModel ModeloTabela = new DefaultTableModel();
	        tabApoio.setModel(ModeloTabela);	  
	        ModeloTabela.addColumn("Cep");
	        ModeloTabela.addColumn("Rua");
	        ModeloTabela.addColumn("UF");
	        tabApoio.getColumnModel().getColumn(0).setPreferredWidth(75);
			tabApoio.getColumnModel().getColumn(1).setPreferredWidth(370);
			tabApoio.getColumnModel().getColumn(2).setPreferredWidth(30);
			tabApoio.getColumnModel().getColumn(0).setResizable(false);
			tabApoio.getColumnModel().getColumn(1).setResizable(false);		
			tabApoio.getColumnModel().getColumn(2).setResizable(false);		
			tabApoio.getTableHeader().setReorderingAllowed(true);
			tabApoio.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
			tabApoio.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	        
	        for (ModCep modCep : pListaDeCep) {
	        	ModeloTabela.addRow(
	                new Object[]{
	                	modCep.getCep(),	
	                    modCep.getRua(),
	                    modCep.getUf()
	                }
	            );
	        }
	    }    
	    
	    
	/* esse evento vai me ajudar a montar as tabelas a medida que os botoes de opcoes seja acionados*/
	public void montarTabCli(String Sql) {
//		tabCli.clearSelection();
//		ArrayList<Object[]> dados = new ArrayList<Object[]>();										// criando uma lista de objetos 
//		dados.clear();																				// limpando esta lista
//		String[] colunas = new String[]{"Nome", "CPF-CGC"};											// definindo os titulos das colunas das tabelas	
//		Conexao.conexao();																			// estabelecendo a conexao com o banco de dados
//		conecte.executaSql(Sql);																	// executando a instrucao sql de pesquisa
//		try {
//			conecte.rs.first();																		// direcionando o ponteiro para o principio		
//			do {
//				dados.add(new Object[] {															
//						conecte.rs.getString("nome"),				
//						conecte.rs.getString("cpfcgc")});				
//			}while(conecte.rs.next());
//		} catch (Exception e) {
//			// se nao tiver nada nao mostra nada
//		}
//		ModTabela modelo = new ModTabela(dados, colunas);
//		tabCli.setModel(modelo);
//		tabCli.getColumnModel().getColumn(0).setPreferredWidth(375);
//		tabCli.getColumnModel().getColumn(0).setResizable(false);
//		tabCli.getColumnModel().getColumn(1).setPreferredWidth(100);
//		tabCli.getColumnModel().getColumn(1).setResizable(false);		
//		tabCli.getTableHeader().setReorderingAllowed(true);
//		tabCli.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
//		tabCli.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
//		conecte.desconecta();
	}
	
//
//	public void montarTabCep() {
//		tabCep.clearSelection();
//		ArrayList<Object[]> dados = new ArrayList<Object[]>();										// criando uma lista de objetos 
//		dados.clear();																				// limpando esta lista
//		String[] colunas = new String[]{"Cep", "Rua", "Cidade"};									// definindo os titulos das colunas das tabelas	
//		Conexao.conexao();																			// estabelecendo a conexao com o banco de dados
//		conecte.executaSql("Select * from cep where rua like '%"+txtEndereco.getText()+"%'");		// executando a instrucao sql de pesquisa
//		try {
//			conecte.rs.first();																		// direcionando o ponteiro para o principio		
//			do {
//				dados.add(new Object[] {															
//						conecte.rs.getString("cep"),				
//						conecte.rs.getString("rua"),
//						conecte.rs.getString("cidade")});				
//			}while(conecte.rs.next());
//		} catch (Exception e) {
//			// se nao tiver nada nao mostra nada
//		}
//		ModTabela modelo = new ModTabela(dados, colunas);
//		tabCep.setModel(modelo);
//		tabCep.getColumnModel().getColumn(0).setPreferredWidth(80);
//		tabCep.getColumnModel().getColumn(0).setResizable(false);
//		tabCep.getColumnModel().getColumn(1).setPreferredWidth(250);
//		tabCep.getColumnModel().getColumn(1).setResizable(false);		
//		tabCep.getColumnModel().getColumn(2).setPreferredWidth(150);
//		tabCep.getColumnModel().getColumn(2).setResizable(false);		
//		tabCep.getTableHeader().setReorderingAllowed(true);
//		tabCep.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
//		tabCep.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
//		conecte.desconecta();
//		tabCep.addMouseListener(new java.awt.event.MouseAdapter() {
//			public void mouseClicked(java.awt.event.MouseEvent e) {
//				String numeroCep = "" + tabCep.getValueAt(tabCep.getSelectedRow(), 0);
//				Conexao.conexao();
//				conecte.executaSql("SELECT * FROM cep WHERE cep='"+numeroCep+"'");
//				try {
//					conecte.rs.first();
//					txtEndereco.setText(conecte.rs.getString("rua"));
//					txtBairro.setText(conecte.rs.getString("bairro"));
//					txtCidade.setText(conecte.rs.getString("cidade"));
//					txtCep.setText(conecte.rs.getString("cep"));
//					txtUf.setText(conecte.rs.getString("uf"));
//				} catch (SQLException e1) {
//					JOptionPane.showMessageDialog(null, "Falha ao recuperar dados do endereço!!!");
//				}finally {
//					conecte.desconecta();
//				}
//			}
//		});
//	}
}
