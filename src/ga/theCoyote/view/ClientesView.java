package ga.theCoyote.view;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

import ga.theCoyote.controller.BeansCep;
import ga.theCoyote.controller.BeansClientes;
import ga.theCoyote.controller.BeansSituacaoCliente;
import ga.theCoyote.controller.BeansTipoClientes;
import ga.theCoyote.model.ModCep;
import ga.theCoyote.model.ModClientes;
import ga.theCoyote.model.ModSituacaoCliente;
import ga.theCoyote.model.ModTipoCliente;
import ga.theCoyote.model.forms.ModeloCadastro;
import ga.theCoyote.model.tableModel.TabClientesCadastro;
import ga.theCoyote.uteis.AuxData;
import ga.theCoyote.uteis.CaixaTexto;
import ga.theCoyote.uteis.CorrigeTexto;
import ga.theCoyote.uteis.FormartarCampo;
import ga.theCoyote.uteis.LimparDados;
import ga.theCoyote.uteis.ProximoCampo;
import ga.theCoyote.uteis.TextoGeral;
import ga.theCoyote.uteis.TextoNumero;
import ga.theCoyote.uteis.ValidarCpfCgc;
import ga.theCoyote.uteis.ValidarEmail;

public class ClientesView extends ModeloCadastro{

	BeansClientes beansClientes = new BeansClientes();
	BeansCep beansCep = new BeansCep();
	BeansTipoClientes beansTipoClientes = new BeansTipoClientes(); 
	BeansSituacaoCliente beansSituacaoCliente = new BeansSituacaoCliente();

	public ClientesView() {
		inicializa();
		setVisible(true);
		lblTitulo.setText("Cadastro de Clientes");
	}

