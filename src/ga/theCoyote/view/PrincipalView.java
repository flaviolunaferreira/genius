package ga.theCoyote.view;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;

import ga.theCoyote.uteis.AuxBtn;
import ga.theCoyote.uteis.AuxCard;

public class PrincipalView extends JFrame {

	public PrincipalView(){ 
		
		inicialize(); 
		
	}
	
	/**
	 * flavio
	 */
	private void inicialize() {		
/****************************************************************************************************/
/* vou inicializar as variaveis do formulario													 	*/
/****************************************************************************************************/	
		/* painel Container que vai conter todos os paineis dos sistema								*/
		pnlContainer = new JPanel(null);								
		/* Agora todos os paineis que fazem parte deste formulario									*/
		pnlOpcoes = new JPanel();
		menuPrincipal = new JMenuBar();
		pnlMenu = new JPanel();
		menuCadastro = new JPanel();
		menuVendas = new JPanel();
		menuCompras = new JPanel();			
		menuProducao = new JPanel();
		menuEstoque = new JPanel();
		menuFinanceiro = new JPanel();
		menuWeb = new JPanel();
		menuRH = new JPanel();
		menuGraficos = new JPanel();
		menuConsultas = new JPanel();
		menuAjuda = new JPanel();
		
		/*  Esse vai ser o titulo que vai aparecer em cada painel das opcoes do sistema				*/
		lblTituloMenu = new JLabel();
		
		/* agora vou definir os botoes do menu principal do sistema									*/
		btnCadastro = new JButton("Cadastro");
		btnVendas = new JButton("Vendas");					
		btnCompras = new JButton("Compras");
		btnProducao = new JButton("Produção");
		btnEstoque = new JButton("Estoque");
		btnFinanceiro = new JButton("Financeiro");
		btnWeb = new JButton("Web");
		btnRH = new JButton("R Humanos");
		btnGraficos = new JButton("Gráficos");
		btnConsultas = new JButton("Consultas");	
		btnAjuda = new JButton("Ajuda");
		btnSair = new JButton("Sair");

		/* CADASTRO -> agora as opcoes para cada paineL												*/
		btnProdutos = new JButton("Produtos"); 
		btnClientes = new JButton("Clientes");
		btnFornecedores = new JButton("Fornecedores");
		btnFuncionarios = new JButton("Funcionários");
		btnPatrimonios = new JButton("Patrimonios");
		btnContasCaixa = new JButton("Contas Caixa");
		btnEnderecos = new JButton("Endereços");
		btnTabApoio = new JButton("Tab. Apoio");
		btnVoltarCadastro = new JButton("Voltar");

		/* VENDAS -> agora as opcoes para cada painel												*/
		btnVender = new JButton("Vender");
		btnEncomendas = new JButton("Encomendas");
		btnOrcamentos = new JButton("Orçamentos");
		btnContratos = new JButton("Contratos");
		btnVoltarVendas = new JButton("Voltar");

		/* COMPRAS -> agora as opcoes para cada painel												*/
		btnRequisicoesDeCompras = new JButton("R. Compras");
		btnPedidos = new JButton("Pedidos");
		btnVoltarCompras = new JButton("Voltar");

		/* PRODUÇÃO -> agora as opcoes para cada painel												*/	
		btnRequesicoesDeProducao = new JButton("R. Produção");
		btnRequesicaoRetirada = new JButton("R. Retirada");
		btnVoltarProducao = new JButton("Voltar");

		/* ESTOQUE -> agora as opcoes para cada painel												*/
		btnRequesicaoProduto = new JButton("R. Produtos");
		btnAuditoria = new JButton("Auditoria");
		btnPercas = new JButton("Percas");
		btnSaida = new JButton("Saidas");
		btnVoltarEstoque = new JButton("Voltar");

		/* FINANCEIRO -> agora as opcoes para cada painel											*/	
		btnReceber = new JButton("Receber");
		btnPagar = new JButton("Pagar");
		btnCarteiraEmpresa = new JButton("C. Empresa");
		btnCarteiraCliente = new JButton("C. Clientes");
		btnVoltarFinanceiro = new JButton("Voltar");
		
		/* WEB -> agora as opcoes para cada painel													*/
		btnProdutoWeb = new JButton("Produtos");
		btnPromocoes = new JButton("Promoções");
		btnEmailClientes = new JButton("E. Clientes");
		btnEmailFornecedores = new JButton("E. Fornecedores");
		btnAcompanhaSite = new JButton("A. Site");
		btnVoltarWeb = new JButton("Voltar");

		/* RH -> agora as opcoes para cada painel													*/
		btnSinistros = new JButton("Sinistros");
		btnAnexarAtestado = new JButton("Atestados");
		btnProgramarFerias = new JButton("Ferias");
		btnCadastroProventos_Descontos = new JButton("Proventos");
		btnFolhaPagamento = new JButton("F. Pagamento");
		btnVoltarRH = new JButton("Voltar");
		
		/* GRÁFICOS -> agora as opcoes para cada painel												*/	
		btnVoltarGraficos = new JButton("Voltar");

		/* CONSULTAS -> agora as opcoes para cada painel											*/
		btnConsultarClientes = new JButton("Clientes");
		btnVoltarConsultas = new JButton("Voltar");

		/* AJUDA -> agora as opcoes para cada painel												*/
		btnVoltarAjuda = new JButton("Voltar");

		/* essa vai ser nossa area de trabalho, onde todos os formularios vao aparecer				*/				
		areaDeTrabalho = new JDesktopPane();
		
//		JMenuBar barraDeMenu = new JMenuBar();
//		this.setJMenuBar(barraDeMenu);
//		barraDeMenu.setBounds(0, 0, 1364, 50);
//					
//		JMenu menuBCadastro = new JMenu("Cadatros");
//		barraDeMenu.add(menuBCadastro);
//			JMenuItem menuBProdutos = new JMenuItem("Produtos");
//			menuBCadastro.add(menuBProdutos);
//		
//		JMenu menuBVendas = new JMenu("Vendas");
//		barraDeMenu.add(menuBVendas);
//		
//		JMenu menuBCompras = new JMenu("Compras");
//		barraDeMenu.add(menuBCompras);
//		
//		JMenu menuBCaixa = new JMenu("Caixa");
//		barraDeMenu.add(menuBCaixa);		
		
		/********************************************************************************************/
		/* definindo os objetos do formulário principal												*/
		/********************************************************************************************/		
		/* Paineis 																					*/
		setBounds(1, 1, 1364, 733);																
		setUndecorated(true);
		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		pnlContainer.setBounds(1, 1, 1364, 733);
		pnlContainer.setVisible(true);
		getContentPane().add(pnlContainer);

		pnlContainer.add(menuPrincipal);
				
		/* painel de container dos cards com seus cards.											*/
		pnlOpcoes.setLayout(new java.awt.CardLayout());
		pnlOpcoes.setBounds(5, 5, 180, 723);
		pnlOpcoes.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		pnlContainer.add(pnlOpcoes);																		//esse é o container principal dos cards
		pnlOpcoes.add(pnlMenu, "menu");																		// o menu default
		pnlOpcoes.add(menuCadastro, "cadastro");
		pnlOpcoes.add(menuVendas, "vendas");					
		pnlOpcoes.add(menuCompras, "compras");
		pnlOpcoes.add(menuProducao, "producao");
		pnlOpcoes.add(menuEstoque, "estoque");
		pnlOpcoes.add(menuFinanceiro, "financeiro");
		pnlOpcoes.add(menuWeb, "web");
		pnlOpcoes.add(menuRH, "rh");
		pnlOpcoes.add(menuGraficos, "graficos");
		pnlOpcoes.add(menuConsultas, "consultas");	
		pnlOpcoes.add(menuAjuda, "ajuda");

		/* vou montar os cards das opcoes com os menus secundarios do sistema.						*/
		/* comecando com o card principal. Através dele vou chamar os outros cards					*/	
		AuxCard.chamarCard(pnlMenu, pnlOpcoes, "Menu Geral", lblTituloMenu);						// informa o card a ser visualizado, o container, o titulo do cars e o label que vai receber o titulo. 
		/* PRINCIPAL -> agora vou montar os botoes do menu principal								*/
		AuxBtn.montarBotaoV(btnCadastro, pnlMenu, 1);
		AuxBtn.montarBotaoV(btnVendas, pnlMenu, 2);
		AuxBtn.montarBotaoV(btnCompras, pnlMenu, 3);
		AuxBtn.montarBotaoV(btnProducao, pnlMenu, 4);
		AuxBtn.montarBotaoV(btnEstoque, pnlMenu, 5);
		AuxBtn.montarBotaoV(btnFinanceiro, pnlMenu, 6);
		AuxBtn.montarBotaoV(btnWeb, pnlMenu, 7);
		AuxBtn.montarBotaoV(btnRH, pnlMenu, 8);
		AuxBtn.montarBotaoV(btnGraficos, pnlMenu, 9);
		AuxBtn.montarBotaoV(btnConsultas, pnlMenu, 10);
		AuxBtn.montarBotaoV(btnAjuda, pnlMenu, 11);
		AuxBtn.montarBotaoV(btnSair, pnlMenu, 12);
		
		
		
				/* vou colocar a acao dos botoes do MENU Principal aqui.								*/
		
				btnCadastro.addActionListener((ActionEvent) -> { AuxCard.chamarCard(menuCadastro, pnlOpcoes, "Cadastro", lblTituloMenu); });
				btnVendas.addActionListener((ActionEvent) -> { AuxCard.chamarCard(menuVendas, pnlOpcoes, "Vendas", lblTituloMenu); });
				btnCompras.addActionListener((ActionEvent) -> { AuxCard.chamarCard(menuCompras, pnlOpcoes, "Compras", lblTituloMenu); });
				btnProducao.addActionListener((ActionEvent) -> { AuxCard.chamarCard(menuProducao, pnlOpcoes, "Opcoes", lblTituloMenu); });
				btnEstoque.addActionListener((ActionEvent) -> { AuxCard.chamarCard(menuEstoque, pnlOpcoes, "Estoque", lblTituloMenu); });
				btnFinanceiro.addActionListener((ActionEvent) -> { AuxCard.chamarCard(menuFinanceiro, pnlOpcoes, "Financeiro", lblTituloMenu); });
				btnWeb.addActionListener((ActionEvent) -> { AuxCard.chamarCard(menuWeb, pnlOpcoes, "Web", lblTituloMenu); });
				btnRH.addActionListener((ActionEvent) -> { AuxCard.chamarCard(menuRH, pnlOpcoes, "RH", lblTituloMenu); });
				btnGraficos.addActionListener((ActionEvent) -> { AuxCard.chamarCard(menuGraficos, pnlOpcoes, "Gráficos", lblTituloMenu); });
				btnConsultas.addActionListener((ActionEvent) -> { AuxCard.chamarCard(menuConsultas, pnlOpcoes, "Consultas", lblTituloMenu); });
				btnAjuda.addActionListener((ActionEvent) -> { AuxCard.chamarCard(menuAjuda, pnlOpcoes, "Ajuda", lblTituloMenu); });
				btnSair.addActionListener((ActionEvent) -> { System.exit(0);});															
				
/****************************************************************************************************/
/*  vou escrever os objetos do MENU CADASTRO. botoes e depois os eventos.	.						*/			
/****************************************************************************************************/								
		AuxCard.montarCard(menuCadastro);
		AuxBtn.montarBotaoV(btnProdutos, menuCadastro, 1);
		AuxBtn.montarBotaoV(btnClientes, menuCadastro, 2);
		AuxBtn.montarBotaoV(btnFornecedores, menuCadastro, 3);
		AuxBtn.montarBotaoV(btnFuncionarios, menuCadastro, 4);
		AuxBtn.montarBotaoV(btnContasCaixa, menuCadastro, 5);
		AuxBtn.montarBotaoV(btnPatrimonios, menuCadastro, 6);
		AuxBtn.montarBotaoV(btnEnderecos, menuCadastro, 7);
		AuxBtn.montarBotaoV(btnTabApoio, menuCadastro, 9);		
		AuxBtn.montarBotaoV(btnVoltarCadastro, menuCadastro, 12);		
		
				btnProdutos.addActionListener((ActionEvent) -> {
						ProdutosView produto = new ProdutosView();
						produto.setVisible(true);
						areaDeTrabalho.removeAll();
						areaDeTrabalho.add(produto);
						AuxBtn.desativarBotoes(menuCadastro);
				});
		
				btnClientes.addActionListener((ActionEvent) -> {
						ClientesView clientes = new ClientesView();
						clientes.setVisible(true);
						areaDeTrabalho.removeAll();
						areaDeTrabalho.add(clientes);
						AuxBtn.desativarBotoes(menuCadastro);
				});
		
				btnFornecedores.addActionListener((ActionEvent) -> {
						FornecedoresView fornecedores = new FornecedoresView();
						fornecedores.setVisible(true);
						areaDeTrabalho.removeAll();
						areaDeTrabalho.add(fornecedores);
						AuxBtn.desativarBotoes(menuCadastro);
				});

				btnFuncionarios.addActionListener((ActionEvent) -> {
						FuncionariosView funcionarios = new FuncionariosView();
						funcionarios.setVisible(true);
						areaDeTrabalho.removeAll();
						areaDeTrabalho.add(funcionarios); 
						AuxBtn.desativarBotoes(menuCadastro);		
				});
				
				btnContasCaixa.addActionListener((ActionEvent) -> {
						ContasCaixaView contasCaixa = new ContasCaixaView();
						contasCaixa.setVisible(true);
						areaDeTrabalho.removeAll();
						areaDeTrabalho.add(contasCaixa); 
						AuxBtn.desativarBotoes(menuCadastro);		
				});
		
				btnPatrimonios.addActionListener((ActionEvent) -> {
						PatrimoniosView patrimonios = new PatrimoniosView();
						patrimonios.setVisible(true);
						areaDeTrabalho.removeAll();
						areaDeTrabalho.add(patrimonios); 
						AuxBtn.desativarBotoes(menuCadastro);		
				});
		
				btnEnderecos.addActionListener((ActionEvent) -> {
						CepView cepView = new CepView();
						cepView.setVisible(true);
						areaDeTrabalho.removeAll();
						areaDeTrabalho.add(cepView); 
						AuxBtn.desativarBotoes(menuCadastro);
				});
				
				btnTabApoio.addActionListener((ActionEvent) -> {
					TabelasDeApoioView tabApoio = new TabelasDeApoioView();
					tabApoio.setVisible(true);
					areaDeTrabalho.removeAll();
					areaDeTrabalho.add(tabApoio); 
					AuxBtn.desativarBotoes(menuCadastro);
				});				
				
				btnVoltarCadastro.addActionListener((ActionEvent) -> { 
					AuxCard.chamarCard(pnlMenu, pnlOpcoes, "Menu Geral", lblTituloMenu); 
				});
				
/****************************************************************************************************/
/*  agora os objetos do MENU VENDAS. botoes e depois os eventos.			.						*/			
/****************************************************************************************************/					
		AuxCard.montarCard(menuVendas);
		AuxBtn.montarBotaoV(btnVender, menuVendas, 1);
		AuxBtn.montarBotaoV(btnEncomendas, menuVendas, 2);
		AuxBtn.montarBotaoV(btnOrcamentos, menuVendas, 3);
		AuxBtn.montarBotaoV(btnContratos, menuVendas, 4);
		AuxBtn.montarBotaoV(btnVoltarVendas, menuVendas, 12);
			
				
				btnVoltarVendas.addActionListener((ActionEvent) -> { AuxCard.chamarCard(pnlMenu, pnlOpcoes, "Menu Geral", lblTituloMenu); });
				
/****************************************************************************************************/
/*  agora os objetos do MENU COMPRAS. botoes e depois os eventos.			.						*/			
/****************************************************************************************************/					
		AuxCard.montarCard(menuCompras);
		AuxBtn.montarBotaoV(btnRequisicoesDeCompras, menuCompras, 1);
		AuxBtn.montarBotaoV(btnPedidos, menuCompras, 2);
		AuxBtn.montarBotaoV(btnVoltarCompras, menuCompras, 12);
								
				btnVoltarCompras.addActionListener((ActionEvent) -> { AuxCard.chamarCard(pnlMenu, pnlOpcoes, "Menu Geral", lblTituloMenu); });				
				
			
/****************************************************************************************************/
/*  agora os objetos do MENU PRODUCAO. botoes e depois os eventos.			.						*/			
/****************************************************************************************************/					
		AuxCard.montarCard(menuProducao);
		AuxBtn.montarBotaoV(btnRequesicoesDeProducao, menuProducao, 1);
		AuxBtn.montarBotaoV(btnRequesicaoRetirada, menuProducao, 2);
		AuxBtn.montarBotaoV(btnVoltarProducao, menuProducao, 12);
								
				btnVoltarProducao.addActionListener((ActionEvent) -> { AuxCard.chamarCard(pnlMenu, pnlOpcoes, "Menu Geral", lblTituloMenu);	});					
				
/****************************************************************************************************/
/*  agora os objetos do MENU ESTOQUE. botoes e depois os eventos.			.						*/			
/****************************************************************************************************/					
		AuxCard.montarCard(menuEstoque);
		AuxBtn.montarBotaoV(btnRequesicaoProduto, menuEstoque, 1);
		AuxBtn.montarBotaoV(btnAuditoria, menuEstoque, 2);
		AuxBtn.montarBotaoV(btnPercas, menuEstoque, 3);
		AuxBtn.montarBotaoV(btnSaida, menuEstoque, 4);
		AuxBtn.montarBotaoV(btnVoltarEstoque, menuEstoque, 12);
								
				btnVoltarEstoque.addActionListener((ActionEvent) -> { AuxCard.chamarCard(pnlMenu, pnlOpcoes, "Menu Geral", lblTituloMenu); });			

/****************************************************************************************************/
/*  agora os objetos do MENU FINANCEIRO. botoes e depois os eventos.			.						*/			
/****************************************************************************************************/					
		AuxCard.montarCard(menuFinanceiro);
		AuxBtn.montarBotaoV(btnReceber, menuFinanceiro, 1);
		AuxBtn.montarBotaoV(btnPagar, menuFinanceiro, 2);
		AuxBtn.montarBotaoV(btnCarteiraEmpresa, menuFinanceiro, 3);
		AuxBtn.montarBotaoV(btnCarteiraCliente, menuFinanceiro, 4);
		AuxBtn.montarBotaoV(btnVoltarFinanceiro, menuFinanceiro, 12);

									
				btnVoltarFinanceiro.addActionListener((ActionEvent) -> { AuxCard.chamarCard(pnlMenu, pnlOpcoes, "Menu Geral", lblTituloMenu); });	

/****************************************************************************************************/
/*  agora os objetos do MENU WEB. botoes e depois os eventos.			.						*/			
/****************************************************************************************************/					
		AuxCard.montarCard(menuWeb);
		AuxBtn.montarBotaoV(btnProdutoWeb, menuWeb, 1);
		AuxBtn.montarBotaoV(btnPromocoes, menuWeb, 2);
		AuxBtn.montarBotaoV(btnEmailClientes, menuWeb, 3);
		AuxBtn.montarBotaoV(btnEmailFornecedores, menuWeb, 4);
		AuxBtn.montarBotaoV(btnAcompanhaSite, menuWeb, 5);
		AuxBtn.montarBotaoV(btnVoltarWeb, menuWeb, 12);
							
				btnVoltarWeb.addActionListener((ActionEvent) -> { AuxCard.chamarCard(pnlMenu, pnlOpcoes, "Menu Geral", lblTituloMenu); });	
				
/****************************************************************************************************/
/*  agora os objetos do MENU WEB. botoes e depois os eventos.			.						*/			
/****************************************************************************************************/					
		AuxCard.montarCard(menuRH);
		AuxBtn.montarBotaoV(btnSinistros, menuRH, 1);
		AuxBtn.montarBotaoV(btnAnexarAtestado, menuRH, 2);
		AuxBtn.montarBotaoV(btnProgramarFerias, menuRH, 3);
		AuxBtn.montarBotaoV(btnCadastroProventos_Descontos, menuRH, 4);
		AuxBtn.montarBotaoV(btnFolhaPagamento, menuRH, 5);
		AuxBtn.montarBotaoV(btnVoltarRH, menuRH, 12);

				btnVoltarRH.addActionListener((ActionEvent) -> { AuxCard.chamarCard(pnlMenu, pnlOpcoes, "Menu Geral", lblTituloMenu); });	
				
/****************************************************************************************************/
/*  agora os objetos do MENU GRAFICOS. botoes e depois os eventos.			.						*/			
/****************************************************************************************************/					
		AuxCard.montarCard(menuGraficos);
		AuxBtn.montarBotaoV(btnVoltarGraficos, menuGraficos, 12);

				btnVoltarGraficos.addActionListener(new ActionListener() {						
					@Override
					public void actionPerformed(ActionEvent e) {
						AuxCard.chamarCard(pnlMenu, pnlOpcoes, "Menu Geral", lblTituloMenu);
					}
				});
	
/****************************************************************************************************/
/*  agora os objetos do MENU CONSULTAS. botoes e depois os eventos.			.						*/			
/****************************************************************************************************/					
		AuxCard.montarCard(menuConsultas);
		AuxBtn.montarBotaoV(btnConsultarClientes, menuConsultas, 1);
		AuxBtn.montarBotaoV(btnVoltarConsultas, menuConsultas, 12);
		
				btnConsultarClientes.addActionListener((ActionEvent) -> {
//					ConModeloConsulta consulta = new ConModeloConsulta();
//					consulta.setVisible(true);
//					areaDeTrabalho.removeAll();
//					areaDeTrabalho.add(consulta); 
//					btnVoltarCadastro.setEnabled(false);
				});	
				
				btnVoltarConsultas.addActionListener(new ActionListener() {						
					@Override
					public void actionPerformed(ActionEvent e) {
						AuxCard.chamarCard(pnlMenu, pnlOpcoes, "Menu Geral", lblTituloMenu);
					}
				});

/****************************************************************************************************/
/*  E finalmente o  MENU AJUDA. botoes e depois os eventos.			.						*/			
/****************************************************************************************************/					
		AuxCard.montarCard(menuAjuda);
		AuxBtn.montarBotaoV(btnVoltarAjuda, menuAjuda, 12);

				btnVoltarAjuda.addActionListener(new ActionListener() {						
					@Override
					public void actionPerformed(ActionEvent e) {
						AuxCard.chamarCard(pnlMenu, pnlOpcoes, "Menu Geral", lblTituloMenu);
					}
				});
		areaDeTrabalho.setBounds(190, 5, 1169, 643);
		areaDeTrabalho.setBorder(javax.swing.BorderFactory.createEtchedBorder());
		pnlContainer.add(areaDeTrabalho);

/****************************************************************************************************/
/* vou trabalhar no painel de ajuda do sistema														*/
/****************************************************************************************************/		
		pnlAjuda.setBounds(190, 653, 1169, 75);
		pnlAjuda.setBorder(javax.swing.BorderFactory.createEtchedBorder());
		pnlAjuda.setLayout(null);
		
		lblTituloAjuda.setLayout(new GridLayout(1, 1));
		lblTituloAjuda.setForeground(new Color(0, 0, 90));
		lblTituloAjuda.setFont(new java.awt.Font("arial", 2, 26));
		lblTituloAjuda.setBounds(18, 15, 220, 40);
		
		lblMensagemAjuda.setLayout(new GridLayout(4, 2));
		lblMensagemAjuda.setForeground(new Color(0, 0, 30));
		lblMensagemAjuda.setFont(new java.awt.Font("arial", 2, 16));
		lblMensagemAjuda.setBounds(250, 5, 913, 65);
		
		
		pnlAjuda.add(lblTituloAjuda);
		pnlAjuda.add(lblMensagemAjuda);
		
		
		pnlContainer.add(pnlAjuda);
		
		/********************************************************************************************/
		/* montando a ajuda para os eventos do mouse usando um pouco de HTML para facilitar 		*/
		/* a formatação das linhas e melhorar a visibilidade.										*/
		/* comecando com o menu principal 															*/
		/********************************************************************************************/
		btnCadastro.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent evt) {
				lblTituloAjuda.setText("Menu Cadastro");
				lblMensagemAjuda.setText("<html>No menu de cadastro você pode fazer as inclusões primimárias do sistema, Produtos, Clientes, Fornecedores, Funcionários... são informações que lhe ajudarão com o controle de sua empresa!");
			}
		});
		
		btnVendas.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent evt) {
				lblTituloAjuda.setText("Menu Vendas");
				lblMensagemAjuda.setText("<html>Aquí você terá as opições de Vendas, orçamentos, contratos de fornecimento, entre outros. Teste nosso modelo de vendas e mande-nos um feedback com melhorias para atende-lo melhor.");
			}
		});
		
		btnCompras.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent evt) {
				lblTituloAjuda.setText("Menu Compras");
				lblMensagemAjuda.setText("<html>Use esta opção para fazer pedidos, comprar ou ver o que a sua empresa precise que você compre. Você pode usar esta opinião para verificar quais os produtos mais usados e se programar para não deixar faltar a matéria prima que sua empresa mais usa  ou  o produto que mais vende simplismente consultando o histórico de vendas e/ou produção.");
			}
		});
		
		btnProducao.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent evt) {
				lblTituloAjuda.setText("Menu Produção");
				lblMensagemAjuda.setText("<html>Essa etapa do sistema destina-se a industria. você deve cadastrar seus produtos e formular o preço com base nos materiais usados, tempo de produtividadeo, mão de obra e outros. Nosso modelo de produção lhe ajuda a controlar melhor sua empresa e lhe fornece uma previsão de produção por período");
			}
		});
		
		btnEstoque.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent evt) {
				lblTituloAjuda.setText("Menu Estoque");
				lblMensagemAjuda.setText("<html> Em operações comuns como COMPRA e VENDA seu estoque é automaticamente atualizado, esta opção destina-se a atividades que fogem desta regra. Envie produtos ou matéria prima para outros setores ou informe percas e conheça o que esta acontecendo com seus produtos!!!");
			}
		});
		
		btnFinanceiro.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent evt) {
				lblTituloAjuda.setText("Menu Financeiro");
				lblMensagemAjuda.setText("<html>Essa Opção vai te ajudar a conhecer o fluxo do capital de sua empresa. Formule seu caixa com suas receitas e despesas, defina metas e orquestre seus objetivos com a ajuda deste módulo");
			}
		});
		
		btnWeb.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent evt) {
				lblTituloAjuda.setText("Menu Web");
				lblMensagemAjuda.setText("<html>Esta é a opção de definição dos produtos que farão parte de sua página de vendas WEB. Configure seu provedor e definas quais os produtos que farão parte do seu ECOMMERCE, inclua fotos e atribua promoções, acompanhe visualizações e veja o que estão pesquisando em sua página.");
			}
		});
		
		btnRH.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent evt) {
				lblTituloAjuda.setText("Menu RH");
				lblMensagemAjuda.setText("<html> Use esta opção para fazer o controle dos seus colaboradores, aquí você vai encontrar modelos de recisões, folha de pagamento, comissões e outras opções que irão te ajudar.");
			}
		});
		
		btnGraficos.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent evt) {
				lblTituloAjuda.setText("Menu Gráficos");
				lblMensagemAjuda.setText("<html>Os grïáficos são uma exelente forma de te mostrar como sua empresa esta progredindo");
			}
		});
		
		btnConsultas.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent evt) {
				lblTituloAjuda.setText("Menu Consultas");
				lblMensagemAjuda.setText("<html>Aquí mostraremos todas as opções de consultas do sistema divididas em categoria, além disso para cada categoria, teremos a opção de você mesmo montar sua consulta. Ha!!! todas as consultas tem a opção e impressão");
			}
		});
		
		btnAjuda.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent evt) {
				lblTituloAjuda.setText("Ajuda do Sistema");
				lblMensagemAjuda.setText("<html>Nesta opção, tentaremos mostrar de forma fácil como usar o sistema usando exemplos para facilitar o aprendizado, caso exista uma questão que não abordamos, entre em contato conosco e teremos um grande prazer em ajuda-lo.");
			}
		});
		
		btnSair.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent evt) {
				lblTituloAjuda.setText("Botãoo Sair");
				lblMensagemAjuda.setText("<html>Acho que não é preciso dizer o que este botão faz, mas... mesmo assim... Esse botão fecha a aplicação");
			}
		});
		
		areaDeTrabalho.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent evt) {
				lblTituloAjuda.setText("área de Trabalho");
				lblMensagemAjuda.setText("Essa é nossa área de trabalho. Nela é que irão aparecer todas as telas do sistema!");
			}
		});
		pnlAjuda.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent evt) {
				lblTituloAjuda.setText("Ajuda!!!");
				lblMensagemAjuda.setText("<html><i>Este painel será usado para mostrar as informações para o usuário. Também pode ser usado para mostrar Ajudas e/ou dicas para as telas do sistema. Todo este blablabla é só pra testar as tags html e quantas linhas tenho para usar como texto de ajuda para o usuário.");
			}
		});
		pnlOpcoes.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent evt) {
				lblTituloAjuda.setText("");
				lblMensagemAjuda.setText("");
			}
		});
		pnlMenu.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent evt) {
				lblTituloAjuda.setText("");
				lblMensagemAjuda.setText("");
			}
		});
		
		/********************************************************************************************/
		/* Definindo a ajuda para o card Cadastro.													*/
		/********************************************************************************************/
		btnProdutos.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent evt) {
				lblTituloAjuda.setText("Cad. Produtos");
				lblMensagemAjuda.setText("<html>Neste módulo você podera cadastrar ou manter os produtos que sua empresa trabalha");
			}
		});
		
		btnClientes.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent evt) {
				lblTituloAjuda.setText("Cad. Clientes");
				lblMensagemAjuda.setText("<html>Use esta opção para cadastrar seus clientes");
			}
		});
		
		btnFornecedores.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent evt) {
				lblTituloAjuda.setText("Cad. Fornecedores");
				lblMensagemAjuda.setText("<html>Neste módulo você podera cadastrar ou manter os Fornecedores que sua empresa trabalha");
			}
		});
		
		btnFuncionarios.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent evt) {
				lblTituloAjuda.setText("Cad. Funcionários");
				lblMensagemAjuda.setText("<html>Madrugada... com sono... e sem criatividade para escrever os texto de ajuda para o cadastro de funcionários");
			}
		});
		
		btnContasCaixa.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent evt) {
				lblTituloAjuda.setText("Contas Caixa");
				lblMensagemAjuda.setText("<html>Você precisa cadastrar suas contas para obter informação sobre a situação financeira, com os lancamentos corretos você pode definir metas para a contenção de despesas ou aumento das receitas.");
			}
		});
		
		btnPatrimonios.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent evt) {
				lblTituloAjuda.setText("Cad. Patrimônios");
				lblMensagemAjuda.setText("<html>Esse é um modulo interessante pois com base nos lancamentos você pode decidir se é melhor tercerizar o equipamento ou mante-lo. Além do controle do patrimônio da empresa.");
			}
		});
		
		btnEnderecos.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent evt) {
				lblTituloAjuda.setText("Tab. de Apoio");
				lblMensagemAjuda.setText("<html>As tabelas de apoio lhe ajudarão no processo e edição dos formulários de cadastro.");
			}
		});
		
		btnVoltarCadastro.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent evt) {
				if(btnVoltarCadastro.isEnabled()) {
					lblTituloAjuda.setText("Botão Voltar");
					lblMensagemAjuda.setText("<html>Volta para o painel principal de opçães do sistema.");
				} else {
					btnVoltarCadastro.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
					lblTituloAjuda.setText("Botão Voltar");
					lblMensagemAjuda.setText("<html>Você precisa fechar as telas de cadastro para poder ativar esta opção.");
					
				}
			}
		});
		
	};
	

	/*************************************************************************************************/
	/* instanciando os objetos																		 */
	/*************************************************************************************************/	
	private JPanel pnlContainer;	
	
	public static JPanel pnlAjuda = new JPanel();
	public static JLabel lblTituloAjuda = new JLabel();
	public static JLabel lblMensagemAjuda = new JLabel();


	private JMenuBar menuPrincipal;
	private JPanel pnlOpcoes;
	private JPanel pnlMenu;
	public static JPanel menuCadastro;
	public static JPanel menuVendas;
	public static JPanel menuCompras;
	public static JPanel menuProducao;
	public static JPanel menuEstoque;
	public static JPanel menuFinanceiro;
	public static JPanel menuWeb;
	public static JPanel menuRH;
	public static JPanel menuGraficos;
	public static JPanel menuConsultas;
	public static JPanel menuAjuda;

	
	private JButton btnCadastro;
	private JButton btnVendas;			
	private JButton btnCompras;
	private JButton btnProducao;
	private JButton btnEstoque;
	private JButton btnFinanceiro;
	private JButton btnWeb;
	private JButton btnRH;
	private JButton btnGraficos;
	private JButton btnConsultas;
	private JButton btnAjuda;
	private JButton btnSair;
	
	private JLabel lblTituloMenu;

	private JButton btnProdutos; 
	private JButton btnClientes;
	private JButton btnFornecedores;
	private JButton btnFuncionarios;
	private JButton btnPatrimonios;
	private JButton btnContasCaixa;
	private JButton btnEnderecos;
	private JButton btnTabApoio;
	static JButton btnVoltarCadastro;

	private JButton btnVender;
	private JButton btnEncomendas;
	private JButton btnOrcamentos;
	private JButton btnContratos;
	private JButton btnVoltarVendas;

	private JButton btnRequisicoesDeCompras;
	private JButton btnPedidos;
	private JButton btnVoltarCompras;

	private JButton btnRequesicoesDeProducao;
	private JButton btnRequesicaoRetirada;
	private JButton btnVoltarProducao;

	private JButton btnRequesicaoProduto;
	private JButton btnAuditoria;
	private JButton btnPercas;
	private JButton btnSaida;
	private JButton btnVoltarEstoque;

	private JButton btnReceber;
	private JButton btnPagar;
	private JButton btnCarteiraEmpresa;
	private JButton btnCarteiraCliente;
	private JButton btnVoltarFinanceiro;
	
	/* WEB -> agora as opcoes para cada painel										*/
	private JButton btnProdutoWeb;
	private JButton btnPromocoes;
	private JButton btnEmailClientes;
	private JButton btnEmailFornecedores;
	private JButton btnAcompanhaSite;
	private JButton btnVoltarWeb;

	/* RH -> agora as opcoes para cada painel										*/
	private JButton btnSinistros;
	private JButton btnAnexarAtestado;
	private JButton btnProgramarFerias;
	private JButton btnCadastroProventos_Descontos;
	private JButton btnFolhaPagamento;
	private JButton btnVoltarRH;

	private JButton btnVoltarGraficos;

	private JButton btnConsultarClientes;
	private JButton btnVoltarConsultas;

	private JButton btnVoltarAjuda;
	

	public static JDesktopPane areaDeTrabalho;

}
