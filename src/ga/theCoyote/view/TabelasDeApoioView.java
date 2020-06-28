package ga.theCoyote.view;

import java.awt.event.ActionEvent;
import java.math.BigDecimal;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import ga.theCoyote.controller.BeansFabricantes;
import ga.theCoyote.controller.BeansFamiliaTributaria;
import ga.theCoyote.controller.BeansFuncoesColaboradores;
import ga.theCoyote.controller.BeansGrupo;
import ga.theCoyote.controller.BeansSituacaoCliente;
import ga.theCoyote.controller.BeansSubGrupo;
import ga.theCoyote.controller.BeansTipoClientes;
import ga.theCoyote.controller.BeansTipoProduto;
import ga.theCoyote.model.ModFabricantes;
import ga.theCoyote.model.ModFamiliaTributaria;
import ga.theCoyote.model.ModFuncoesColaboradores;
import ga.theCoyote.model.ModGrupo;
import ga.theCoyote.model.ModSituacaoCliente;
import ga.theCoyote.model.ModSubGrupo;
import ga.theCoyote.model.ModTipoCliente;
import ga.theCoyote.model.ModTipoProduto;
import ga.theCoyote.model.forms.ModeloCadastro;
import ga.theCoyote.uteis.AuxBtn;
import ga.theCoyote.uteis.CaixaTexto;
import ga.theCoyote.uteis.CorrigeTexto;
import ga.theCoyote.uteis.ProximoCampo;

public class TabelasDeApoioView extends ModeloCadastro{

	String quem = null;																				// variavel de controle para as tabelas
	ModTipoCliente modTipoCliente = new ModTipoCliente();
	BeansTipoClientes beansTipoCliente = new BeansTipoClientes();
	ModSituacaoCliente modSituacaoCliente = new ModSituacaoCliente();
	BeansSituacaoCliente beansSituacaoCliente = new BeansSituacaoCliente();
	BeansFuncoesColaboradores beansFuncoesColaboradores = new BeansFuncoesColaboradores();
	ModFabricantes modFabricantes = new ModFabricantes();
	BeansFabricantes beansFabricantes = new BeansFabricantes();
	ModTipoProduto modTipoProduto = new ModTipoProduto();
	BeansTipoProduto beansTipoProduto = new BeansTipoProduto();
	ModFamiliaTributaria modFamiliaTributaria = new ModFamiliaTributaria();
	BeansFamiliaTributaria beansFamiliaTributaria = new BeansFamiliaTributaria();
	ModGrupo modGrupo = new ModGrupo();
	BeansGrupo beansGrupo = new BeansGrupo();
	ModSubGrupo modSubGrupo = new ModSubGrupo();
	BeansSubGrupo beansSubGrupo = new BeansSubGrupo();

	public TabelasDeApoioView() {
		inicializa();
		lblTitulo.setText("Tabelas de Apoio");
	}

