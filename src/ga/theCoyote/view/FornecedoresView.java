package ga.theCoyote.view;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
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
import ga.theCoyote.controller.BeansFornecedores;
import ga.theCoyote.model.ModCep;
import ga.theCoyote.model.ModFornecedores;
import ga.theCoyote.model.forms.ModeloCadastro;
import ga.theCoyote.model.tableModel.TabFornecedoresCadastro;
import ga.theCoyote.uteis.AuxData;
import ga.theCoyote.uteis.CaixaTexto;
import ga.theCoyote.uteis.CorrigeTexto;
import ga.theCoyote.uteis.FormartarCampo;
import ga.theCoyote.uteis.LimparDados;
import ga.theCoyote.uteis.ProximoCampo;
import ga.theCoyote.uteis.TextoGeral;
import ga.theCoyote.uteis.TextoNumero;
import ga.theCoyote.uteis.ValidarCpfCgc;

public class FornecedoresView extends ModeloCadastro{
	BeansFornecedores beansFornecedores = new BeansFornecedores();
	BeansCep beansCep = new BeansCep();


	public FornecedoresView() {
		inicializa();
		setVisible(true);

		lblTitulo.setText("Cadastro de Fornecedores");

	}

	public void inicializa() {

		/* inicializando os objetos																	*/
		lblId = new JLabel("Id. Fornecedor");
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
		lblContato = new JLabel("Contato");
		lblCelularContato = new JLabel("Cel. Cont.");
		lblEmail1 = new JLabel("Email 1");
		lblEmail2 = new JLabel("Email 2");

		/*agora os campos de edicao																	*/
		txtId = new JTextField();
		txtCadastro = new JFormattedTextField();
		txtNome = new JTextField();
		txtEndereco = new JTextField();
		txtNumero = new JTextField(12);
		txtComplemento = new JTextField();
		txtBairro = new JTextField();
		txtCidade = new JTextField();
		txtCep = new JFormattedTextField();
		txtUf = new JTextField();
		txtReferencia = new JTextField();
		txtCpfCgc = new JTextField();
		txtRgInscricao = new JTextField();
		txtCelular1 = new JFormattedTextField();
		txtCelular2 = new JFormattedTextField();
		txtContato = new JTextField();
		txtCelularContato = new JFormattedTextField();
		txtEmail1 = new JTextField();
		txtEmail2 = new JTextField();

		/* vou usar esta rotina para limitar o tamanho dos campos e fazer uma pre-validação.			*/
		txtNome.setDocument(new TextoGeral(64));
		txtEndereco.setDocument(new TextoGeral(64));
		txtComplemento.setDocument(new TextoGeral(64));
		txtBairro.setDocument(new TextoGeral(32));
		txtCidade.setDocument(new TextoGeral(32));
		txtUf.setDocument(new TextoGeral(2));
		txtReferencia.setDocument(new TextoGeral(64));
		txtCpfCgc.setDocument(new TextoNumero(20));
		txtRgInscricao.setDocument(new TextoNumero(20));
		txtEmail1.setDocument(new TextoGeral(32));
		txtEmail2.setDocument(new TextoGeral(32));
		
		FormartarCampo.formatarData(txtCadastro);
		FormartarCampo.formatarCep(txtCep);
		FormartarCampo.formatarFone(txtCelular1);
		FormartarCampo.formatarFone(txtCelular2);

		lblId.setBounds(30, 80, 100, 27); 
		lblCadastro.setBounds(441, 80, 80, 27);				// largura total 648
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
		lblContato.setBounds(30, 380, 100, 27);
		lblCelularContato.setBounds(350, 380, 100, 27);
		lblEmail1.setBounds(30, 410, 80, 27);
		lblEmail2.setBounds(30, 440, 80, 27);

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
		txtContato.setBounds(110, 380, 200, 27);
		txtCelularContato.setBounds(410, 380, 208, 27);
		txtEmail1.setBounds(110, 410, 508, 27);
		txtEmail2.setBounds(110, 440, 508, 27);

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
		pnlCadastro.add(lblContato);
		pnlCadastro.add(lblCelularContato);
		pnlCadastro.add(lblEmail1);
		pnlCadastro.add(lblEmail2);

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
		pnlCadastro.add(txtContato);
		pnlCadastro.add(txtCelularContato);
		pnlCadastro.add(txtEmail1);
		pnlCadastro.add(txtEmail2);
		
		/****************************************************************************************************/
		/* comecando os eventos																				*/
		/****************************************************************************************************/	
		/* vou colocar todos os campos de edicao com a propriedade enabled = false					*/
		CaixaTexto.desativar(pnlCadastro);

		List<ModFornecedores> listaFornecedores = new ArrayList<ModFornecedores>();
		listaFornecedores = beansFornecedores.listarFornecedoresController();
		popularTabelaFornecedores(listaFornecedores);


		/* quando a tecla enter for pressionada														*/
		txtId.addKeyListener(new java.awt.event.KeyAdapter() {
			@Override
			public void keyPressed(java.awt.event.KeyEvent evt) {ProximoCampo.enter(evt, txtNome);}
		});	

		txtCadastro.addKeyListener(new java.awt.event.KeyAdapter() {
			@Override
			public void keyPressed(java.awt.event.KeyEvent evt) {
				ProximoCampo.enter(evt, txtNome);
			}
		});

		txtNome.addKeyListener(new java.awt.event.KeyAdapter() {
			@Override
			public void keyPressed(java.awt.event.KeyEvent evt) {
				ProximoCampo.enter(evt, txtEndereco);
				List<ModFornecedores> listaFornecedores = new ArrayList<ModFornecedores>();
				listaFornecedores = beansFornecedores.procurarContemNomeFornecedoresController(txtNome.getText());
				popularTabelaFornecedores(listaFornecedores);

			}
		});			

		txtEndereco.addKeyListener(new java.awt.event.KeyAdapter() {
			@Override
			public void keyPressed(java.awt.event.KeyEvent evt) {
				List<ModCep> procurarEndereco = new ArrayList<ModCep>();
				procurarEndereco = beansCep.procurarEnderecoController(txtEndereco.getText());
				popularTabelaCep(procurarEndereco);
				if(evt.getKeyCode() == 10) {
					txtNumero.requestFocus();
					if(procurarEndereco.size() > 0) {
						txtEndereco.setText(procurarEndereco.get(0).getRua());
						txtBairro.setText(procurarEndereco.get(0).getBairro());
						txtCidade.setText(procurarEndereco.get(0).getCidade());
						txtReferencia.setText(procurarEndereco.get(0).getReferencia());
						txtUf.setText(procurarEndereco.get(0).getUf());
						txtCep.setText(procurarEndereco.get(0).getCep());
					}
				}
			}
		});			

		txtNumero.addKeyListener(new java.awt.event.KeyAdapter() {
			@Override
			public void keyPressed(java.awt.event.KeyEvent evt) {
				ProximoCampo.enter(evt, txtComplemento);
			}
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
			public void keyPressed(java.awt.event.KeyEvent evt) {ProximoCampo.enter(evt, txtContato);}
		});			

		txtContato.addKeyListener(new java.awt.event.KeyAdapter() {
			@Override
			public void keyPressed(java.awt.event.KeyEvent evt) {ProximoCampo.enter(evt, txtCelularContato);}
		});			

		txtCelularContato.addKeyListener(new java.awt.event.KeyAdapter() {
			@Override
			public void keyPressed(java.awt.event.KeyEvent evt) {ProximoCampo.enter(evt, txtEmail1);}
		});	

		txtEmail1.addKeyListener(new java.awt.event.KeyAdapter() {
			@Override
			public void keyPressed(java.awt.event.KeyEvent evt) {ProximoCampo.enter(evt, txtEmail2);}
		});	

		txtEmail2.addKeyListener(new java.awt.event.KeyAdapter() {
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

		/* Agora vou trabalhar o focus de cada componente													*/
		txtId.addFocusListener(new java.awt.event.FocusAdapter() {
			public void focusGained(java.awt.event.FocusEvent evt) {
				PrincipalView.lblTituloAjuda.setText("Id. Fornecedor");
				PrincipalView.lblMensagemAjuda.setText("<html>Esse é o campo que vai o código de Identificação do fornecedor. Atenção, Esse código será gerado pelo sistema.");
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
				PrincipalView.lblMensagemAjuda.setText("<html>Informe ou confirme a data do cadastro do fornecedor.");
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

				List<ModFornecedores> fornecedor = beansFornecedores.procurarNomeFornecedoresController(txtNome.getText());
				
				switch (acao) {
				case "novo": {
					if(!fornecedor.isEmpty()) {
						txtNome.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(255,0,0)));						
					} else {
						txtNome.setBorder(txtCadastro.getBorder());
					}
					break;
				}

				default:
					throw new IllegalArgumentException("Unexpected value: " + acao);
				}
				
				List<ModFornecedores> procurarFornecedor = new ArrayList<ModFornecedores>();					// essa nova lista de clientes vai						
				procurarFornecedor = beansFornecedores.procurarContemNomeFornecedoresController(txtNome.getText());		// selecionar o cliente com base no que o usuario digitar no campo
				popularTabelaFornecedores(procurarFornecedor);												// txtNome, usando o %LIKE%
			}
		});

		txtEndereco.addFocusListener(new java.awt.event.FocusAdapter() {
			public void focusGained(java.awt.event.FocusEvent evt) {
				PrincipalView.lblTituloAjuda.setText("Endereco");
				PrincipalView.lblMensagemAjuda.setText("<html>Informe o endereço do fornecedor.");

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
				
				List<ModFornecedores> listaFornecedores = new ArrayList<ModFornecedores>();
				listaFornecedores = beansFornecedores.listarFornecedoresController();
				popularTabelaFornecedores(listaFornecedores);

			}
			@Override
			public void focusLost(java.awt.event.FocusEvent evt) {

			}
		});

		txtComplemento.addFocusListener(new java.awt.event.FocusAdapter() {
			public void focusGained(java.awt.event.FocusEvent evt) {
				PrincipalView.lblTituloAjuda.setText("Complemento");
				PrincipalView.lblMensagemAjuda.setText("<html>Informe o complemento referente ao endereço do fornecedor.");
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
				PrincipalView.lblMensagemAjuda.setText("<html>Informe o nome da cidade referente ao endereço do fornecedor.");
			}
			public void focusLost(java.awt.event.FocusEvent evt) {
				String novo = CorrigeTexto.corrige(txtCidade.getText());              				// pega o texto digitado e mandar para a correção
				txtCidade.setText(novo);                                               				// retorna o texto digitado já corrigido

			}
		});

		txtCep.addFocusListener(new java.awt.event.FocusAdapter() {
			public void focusGained(java.awt.event.FocusEvent evt) {
				PrincipalView.lblTituloAjuda.setText("Cep");
				PrincipalView.lblMensagemAjuda.setText("<html>Informe o CEP referente ao endereço do fornecedor.");
			}
			public void focusLost(java.awt.event.FocusEvent evt) {

			}
		});

		txtUf.addFocusListener(new java.awt.event.FocusAdapter() {
			public void focusGained(java.awt.event.FocusEvent evt) {
				PrincipalView.lblTituloAjuda.setText("Estado");
				PrincipalView.lblMensagemAjuda.setText("<html>Informe o Estado referente ao endereço do fornecedor.");
			}
			public void focusLost(java.awt.event.FocusEvent evt) {
				txtUf.setText(txtUf.getText().toUpperCase());
			}
		});

		txtReferencia.addFocusListener(new java.awt.event.FocusAdapter() {
			public void focusGained(java.awt.event.FocusEvent evt) {
				PrincipalView.lblTituloAjuda.setText("Referencia");
				PrincipalView.lblMensagemAjuda.setText("<html>Informe uma referencia para o endereço do fornecedor. EX: perto da loja do Sr. manoel.");
			}
			public void focusLost(java.awt.event.FocusEvent evt) {
				String novo = CorrigeTexto.corrige(txtReferencia.getText());              				// pega o texto digitado e mandar para a correção
				txtReferencia.setText(novo);                                               				// retorna o texto digitado já corrigido            	
			}
		});

		txtCpfCgc.addFocusListener(new java.awt.event.FocusAdapter() {
			public void focusGained(java.awt.event.FocusEvent evt) {
				PrincipalView.lblTituloAjuda.setText("CPF ou CGC");
				PrincipalView.lblMensagemAjuda.setText("<html>Informe o numero do CPf ou o numero do CGC do fornecedor.");
			}
			public void focusLost(java.awt.event.FocusEvent evt) {
				ValidarCpfCgc.validar(txtCpfCgc, lblInformaCpfCgc);
				List<ModFornecedores> fornecedor = beansFornecedores.verSeExisteFornecedoresController(txtNome.getText(), txtCpfCgc.getText());
				if(acao == "novo") {
					if(!fornecedor.isEmpty()) {
						JOptionPane.showMessageDialog(null, "Desculpe, mas já tenho um fornecedor cadastrado com essas informações");
						txtNome.requestFocus();
					}
				}
			}
		});


		txtRgInscricao.addFocusListener(new java.awt.event.FocusAdapter() {
			public void focusGained(java.awt.event.FocusEvent evt) {
				PrincipalView.lblTituloAjuda.setText("Rg ou Inscrição");
				PrincipalView.lblMensagemAjuda.setText("<html>Informe o numero do Registro Geral do fornecedor ou o número da Inscrição Estadual.");
			}
			public void focusLost(java.awt.event.FocusEvent evt) {

			}
		});

		txtCelular1.addFocusListener(new java.awt.event.FocusAdapter() {
			public void focusGained(java.awt.event.FocusEvent evt) {
				PrincipalView.lblTituloAjuda.setText("Celular 1");
				PrincipalView.lblMensagemAjuda.setText("<html>Informe o número do telefone ou Celular do fornecedor.");
			}
			public void focusLost(java.awt.event.FocusEvent evt) {

			}
		});

		txtCelular2.addFocusListener(new java.awt.event.FocusAdapter() {
			public void focusGained(java.awt.event.FocusEvent evt) {
				PrincipalView.lblTituloAjuda.setText("Celular 2");
				PrincipalView.lblMensagemAjuda.setText("<html>Informe o número do telefone ou Celular do fornecedor");
			}
			public void focusLost(java.awt.event.FocusEvent evt) {
				ValidarCpfCgc.validar(txtCpfCgc, lblInformaCpfCgc);
			}
		});

		txtEmail1.addFocusListener(new java.awt.event.FocusAdapter() {
			public void focusGained(java.awt.event.FocusEvent evt) {
				PrincipalView.lblTituloAjuda.setText("Email");
				PrincipalView.lblMensagemAjuda.setText("<html>Informe o endereço de Email do fornecedor");
			}
			public void focusLost(java.awt.event.FocusEvent evt) {

			}
		});

		txtEmail1.addFocusListener(new java.awt.event.FocusAdapter() {
			public void focusGained(java.awt.event.FocusEvent evt) {
				PrincipalView.lblTituloAjuda.setText("Email");
				PrincipalView.lblMensagemAjuda.setText("<html>Informe o endereço de Email do fornecedor");
			}
			public void focusLost(java.awt.event.FocusEvent evt) {

			}
		});

		btnSalvar.addFocusListener(new java.awt.event.FocusAdapter() {
			public void focusGained(java.awt.event.FocusEvent evt) {
				PrincipalView.lblTituloAjuda.setText("Botão Salvar");
				PrincipalView.lblMensagemAjuda.setText("<html>Salva a ficha de cadastro de fornecedores");
			}
			public void focusLost(java.awt.event.FocusEvent evt) {

			}
		});

		btnNovo.addFocusListener(new java.awt.event.FocusAdapter() {
			public void focusGained(java.awt.event.FocusEvent evt) {
				PrincipalView.lblTituloAjuda.setText("Botão Novo");
				PrincipalView.lblMensagemAjuda.setText("<html>Abre o leque de capos para cadastrar um novo fornecedores");
			}
			public void focusLost(java.awt.event.FocusEvent evt) {

			}
		});


		/****************************************************************************************************/
		/* Trabalhando com opainel de botões do cadastro de Fornecedores.										*/
		/****************************************************************************************************/		
		/* mudando a cor do focus */
		//txtId.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0,0,255)));
		//txtId.setBorder(null);

		btnSalvar.addKeyListener(new java.awt.event.KeyAdapter() {
			@Override
			public void keyPressed(java.awt.event.KeyEvent evt) {
				ProximoCampo.enter(evt, btnNovo);
				acaoBtnSalvar();
			}
		});			

		btnSalvar.addActionListener((ActionEvent evt) -> {
			ProximoCampo.enter(evt, btnNovo);
			acaoBtnSalvar();
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
			txtNome.setBorder(txtCadastro.getBorder());								// definindo o campo do Id com enabled
		});


		btnCancelar.addActionListener((ActionEvent evt) ->{
			ProximoCampo.enter(evt, btnNovo);
			txtNome.setBorder(txtCadastro.getBorder());
			txtPesquisa.setText("");
			btnEditar.setEnabled(false);
			btnApagar.setEnabled(false);			
			List<ModFornecedores> fornecedor = new ArrayList<>();											// definindo uma lista com base no nosso modelo
			fornecedor = beansFornecedores.listarFornecedoresController();										// essa e nossa lista de clientes
			popularTabelaFornecedores(fornecedor);
		});

		btnCancelar.addKeyListener(new java.awt.event.KeyAdapter() {
			@Override
			public void keyPressed(java.awt.event.KeyEvent evt) {
				ProximoCampo.enter(evt, btnCancelar);
				txtNome.setBorder(txtCadastro.getBorder());
				txtPesquisa.setText("");
				btnEditar.setEnabled(false);
				btnApagar.setEnabled(false);
				List<ModFornecedores> fornecedor = new ArrayList<>();											// definindo uma lista com base no nosso modelo
				fornecedor = beansFornecedores.listarFornecedoresController();										// essa e nossa lista de clientes
				popularTabelaFornecedores(fornecedor);
			}
		});	

		btnApagar.addActionListener((ActionEvent evt) ->{
			UIManager.put("OptionPane.yesButtonText", "Sim");
			UIManager.put("OptionPane.noButtonText", "Não");   
			switch (JOptionPane.showConfirmDialog(null, "Apagar fornecedor?")){
			case 0: {
				beansFornecedores.deletarFornecedorController(Integer.parseInt(txtId.getText()));
				tabApoio.updateUI();
				LimparDados.limparDados(pnlCadastro);
				break;}
			case 1:{
				break;}
			}			
			List<ModFornecedores> fornecedor = new ArrayList<>();											// definindo uma lista com base no nosso modelo
			fornecedor = beansFornecedores.listarFornecedoresController();										// essa e nossa lista de clientes
			popularTabelaFornecedores(fornecedor);
			txtPesquisa.setText("");
			btnEditar.setEnabled(false);
			btnApagar.setEnabled(false);
		});

		btnEditar.addActionListener((ActionEvent evt) ->{
			txtCadastro.requestFocus();	
		});
		
	}


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
	private JLabel lblContato;
	private JLabel lblCelularContato;
	private JLabel lblEmail1;
	private JLabel lblEmail2;

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
	private JTextField txtContato;
	private JFormattedTextField txtCelularContato;
	private JTextField txtEmail1;
	private JTextField txtEmail2;

