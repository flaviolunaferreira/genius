package ga.theCoyote.uteis;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JTextField;

public class ValidarCpfCgc {

 /**
 * ****************************************************************************
 * Agora vamos criar uma classe que valide o cnpj e/ou o cpf digitado. Primeiro
 * vamos verificar se o que foi digitado é um CPF ou se é um CNPJ e depois
 * vamos fazer a validação retornando uma string.
 *
 * @param String CpfCnpj contendo o numero do documento
 * @return (cpf valido, cpf invalido, cnpj valido, cnpj invalido, nao
 * informado, invalido)
 * ****************************************************************************
 */

public static void validar(JTextField documento, JLabel lblAviso ) { 
	
    String resultado = retornoCpfCnpj(documento.getText());				    			// armazenar na variavel retorno do resuldado do método de validação
    switch (resultado) {                                                    			// agora usar o switch para validar o retorno
        case "cpf valido": {                                                			// verifica o retorno
                                                                            			// cria uma string para a confeccao da mascara
        	lblAviso.setForeground(Color.blue);                 		    			// deixa a mensagem para o cliente azul
        	lblAviso.setText("O CPF Informado é válido");           					// mostra a mensagem para o cliente
            String CPF = documento.getText();                               			// pega o que foi digitado, tira os espaços em branco e
            CPF = CPF.trim();                                               			// sinais digitados e monta a mascara respectivamente
            CPF = CPF.replace(",", "").replace(".", "").replace("-", "").replace("/", "");
            String finalCPF = CPF.substring(0, 3) + "." + CPF.substring(3, 6) + "." + CPF.substring(6, 9) + "-" + CPF.substring(9, 11);
            documento.setText(finalCPF);                                    			// monta o texto agora com sua respectiva mascara
            break;
        }
        case ("cpf invalido"): {                                             			// se o CPF for invalido
        	lblAviso.setForeground(Color.red);           			           			// deixa o texto vermelho
        	lblAviso.setText("Desculpe, CPF INVÁLIDO!!!");          					// Informa ao usuário que nao e válido
            documento.requestFocus();                                       			// volta para o campo CPF/CNPJ
            break;
        }
        case ("cnpj valido"): {
//            String finalCNPJ = "";                                        			// cria uma string para a confeccao da mascara
        	lblAviso.setForeground(Color.BLUE);                     					// deixa a mensagem para o cliente azul
        	lblAviso.setText("O CNPJ Informado é válido");     			     			// mostra a mensagem para o cliente
            String CNPJ = documento.getText();                              			// pega o que foi digitado, tira os espaços em branco e 
            CNPJ = CNPJ.trim();                                            			 	// monta a mascara respectivamente    
            CNPJ = CNPJ.replace(",", "").replace(".", "").replace("-", "").replace("/", "");
            String finalCNPJ = CNPJ.substring(0, 2) + "." + CNPJ.substring(2, 5) + "." + CNPJ.substring(5, 8) + "/" + CNPJ.substring(8, 12) + "-" + CNPJ.substring(12, 14);
            documento.setText(finalCNPJ);                                   			// monta o texto agora com sua respectiva mascara
            break;
        }
        case ("cnpj invalido"): {                                           			// se o CNPJ for invalido
        	lblAviso.setForeground(Color.red);                      					// muda a cor do texto para vermelho
        	lblAviso.setText("Desculpe, CNPJ INVÁLIDO!!!");   			      			// informa ao cliente
            documento.requestFocus();                                       			// retorna para o campo CPF/CNPJ
            break;
        }
        case ("nao informado"): {                                           			// se o usuário deixar o campo em branco
        	lblAviso.setForeground(Color.red);                        					// deixa o texto em vermelho
        	lblAviso.setText("Atençao!!!, Documento não informado!!!");					// informa para o usuário
            break;
        }
        case ("invalido"): {                                                			// se o usuário digitar qualquer coisa que náo dê para reconhecer
        	lblAviso.setForeground(Color.red);                      					// deixa o texto vermelho
        	lblAviso.setText("Desculpe, NÚMERO INVÁLIDO!!!");      			 			// informa ao usuário
            documento.requestFocus();                                       			// retorna o focus
            break;
        }

    } 
}
	
	
	
/**
 * 	
 * @param CpfCnpj
 * @return String contendo a resposta
 */
public static String retornoCpfCnpj(String CpfCnpj) {
    String resposta = "";                                                   // criando uma string para armazenar a resposta
    CpfCnpj = CpfCnpj.trim();                                               // retira possíveis espaços em branco que o usuario possa ter digitao
    CpfCnpj = CpfCnpj.replace(".", "") 										// agora os caracteres (. , / -) serão tirados
            .replace("-", "") 												// Isso tudo poderia ficar em uma só linha
            .replace(",", "") 												// mas assim fica mais bonitinho.
            .replace("/", "");
    switch (CpfCnpj.length()) {                                             // vamos usar a largura da variavel para saber o que ela é
        case 11:                                                            // se a variavel tiver 11 digitos mande para validarCpf
            resposta = validarCpf(CpfCnpj) ? "cpf valido" : "cpf invalido"; // e dependendo do retorno valide ou nao o cpf
            break;                                                          // nao precisa eu esrever que isso aqui para parar né.
        case 14:                                                            // se a variavel tiver 14 mande para o validarCnpj
            resposta = validarCnpj(CpfCnpj) ? "cnpj valido" : "cnpj invalido";// aqui temos dois tipos de retorno válido ou não que servira para o
            break;
        case 0:                                                             // tratamento com o cliente
            resposta = "nao informado";                                     // se o cpf ou cnpj nao for informado, informe. E finalmente
            break;
        default:
            resposta = "invalido";                                          // qualquer outro conjunto de caracteres informe que o cpf ou cnpj
            break;                                                          // não são válidos
    }
    return resposta;
}


/**
 * *************************************************************************
 * Verifica se o Cpf digitado é válido
 *
 * @param String cpf
 * @return boolean
*************************************************************************
 */

public static boolean validarCpf(String cpf) {

    int[] multiplicador1Cpf = new int[]{10, 9, 8, 7, 6, 5, 4, 3, 2};        // vamos definir o primeiro digito verificador do Cpf
    int[] multiplicador2Cpf = new int[]{11, 10, 9, 8, 7, 6, 5, 4, 3, 2};    // agora o segundo
    int soma = 0;                                                           // essa variável vai amarzenar o resultado da soma das multiplicações do primeiro digito
    int resto = 0;                                                          // e essa o resto da soma da primeira multiplicação
    String digito = null;                                                   // aqui vamos guardar o nosso primeiro dígito verificador
    String tempCpf = null;                                                  // aqui vamos armazenar o cpf/cgc temporário

    /**
     * ************** Vamos comessar nossas validações ********************
     */
    tempCpf = cpf.substring(0, 9);                                          // vamos pegarmos apenas os 9 primeiros numeros (sem o digito)
    int[] calculo = new int[tempCpf.length()];                              // e criar um array de inteiros com esses numeros com a largura da variavel
    for (int i = 0; i < tempCpf.length(); i++) {                            // que sabemos ter nove digitos, mas vou colocar assim para usar a mesma
        calculo[i] = Integer.parseInt(tempCpf.substring(i, i + 1));         // coisa no cnpj, para cada indece de i ele cria um novo int de cpf
    }                                                                       // que vai facilitar a soma dos elementos, ou seja cada variavel do eu vou
    soma = 0;                                                               // multiplicar com o arrey fornecedo pela receita e armazenar tudo no
    for (int i = 0; i < 9; i++) {                                           // na variavel soma.
        soma += calculo[i] * multiplicador1Cpf[i];                          // primeiro com primeiro, segundo com segundo e assim por diante
    }
    resto = soma % 11;                                                      // agora vou pegar o resto da divisao da soma de tudo por 11
    if (resto < 2) {                                                        // se o resto for 1 ou 0 o resto vai ser 0
        resto = 0;
    } else {                                                                // se nao
        resto = 11 - resto;                                                 // vamos dividir o resto por 11
    }
    digito = String.valueOf(resto);                                         // agora temos nosso primeiro digito
    tempCpf = tempCpf + digito;                                             // vou pegar esse digito e acrescentar a nossa variavel temp que agora tem
    int[] calculo2 = new int[tempCpf.length()];                             // dez digitos, vamos criar um novo array e comessar tudo de novo, agora com
    for (int i = 0; i < tempCpf.length(); i++) {                            // um digito a mais e usanto o segundo multiplicador.
        calculo2[i] = Integer.parseInt(tempCpf.substring(i, i + 1));
    }
    soma = 0;
    for (int i = 0; i < 10; i++) {
        soma += calculo2[i] * multiplicador2Cpf[i];
    }
    resto = soma % 11;
    if (resto < 2) {
        resto = 0;
    } else {
        resto = 11 - resto;
    }
    tempCpf = tempCpf + String.valueOf(resto);

    return cpf.endsWith(tempCpf);
}
/**
 * **************************************************************************
 * validacao do cnpj
 *
 * @param String cnpj
 * @return boolean
 */
public static boolean validarCnpj(String cnpj) {
    int[] multiplicador1Cnpj = new int[]{5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2}; // vamos definir o primeiro digito verificados do Cnpj
    int[] multiplicador2Cnpj = new int[]{6, 5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2};// agora o segundo.
    int soma;                                                               // essa variável vai amarzenar o resultado da soma das multiplicações do primeiro digito
    int resto;                                                              // e essa o resto da soma da primeira multiplicação
    String digito = "";                                                     // aqui vamos guardar o nosso primeiro dígito verificador
    String tempCnpj;                                                        // aqui vamos armazenar o cpf/cgc temporário
    tempCnpj = cnpj.substring(0, 12);                                       // vamos pegarmos apenas os 12 primeiros numeros (sem o digito)
    int[] calculo = new int[tempCnpj.length()];                             // e criar um array de inteiros com esses numeros com a largura da variavel
    for (int i = 0; i < tempCnpj.length(); i++) {                           // que sabemos ter doze digitos
        calculo[i] = Integer.parseInt(tempCnpj.substring(i, i + 1));        // para cada indece de i ele cria um novo int de cpf(cnpj. so usei o mesmo nome da variavel)
    }                                                                       // que vai facilitar a soma dos elementos, ou seja cada variavel do cnpj eu vou
    soma = 0;                                                               // multiplicar com o arrey fornecedo pela receita e armazenar tudo no
    for (int i = 0; i < 12; i++) {                                          // na variavel soma.
        soma += calculo[i] * multiplicador1Cnpj[i];                         // primeiro com primeiro, segundo com segundo e assim por diante
    }
    resto = soma % 11;                                                      // agora vou pegar o resto da divisao da soma de tudo por 11
    if (resto < 2) {                                                        // se o resto for 1 ou 0 o resto vai ser 0 para que o digito seja de 0 a 9
        resto = 0;
    } else {                                                                // se nao
        resto = 11 - resto;                                                 // vamos dividir o resto por 11
    }
    digito = String.valueOf(resto);                                         // agora temos nosso primeiro digito
    tempCnpj = tempCnpj + digito;                                           // vou pegar esse digito e acrescentar a nossa variavel temp que agora tem
    int[] calculo2 = new int[tempCnpj.length()];                            // dez digitos, vamos criar um novo array e comessar tudo de novo, agora com
    for (int i = 0; i < tempCnpj.length(); i++) {                           // um digito a mais e usando o segundo multiplicador.
        calculo2[i] = Integer.parseInt(tempCnpj.substring(i, i + 1));
    }
    soma = 0;
    for (int i = 0; i < 13; i++) {
        soma += calculo2[i] * multiplicador2Cnpj[i];
    }
    resto = soma % 11;
    if (resto < 2) {
        resto = 0;
    } else {
        resto = 11 - resto;
    }
    tempCnpj = tempCnpj + String.valueOf(resto);

    return cnpj.endsWith(tempCnpj);
}

	
}