	public final void inicializa() {
		/*	Estes são os botoes para as opções do cadastro de tabelas auxiliares					*/
		btnTipoCliente = new JButton("T. Cliente");
		btnSituacaoCliente = new JButton("S. Cliente");
		btnFuncaoColaborador = new JButton("F. Colaborador");
		btnFabricante = new JButton("Fabricante");
		btnTipoProduto = new JButton("T. Produto");
		btnFamiliaTributaria = new JButton("F. Tributaria");
		btnGrupo = new JButton("Grupo");
		btnSubGrupo = new JButton("SubGrupo");

		/* vou tentar usar os mesmos componentes para cadastro diferentes							*/
		lblDescricao = new JLabel("Descrição");
		lblDescontoAcrescimo = new JLabel("Desc.- Acresc.");
		lblPrazo = new JLabel("Prazo");
		lblBloquear = new JLabel("Bloquear?");
		lblProventos = new JLabel("Proventos R$");
		lblHoras = new JLabel("C. Horária");
		lblInformarComposicao = new JLabel("Neste tipo, você precisa informar a composição?");
		lblFormatarCusto = new JLabel("Posso formatar o custo deste produto?");
		lblVender = new JLabel("Esse produto pode ser vendido pelo Departamento de Vendas?");
		lblPerecivel = new JLabel("Gostaria de controlar a data de vencimento do produto?");
		lblIpi = new JLabel("IPI");
		lblIcms = new JLabel("ICMS");
		lblPis = new JLabel("PIS");
		lblCofins = new JLabel("COFINS");
		lblIss = new JLabel("ISS");
		lblReferencia = new JLabel("Referencia");

		/* os campos de edição																		*/
		txtDescricao = new JTextField();
		txtDescontoAcrescimo= new JFormattedTextField();
		txtPrazo = new JFormattedTextField();
		txtProventos = new JFormattedTextField();
		txtHoras = new JFormattedTextField();
		txtBloquear = new JCheckBox();
		txtInformarComposicao = new JCheckBox();
		txtFormatarCusto = new JCheckBox();
		txtVender = new JCheckBox();
		txtPerecivel = new JCheckBox();
		txtIpi = new JFormattedTextField();
		txtIcms = new JFormattedTextField();
		txtPis = new JFormattedTextField();
		txtCofins = new JFormattedTextField();
		txtIss = new JFormattedTextField();	
		txtReferencia = new JTextField();
		
		txtDescontoAcrescimo.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,###,##0.00"))));
		txtProventos.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,###,##0.00"))));
		txtIcms.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,###,##0.00"))));
		txtPis.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,###,##0.00"))));
		txtCofins.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,###,##0.00"))));
		txtIss.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,###,##0.00"))));

		txtPrazo.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter()));
		txtHoras.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter()));

		/*	vou formatar aqui os campos numericos													*/
		txtDescontoAcrescimo.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("###,###.00"))));
		txtPrazo.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("###,#00"))));
		txtDescontoAcrescimo.setAlignmentX(RIGHT_ALIGNMENT);


		/* usando uma rotina para montar os botoes													*/
		AuxBtn.montarButao(btnTipoCliente, pnlInformacoes, 0, 0);
		AuxBtn.montarButao(btnSituacaoCliente, pnlInformacoes, 1, 0);
		AuxBtn.montarButao(btnFuncaoColaborador, pnlInformacoes, 2, 0);
		AuxBtn.montarButao(btnFabricante, pnlInformacoes, 0, 1);
		AuxBtn.montarButao(btnTipoProduto, pnlInformacoes, 1, 1);
		AuxBtn.montarButao(btnFamiliaTributaria, pnlInformacoes, 2, 1);
		AuxBtn.montarButao(btnGrupo, pnlInformacoes, 0, 2);
		AuxBtn.montarButao(btnSubGrupo, pnlInformacoes, 1, 2);

		/* desativanto os botoes de acoes do banco de dados											*/
		AuxBtn.desativarBotoes(pnlBotoes);
		btnFechar.setEnabled(true);

		/****************************************************************************************************/
		/*	Vou montar as tabelas de apoio aquí para diminuir o numero de botoes no painel principal		*/
		/****************************************************************************************************/
		/********************************************************************************************/
		/* vou comessar com o painel de cadastro de tipo de clientes								*/
		/********************************************************************************************/
		btnTipoCliente.addActionListener((ActionEvent) -> {
			if(quem != "tipoCliente") {
				quem = "tipoCliente";

				acaoBtnSalvar(pnlCadastro);

				List<ModTipoCliente> listarTipoCliente = beansTipoCliente.listarTipoClienteController();
				popularTabelaTipoCliente(listarTipoCliente);

				lblTitulo.setText("Cadastro de Tipo de Clientes");
				pnlCadastro.removeAll();

				lblDescricao.setBounds(30, 80, 100, 27);
				lblDescontoAcrescimo.setBounds(30, 110, 100, 27);
				lblPrazo.setBounds(350, 110, 100, 27);

				txtDescricao.setBounds(110, 80, 508, 27);
				txtDescontoAcrescimo.setBounds(110, 110, 200, 27);
				txtPrazo.setBounds(410, 110, 208, 27);

				pnlCadastro.add(pnlTitulo);
				pnlCadastro.add(lblDescricao);
				pnlCadastro.add(lblDescontoAcrescimo);
				pnlCadastro.add(lblPrazo);
				pnlCadastro.add(txtDescricao);
				pnlCadastro.add(txtDescontoAcrescimo);
				pnlCadastro.add(txtPrazo);

				CaixaTexto.desativar(pnlCadastro);

				pnlCadastro.validate();
				pnlCadastro.repaint();

				txtDescricao.addKeyListener(new java.awt.event.KeyAdapter() {
					@Override
					public void keyPressed(java.awt.event.KeyEvent evt) {
						ProximoCampo.enter(evt, txtDescontoAcrescimo);
					}
				});

				txtDescontoAcrescimo.addKeyListener(new java.awt.event.KeyAdapter() {
					@Override
					public void keyPressed(java.awt.event.KeyEvent evt) {ProximoCampo.enter(evt, txtPrazo);}
				});	

				txtPrazo.addKeyListener(new java.awt.event.KeyAdapter() {
					@Override
					public void keyPressed(java.awt.event.KeyEvent evt) {ProximoCampo.enter(evt, btnSalvar);}
				});	
				
		        txtDescricao.addFocusListener(new java.awt.event.FocusAdapter() {
		            public void focusGained(java.awt.event.FocusEvent evt) {
		            	PrincipalView.lblTituloAjuda.setText("Tipo de Cliente");
						PrincipalView.lblMensagemAjuda.setText("<html>Informe O tipo de Cliente <br> Essa informação nos ajudarar a forma o preço final de venda para esse tipo de cliente.");
		            }
		            public void focusLost(java.awt.event.FocusEvent evt) {
		            	if(!txtDescricao.getText().isEmpty()) {
		            		String novo = CorrigeTexto.corrige(txtDescricao.getText());           				// pega o texto digitado e mandar para a correção
		                	txtDescricao.setText(novo);                                            				// retorna o texto digitado já corrigido
		            	}	
		            }
		        });
		        
		        txtDescontoAcrescimo.addFocusListener(new java.awt.event.FocusAdapter() {
		            public void focusGained(java.awt.event.FocusEvent evt) {
		            	PrincipalView.lblTituloAjuda.setText("Desc. ou Acresc.");
						PrincipalView.lblMensagemAjuda.setText("<html>Informe se este tipo de cliente tera desconto ou acrescimo <br> Atenção... <br> Os descontos devem ser informados com o sinal de menus (-) na frente!.");
		            }
		            public void focusLost(java.awt.event.FocusEvent evt) {
		            	if(txtDescontoAcrescimo.getText().isEmpty()) {
		            		txtDescontoAcrescimo.setText("0");
		            	}
		            }
		        });
		        
		        txtPrazo.addFocusListener(new java.awt.event.FocusAdapter() {
		            public void focusGained(java.awt.event.FocusEvent evt) {
		            	PrincipalView.lblTituloAjuda.setText("Prazo");
						PrincipalView.lblMensagemAjuda.setText("<html>Informe o prazo máximo para o pagamento das compras desse tipo de cliente.<br> Atenção... <br> Você pode informar 90 dias e usar apenar 30, esse é o prazo máximo para o tipo de cliente");
		            }
		            public void focusLost(java.awt.event.FocusEvent evt) {
		            	if(txtPrazo.getText().isEmpty()) {
		            		txtPrazo.setText("0");
		            	}
		            }
		        });
			}
		});

		/********************************************************************************************/
		/* Agora o cadastro de situação do cliente													*/
		/********************************************************************************************/
		btnSituacaoCliente.addActionListener((ActionEvent) -> {

			if(quem != "situacaoCliente") {
				quem = "situacaoCliente";

				acaoBtnSalvar(pnlCadastro);

				List<ModSituacaoCliente> listarSituacaoCliente = beansSituacaoCliente.listarSituacaoClienteController();
				popularTabelaSituacaoCliente(listarSituacaoCliente);

				
				lblTitulo.setText("Cadastro de Situação do Cliente");
				pnlCadastro.removeAll();

				lblDescricao.setBounds(30, 80, 100, 27);
				lblBloquear.setBounds(30, 110, 100, 27);

				txtDescricao.setBounds(110, 80, 508, 27);
				txtBloquear.setBounds(110, 110, 200, 27);

				pnlCadastro.add(pnlTitulo);
				pnlCadastro.add(lblDescricao);
				pnlCadastro.add(lblBloquear);
				pnlCadastro.add(txtDescricao);
				pnlCadastro.add(txtBloquear);

				CaixaTexto.desativar(pnlCadastro);

				pnlCadastro.validate();
				pnlCadastro.repaint();

				txtDescricao.addKeyListener(new java.awt.event.KeyAdapter() {
					@Override
					public void keyPressed(java.awt.event.KeyEvent evt) {
						ProximoCampo.enter(evt, txtBloquear);
					}
				});	

				txtBloquear.addKeyListener(new java.awt.event.KeyAdapter() {
					@Override
					public void keyPressed(java.awt.event.KeyEvent evt) {ProximoCampo.enter(evt, btnSalvar);}
				});	
			}
		});

		/********************************************************************************************/
		/* Definindo o cadastro de funcoes dos colaboradores										*/
		/********************************************************************************************/
		btnFuncaoColaborador.addActionListener((ActionEvent) -> {
			if(quem != "funcaoColaborador") {
				quem = "funcaoColaborador";

				acaoBtnSalvar(pnlCadastro);

				List<ModFuncoesColaboradores> listarFuncoesColaboradores = beansFuncoesColaboradores.listarFuncoesColaboradoresController();
				popularTabelaFuncoesColaboradores(listarFuncoesColaboradores);

				lblTitulo.setText("Cadastro de Funções de Colaboradores");
				pnlCadastro.removeAll();

				lblDescricao.setBounds(30, 80, 100, 27);
				lblProventos.setBounds(30, 110, 100, 27);
				lblHoras.setBounds(350, 110, 100, 27);

				txtDescricao.setBounds(110, 80, 508, 27);
				txtProventos.setBounds(110, 110, 200, 27);
				txtHoras.setBounds(410, 110, 208, 27);

				pnlCadastro.add(pnlTitulo);
				pnlCadastro.add(lblDescricao);
				pnlCadastro.add(lblProventos);
				pnlCadastro.add(lblHoras);
				pnlCadastro.add(txtDescricao);
				pnlCadastro.add(txtProventos);
				pnlCadastro.add(txtHoras);

				CaixaTexto.desativar(pnlCadastro);

				pnlCadastro.validate();
				pnlCadastro.repaint();
				
				txtDescricao.addKeyListener(new java.awt.event.KeyAdapter() {
					@Override
					public void keyPressed(java.awt.event.KeyEvent evt) {
						ProximoCampo.enter(evt, txtProventos);
					}
				});	
				txtProventos.addKeyListener(new java.awt.event.KeyAdapter() {
					@Override
					public void keyPressed(java.awt.event.KeyEvent evt) {ProximoCampo.enter(evt, txtHoras);}
				});	
				txtHoras.addKeyListener(new java.awt.event.KeyAdapter() {
					@Override
					public void keyPressed(java.awt.event.KeyEvent evt) {ProximoCampo.enter(evt, btnSalvar);}
				});	
			}
		});

		/********************************************************************************************/
		/* Definindo o cadastro de fabricantes que pode ser incluso na hora do cadastro de produtos */
		/********************************************************************************************/
		btnFabricante.addActionListener((ActionEvent) -> {
			if(quem != "fabricante") {
				quem = "fabricante";

				acaoBtnSalvar(pnlCadastro);

				List<ModFabricantes> listarFabricantes = beansFabricantes.listarFabricantesController();
				popularTabelaFabricantes(listarFabricantes);
				
				lblTitulo.setText("Cadastro de Fabricantes");
				pnlCadastro.removeAll();

				lblDescricao.setBounds(30, 80, 100, 27);

				txtDescricao.setBounds(110, 80, 508, 27);

				pnlCadastro.add(pnlTitulo);
				pnlCadastro.add(lblDescricao);
				pnlCadastro.add(txtDescricao);

				CaixaTexto.desativar(pnlCadastro);

				pnlCadastro.validate();
				pnlCadastro.repaint();
				
				txtDescricao.addKeyListener(new java.awt.event.KeyAdapter() {
					@Override
					public void keyPressed(java.awt.event.KeyEvent evt) {
						ProximoCampo.enter(evt, btnSalvar);
						CorrigeTexto.corrige(txtDescricao.getText());	
					}
				});	
			}
		});

		/********************************************************************************************/
		/*  Painel de cadastro de tipo de Produto													*/
		/********************************************************************************************/

		btnTipoProduto.addActionListener((ActionEvent) -> {
			if(quem != "tipoProduto") {
				quem = "tipoProduto";

				acaoBtnSalvar(pnlCadastro);

				List<ModTipoProduto> listarTipoProduto = beansTipoProduto.listarTipoProdutoController();
				popularTabelaTipoProduto(listarTipoProduto);

				lblTitulo.setText("Cadastro de Funções de Colaboradores");
				pnlCadastro.removeAll();

				lblDescricao.setBounds(30, 80, 100, 27);
				lblInformarComposicao.setBounds(30, 110, 400, 27);
				lblFormatarCusto.setBounds(30, 140, 400, 27);
				lblVender.setBounds(30, 170, 400, 27);
				lblPerecivel.setBounds(30, 200, 400, 27);

				txtDescricao.setBounds(110, 80, 508, 27);
				txtInformarComposicao.setBounds(600, 110, 400, 27);
				txtFormatarCusto.setBounds(600, 140, 400, 27);
				txtVender.setBounds(600, 170, 400, 27);
				txtPerecivel.setBounds(600, 200, 400, 27);	

				pnlCadastro.add(pnlTitulo);
				pnlCadastro.add(lblDescricao);
				pnlCadastro.add(lblInformarComposicao);
				pnlCadastro.add(lblFormatarCusto);
				pnlCadastro.add(lblVender);
				pnlCadastro.add(lblPerecivel);
				pnlCadastro.add(txtDescricao);
				pnlCadastro.add(txtInformarComposicao);
				pnlCadastro.add(txtFormatarCusto);
				pnlCadastro.add(txtVender);
				pnlCadastro.add(txtPerecivel);

				CaixaTexto.desativar(pnlCadastro);

				pnlCadastro.validate();
				pnlCadastro.repaint();
			}

		});

		/********************************************************************************************/
		/* vou escrever agora o painel de familia de tributação										*/
		/********************************************************************************************/
		btnFamiliaTributaria.addActionListener((ActionEvent) -> {
			if(quem != "familiaTributaria") {
				quem = "familiaTributaria";

				acaoBtnSalvar(pnlCadastro);

				List<ModFamiliaTributaria> listarFamiliaTributaria = beansFamiliaTributaria.listarFamiliaTributariaController();
				popularTabelaFamiliaTributaria(listarFamiliaTributaria);

				lblTitulo.setText("Cadastro de Familia Tributaria");
				pnlCadastro.removeAll();

				lblDescricao.setBounds(30, 80, 100, 27);
				lblIpi.setBounds(30, 110, 100, 27);
				lblIcms.setBounds(350, 110, 100, 27);
				lblCofins.setBounds(30, 140, 100, 27);
				lblPis.setBounds(350, 140, 100, 27);
				lblIss.setBounds(30, 170, 100, 27);

				txtDescricao.setBounds(110, 80, 508, 27);
				txtIpi.setBounds(110, 110, 100, 27);
				txtIcms.setBounds(410, 110, 100, 27);
				txtCofins.setBounds(110, 140, 100, 27);
				txtPis.setBounds(410, 140, 100, 27);
				txtIss.setBounds(110, 170, 100, 27);	

				pnlCadastro.add(pnlTitulo);
				pnlCadastro.add(lblDescricao);
				pnlCadastro.add(lblIpi);
				pnlCadastro.add(lblIcms);
				pnlCadastro.add(lblCofins);
				pnlCadastro.add(lblPis);
				pnlCadastro.add(lblIss);			
				pnlCadastro.add(txtDescricao);
				pnlCadastro.add(txtIpi);
				pnlCadastro.add(txtIcms);
				pnlCadastro.add(txtCofins);
				pnlCadastro.add(txtPis);
				pnlCadastro.add(txtIss);

				CaixaTexto.desativar(pnlCadastro);

				pnlCadastro.validate();
				pnlCadastro.repaint();	

			}
		}); 

		/********************************************************************************************/
		/* vou escrever agora o painel dos Grupos de Produtos										*/
		/********************************************************************************************/
		btnGrupo.addActionListener((ActionEvent) -> {
			if(quem != "grupo") {
				quem = "grupo";

				List<ModGrupo> listarGrupo = beansGrupo.listarGrupoController();
				popularTabelaGrupo(listarGrupo);

				
				acaoBtnSalvar(pnlCadastro);
				lblTitulo.setText("Cadastro de Grupo de Produtos");
				pnlCadastro.removeAll();

				lblDescricao.setBounds(30, 80, 100, 27);
				lblReferencia.setBounds(30, 110, 100, 27);

				txtDescricao.setBounds(110, 80, 508, 27);
				txtReferencia.setBounds(110, 110, 508, 27);

				pnlCadastro.add(pnlTitulo);
				pnlCadastro.add(lblDescricao);
				pnlCadastro.add(lblReferencia);
				pnlCadastro.add(txtDescricao);
				pnlCadastro.add(txtReferencia);

				CaixaTexto.desativar(pnlCadastro);

				pnlCadastro.validate();
				pnlCadastro.repaint();
			}
		}); 

		/********************************************************************************************/
		/* vou escrever agora o painel dos SubGrupos de Produtos										*/
		/********************************************************************************************/
		btnSubGrupo.addActionListener((ActionEvent) -> {
			if(quem != "subGrupo") {
				quem = "subGrupo";

				List<ModSubGrupo> listarSubGrupo = beansSubGrupo.listarSubGrupoController();
				popularTabelaSubGrupo(listarSubGrupo);
				acaoBtnSalvar(pnlCadastro);
				lblTitulo.setText("Cadastro de SubGrupo de Produtos");
				pnlCadastro.removeAll();

				lblDescricao.setBounds(30, 80, 100, 27);
				lblReferencia.setBounds(30, 110, 100, 27);

				txtDescricao.setBounds(110, 80, 508, 27);
				txtReferencia.setBounds(110, 110, 508, 27);	

				pnlCadastro.add(pnlTitulo);
				pnlCadastro.add(lblDescricao);
				pnlCadastro.add(lblReferencia);
				pnlCadastro.add(txtDescricao);
				pnlCadastro.add(txtReferencia);

				CaixaTexto.desativar(pnlCadastro);

				pnlCadastro.validate();
				pnlCadastro.repaint();	
			}
		});

		/****************************************************************************************************/
		/* Definindo os eventos do mouse																	*/
		/****************************************************************************************************/		
        txtDescricao.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
            	PrincipalView.lblTituloAjuda.setText("Tipo de Cliente");
				PrincipalView.lblMensagemAjuda.setText("<html>Informe O tipo de Cliente <br> Essa informação nos ajudarar a forma o preço final de venda para esse tipo de cliente.");
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                String novo = CorrigeTexto.corrige(txtDescricao.getText());           				// pega o texto digitado e mandar para a correção
                txtDescricao.setText(novo);                                            				// retorna o texto digitado já corrigido
            }
        });

		/****************************************************************************************************/
		/* Definindo as ações do teclado																	*/
		/****************************************************************************************************/		

		/****************************************************************************************************/
		/* Definindo as ações dos botoes																	*/
		/****************************************************************************************************/		
		btnNovo.addActionListener((ActionEvent evt) -> {
			ProximoCampo.enter(evt, txtDescricao);
		});

		btnSalvar.addActionListener((ActionEvent evt) -> {
			ProximoCampo.enter(evt, btnNovo);
			acaoGravar();
		});
		