	/****************************************************************************************************/
	/* Essa é a área dos eventos que devem ser usados mais de uma vêz									*/
	/****************************************************************************************************/

	private ModFornecedores getDadosInterface(){
		
		ModFornecedores getFornecedores = new ModFornecedores();
		
		LocalDate retorno = null;																	// criando uma variavel de retorno		
		String data = this.txtCadastro.getText().trim();                                            // tirando os espacos em brancos
		data = data.replace("-", "").replace("_", "").replace("/", "");								// tirando os sinais extras	
		int dia = Integer.parseInt(data.substring(0, 2));											// poderia usar o split, acho que na proxima vou usar este
		int mes = Integer.parseInt(data.substring(2, 4));											// dividindo a data em dia, mes e ano
		int ano = Integer.parseInt(data.substring(4, 8));											// lembrano que o primeiro numero é o indece e o segundo a largura.	
		retorno = LocalDate.of(ano, mes, dia);														// definindo uma variavel "retorno" com a data digitada

		if(this.txtId.getText() != null){
			if(!this.txtId.getText().isEmpty()){
				getFornecedores.setId(Integer.parseInt(this.txtId.getText()));
			}    
		}
		getFornecedores.setCadastro(retorno);
		getFornecedores.setNome(this.txtNome.getText());
		getFornecedores.setEndereco(this.txtEndereco.getText());
		getFornecedores.setNumero(this.txtNumero.getText());
		getFornecedores.setComplemento(this.txtComplemento.getText());
		getFornecedores.setBairro(this.txtBairro.getText());
		getFornecedores.setCidade(this.txtCidade.getText());
		getFornecedores.setCep(this.txtCep.getText());
		getFornecedores.setUf(this.txtUf.getText());
		getFornecedores.setReferencia(this.txtReferencia.getText());
		getFornecedores.setCpfcgc(this.txtCpfCgc.getText());
		getFornecedores.setRginscricao(this.txtRgInscricao.getText());
		getFornecedores.setCelular1(this.txtCelular1.getText());
		getFornecedores.setCelular2(this.txtCelular2.getText());
		getFornecedores.setEmail1(this.txtEmail1.getText());
		getFornecedores.setEmail2(this.txtEmail2.getText());
		return getFornecedores;        
	}	   

