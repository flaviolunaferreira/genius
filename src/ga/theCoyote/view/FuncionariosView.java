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
import javax.swing.JPasswordField;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

import ga.theCoyote.controller.BeansCep;
import ga.theCoyote.controller.BeansFuncionarios;
import ga.theCoyote.controller.BeansFuncoesColaboradores;
import ga.theCoyote.model.ModCep;
import ga.theCoyote.model.ModFuncionarios;
import ga.theCoyote.model.ModFuncoesColaboradores;
import ga.theCoyote.model.forms.ModeloCadastro;
import ga.theCoyote.model.tableModel.TabFuncionariosCadastro;
import ga.theCoyote.uteis.AuxData;
import ga.theCoyote.uteis.CaixaTexto;
import ga.theCoyote.uteis.CorrigeTexto;
import ga.theCoyote.uteis.FormartarCampo;
import ga.theCoyote.uteis.LimparDados;
import ga.theCoyote.uteis.ProximoCampo;
import ga.theCoyote.uteis.TextoGeral;
import ga.theCoyote.uteis.TextoNumero;
import ga.theCoyote.uteis.ValidarCpfCgc;

public final class FuncionariosView extends ModeloCadastro{

	BeansFuncionarios beansFuncionarios = new BeansFuncionarios();
	BeansFuncoesColaboradores beansFuncoesColaboradores = new BeansFuncoesColaboradores();
	BeansCep beansCep = new BeansCep();

	
	public FuncionariosView() {
		inicializa();
		setVisible(true);
		lblTitulo.setText("Cadastro de Funcionários");
	}
	
	public void inicializa() {
		lblId = new JLabel("Id. Funcionário");
		lblCadastro = new JLabel("Cadastro");
		lblNome = new JLabel("Nome");
		lblEndereco = new JLabel("Endereço");
		lblComplemento = new JLabel("Complemento");
		lblNumero = new JLabel("Número");
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
		lblFuncao = new JLabel("Função");
		lblSenha = new JLabel("Senha");
		lblEmail1 = new JLabel("Email 1");
		lblEmail2 = new JLabel("Email 2");
		lblSalario = new JLabel("Salário");
		lblCargaHoraria = new JLabel("C. Horário");
		
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
		txtFuncao = new JTextField();
		txtSenha = new JPasswordField();
		txtEmail1 = new JTextField();
		txtEmail2 = new JTextField();
		txtSalario = new JFormattedTextField();
		txtCargaHoraria = new JFormattedTextField();
		
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
		txtSalario.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,###,##0.00"))));
		txtCargaHoraria.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter()));
		
		FormartarCampo.formatarData(txtCadastro);
		FormartarCampo.formatarCep(txtCep);
		FormartarCampo.formatarFone(txtCelular1);
		FormartarCampo.formatarFone(txtCelular2);
		
		lblId.setBounds(30, 80, 100, 27);
		lblCadastro.setBounds(441, 80, 80, 27); 		// largura total 648
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
		lblFuncao.setBounds(30, 380, 100, 27);
		lblSenha.setBounds(350, 380, 100, 27);
		lblEmail1.setBounds(30, 410, 80, 27);
		lblEmail2.setBounds(30, 440, 80, 27);
		lblSalario.setBounds(30, 470, 80, 27);
		lblCargaHoraria.setBounds(350, 470, 80, 27);

		
		txtId.setBounds(110, 80, 100, 27); 	
		txtCadastro.setBounds(508, 80, 108, 27);				// largura total 648
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
		txtFuncao.setBounds(110, 380, 200, 27);
		txtSenha.setBounds(410, 380, 208, 27);
		txtEmail1.setBounds(110, 410, 508, 27);
		txtEmail2.setBounds(110, 440, 508, 27);
		txtSalario.setBounds(110, 470, 200, 27);
		txtCargaHoraria.setBounds(410, 470, 208, 27);

		
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
		pnlCadastro.add(lblFuncao);
		pnlCadastro.add(lblSenha);
		pnlCadastro.add(lblEmail1);
		pnlCadastro.add(lblEmail2);
		pnlCadastro.add(lblSalario);
		pnlCadastro.add(lblCargaHoraria);
		
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
		pnlCadastro.add(txtFuncao);
		pnlCadastro.add(txtSenha);
		pnlCadastro.add(txtEmail1);
		pnlCadastro.add(txtEmail2);
		pnlCadastro.add(txtSalario);
		pnlCadastro.add(txtCargaHoraria);
		