	public final void inicializa() {
		/* inicializando nome dos campos  															*/
		lblId = new JLabel("Id. Cliente");
		lblCadastro = new JLabel("Cadastro");
		lblNome = new JLabel("Nome");
		lblEndereco = new JLabel("Endereço");
		lblNumero = new JLabel("Número");
		lblComplemento = new JLabel("Complemento");
		lblBairro = new JLabel("Bairro");
		lblCidade = new JLabel("Cidade");
		lblCep = new JLabel("Cep");
		lblUf = new JLabel("UF");
		lblReferencia = new JLabel("Referencia");
		lblCpfCgc = new JLabel("CPF - CGC");
		lblInformaCpfCgc = new JLabel();
		lblRgInscricao = new JLabel("RG - Inscricão");
		lblCelular1 = new JLabel("Celular 1");
		lblCelular2 = new JLabel("Celular 2");
		lblTipoCliente = new JLabel("Tipo Cliente");
		lblSituacao = new JLabel("Situação");
		lblEmail1 = new JLabel("Email 1");
		lblEmail2 = new JLabel("Email 2");
		lblLimite = new JLabel("Limite R$");
		lblSaldo = new JLabel("Saldo R$");

		/* agora os campos de edição																*/
		txtId = new JTextField(64);
		txtCadastro = new JFormattedTextField();
		txtNome = new JTextField(64);
		txtEndereco = new JTextField(64);
		txtNumero = new JTextField(12);
		txtComplemento = new JTextField(64);
		txtBairro = new JTextField(32);
		txtCidade = new JTextField(32);
		txtCep = new JFormattedTextField();
		txtUf = new JTextField(2);
		txtReferencia = new JTextField(64);
		txtCpfCgc = new JTextField(20);
		txtRgInscricao = new JTextField(20);
		txtCelular1 = new JFormattedTextField();
		txtCelular2 = new JFormattedTextField();
		txtTipoCliente = new JTextField(20);
		txtSituacao = new JTextField(20);
		txtEmail1 = new JTextField(32);
		txtEmail2 = new JTextField(32);
		txtLimite = new JFormattedTextField();
		txtSaldo = new JFormattedTextField();

		/* vou usar esta rotina para limitar o tamanho dos campos e fazer uma pre-validação.			*/
		txtNome.setDocument(new TextoGeral(64));
		txtCadastro.setDocument(new TextoNumero(10));
		txtEndereco.setDocument(new TextoGeral(64));
		txtComplemento.setDocument(new TextoGeral(64));
		txtBairro.setDocument(new TextoGeral(32));
		txtCidade.setDocument(new TextoGeral(32));
		txtUf.setDocument(new TextoGeral(2));
		txtReferencia.setDocument(new TextoGeral(64));
		txtCpfCgc.setDocument(new TextoNumero(20));
		txtRgInscricao.setDocument(new TextoNumero(20));
		txtCelular1.setDocument(new TextoNumero(14));
		txtCelular2.setDocument(new TextoNumero(14));
		txtTipoCliente.setDocument(new TextoGeral(20));
		txtSituacao.setDocument(new TextoGeral(20));
		txtEmail1.setDocument(new TextoGeral(32));
		txtEmail2.setDocument(new TextoGeral(32));

		FormartarCampo.formatarData(txtCadastro);
		FormartarCampo.formatarCep(txtCep);
		FormartarCampo.formatarFone(txtCelular1);
		FormartarCampo.formatarFone(txtCelular2);
		txtLimite.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("###,###.00"))));
		txtSaldo.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("###,###.00"))));

		lblId.setBounds(30, 80, 100, 27); 															// largura total 648
		lblCadastro.setBounds(441, 80, 80, 27);
		lblNome.setBounds(30, 110, 100, 27);
		lblEndereco.setBounds(30, 140, 100, 27);
		lblNumero.setBounds(491, 140, 50, 27);
		lblComplemento.setBounds(30, 170, 100, 27);
		lblBairro.setBounds(30, 200, 80, 27);
		lblCidade.setBounds(350, 200, 100, 27);
		lblCep.setBounds(30, 230, 80, 27);
		lblUf.setBounds(350, 230, 100, 27);
		lblReferencia.setBounds(30, 260, 80, 27);
		lblCpfCgc.setBounds(30, 290, 200, 27);
		lblInformaCpfCgc.setBounds(350, 290, 300, 27);
		lblRgInscricao.setBounds(30, 320, 80, 27);
		lblCelular1.setBounds(30, 350, 80, 27);
		lblCelular2.setBounds(350, 350, 80, 27);
		lblTipoCliente.setBounds(30, 380, 100, 27);
		lblSituacao.setBounds(350, 380, 100, 27);
		lblEmail1.setBounds(30, 410, 80, 27);
		lblEmail2.setBounds(30, 440, 80, 27);
		lblLimite.setBounds(30, 470, 80, 27);
		lblSaldo.setBounds(350, 470, 80, 27);

		txtId.setBounds(110, 80, 100, 27); 															// largura total 648
		txtCadastro.setBounds(508, 80, 108, 27);
		txtNome.setBounds(110, 110, 508, 27);
		txtEndereco.setBounds(110, 140, 375, 27);
		txtNumero.setBounds(538, 140, 80, 27);
		txtComplemento.setBounds(110, 170, 508, 27);
		txtBairro.setBounds(110, 200, 200, 27);
		txtCidade.setBounds(410, 200, 208, 27);
		txtCep.setBounds(110, 230, 200, 27);
		txtUf.setBounds(410, 230, 208, 27);
		txtReferencia.setBounds(110, 260, 508, 27);
		txtCpfCgc.setBounds(110, 290, 200, 27);
		txtRgInscricao.setBounds(110, 320, 200, 27);
		txtCelular1.setBounds(110, 350, 200, 27);
		txtCelular2.setBounds(410, 350, 208, 27);
		txtTipoCliente.setBounds(110, 380, 200, 27);
		txtSituacao.setBounds(410, 380, 208, 27);
		txtEmail1.setBounds(110, 410, 508, 27);
		txtEmail2.setBounds(110, 440, 508, 27);
		txtLimite.setBounds(110, 470, 200, 27);
		txtSaldo.setBounds(410, 470, 208, 27);

		pnlCadastro.add(lblId);
		pnlCadastro.add(lblCadastro);
		pnlCadastro.add(lblNome);
		pnlCadastro.add(lblEndereco);
		pnlCadastro.add(lblNumero);
		pnlCadastro.add(lblComplemento);
		pnlCadastro.add(lblBairro);
		pnlCadastro.add(lblCidade);
		pnlCadastro.add(lblCep);
		pnlCadastro.add(lblUf);
		pnlCadastro.add(lblReferencia);
		pnlCadastro.add(lblCpfCgc);
		pnlCadastro.add(lblInformaCpfCgc);
		pnlCadastro.add(lblRgInscricao);
		pnlCadastro.add(lblCelular1);
		pnlCadastro.add(lblCelular2);
		pnlCadastro.add(lblTipoCliente);
		pnlCadastro.add(lblSituacao);
		pnlCadastro.add(lblEmail1);
		pnlCadastro.add(lblEmail2);
		pnlCadastro.add(lblLimite);
		pnlCadastro.add(lblSaldo);

		pnlCadastro.add(txtId);
		pnlCadastro.add(txtCadastro);
		pnlCadastro.add(txtNome);
		pnlCadastro.add(txtEndereco);
		pnlCadastro.add(txtNumero);
		pnlCadastro.add(txtComplemento);
		pnlCadastro.add(txtBairro);
		pnlCadastro.add(txtCidade);
		pnlCadastro.add(txtCep);
		pnlCadastro.add(txtUf);
		pnlCadastro.add(txtReferencia);
		pnlCadastro.add(txtCpfCgc);
		pnlCadastro.add(txtRgInscricao);
		pnlCadastro.add(txtCelular1);
		pnlCadastro.add(txtCelular2);
		pnlCadastro.add(txtTipoCliente);
		pnlCadastro.add(txtSituacao);
		pnlCadastro.add(txtEmail1);
		pnlCadastro.add(txtEmail2);
		pnlCadastro.add(txtLimite);
		pnlCadastro.add(txtSaldo);
		
		/*__________________________________________________________________________________________________*/
		/****************************************************************************************************/
		/* comecando os eventos																				*/
		/****************************************************************************************************/	
		/* vou colocar todos os campos de edicao e exclusão com a propriedade enabled = false					
		 *  e ativar a medida que for precisando*/
		CaixaTexto.desativar(pnlCadastro);	
		btnEditar.setEnabled(false);
		btnApagar.setEnabled(false);

		List<ModClientes> listaCliente = new ArrayList<ModClientes>();								// definindo uma lista com base no nosso modelo
		listaCliente = beansClientes.listarClientesController();									// essa e nossa lista de clientes
		popularTabelaCliente(listaCliente);															// vamos popular a tabela com essa lista
		tabApoio.setEnabled(false);
		
		/* quando uma tecla enter for pressionada nos campos de edicao										*/		
		txtId.addKeyListener(new java.awt.event.KeyAdapter() {
			@Override
			public void keyPressed(java.awt.event.KeyEvent evt) {ProximoCampo.enter(evt, txtCadastro);}
		});			

		txtCadastro.addKeyListener(new java.awt.event.KeyAdapter() {
			@Override
			public void keyPressed(java.awt.event.KeyEvent evt) {ProximoCampo.enter(evt, txtNome);}
		});			

		txtNome.addKeyListener(new java.awt.event.KeyAdapter() {
			@Override
			public void keyPressed(java.awt.event.KeyEvent evt) {
				ProximoCampo.enter(evt, txtEndereco);
				List<ModClientes> procurarCliente = new ArrayList<ModClientes>();					// essa nova lista de clientes vai						
				procurarCliente = beansClientes.procurarContemNomeClientesController(txtNome.getText());		// selecionar o cliente com base no que o usuario digitar no campo
				popularTabelaCliente(procurarCliente);												// txtNome, usando o %LIKE%
			}
		});			

		txtEndereco.addKeyListener(new java.awt.event.KeyAdapter() {
			@Override
			public void keyPressed(java.awt.event.KeyEvent evt) {
				int tabLinha = 0;
				List<ModCep> procurarEndereco = new ArrayList<ModCep>();
				procurarEndereco = beansCep.procurarEnderecoController(txtEndereco.getText());
				popularTabelaCep(procurarEndereco);
				if(evt.getKeyCode() == 10) {
					txtNumero.requestFocus();
					if(procurarEndereco.size()>0) {													// se tiver algo na lista, pega sempre o primeiro
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

		txtNumero.addKeyListener(new java.awt.event.KeyAdapter() {
			@Override
			public void keyPressed(java.awt.event.KeyEvent evt) {ProximoCampo.enter(evt, txtComplemento);}
		});			

		txtComplemento.addKeyListener(new java.awt.event.KeyAdapter() {
			@Override
			public void keyPressed(java.awt.event.KeyEvent evt) {ProximoCampo.enter(evt, txtBairro);}
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
			public void keyPressed(java.awt.event.KeyEvent evt) {ProximoCampo.enter(evt, txtCpfCgc);}
		});			

		txtCpfCgc.addKeyListener(new java.awt.event.KeyAdapter() {
			@Override
			public void keyPressed(java.awt.event.KeyEvent evt) {ProximoCampo.enter(evt, txtRgInscricao);}
		});			

		txtRgInscricao.addKeyListener(new java.awt.event.KeyAdapter() {
			@Override
			public void keyPressed(java.awt.event.KeyEvent evt) {ProximoCampo.enter(evt, txtCelular1);}
		});			

		txtCelular1.addKeyListener(new java.awt.event.KeyAdapter() {
			@Override
			public void keyPressed(java.awt.event.KeyEvent evt) {ProximoCampo.enter(evt, txtCelular2);}
		});			

		txtCelular2.addKeyListener(new java.awt.event.KeyAdapter() {
			@Override
			public void keyPressed(java.awt.event.KeyEvent evt) {ProximoCampo.enter(evt, txtTipoCliente);}
		});			

		txtTipoCliente.addKeyListener(new java.awt.event.KeyAdapter() {
			@Override
			public void keyPressed(java.awt.event.KeyEvent evt) {
				Integer tabLinha = 0;
				List<ModTipoCliente> pTipoCliente = new ArrayList<ModTipoCliente>();
				pTipoCliente = beansTipoClientes.procurarTipoClienteController(txtTipoCliente.getText());
				popularTabelaTipoCliente(pTipoCliente);
				if(evt.getKeyCode() == 10) {
					txtSituacao.requestFocus();
					if(pTipoCliente.size()>0) {													// se tiver algo na lista, pega sempre o primeiro						
						txtTipoCliente.setText(pTipoCliente.get(tabLinha).getTipoCliente());
					}
				}
			}
		});			

		txtSituacao.addKeyListener(new java.awt.event.KeyAdapter() {
			@Override
			public void keyPressed(java.awt.event.KeyEvent evt) {
				Integer tabLinha = 0;
				List<ModSituacaoCliente> pSituacaoCliente = new ArrayList<ModSituacaoCliente>();
				pSituacaoCliente = beansSituacaoCliente.procurarSituacaoClienteController(txtSituacao.getText());
				popularTabelaSituacaoCliente(pSituacaoCliente);
				if(evt.getKeyCode() == 10) {
					txtEmail1.requestFocus(); 
					if(pSituacaoCliente.size()>0) {
						txtSituacao.setText(pSituacaoCliente.get(tabLinha).getSituacaoCliente());
					}
				}

			}
		});	

		txtEmail1.addKeyListener(new java.awt.event.KeyAdapter() {
			@Override
			public void keyPressed(java.awt.event.KeyEvent evt) {ProximoCampo.enter(evt, txtEmail2);}
		});	

		txtEmail2.addKeyListener(new java.awt.event.KeyAdapter() {
			@Override
			public void keyPressed(java.awt.event.KeyEvent evt) {ProximoCampo.enter(evt, txtLimite);}
		});	

		txtLimite.addKeyListener(new java.awt.event.KeyAdapter() {
			@Override
			public void keyPressed(java.awt.event.KeyEvent evt) {ProximoCampo.enter(evt, txtSaldo);}
		});	

		txtSaldo.addKeyListener(new java.awt.event.KeyAdapter() {
			@Override
			public void keyPressed(java.awt.event.KeyEvent evt) {ProximoCampo.enter(evt, btnSalvar);}
		});	

		txtPesquisa.addKeyListener(new java.awt.event.KeyAdapter() {
			@Override
			public void keyPressed(java.awt.event.KeyEvent evt) {
				acaoPesquisar(evt);
			}
		});	
		
		btnPesquisa.addKeyListener(new java.awt.event.KeyAdapter() {
			@Override
			public void keyPressed(java.awt.event.KeyEvent evt) {
				acaoPesquisar(evt);
			}
		});	

		
/*__________________________________________________________________________________________________*/		
/*	 Agora vou trabalhar o focus de cada componente													*/
/*__________________________________________________________________________________________________*/		

		txtId.addFocusListener(new java.awt.event.FocusAdapter() {
			public void focusGained(java.awt.event.FocusEvent evt) {
				PrincipalView.lblTituloAjuda.setText("Id. Cliente");
				PrincipalView.lblMensagemAjuda.setText("<html>Esse é o campo que vai o código de Identificação do cliente. Atenção, Esse código será gerado pelo sistema.");
			}
			public void focusLost(java.awt.event.FocusEvent evt) {

			}
		});  

		txtCadastro.addFocusListener(new java.awt.event.FocusAdapter() {
			public void focusGained(java.awt.event.FocusEvent evt) {
				Date data = new Date();
				SimpleDateFormat out = new SimpleDateFormat("dd/MM/yyyy");
				String resultado = out.format(data);
				txtCadastro.setText(resultado);

				PrincipalView.lblTituloAjuda.setText("Data Cadastro");
				PrincipalView.lblMensagemAjuda.setText("<html>Informe ou confirme a data do cadastro do cliente.");
			}
			public void focusLost(java.awt.event.FocusEvent evt) {
				if(!AuxData.dataCerta(txtCadastro.getText())) {
					JOptionPane.showMessageDialog(null, "Você precisa informar uma data de cadastro VALIDA!!!");
					txtCadastro.requestFocus();
				}
			}
		}); 

		txtNome.addFocusListener(new java.awt.event.FocusAdapter() {
			public void focusGained(java.awt.event.FocusEvent evt) {
				PrincipalView.lblTituloAjuda.setText("Nome");
				PrincipalView.lblMensagemAjuda.setText("<html>Informe o nome do cliente.");
			}
			public void focusLost(java.awt.event.FocusEvent evt) {
				String novo = CorrigeTexto.corrige(txtNome.getText());                				// pega o texto digitado e mandar para a correção
				txtNome.setText(novo);                                                				// retorna o texto digitado já corrigido

				List<ModClientes> cliente = beansClientes.procurarNomeClientesController(txtNome.getText());
				
				switch (acao) {
				case "novo": {
					if(!cliente.isEmpty()) {
						txtNome.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(255,0,0)));						
					} else {
						txtNome.setBorder(txtCadastro.getBorder());
					}
					break;
				}

				default:
					throw new IllegalArgumentException("Unexpected value: " + acao);
				}
				
				List<ModClientes> procurarCliente = new ArrayList<ModClientes>();					// essa nova lista de clientes vai						
				procurarCliente = beansClientes.procurarContemNomeClientesController(txtNome.getText());		// selecionar o cliente com base no que o usuario digitar no campo
				popularTabelaCliente(procurarCliente);												// txtNome, usando o %LIKE%
			}
		});

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

		txtNumero.addFocusListener(new java.awt.event.FocusAdapter() {
			public void focusGained(java.awt.event.FocusEvent evt) {
				PrincipalView.lblTituloAjuda.setText("Numero");
				PrincipalView.lblMensagemAjuda.setText("<html>Informe o número do imovel.");

				List<ModClientes> listaCliente = new ArrayList<ModClientes>();
				listaCliente = beansClientes.listarClientesController();
				popularTabelaCliente(listaCliente);
			}
			@Override
			public void focusLost(java.awt.event.FocusEvent evt) {

			}
		});

		txtComplemento.addFocusListener(new java.awt.event.FocusAdapter() {
			public void focusGained(java.awt.event.FocusEvent evt) {
				PrincipalView.lblTituloAjuda.setText("Complemento");
				PrincipalView.lblMensagemAjuda.setText("<html>Informe o complemento referente ao endereço do cliente.");
			}
			public void focusLost(java.awt.event.FocusEvent evt) {
				String novo = CorrigeTexto.corrige(txtComplemento.getText());          				// pega o texto digitado e mandar para a correção
				txtComplemento.setText(novo);                                          				// retorna o texto digitado já corrigido

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

		txtCpfCgc.addFocusListener(new java.awt.event.FocusAdapter() {
			public void focusGained(java.awt.event.FocusEvent evt) {
				PrincipalView.lblTituloAjuda.setText("CPF ou CGC");
				PrincipalView.lblMensagemAjuda.setText("<html>Informe o numero do CPf ou o numero do CGC do cliente.");
			}
			public void focusLost(java.awt.event.FocusEvent evt) {
				ValidarCpfCgc.validar(txtCpfCgc, lblInformaCpfCgc);
				List<ModClientes> cliente = beansClientes.verSeExisteClientesController(txtNome.getText(), txtCpfCgc.getText());
				if(acao == "novo") {
					if(!cliente.isEmpty()) {
						JOptionPane.showMessageDialog(null, "Desculpe, mas já tenho um cliente cadastrado com essas informações");
						txtNome.requestFocus();
					}
				}
			}
		});


		txtRgInscricao.addFocusListener(new java.awt.event.FocusAdapter() {
			public void focusGained(java.awt.event.FocusEvent evt) {
				PrincipalView.lblTituloAjuda.setText("Rg ou Inscrição");
				PrincipalView.lblMensagemAjuda.setText("<html>Informe o numero do Registro Geral do cliente ou o número da Inscrição Estadual.");
			}
			public void focusLost(java.awt.event.FocusEvent evt) {

			}
		});

		txtCelular1.addFocusListener(new java.awt.event.FocusAdapter() {
			public void focusGained(java.awt.event.FocusEvent evt) {
				PrincipalView.lblTituloAjuda.setText("Celular 1");
				PrincipalView.lblMensagemAjuda.setText("<html>Informe o número do telefone ou Celular do cliente");
			}
			public void focusLost(java.awt.event.FocusEvent evt) {

			}
		});

		txtCelular2.addFocusListener(new java.awt.event.FocusAdapter() {
			public void focusGained(java.awt.event.FocusEvent evt) {
				PrincipalView.lblTituloAjuda.setText("Celular 2");
				PrincipalView.lblMensagemAjuda.setText("<html>Informe o número do telefone ou Celular do cliente");
			}
			public void focusLost(java.awt.event.FocusEvent evt) {

			}
		});

		txtTipoCliente.addFocusListener(new java.awt.event.FocusAdapter() {
			public void focusGained(java.awt.event.FocusEvent evt) {
				PrincipalView.lblTituloAjuda.setText("Tipo de Cliente");
				PrincipalView.lblMensagemAjuda.setText("<html>Escolha o tipo do Cliente");
				List<ModTipoCliente> listaTipoCliente = new ArrayList<ModTipoCliente>();
				listaTipoCliente = beansTipoClientes.listarTipoClienteController();
				popularTabelaTipoCliente(listaTipoCliente);

			}
			public void focusLost(java.awt.event.FocusEvent evt) {

			}
		});

		txtSituacao.addFocusListener(new java.awt.event.FocusAdapter() {
			public void focusGained(java.awt.event.FocusEvent evt) {
				PrincipalView.lblTituloAjuda.setText("Situação");
				PrincipalView.lblMensagemAjuda.setText("<html>Informe a Situação di Cliente.");
				List<ModSituacaoCliente> listaSituacaoCliente = new ArrayList<ModSituacaoCliente>();
				listaSituacaoCliente = beansSituacaoCliente.listarSituacaoClienteController();
				popularTabelaSituacaoCliente(listaSituacaoCliente);
			}
			public void focusLost(java.awt.event.FocusEvent evt) {

			}
		});

		txtEmail1.addFocusListener(new java.awt.event.FocusAdapter() {
			public void focusGained(java.awt.event.FocusEvent evt) {
				PrincipalView.lblTituloAjuda.setText("Email");
				PrincipalView.lblMensagemAjuda.setText("<html>Informe o endereço de Email do cliente");
			}
			public void focusLost(java.awt.event.FocusEvent evt) {
				if(txtEmail1.getText().length() > 0) {
					if(ValidarEmail.Validar(txtEmail1.getText()) == false) {
						JOptionPane.showMessageDialog( null, "<html>Desculpe mas esse email não tem o formato de escrita válido!!!<br> você pode deixar em branco ou digitar um formato que seja válido");
						txtEmail1.requestFocus();
					}
				}
			}
		});

		txtEmail1.addFocusListener(new java.awt.event.FocusAdapter() {
			public void focusGained(java.awt.event.FocusEvent evt) {
				PrincipalView.lblTituloAjuda.setText("Email");
				PrincipalView.lblMensagemAjuda.setText("<html>Informe o endereço de Email do cliente");
				List<ModClientes> listaCliente = new ArrayList<ModClientes>();
				listaCliente = beansClientes.listarClientesController();
				popularTabelaCliente(listaCliente);
			}
			public void focusLost(java.awt.event.FocusEvent evt) {

			}
		});

		btnSalvar.addFocusListener(new java.awt.event.FocusAdapter() {
			public void focusGained(java.awt.event.FocusEvent evt) {
				PrincipalView.lblTituloAjuda.setText("Botão Salvar");
				PrincipalView.lblMensagemAjuda.setText("<html>Salva a ficha de cadastro de clientes");
			}
			public void focusLost(java.awt.event.FocusEvent evt) {

			}
		});

		btnNovo.addFocusListener(new java.awt.event.FocusAdapter() {
			public void focusGained(java.awt.event.FocusEvent evt) {
				PrincipalView.lblTituloAjuda.setText("Botão Novo");
				PrincipalView.lblMensagemAjuda.setText("<html>Abre o leque de capos para cadastrar um novo Cliente");
			}
			public void focusLost(java.awt.event.FocusEvent evt) {

			}
		});



		/****************************************************************************************************/
		/* Trabalhando com o painel de botões do cadastro de Clientes.										*/
		/****************************************************************************************************/		
		/* mudando a cor do focus */
		//txtId.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0,0,255)));
		//txtId.setBorder(null);


		btnSalvar.addActionListener((ActionEvent evt) -> {
			ProximoCampo.enter(evt, btnNovo);
			acaoBtnSalvar();
		});


		btnSalvar.addKeyListener(new java.awt.event.KeyAdapter() {
			@Override
			public void keyPressed(java.awt.event.KeyEvent evt) {
				ProximoCampo.enter(evt, btnNovo);
				acaoBtnSalvar();
			}
		});

		btnNovo.addKeyListener(new java.awt.event.KeyAdapter() {
			@Override
			public void keyPressed(java.awt.event.KeyEvent evt) {
				txtId.setEnabled(false); 															// definindo o campo do Id com enabled
				btnEditar.setEnabled(false);
				btnApagar.setEnabled(false);
				ProximoCampo.enter(evt, txtCadastro);
				txtNome.setBorder(txtCadastro.getBorder());
			}
		});	

		btnNovo.addActionListener((ActionEvent evt) -> {
			ProximoCampo.enter(evt, txtCadastro);
			txtId.setEnabled(false); 															// definindo o campo do Id com enabled
			btnEditar.setEnabled(false);
			btnApagar.setEnabled(false);
			txtNome.setBorder(txtCadastro.getBorder());
		});

		btnCancelar.addActionListener((ActionEvent evt) ->{
			ProximoCampo.enter(evt, btnNovo);
			txtNome.setBorder(txtCadastro.getBorder());
			txtPesquisa.setText("");
			btnEditar.setEnabled(false);
			btnApagar.setEnabled(false);
			List<ModClientes> cliente = new ArrayList<>();											// definindo uma lista com base no nosso modelo
			cliente = beansClientes.listarClientesController();										// essa e nossa lista de clientes
			popularTabelaCliente(cliente);
		});

		btnCancelar.addKeyListener(new java.awt.event.KeyAdapter() {
			@Override
			public void keyPressed(java.awt.event.KeyEvent evt) {
				ProximoCampo.enter(evt, btnCancelar);
				txtNome.setBorder(txtCadastro.getBorder());
				txtPesquisa.setText("");
				btnEditar.setEnabled(false);
				btnApagar.setEnabled(false);
				List<ModClientes> cliente = new ArrayList<>();											// definindo uma lista com base no nosso modelo
				cliente = beansClientes.listarClientesController();										// essa e nossa lista de clientes
				popularTabelaCliente(cliente);
			}
		});	

		btnApagar.addActionListener((ActionEvent evt) ->{
			UIManager.put("OptionPane.yesButtonText", "Sim");
			UIManager.put("OptionPane.noButtonText", "Não");   
			switch (JOptionPane.showConfirmDialog(null, "Apagar Cliente?")){
			case 0: {
				beansClientes.deletarClienteController(Integer.parseInt(txtId.getText()));
				tabApoio.updateUI();
				LimparDados.limparDados(pnlCadastro);
				break;}
			case 1:{
				break;}
			}			
			txtPesquisa.setText("");
			btnEditar.setEnabled(false);
			btnApagar.setEnabled(false);
			List<ModClientes> cliente = new ArrayList<>();											// definindo uma lista com base no nosso modelo
			cliente = beansClientes.listarClientesController();										// essa e nossa lista de clientes
			popularTabelaCliente(cliente);
		});

		btnEditar.addActionListener((ActionEvent evt) ->{
			txtCadastro.requestFocus();	
		});

	}


	/****************************************************************************************************/
	/* vamos trabalhar com a tabela agora																*/
	/****************************************************************************************************/		

	private JLabel lblId;
	private JLabel lblCadastro;
	private JLabel lblNome;
	private JLabel lblEndereco;
	private JLabel lblNumero;
	private JLabel lblComplemento;
	private JLabel lblBairro;
	private JLabel lblCidade;
	private JLabel lblCep;
	private JLabel lblUf;
	private JLabel lblReferencia;
	private JLabel lblCpfCgc;
	private JLabel lblInformaCpfCgc;
	private JLabel lblRgInscricao;
	private JLabel lblCelular1;
	private JLabel lblCelular2;
	private JLabel lblTipoCliente;
	private JLabel lblSituacao;
	private JLabel lblEmail1;
	private JLabel lblEmail2;
	private JLabel lblLimite;
	private JLabel lblSaldo;

	private JTextField txtId;
	private JFormattedTextField txtCadastro;
	private JTextField txtNome;
	private JTextField txtEndereco;
	private JTextField txtNumero;
	private JTextField txtComplemento;
	private JTextField txtBairro;
	private JTextField txtCidade;
	private JFormattedTextField txtCep;
	private JTextField txtUf;
	private JTextField txtReferencia;
	private JTextField txtCpfCgc;
	private JTextField txtRgInscricao;
	private JFormattedTextField txtCelular1;
	private JFormattedTextField txtCelular2;
	private JTextField txtTipoCliente;
	private JTextField txtSituacao;
	private JTextField txtEmail1;
	private JTextField txtEmail2;
	private JFormattedTextField txtLimite;
	private JFormattedTextField txtSaldo;

	/****************************************************************************************************/
	/* Essa é a área dos eventos que devem ser usados mais de uma vêz									*/
	/****************************************************************************************************/

	private ModClientes getDadosInterface(){

		ModClientes getClientes = new ModClientes();

		LocalDate retorno = null;																	// criando uma variavel de retorno		
		String data = this.txtCadastro.getText().trim();                                            // tirando os espacos em brancos
		data = data.replace("-", "").replace("_", "").replace("/", "");								// tirando os sinais extras	
		int dia = Integer.parseInt(data.substring(0, 2));											// poderia usar o split, acho que na proxima vou usar este
		int mes = Integer.parseInt(data.substring(2, 4));											// dividindo a data em dia, mes e ano
		int ano = Integer.parseInt(data.substring(4, 8));											// lembrano que o primeiro numero é o indece e o segundo a largura.	
		retorno = LocalDate.of(ano, mes, dia);														// definindo uma variavel "retorno" com a data digitada
		if(this.txtId.getText() != null){
			if(!this.txtId.getText().isEmpty()){
				getClientes.setId(Integer.parseInt(this.txtId.getText()));
			}    
		}
		getClientes.setCadastro(retorno);
		getClientes.setNome(this.txtNome.getText());
		getClientes.setEndereco(this.txtEndereco.getText());
		getClientes.setNumero(this.txtNumero.getText());
		getClientes.setComplemento(this.txtComplemento.getText());
		getClientes.setBairro(this.txtBairro.getText());
		getClientes.setCidade(this.txtCidade.getText());
		getClientes.setCep(this.txtCep.getText());
		getClientes.setUf(this.txtUf.getText());
		getClientes.setReferencia(this.txtReferencia.getText());
		getClientes.setCpfCgc(this.txtCpfCgc.getText());
		getClientes.setRgInscricao(this.txtRgInscricao.getText());
		getClientes.setCelular1(this.txtCelular1.getText());
		getClientes.setCelular2(this.txtCelular2.getText());
		getClientes.setEmail1(this.txtEmail1.getText());
		getClientes.setEmail2(this.txtEmail2.getText());
		
		List<ModTipoCliente> procurarTipo = new ArrayList<ModTipoCliente>();	
		procurarTipo = beansTipoClientes.procurarTipoClienteController(txtTipoCliente.getText());			
		getClientes.setTipoCliente((ModTipoCliente) procurarTipo.get(0));
		
		List<ModSituacaoCliente> procurarSituacao = new ArrayList<ModSituacaoCliente>();
		procurarSituacao = beansSituacaoCliente.procurarSituacaoClienteController(txtSituacao.getText());
		getClientes.setSituacaoCliente((ModSituacaoCliente) procurarSituacao.get(0));
		if(!txtLimite.getText().isEmpty()) {
			getClientes.setLimite(new BigDecimal(txtLimite.getText().replace(".", "").replace(",", ".")));
		}else {
			getClientes.setLimite(new BigDecimal(0.00));
		}
		if(!txtSaldo.getText().isEmpty()) {
			getClientes.setSaldo(new BigDecimal(txtSaldo.getText().replace(".", "").replace(",", ".")));
		}else {
			getClientes.setSaldo(new BigDecimal(0.00));
		}
		return getClientes;        
	}	

	private void setDadosInterface(int linha) {
		ModClientes modClientes = new ModClientes();	
		modClientes = null;
		String retorno = null;																		// criando uma variavel de retorno		
		int idCliente = Integer.parseInt((String) tabApoio.getValueAt(linha, 0));
		modClientes = beansClientes.procurarIdClienteController(idCliente);

		String data = String.valueOf(modClientes.getCadastro());	                               // tirando os espacos em brancos	
		String pData[] = new String[3];
		pData = data.split("-");
		String ano = pData[0];																		// Agora to usando o Split
		String mes = pData[1];																		// dividindo a data em dia, mes e ano
		String dia = pData[2];																			
		retorno = dia+"/"+mes+"/"+ano;																	

		txtId.setText(String.valueOf(modClientes.getId()));
		txtCadastro.setText(retorno);
		txtNome.setText(modClientes.getNome());
		txtEndereco.setText(modClientes.getEndereco());
		txtNumero.setText(modClientes.getNumero());
		txtComplemento.setText(modClientes.getComplemento());
		txtBairro.setText(modClientes.getBairro());
		txtCidade.setText(modClientes.getCidade());
		txtCep.setText(modClientes.getCep());
		txtUf.setText(modClientes.getUf());
		txtReferencia.setText(modClientes.getReferencia());
		txtCpfCgc.setText(modClientes.getCpfCgc());
		txtRgInscricao.setText(modClientes.getRgInscricao());
		txtCelular1.setText(modClientes.getCelular1());
		txtCelular2.setText(modClientes.getCelular2());
		txtTipoCliente.setText(modClientes.getTipoCliente().getTipoCliente());
		txtSituacao.setText(modClientes.getSituacaoCliente().getSituacaoCliente());
		txtEmail1.setText(modClientes.getEmail1());
		txtEmail2.setText(modClientes.getEmail2());		
		txtLimite.setText(String.valueOf(modClientes.getLimite()));
		txtSaldo.setText(String.valueOf(modClientes.getSaldo()));
	}

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

	private void popularTabelaCliente(List<ModClientes> pListaDeClientes) {
		if(pListaDeClientes != null) {
			tabApoio.setModel(new TabClientesCadastro(pListaDeClientes));
			tabApoio.getColumnModel().getColumn(0).setPreferredWidth(50);
			tabApoio.getColumnModel().getColumn(1).setPreferredWidth(315);
			tabApoio.getColumnModel().getColumn(2).setPreferredWidth(100);
			tabApoio.getColumnModel().getColumn(0).setResizable(false);
			tabApoio.getColumnModel().getColumn(1).setResizable(false);
			tabApoio.getColumnModel().getColumn(2).setResizable(false);
			tabApoio.getTableHeader().setReorderingAllowed(true);
			tabApoio.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
			tabApoio.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		}
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

	private void popularTabelaTipoCliente(List<ModTipoCliente> pListaTipoCliente) {
		DefaultTableModel modeloTabela = new DefaultTableModel();
		tabApoio.setModel(modeloTabela);
		modeloTabela.addColumn("Tipo de Cliente");
		modeloTabela.addColumn("Desconto Acrescimo");
		modeloTabela.addColumn("Prazo");
		tabApoio.getColumnModel().getColumn(0).setPreferredWidth(370);
		tabApoio.getColumnModel().getColumn(1).setPreferredWidth(155);
		tabApoio.getColumnModel().getColumn(2).setPreferredWidth(100);
		tabApoio.getColumnModel().getColumn(0).setResizable(false);
		tabApoio.getColumnModel().getColumn(1).setResizable(false);		
		tabApoio.getColumnModel().getColumn(2).setResizable(false);		
		tabApoio.getTableHeader().setReorderingAllowed(true);
		tabApoio.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		tabApoio.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		for (ModTipoCliente modTipoCliente : pListaTipoCliente) {
			modeloTabela.addRow(
					new Object[]{
							modTipoCliente.getTipoCliente(),	
							modTipoCliente.getDescontoAcrescimo(),
							modTipoCliente.getPrazo()
					}
					);
		}
	}

	private void popularTabelaSituacaoCliente(List<ModSituacaoCliente> pListaSituacaoCliente) {
		DefaultTableModel modeloTabela = new DefaultTableModel(){
			@Override																				// informando que a coluna 2 é boolean
			public Class<?> getColumnClass(int columnIndex) {
				return columnIndex == 1 ? Boolean.class : super.getColumnClass(columnIndex);
			}
			@Override																				// definindo a edicao como false
			public boolean isCellEditable(int row, int col) {
				return false;
			}
		};
		tabApoio.setModel(modeloTabela);
		modeloTabela.addColumn("Situação do Cliente");
		modeloTabela.addColumn("Bloqueado ?");

		tabApoio.getColumnModel().getColumn(0).setPreferredWidth(470);
		tabApoio.getColumnModel().getColumn(1).setPreferredWidth(155);
		tabApoio.getColumnModel().getColumn(0).setResizable(false);
		tabApoio.getColumnModel().getColumn(1).setResizable(false);		
		tabApoio.getTableHeader().setReorderingAllowed(true);
		tabApoio.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		tabApoio.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		for (ModSituacaoCliente modSituacaoCliente : pListaSituacaoCliente) {
			modeloTabela.addRow(
					new Object[]{
							modSituacaoCliente.getSituacaoCliente(),	
							modSituacaoCliente.isBloquear()
					}
					);
		}
	}

	private void acaoBtnSalvar() {
		if(txtId.getText().isEmpty()) {
			
			String tRua = getDadosInterfaceCep().getRua();
			String tCep = getDadosInterfaceCep().getCep();
			if(beansCep.verSeExisteEnderecoController(tRua, tCep ).isEmpty()) {
				ModCep modCep = getDadosInterfaceCep();
				beansCep.salvarCepController(modCep);
			}
			
			String pNome = getDadosInterface().getNome();
			String pCpfCgc = getDadosInterface().getCpfCgc();
			if(beansClientes.verSeExisteClientesController(pNome, pCpfCgc).isEmpty()) {
				ModClientes modClientes = getDadosInterface();
				ModClientes clienteSalvo = beansClientes.salvarClienteController(modClientes);
				if(clienteSalvo != null){
					List<ModClientes> listaDeClientes = beansClientes.listarClientesController();
					popularTabelaCliente(listaDeClientes);
				}else{
					JOptionPane.showMessageDialog(null, "Erro ao salvar o cliente.");
				}
			} else {
				JOptionPane.showMessageDialog(null, "Cliente Já Cadastrado");
				txtNome.requestFocus();
			}
		} else {
				ModClientes modClientes = getDadosInterface();
				boolean clienteSalvo = beansClientes.atualizarClientesController(modClientes);
				if(clienteSalvo != false){
					List<ModClientes> listaDeClientes = beansClientes.listarClientesController();
					txtPesquisa.setText("");
					btnEditar.setEnabled(false);
					btnApagar.setEnabled(false);
					popularTabelaCliente(listaDeClientes);

				}else{
					JOptionPane.showMessageDialog(null, "Erro ao Atualizar o cliente.");
				}	
			}

	}

	private void acaoPesquisar(KeyEvent evt) {
		List<ModClientes> procurarCliente = new ArrayList<ModClientes>();					// essa nova lista de clientes vai						
		procurarCliente = beansClientes.procurarContemNomeClientesController(txtPesquisa.getText());  // selecionar o cliente com base no que o usuario digitar no campo
		popularTabelaCliente(procurarCliente);												// txtNome, usando o %LIKE%
		if(tabApoio.getRowCount() == 1) {
			tabApoio.selectAll();
			btnEditar.setEnabled(true);
			btnApagar.setEnabled(true);
		} else {
			btnEditar.setEnabled(false);
			btnApagar.setEnabled(false);
		}
		if(evt.getKeyCode() == 10) {
			setDadosInterface(tabApoio.getSelectedRow());
			pnlCadastro.validate();
			pnlCadastro.repaint();
		}				
	}

}