	private void setDadosInterface(int linha) {
		ModFornecedores modFornecedores = new ModFornecedores();	
		modFornecedores = null;
		String retorno = null;																		// criando uma variavel de retorno		
		int idFornecedor = Integer.parseInt((String) tabApoio.getValueAt(linha, 0));
		modFornecedores = beansFornecedores.procurarIdFornecedorController(idFornecedor);

		String data = String.valueOf(modFornecedores.getCadastro());	                               // tirando os espacos em brancos	
		String pData[] = new String[3];
		pData = data.split("-");
		String ano = pData[0];																		// Agora to usando o Split
		String mes = pData[1];																		// dividindo a data em dia, mes e ano
		String dia = pData[2];																			
		retorno = dia+"/"+mes+"/"+ano;																	

		txtId.setText(String.valueOf(modFornecedores.getId()));
		txtCadastro.setText(retorno);
		txtNome.setText(modFornecedores.getNome());
		txtEndereco.setText(modFornecedores.getEndereco());
		txtNumero.setText(modFornecedores.getNumero());
		txtComplemento.setText(modFornecedores.getComplemento());
		txtBairro.setText(modFornecedores.getBairro());
		txtCidade.setText(modFornecedores.getCidade());
		txtCep.setText(modFornecedores.getCep());
		txtUf.setText(modFornecedores.getUf());
		txtReferencia.setText(modFornecedores.getReferencia());
		txtCpfCgc.setText(modFornecedores.getCpfcgc());
		txtRgInscricao.setText(modFornecedores.getRginscricao());
		txtCelular1.setText(modFornecedores.getCelular1());
		txtCelular2.setText(modFornecedores.getCelular2());
		txtContato.setText(modFornecedores.getContato());
		txtCelularContato.setText(modFornecedores.getCelularContato());
		txtEmail1.setText(modFornecedores.getEmail1());
		txtEmail2.setText(modFornecedores.getEmail2());		
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



	private void popularTabelaFornecedores(List<ModFornecedores> pListaDeFornecedores){
		if(pListaDeFornecedores != null) {
			tabApoio.setModel(new TabFornecedoresCadastro(pListaDeFornecedores));
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
					});
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
			String pCpfCgc = getDadosInterface().getCpfcgc();
			if(beansFornecedores.verSeExisteFornecedoresController(pNome, pCpfCgc).isEmpty()) {
				ModFornecedores modFornecedores = getDadosInterface();
				ModFornecedores fornecedorSalvo = beansFornecedores.salvarFornecedorController(modFornecedores);
				if(fornecedorSalvo != null){
					List<ModFornecedores> listaDeFornecedores = beansFornecedores.listarFornecedoresController();
					txtPesquisa.setText("");
					btnEditar.setEnabled(false);
					btnApagar.setEnabled(false);
					popularTabelaFornecedores(listaDeFornecedores);
				}else{
					JOptionPane.showMessageDialog(null, "Erro ao salvar o fornecedor.");
				}
			} else {
				JOptionPane.showMessageDialog(null, "Fornecedor Já Cadastrado");
				txtNome.requestFocus();
			}
		} else {
				ModFornecedores modFornecedores = getDadosInterface();
				boolean fornecedorSalvo = beansFornecedores.atualizarFornecedoresController(modFornecedores);
				if(fornecedorSalvo != false){
					List<ModFornecedores> listaDeFornecedores = beansFornecedores.listarFornecedoresController();
					popularTabelaFornecedores(listaDeFornecedores);
				}else{
					JOptionPane.showMessageDialog(null, "Erro ao Atualizar o cliente.");
				}	
			}

	}
	
		private void acaoPesquisar(KeyEvent evt) {
			List<ModFornecedores> procurarFornecedor = new ArrayList<ModFornecedores>();					// essa nova lista de clientes vai						
			procurarFornecedor = beansFornecedores.procurarContemNomeFornecedoresController(txtPesquisa.getText());  // selecionar o cliente com base no que o usuario digitar no campo
			popularTabelaFornecedores(procurarFornecedor);												// txtNome, usando o %LIKE%
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