/****************************************************************************************************/
		btnNovo.addKeyListener(new java.awt.event.KeyAdapter() {
			@Override
			public void keyPressed(java.awt.event.KeyEvent evt) {
					ProximoCampo.enter(evt, txtDescricao);
					acaoBtnNovo(pnlCadastro);				
			}	
		});
		
		btnSalvar.addKeyListener(new java.awt.event.KeyAdapter() {
			@Override
			public void keyPressed(java.awt.event.KeyEvent evt) {
				acaoGravar();
				ProximoCampo.enter(evt, btnNovo);
			}
		});

		/********************************************************************* *******************************/
		/* Definindo os eventos																				*/
		/****************************************************************************************************/	        
		/********************************************************************************************/
		/* vou pegar a variavel "quem" para pegar os dados referente a cada cadastro				*/
		/********************************************************************************************/


	}

	private JButton btnTipoCliente;
	private JButton btnSituacaoCliente;
	private JButton btnFuncaoColaborador;
	private JButton btnFabricante;
	private JButton btnTipoProduto;
	private JButton btnFamiliaTributaria;
	private JButton btnGrupo;
	private JButton btnSubGrupo;

	private JLabel lblDescricao;
	private JLabel lblDescontoAcrescimo;
	private JLabel lblPrazo;
	private JLabel lblBloquear;
	private JLabel lblProventos;
	private JLabel lblHoras;
	private JLabel lblInformarComposicao;
	private JLabel lblFormatarCusto;
	private JLabel lblVender;
	private JLabel lblPerecivel;
	private JLabel lblIpi;
	private JLabel lblIcms;
	private JLabel lblPis;
	private JLabel lblCofins;
	private JLabel lblIss;
	private JLabel lblReferencia;


	private JTextField txtDescricao;
	private JFormattedTextField txtDescontoAcrescimo;
	private JFormattedTextField txtPrazo;
	private JFormattedTextField txtProventos;
	private JFormattedTextField txtHoras;
	private JFormattedTextField txtIpi;
	private JFormattedTextField txtIcms;
	private JFormattedTextField txtPis;
	private JFormattedTextField txtCofins;
	private JFormattedTextField txtIss;
	private JTextField txtReferencia;
	
	private JCheckBox txtBloquear;
	private JCheckBox txtInformarComposicao;
	private JCheckBox txtFormatarCusto;
	private JCheckBox txtVender;
	private JCheckBox txtPerecivel;

	/****************************************************************************************************/	
	private ModTipoCliente getDadosInterfaceTipoCliente() {
		modTipoCliente.setTipoCliente(this.txtDescricao.getText());
		if(!txtDescontoAcrescimo.getText().isEmpty()) {
			modTipoCliente.setDescontoAcrescimo(new BigDecimal(txtDescontoAcrescimo.getText().replace(".", "").replace(",", ".")));		
		} else {
			modTipoCliente.setDescontoAcrescimo(new BigDecimal(0.00));}
		if(!txtPrazo.getText().isEmpty()) {
			modTipoCliente.setPrazo(Integer.parseInt(txtPrazo.getText()));
		} else {modTipoCliente.setPrazo((Integer) 0);}
		return modTipoCliente;
	}

	private ModSituacaoCliente getDadosInterfaceSituacaoCliente() {
		modSituacaoCliente.setSituacaoCliente(this.txtDescricao.getText());
		modSituacaoCliente.setBloquear(txtBloquear.isSelected());
		return modSituacaoCliente;
	}
	
	private ModFuncoesColaboradores getDadosInterfaceFuncoesColaboradores() {
		ModFuncoesColaboradores modFuncoesColaboradores = new ModFuncoesColaboradores();
		modFuncoesColaboradores.setFuncaoColaboradores(txtDescricao.getText());
		
		if(!txtProventos.getText().isEmpty()) {
			modFuncoesColaboradores.setProventos(new BigDecimal(txtProventos.getText().replace(".", "").replace(",", ".")));
		}else {
			modFuncoesColaboradores.setProventos(new BigDecimal(0.00));
		}
		
		if(!txtHoras.getText().isEmpty()) {
			modFuncoesColaboradores.setCargaHoraria(Integer.parseInt(txtHoras.getText()));
		} else { 
			modFuncoesColaboradores.setCargaHoraria((Integer)0);
		}
		return modFuncoesColaboradores;
	}

	private ModFabricantes getDadosInterfaceFabricantes() {
		modFabricantes.setFabricante(this.txtDescricao.getText());
		return modFabricantes;
	}
	
	private ModTipoProduto getDadosInterfaceTipoProdutos() {
		modTipoProduto.setTipoProduto(this.txtDescricao.getText());
		modTipoProduto.setComposicao(this.txtInformarComposicao.isSelected());
		modTipoProduto.setCusto(this.txtFormatarCusto.isSelected());
		modTipoProduto.setVender(txtVender.isSelected());
		modTipoProduto.setVencimento(txtPerecivel.isSelected());
		return modTipoProduto;
	}
	
	private ModFamiliaTributaria getDadosInterfaceFamiliaTributaria() {
		modFamiliaTributaria.setFamiliaTributaria(this.txtDescricao.getText());
		if(!txtIpi.getText().isEmpty()) {
			modFamiliaTributaria.setIpi(new BigDecimal(txtIpi.getText().replace(".", "").replace(",", ".")));
		} else {
			modFamiliaTributaria.setIpi(new BigDecimal(0.00));
		}
		if(!txtIcms.getText().isEmpty()) {
			modFamiliaTributaria.setIcms(new BigDecimal(txtIcms.getText().replace(".", "").replace(",", ".")));
		} else {
			modFamiliaTributaria.setIcms(new BigDecimal(0.00));
		}
		if(!txtCofins.getText().isEmpty()) {
			modFamiliaTributaria.setCofins(new BigDecimal(txtCofins.getText().replace(".", "").replace(",", ".")));
		} else {
			modFamiliaTributaria.setCofins(new BigDecimal(0.00));
		}
		if(!txtPis.getText().isEmpty()) {
			modFamiliaTributaria.setPis(new BigDecimal(txtPis.getText().replace(".", "").replace(",", ".")));
		} else {
			modFamiliaTributaria.setPis(new BigDecimal(0.00));
		}
		if(!txtIss.getText().isEmpty()) {
			modFamiliaTributaria.setIss(new BigDecimal(txtIss.getText().replace(".", "").replace(",", ".")));
		} else {
			modFamiliaTributaria.setIss(new BigDecimal(0.00));
		}		
		return modFamiliaTributaria;
	}
	
	private ModGrupo getDadosInterfaceGrupo() {
		modGrupo.setGrupo(this.txtDescricao.getText());
		modGrupo.setReferrencia(txtReferencia.getText());
		return modGrupo;
	}
	
	private ModSubGrupo getDadosInterfaceSubGrupo() {
		modSubGrupo.setSubGrupo(txtDescricao.getText());
		modSubGrupo.setReferencia(txtReferencia.getText());
		return modSubGrupo;
	}
	
	/****************************************************************************************************/
	private void popularTabelaTipoCliente(List<ModTipoCliente> pListaTipoCliente){
		DefaultTableModel modeloTabela = new DefaultTableModel() {
			@Override																				// definindo a edicao como false
			public boolean isCellEditable(int row, int col) {
				return false;
			}
		};
		tabApoio.setModel(modeloTabela);	  
		modeloTabela.addColumn("Tipo de Cliente");
		modeloTabela.addColumn("Desconto ou Acréscimo");
		modeloTabela.addColumn("Prazo Máximo");
		tabApoio.getColumnModel().getColumn(0).setPreferredWidth(270);
		tabApoio.getColumnModel().getColumn(1).setPreferredWidth(100);
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
					});
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
		modeloTabela.addColumn("Bloqueado?");        
		tabApoio.getColumnModel().getColumn(0).setPreferredWidth(360);
		tabApoio.getColumnModel().getColumn(1).setPreferredWidth(65);
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
					});
		}
	}
	
	private void popularTabelaFuncoesColaboradores(List<ModFuncoesColaboradores> pListarFuncoesColaboradoes) {
		DefaultTableModel modeloTabela = new DefaultTableModel(){
			@Override																				// definindo a edicao como false
			public boolean isCellEditable(int row, int col) {
				return false;
			}
		};
		tabApoio.setModel(modeloTabela);
		modeloTabela.addColumn("Função");
		modeloTabela.addColumn("Proventos?");
		modeloTabela.addColumn("C. Horaria Semanal");
		tabApoio.getColumnModel().getColumn(0).setPreferredWidth(210);
		tabApoio.getColumnModel().getColumn(1).setPreferredWidth(65);
		tabApoio.getColumnModel().getColumn(2).setPreferredWidth(150);
		tabApoio.getColumnModel().getColumn(0).setResizable(false);
		tabApoio.getColumnModel().getColumn(1).setResizable(false);
		tabApoio.getColumnModel().getColumn(2).setResizable(false);
		tabApoio.getTableHeader().setReorderingAllowed(true);
		tabApoio.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		tabApoio.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		for (ModFuncoesColaboradores modFuncaoColaboradores : pListarFuncoesColaboradoes) {
			modeloTabela.addRow(
					new Object[]{
							modFuncaoColaboradores.getFuncaoColaboradores(),
							modFuncaoColaboradores.getProventos(),
							modFuncaoColaboradores.getCargaHoraria()
					});
		}
	}
	
	private void popularTabelaFabricantes(List<ModFabricantes> pListarFabricantes) {
		DefaultTableModel modeloTabela = new DefaultTableModel(){
			@Override																				// definindo a edicao como false
			public boolean isCellEditable(int row, int col) {
				return false;
			}
		};
		tabApoio.setModel(modeloTabela);
		modeloTabela.addColumn("Fabricante");
		tabApoio.getColumnModel().getColumn(0).setPreferredWidth(425);
		tabApoio.getColumnModel().getColumn(0).setResizable(false);
		tabApoio.getTableHeader().setReorderingAllowed(true);
		tabApoio.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		tabApoio.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		for (ModFabricantes modFabricantes : pListarFabricantes) {
			modeloTabela.addRow(
					new Object[]{
							modFabricantes.getFabricante()
					});
		}
	}
	
	private void popularTabelaTipoProduto(List<ModTipoProduto> pListarTipoProduto) {
		DefaultTableModel modeloTabela = new DefaultTableModel(){
			@Override																				// informando que a coluna 2 é boolean
			public Class<?> getColumnClass(int columnIndex) {
				return columnIndex >= 1 ? Boolean.class : super.getColumnClass(columnIndex);
			}
			@Override																				// definindo a edicao como false
			public boolean isCellEditable(int row, int col) {
				return false;
			}
		};
		tabApoio.setModel(modeloTabela);
		modeloTabela.addColumn("Tipo de Produto");
		modeloTabela.addColumn("Composição ?");
		modeloTabela.addColumn("Custo ?");
		modeloTabela.addColumn("Vender ?");
		modeloTabela.addColumn("Validade ?");
		tabApoio.getColumnModel().getColumn(0).setPreferredWidth(260);
		tabApoio.getColumnModel().getColumn(1).setPreferredWidth(60);
		tabApoio.getColumnModel().getColumn(2).setPreferredWidth(60);
		tabApoio.getColumnModel().getColumn(3).setPreferredWidth(60);
		tabApoio.getColumnModel().getColumn(4).setPreferredWidth(60);		
		tabApoio.getColumnModel().getColumn(0).setResizable(false);
		tabApoio.getColumnModel().getColumn(1).setResizable(false);
		tabApoio.getColumnModel().getColumn(2).setResizable(false);
		tabApoio.getColumnModel().getColumn(3).setResizable(false);
		tabApoio.getColumnModel().getColumn(4).setResizable(false);
		tabApoio.getTableHeader().setReorderingAllowed(true);
		tabApoio.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		tabApoio.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		for (ModTipoProduto modTipoProduto : pListarTipoProduto) {
			modeloTabela.addRow(
					new Object[]{
							modTipoProduto.getTipoProduto(),
							modTipoProduto.isComposicao(),
							modTipoProduto.isCusto(),
							modTipoProduto.isVender(),
							modTipoProduto.isVencimento()
					});
		}
	}

	private void popularTabelaFamiliaTributaria(List<ModFamiliaTributaria> pListaFamiliaTributaria) {
		DefaultTableModel modeloTabela = new DefaultTableModel(){
			@Override																				// definindo a edicao como false
			public boolean isCellEditable(int row, int col) {
				return false;
			}
		};
		tabApoio.setModel(modeloTabela);
		modeloTabela.addColumn("Descrição");
		modeloTabela.addColumn("Ipi");
		modeloTabela.addColumn("Icms");
		modeloTabela.addColumn("Cofins");
		modeloTabela.addColumn("Pis");
		modeloTabela.addColumn("Iss");
		tabApoio.getColumnModel().getColumn(0).setPreferredWidth(260);
		tabApoio.getColumnModel().getColumn(1).setPreferredWidth(60);
		tabApoio.getColumnModel().getColumn(2).setPreferredWidth(60);
		tabApoio.getColumnModel().getColumn(3).setPreferredWidth(60);
		tabApoio.getColumnModel().getColumn(4).setPreferredWidth(60);
		tabApoio.getColumnModel().getColumn(5).setPreferredWidth(60);
		tabApoio.getColumnModel().getColumn(0).setResizable(false);
		tabApoio.getColumnModel().getColumn(1).setResizable(false);
		tabApoio.getColumnModel().getColumn(2).setResizable(false);
		tabApoio.getColumnModel().getColumn(3).setResizable(false);
		tabApoio.getColumnModel().getColumn(4).setResizable(false);
		tabApoio.getColumnModel().getColumn(5).setResizable(false);
		tabApoio.getTableHeader().setReorderingAllowed(true);
		tabApoio.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		tabApoio.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		for (ModFamiliaTributaria modFamiliaTributaria : pListaFamiliaTributaria) {
			modeloTabela.addRow(
					new Object[]{
							modFamiliaTributaria.getFamiliaTributaria(),
							modFamiliaTributaria.getIpi(),
							modFamiliaTributaria.getIcms(),
							modFamiliaTributaria.getCofins(),
							modFamiliaTributaria.getPis(),
							modFamiliaTributaria.getIss()
					});
		}
	}

	private void popularTabelaGrupo(List<ModGrupo> pListaGrupo) {
		DefaultTableModel modeloTabela = new DefaultTableModel(){
			@Override																				// definindo a edicao como false
			public boolean isCellEditable(int row, int col) {
				return false;
			}
		};
		tabApoio.setModel(modeloTabela);
		modeloTabela.addColumn("Descrição");
		modeloTabela.addColumn("Referencia");
		tabApoio.getColumnModel().getColumn(0).setPreferredWidth(260);
		tabApoio.getColumnModel().getColumn(1).setPreferredWidth(220);
		tabApoio.getColumnModel().getColumn(0).setResizable(false);
		tabApoio.getColumnModel().getColumn(1).setResizable(false);
		tabApoio.getTableHeader().setReorderingAllowed(true);
		tabApoio.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		tabApoio.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		for (ModGrupo modGrupo : pListaGrupo) {
			modeloTabela.addRow(
					new Object[]{
							modGrupo.getGrupo(),
							modGrupo.getReferrencia()
					});
		}
	}

	private void popularTabelaSubGrupo(List<ModSubGrupo> pListaSubGrupo) {
		DefaultTableModel modeloTabela = new DefaultTableModel(){
			@Override																				// definindo a edicao como false
			public boolean isCellEditable(int row, int col) {
				return false;
			}
		};
		tabApoio.setModel(modeloTabela);
		modeloTabela.addColumn("Descrição");
		modeloTabela.addColumn("Referencia");
		tabApoio.getColumnModel().getColumn(0).setPreferredWidth(260);
		tabApoio.getColumnModel().getColumn(1).setPreferredWidth(220);
		tabApoio.getColumnModel().getColumn(0).setResizable(false);
		tabApoio.getColumnModel().getColumn(1).setResizable(false);
		tabApoio.getTableHeader().setReorderingAllowed(true);
		tabApoio.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		tabApoio.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		for (ModSubGrupo modSubGrupo : pListaSubGrupo) {
			modeloTabela.addRow(
					new Object[]{
							modSubGrupo.getSubGrupo(),
							modSubGrupo.getReferencia()
					});
		}
	}
	
	public void acaoGravar() {
		switch (quem) {
		case "tipoCliente": {
			ModTipoCliente modTipoClientes = getDadosInterfaceTipoCliente();
			ModTipoCliente tipoClienteSalvo = beansTipoCliente.salvarTipoClienteController(modTipoClientes);
			if(tipoClienteSalvo != null){
				List<ModTipoCliente> listarTipoCliente = beansTipoCliente.listarTipoClienteController();
				popularTabelaTipoCliente(listarTipoCliente);
			}else{
				JOptionPane.showMessageDialog(null, "Erro ao Listar o Tipo de cliente.");
			}
			break;
		}
		case "situacaoCliente":{
			ModSituacaoCliente modSituacaoCliente = getDadosInterfaceSituacaoCliente();
			ModSituacaoCliente situacaoClienteSalvo = beansSituacaoCliente.salvarSituacaoClienteController(modSituacaoCliente);
			if(situacaoClienteSalvo != null) {
				List<ModSituacaoCliente> listarSituacaoCliente = beansSituacaoCliente.listarSituacaoClienteController();
				popularTabelaSituacaoCliente(listarSituacaoCliente);
			} else {
				JOptionPane.showMessageDialog(null, "Erro ao listar Situação do Cliente");
			}
			break;
		}
		case "funcaoColaborador":{
			ModFuncoesColaboradores modFuncoesColaboradores = getDadosInterfaceFuncoesColaboradores();
			ModFuncoesColaboradores funcoesColaboradoresSalvo = beansFuncoesColaboradores.salvarFuncaoColaboradorController(modFuncoesColaboradores);
			if(funcoesColaboradoresSalvo !=null) {
				List<ModFuncoesColaboradores> listarFuncoesColaboradores = beansFuncoesColaboradores.listarFuncoesColaboradoresController();
				popularTabelaFuncoesColaboradores(listarFuncoesColaboradores);
			} else {
				JOptionPane.showMessageDialog(null, "Erro ao listar as funções dos colaboradores");
			}
			break;
		}
		case "fabricante":{
			ModFabricantes modFabricantes = getDadosInterfaceFabricantes();
			ModFabricantes fabricanteSalvo = beansFabricantes.salvarFabricantesController(modFabricantes);
			if(fabricanteSalvo != null) {
				List<ModFabricantes> listarFabricantes = beansFabricantes.listarFabricantesController();
				popularTabelaFabricantes(listarFabricantes);
			} else {
				JOptionPane.showMessageDialog(null, "Erro ao listar Fabricantes");
			}
			break;
		}
		case "tipoProduto":{
			ModTipoProduto modTipoProduto = getDadosInterfaceTipoProdutos();
			ModTipoProduto tipoProdutoSalvo = beansTipoProduto.salvarTipoProdutoController(modTipoProduto);
			if(tipoProdutoSalvo != null) {
				List<ModTipoProduto> listarTipoProduto = beansTipoProduto.listarTipoProdutoController();
				popularTabelaTipoProduto(listarTipoProduto);
			} else {
				JOptionPane.showMessageDialog(null, "Erro ao listar o tipo produto");
			}
			break;
		}
		case "familiaTributaria":{
			ModFamiliaTributaria modFamiliaTributaria = getDadosInterfaceFamiliaTributaria();
			ModFamiliaTributaria familiaTributariaSalvo = beansFamiliaTributaria.salvarFamiliaTributariaController(modFamiliaTributaria);
			if(familiaTributariaSalvo != null) {
				List<ModFamiliaTributaria> listarFamiliaTributaria = beansFamiliaTributaria.listarFamiliaTributariaController();
				popularTabelaFamiliaTributaria(listarFamiliaTributaria);
			} else {
				JOptionPane.showMessageDialog(null, "Erro ao listar a família tributaria");
			}
			break;
		}
		case "grupo":{
			ModGrupo modGrupo = getDadosInterfaceGrupo();
			ModGrupo grupoSalvo = beansGrupo.salvarGrupoController(modGrupo);
			if(grupoSalvo != null) {
				List<ModGrupo> listarGrupo = beansGrupo.listarGrupoController();
				popularTabelaGrupo(listarGrupo);
			} else {
				JOptionPane.showMessageDialog(null, "Erro ao listar grupo de produtos");
			}
			break;
		}
		case "subGrupo":{
			ModSubGrupo modSubGrupo = getDadosInterfaceSubGrupo();
			ModSubGrupo subGrupoSalvo = beansSubGrupo.salvarSubGrupoController(modSubGrupo);
			if(subGrupoSalvo != null) {
				List<ModSubGrupo> listarSubGrupo = beansSubGrupo.listarSubGrupoController();
				popularTabelaSubGrupo(listarSubGrupo);
			} else {
				JOptionPane.showMessageDialog(null, "Erro ao listar os subGrupos de produtos");
			}
			break;
		}
		
		default:
			throw new IllegalArgumentException("Valor Inexplicável: " + quem);
		}
		acaoBtnSalvar(pnlCadastro);	
	}

}