/****************************************************************************************************/
/* comecando os eventos																				*/
/****************************************************************************************************/	
		/* vou colocar todos os campos de edicao com a propriedade enabled = false					*/
		/* e ativar a medida que for precisando														*/
		CaixaTexto.desativar(pnlCadastro);
		btnEditar.setEnabled(false);
		btnApagar.setEnabled(false);

		List<ModFuncionarios> listaFuncionarios = new ArrayList<ModFuncionarios>();
		listaFuncionarios = beansFuncionarios.listarFuncionariosController();
		popularTabelaFuncionarios(listaFuncionarios);
		tabApoio.setEnabled(false);

		/* quando a tecla enter for pressionada														*/
		txtId.addKeyListener(new java.awt.event.KeyAdapter() {
			@Override
			public void keyPressed(java.awt.event.KeyEvent evt) {ProximoCampo.enter(evt, txtCadastro);}
		});	
		
		txtCadastro.addKeyListener(new java.awt.event.KeyAdapter() {
			@Override
			public void keyPressed(java.awt.event.KeyEvent evt) {ProximoCampo.enter(evt, txtNome);
			}
		});

		txtNome.addKeyListener(new java.awt.event.KeyAdapter() {
			@Override
			public void keyPressed(java.awt.event.KeyEvent evt) {
				ProximoCampo.enter(evt, txtEndereco);
				List<ModFuncionarios> procurarFuncionarios = new ArrayList<ModFuncionarios>();
				procurarFuncionarios = beansFuncionarios.procurarContemNomeFuncionariosController(txtNome.getText());
				popularTabelaFuncionarios(procurarFuncionarios);
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
			public void keyPressed(java.awt.event.KeyEvent evt) {ProximoCampo.enter(evt, txtFuncao);}
		});			

		txtFuncao.addKeyListener(new java.awt.event.KeyAdapter() {
			@Override
			public void keyPressed(java.awt.event.KeyEvent evt) {
				Integer tabLinha = 0;
				List<ModFuncoesColaboradores> pFuncoesColaboradores = new ArrayList<ModFuncoesColaboradores>();
				pFuncoesColaboradores = beansFuncoesColaboradores.procurarContemNomeFuncoesColaboradoresController(txtFuncao.getText());
				popularTabelaFuncoesColaboradores(pFuncoesColaboradores);
				if(evt.getKeyCode() == 10) {
					txtSenha.requestFocus();
					if(pFuncoesColaboradores.size()>0) {													// se tiver algo na lista, pega sempre o primeiro						
						txtFuncao.setText(pFuncoesColaboradores.get(tabLinha).getFuncaoColaboradores());
					}
				}
			}
		});			

		txtSenha.addKeyListener(new java.awt.event.KeyAdapter() {
			@Override
			public void keyPressed(java.awt.event.KeyEvent evt) {ProximoCampo.enter(evt, txtEmail1);}
		});	

		txtEmail1.addKeyListener(new java.awt.event.KeyAdapter() {
			@Override
			public void keyPressed(java.awt.event.KeyEvent evt) {ProximoCampo.enter(evt, txtEmail2);}
		});	
		
		txtEmail2.addKeyListener(new java.awt.event.KeyAdapter() {
			@Override
			public void keyPressed(java.awt.event.KeyEvent evt) {ProximoCampo.enter(evt, txtSalario);}
		});	
		
		txtSalario.addKeyListener(new java.awt.event.KeyAdapter() {
			@Override
			public void keyPressed(java.awt.event.KeyEvent evt) {ProximoCampo.enter(evt, txtCargaHoraria);}
		});	

		txtCargaHoraria.addKeyListener(new java.awt.event.KeyAdapter() {
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
				PrincipalView.lblMensagemAjuda.setText("<html>Esse é o campo que vai o código de Identificação do funcionario. Atenção, Esse código será gerado pelo sistema.");
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
				PrincipalView.lblMensagemAjuda.setText("<html>Informe ou confirme a data do cadastro do funcionario.");
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
				PrincipalView.lblMensagemAjuda.setText("<html>Informe o nome do funcionario.");
			}
			public void focusLost(java.awt.event.FocusEvent evt) {
				String novo = CorrigeTexto.corrige(txtNome.getText());                				// pega o texto digitado e mandar para a correção
				txtNome.setText(novo);                                                				// retorna o texto digitado já corrigido

				List<ModFuncionarios> funcionarios = beansFuncionarios.procurarNomeFuncionariosController(txtNome.getText());
				
				switch (acao) {
				case "novo": {
					if(!funcionarios.isEmpty()) {
						txtNome.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(255,0,0)));						
					} else {
						txtNome.setBorder(txtCadastro.getBorder());
					}
					break;
				}

				default:
					throw new IllegalArgumentException("Unexpected value: " + acao);
				}
				
				List<ModFuncionarios> procurarFuncionario = new ArrayList<ModFuncionarios>();					// essa nova lista de clientes vai						
				procurarFuncionario = beansFuncionarios.procurarContemNomeFuncionariosController(txtNome.getText());		// selecionar o cliente com base no que o usuario digitar no campo
				popularTabelaFuncionarios(procurarFuncionario);												// txtNome, usando o %LIKE%
			}
		});

		txtEndereco.addFocusListener(new java.awt.event.FocusAdapter() {
			public void focusGained(java.awt.event.FocusEvent evt) {
				PrincipalView.lblTituloAjuda.setText("Endereco");
				PrincipalView.lblMensagemAjuda.setText("<html>Informe o endereço do funcionario.");

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
			}
			@Override
			public void focusLost(java.awt.event.FocusEvent evt) {

			}
		});

		txtComplemento.addFocusListener(new java.awt.event.FocusAdapter() {
			public void focusGained(java.awt.event.FocusEvent evt) {
				PrincipalView.lblTituloAjuda.setText("Complemento");
				PrincipalView.lblMensagemAjuda.setText("<html>Informe o complemento referente ao endereço do funcionario.");
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
				PrincipalView.lblMensagemAjuda.setText("<html>Informe o nome da cidade referente ao endereço do funcionario.");
			}
			public void focusLost(java.awt.event.FocusEvent evt) {
				String novo = CorrigeTexto.corrige(txtCidade.getText());              				// pega o texto digitado e mandar para a correção
				txtCidade.setText(novo);                                               				// retorna o texto digitado já corrigido

			}
		});

		txtCep.addFocusListener(new java.awt.event.FocusAdapter() {
			public void focusGained(java.awt.event.FocusEvent evt) {
				PrincipalView.lblTituloAjuda.setText("Cep");
				PrincipalView.lblMensagemAjuda.setText("<html>Informe o CEP referente ao endereço do funcionario.");
			}
			public void focusLost(java.awt.event.FocusEvent evt) {

			}
		});

		txtUf.addFocusListener(new java.awt.event.FocusAdapter() {
			public void focusGained(java.awt.event.FocusEvent evt) {
				PrincipalView.lblTituloAjuda.setText("Estado");
				PrincipalView.lblMensagemAjuda.setText("<html>Informe o Estado referente ao endereço do funcionario.");
			}
			public void focusLost(java.awt.event.FocusEvent evt) {
				txtUf.setText(txtUf.getText().toUpperCase());
			}
		});

		txtReferencia.addFocusListener(new java.awt.event.FocusAdapter() {
			public void focusGained(java.awt.event.FocusEvent evt) {
				PrincipalView.lblTituloAjuda.setText("Referencia");
				PrincipalView.lblMensagemAjuda.setText("<html>Informe uma referencia para o endereço do funcionario. EX: perto da loja do Sr. manoel.");
			}
			public void focusLost(java.awt.event.FocusEvent evt) {
				String novo = CorrigeTexto.corrige(txtReferencia.getText());              				// pega o texto digitado e mandar para a correção
				txtReferencia.setText(novo);                                               				// retorna o texto digitado já corrigido            	
			}
		});

		txtCpfCgc.addFocusListener(new java.awt.event.FocusAdapter() {
			public void focusGained(java.awt.event.FocusEvent evt) {
				PrincipalView.lblTituloAjuda.setText("CPF ou CGC");
				PrincipalView.lblMensagemAjuda.setText("<html>Informe o numero do CPf ou o numero do CGC do funcionario.");
			}
			public void focusLost(java.awt.event.FocusEvent evt) {
				ValidarCpfCgc.validar(txtCpfCgc, lblInformaCpfCgc);
				List<ModFuncionarios> funcionarios = beansFuncionarios.verSeExisteFuncionariosController(txtNome.getText(), txtCpfCgc.getText());
				if(acao == "novo") {
					if(!funcionarios.isEmpty()) {
						JOptionPane.showMessageDialog(null, "Desculpe, mas já tenho um funcionário cadastrado com essas informações");
						txtNome.requestFocus();
					}
				}
			}
		});


		txtRgInscricao.addFocusListener(new java.awt.event.FocusAdapter() {
			public void focusGained(java.awt.event.FocusEvent evt) {
				PrincipalView.lblTituloAjuda.setText("Rg ou Inscrição");
				PrincipalView.lblMensagemAjuda.setText("<html>Informe o numero do Registro Geral do funcionario ou o número da Inscrição Estadual.");
			}
			public void focusLost(java.awt.event.FocusEvent evt) {

			}
		});

		txtCelular1.addFocusListener(new java.awt.event.FocusAdapter() {
			public void focusGained(java.awt.event.FocusEvent evt) {
				PrincipalView.lblTituloAjuda.setText("Celular 1");
				PrincipalView.lblMensagemAjuda.setText("<html>Informe o número do telefone ou Celular do funcionario.");
			}
			public void focusLost(java.awt.event.FocusEvent evt) {

			}
		});

		txtCelular2.addFocusListener(new java.awt.event.FocusAdapter() {
			public void focusGained(java.awt.event.FocusEvent evt) {
				PrincipalView.lblTituloAjuda.setText("Celular 2");
				PrincipalView.lblMensagemAjuda.setText("<html>Informe o número do telefone ou Celular do funcionario");
			}
			public void focusLost(java.awt.event.FocusEvent evt) {

			}
		});
		
		txtFuncao.addFocusListener(new java.awt.event.FocusAdapter() {
			public void focusGained(java.awt.event.FocusEvent evt) {
				PrincipalView.lblTituloAjuda.setText("Função");
				PrincipalView.lblMensagemAjuda.setText("<html>Informe a Função do Colaborador.");
				List<ModFuncoesColaboradores> listaFuncoesColaboradores = new ArrayList<ModFuncoesColaboradores>();
				listaFuncoesColaboradores = beansFuncoesColaboradores.listarFuncoesColaboradoresController();
				popularTabelaFuncoesColaboradores(listaFuncoesColaboradores);
			}
			public void focusLost(java.awt.event.FocusEvent evt) {

			}
		});
		

		txtEmail1.addFocusListener(new java.awt.event.FocusAdapter() {
			public void focusGained(java.awt.event.FocusEvent evt) {
				PrincipalView.lblTituloAjuda.setText("Email");
				PrincipalView.lblMensagemAjuda.setText("<html>Informe o endereço de Email do funcionario");
			}
			public void focusLost(java.awt.event.FocusEvent evt) {

			}
		});

		txtEmail1.addFocusListener(new java.awt.event.FocusAdapter() {
			public void focusGained(java.awt.event.FocusEvent evt) {
				PrincipalView.lblTituloAjuda.setText("Email");
				PrincipalView.lblMensagemAjuda.setText("<html>Informe o endereço de Email do funcionario");
			}
			public void focusLost(java.awt.event.FocusEvent evt) {

			}
		});

		txtSalario.addFocusListener(new java.awt.event.FocusAdapter() {
			public void focusGained(java.awt.event.FocusEvent evt) {
				PrincipalView.lblTituloAjuda.setText("Email");
				PrincipalView.lblMensagemAjuda.setText("<html>Informe o salario do funcionario");
			}
			public void focusLost(java.awt.event.FocusEvent evt) {

			}
		});
		
		txtSenha.addFocusListener(new java.awt.event.FocusAdapter() {
			public void focusGained(java.awt.event.FocusEvent evt) {
				PrincipalView.lblTituloAjuda.setText("Email");
				PrincipalView.lblMensagemAjuda.setText("<html>Informe o a senha do funcionario");
			}
			public void focusLost(java.awt.event.FocusEvent evt) {

			}
		});
		
		btnSalvar.addFocusListener(new java.awt.event.FocusAdapter() {
			public void focusGained(java.awt.event.FocusEvent evt) {
				PrincipalView.lblTituloAjuda.setText("Botão Salvar");
				PrincipalView.lblMensagemAjuda.setText("<html>Salva a ficha de cadastro de funcionarios");
			}
			public void focusLost(java.awt.event.FocusEvent evt) {

			}
		});

		btnNovo.addFocusListener(new java.awt.event.FocusAdapter() {
			public void focusGained(java.awt.event.FocusEvent evt) {
				PrincipalView.lblTituloAjuda.setText("Botão Novo");
				PrincipalView.lblMensagemAjuda.setText("<html>Abre o leque de capos para cadastrar um novo funcionarios");
			}
			public void focusLost(java.awt.event.FocusEvent evt) {

			}
		});


		
		
		/****************************************************************************************************/
		/* Trabalhando com opainel de botões do cadastro de Clientes.										*/
		/****************************************************************************************************/		
		
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
			txtId.setEnabled(false); 															// definindo o campo do Id com enabled
			btnEditar.setEnabled(false);
			btnApagar.setEnabled(false);
			ProximoCampo.enter(evt, txtCadastro);
			txtNome.setBorder(txtCadastro.getBorder());																// definindo o campo do Id com enabled
		});

		btnCancelar.addActionListener((ActionEvent evt) ->{
			ProximoCampo.enter(evt, btnNovo);
			txtNome.setBorder(txtCadastro.getBorder());
			txtPesquisa.setText("");
			btnEditar.setEnabled(false);
			btnApagar.setEnabled(false);
			List<ModFuncionarios> funcionarios = new ArrayList<>();									// definindo uma lista com base no nosso modelo
			funcionarios = beansFuncionarios.listarFuncionariosController();						// essa e nossa lista de funcionarios
			popularTabelaFuncionarios(funcionarios);
		});

		btnCancelar.addKeyListener(new java.awt.event.KeyAdapter() {
			@Override
			public void keyPressed(java.awt.event.KeyEvent evt) {
				ProximoCampo.enter(evt, btnNovo);
				txtNome.setBorder(txtCadastro.getBorder());
				txtPesquisa.setText("");
				btnEditar.setEnabled(false);
				btnApagar.setEnabled(false);
				List<ModFuncionarios> funcionarios = new ArrayList<>();									// definindo uma lista com base no nosso modelo
				funcionarios = beansFuncionarios.listarFuncionariosController();						// essa e nossa lista de funcionarios
				popularTabelaFuncionarios(funcionarios);
			}
		});	
		
		btnApagar.addActionListener((ActionEvent evt) -> {
			UIManager.put("OptionPane.yesButtonText", "Sim");
			UIManager.put("OptionPane.noButtonText", "Não");   
			switch (JOptionPane.showConfirmDialog(null, "Apagar Cliente?")){
			case 0: {
				beansFuncionarios.deletarFuncionarioController(Integer.parseInt(txtId.getText()));
				tabApoio.updateUI();
				LimparDados.limparDados(pnlCadastro);
				break;}
			case 1:{
				break;}
			}			
			txtPesquisa.setText("");
			btnEditar.setEnabled(false);
			btnApagar.setEnabled(false);
			List<ModFuncionarios> funcionario = new ArrayList<>();											// definindo uma lista com base no nosso modelo
			funcionario = beansFuncionarios.listarFuncionariosController();										// essa e nossa lista de funcionarios
			popularTabelaFuncionarios(funcionario);
		});
		
		btnEditar.addActionListener((ActionEvent evt) ->{
			txtCadastro.requestFocus();	
		});
		
	}

	private JLabel lblId;
	private JLabel lblNome;
	private JLabel lblCadastro;
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
	private JLabel lblFuncao;
	private JLabel lblSenha;
	private JLabel lblEmail1;
	private JLabel lblEmail2;
	private JLabel lblSalario;
	private JLabel lblCargaHoraria;
	
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
	private JTextField txtFuncao;
	private JPasswordField txtSenha;
	private JTextField txtEmail1;
	private JTextField txtEmail2;
	private JFormattedTextField txtSalario;
	private JFormattedTextField txtCargaHoraria;

	/****************************************************************************************************/
	/* Essa é a área dos eventos que devem ser usados mais de uma vêz									*/
	/****************************************************************************************************/

	private ModFuncionarios getDadosInterface(){
		
		ModFuncionarios getFuncionarios = new  ModFuncionarios();
		
		LocalDate retorno = null;																	// criando uma variavel de retorno		
		String data = this.txtCadastro.getText().trim();                                            // tirando os espacos em brancos
		data = data.replace("-", "").replace("_", "").replace("/", "");								// tirando os sinais extras	
		int dia = Integer.parseInt(data.substring(0, 2));											// poderia usar o split, acho que na proxima vou usar este
		int mes = Integer.parseInt(data.substring(2, 4));											// dividindo a data em dia, mes e ano
		int ano = Integer.parseInt(data.substring(4, 8));											// lembrano que o primeiro numero é o indece e o segundo a largura.	
		retorno = LocalDate.of(ano, mes, dia);														// definindo uma variavel "retorno" com a data digitada
		String valorDoSalario = txtSalario.getText().replace(".", "").replace(",", ".");
		
		if(this.txtId.getText() != null) {
			if(!this.txtId.getText().isEmpty()) {
				getFuncionarios.setId(Integer.parseInt(this.txtId.getText()));
			}
		}
		

		getFuncionarios.setCadastro(retorno);
		getFuncionarios.setNome(this.txtNome.getText());
		getFuncionarios.setEndereco(this.txtEndereco.getText());
		getFuncionarios.setNumero(this.txtNumero.getText());
		getFuncionarios.setComplemento(this.txtComplemento.getText());
		getFuncionarios.setBairro(this.txtBairro.getText());
		getFuncionarios.setCidade(this.txtCidade.getText());
		getFuncionarios.setCep(this.txtCep.getText());
		getFuncionarios.setUf(this.txtUf.getText());
		getFuncionarios.setReferencia(this.txtReferencia.getText());
		getFuncionarios.setCpfCgc(this.txtCpfCgc.getText());
		getFuncionarios.setRgInscricao(this.txtRgInscricao.getText());
		getFuncionarios.setCelular1(this.txtCelular1.getText());
		getFuncionarios.setCelular2(this.txtCelular2.getText());
		
		List<ModFuncoesColaboradores> procurarFuncao = new ArrayList<ModFuncoesColaboradores>();
		procurarFuncao = beansFuncoesColaboradores.procurarContemNomeFuncoesColaboradoresController(txtFuncao.getText());
		getFuncionarios.setFuncao((ModFuncoesColaboradores) procurarFuncao.get(0));

		getFuncionarios.setSenha(new String(this.txtSenha.getPassword()));
		getFuncionarios.setEmail1(this.txtEmail1.getText());
		getFuncionarios.setEmail2(this.txtEmail2.getText());
		if(!txtSalario.getText().isEmpty()) {
			getFuncionarios.setSalario(new BigDecimal(valorDoSalario));
		}else {
			getFuncionarios.setSalario(new BigDecimal(0.00));
		}
		if(!txtCargaHoraria.getText().isEmpty()) {
			getFuncionarios.setCargaHoraria(Integer.parseInt(this.txtCargaHoraria.getText()));
		} else {
			getFuncionarios.setCargaHoraria((Integer) 0);
		}
		
		getFuncionarios.setNivelAcesso(1);
		
		return getFuncionarios;   
	}	   
	
	private void setDadosInterface(int linha) {
		ModFuncionarios modFuncionarios = new ModFuncionarios();	
		modFuncionarios = null;
		String retorno = null;																		// criando uma variavel de retorno		
		int idFuncionario = Integer.parseInt((String) tabApoio.getValueAt(linha, 0));
		modFuncionarios = beansFuncionarios.procurarIdFuncionarioController(idFuncionario);

		String data = String.valueOf(modFuncionarios.getCadastro());	                               // tirando os espacos em brancos	
		String pData[] = new String[3];
		pData = data.split("-");
		String ano = pData[0];																		// Agora to usando o Split
		String mes = pData[1];																		// dividindo a data em dia, mes e ano
		String dia = pData[2];																			
		retorno = dia+"/"+mes+"/"+ano;																	

		txtId.setText(String.valueOf(modFuncionarios.getId()));
		txtCadastro.setText(retorno);
		txtNome.setText(modFuncionarios.getNome());
		txtEndereco.setText(modFuncionarios.getEndereco());
		txtNumero.setText(modFuncionarios.getNumero());
		txtComplemento.setText(modFuncionarios.getComplemento());
		txtBairro.setText(modFuncionarios.getBairro());
		txtCidade.setText(modFuncionarios.getCidade());
		txtCep.setText(modFuncionarios.getCep());
		txtUf.setText(modFuncionarios.getUf());
		txtReferencia.setText(modFuncionarios.getReferencia());
		txtCpfCgc.setText(modFuncionarios.getCpfCgc());
		txtRgInscricao.setText(modFuncionarios.getRgInscricao());
		txtCelular1.setText(modFuncionarios.getCelular1());
		txtCelular2.setText(modFuncionarios.getCelular2());
		txtEmail1.setText(modFuncionarios.getEmail1());
		txtEmail2.setText(modFuncionarios.getEmail2());	
		txtFuncao.setText(modFuncionarios.getFuncao().getFuncaoColaboradores());
		
		
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



	private void popularTabelaFuncionarios(List<ModFuncionarios> pListaDeFuncionarios){
		if(pListaDeFuncionarios != null) {
			tabApoio.setModel(new TabFuncionariosCadastro(pListaDeFuncionarios));
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
	
	private void popularTabelaFuncoesColaboradores(List<ModFuncoesColaboradores> pListaFuncoesColaboradores) {
		DefaultTableModel modeloTabela = new DefaultTableModel();
		tabApoio.setModel(modeloTabela);
		modeloTabela.addColumn("Função");
		modeloTabela.addColumn("Proventos");
		modeloTabela.addColumn("Horas");

		tabApoio.getColumnModel().getColumn(0).setPreferredWidth(370);
		tabApoio.getColumnModel().getColumn(1).setPreferredWidth(155);
		tabApoio.getColumnModel().getColumn(2).setPreferredWidth(100);
		tabApoio.getColumnModel().getColumn(0).setResizable(false);
		tabApoio.getColumnModel().getColumn(1).setResizable(false);	
		tabApoio.getColumnModel().getColumn(2).setResizable(false);
		tabApoio.getTableHeader().setReorderingAllowed(true);
		tabApoio.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		tabApoio.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		for (ModFuncoesColaboradores modFuncoesColaboradores : pListaFuncoesColaboradores) {
			modeloTabela.addRow(
					new Object[]{
							modFuncoesColaboradores.getFuncaoColaboradores(),
							modFuncoesColaboradores.getProventos(),
							modFuncoesColaboradores.getCargaHoraria()
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
			if(beansFuncionarios.verSeExisteFuncionariosController(pNome, pCpfCgc).isEmpty()) {
				ModFuncionarios modFuncionarios = getDadosInterface();
				ModFuncionarios funcionarioSalvo = beansFuncionarios.salvarFuncionarioController(modFuncionarios);
				if(funcionarioSalvo != null){
					List<ModFuncionarios> listaDeFuncionarios = beansFuncionarios.listarFuncionariosController();
					popularTabelaFuncionarios(listaDeFuncionarios);
				}else{
					JOptionPane.showMessageDialog(null, "Erro ao salvar o funcionário.");
				}
			} else {
				JOptionPane.showMessageDialog(null, "Funcionário Já Cadastrado");
				txtNome.requestFocus();
			}
		} else {
				ModFuncionarios modFuncionarios = getDadosInterface();
				boolean funcionarioSalvo = beansFuncionarios.atualizarFuncionariosController(modFuncionarios);
				if(funcionarioSalvo != false){
					List<ModFuncionarios> listaDeFuncionarios = beansFuncionarios.listarFuncionariosController();
					txtPesquisa.setText("");
					btnEditar.setEnabled(false);
					btnApagar.setEnabled(false);
					popularTabelaFuncionarios(listaDeFuncionarios);

				}else{
					JOptionPane.showMessageDialog(null, "Erro ao Atualizar o funcionarios.");
				}	
			}

	}

	private void acaoPesquisar(KeyEvent evt) {
		List<ModFuncionarios> procurarFuncionario = new ArrayList<ModFuncionarios>();					// essa nova lista de funcionario vai						
		procurarFuncionario = beansFuncionarios.procurarContemNomeFuncionariosController(txtPesquisa.getText());  // selecionar o funcionario com base no que o usuario digitar no campo
		popularTabelaFuncionarios(procurarFuncionario);												// txtNome, usando o %LIKE%
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
