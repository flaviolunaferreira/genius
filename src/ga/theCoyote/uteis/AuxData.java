package ga.theCoyote.uteis;

import java.time.LocalDate;

public class AuxData {
	public static LocalDate vaiData(String data) {													// um nome bem horiginal
		String d = data.trim();                                            							// tirando os espacos em brancos
		d = d.replace("-", "").replace("_", "").replace("/", "");									// tirando os sinais extras	
		int dia = Integer.parseInt(d.substring(0, 2));												// poderia usar o split, acho que na proxima vou usar este
		int mes = Integer.parseInt(d.substring(2, 4));												// dividindo a data em dia, mes e ano
		int ano = Integer.parseInt(d.substring(4, 8));												// lembrano que o primeiro numero é o indece e o segundo a largura.	
		return  LocalDate.of(ano, mes, dia);														// definindo uma variavel "retorno" com a data digitada
	}

	public static LocalDate vemData(String data) {													// to me superando nesse negocio de criar nome, esse ficou bom!!!
		String d = data.trim();                                            							// tirando os espacos em brancos
		d = d.replace("-", "").replace("_", "").replace("/", "");									// tirando os sinais extras	
		int dia = Integer.parseInt(d.substring(0, 2));												// poderia usar o split, acho que na proxima vou usar este
		int mes = Integer.parseInt(d.substring(2, 4));												// dividindo a data em dia, mes e ano
		int ano = Integer.parseInt(d.substring(4, 8));												// lembrano que o primeiro numero é o indece e o segundo a largura.	
		return  LocalDate.of(dia, mes, ano);														// definindo uma variavel "retorno" com a data digitada
	}

	public static boolean dataCerta(String data) {
		String a = data.replace(".", "") 															// agora vou tirar os caracteres (. , / -) serão tirados
	            .replace("-", "") 																	// Isso tudo poderia ficar em uma só linha
	            .replace(",", "") 																	// mas assim fica mais bonitinho.
	            .replace("/", "");
		if(a.trim().length() == 0) {
			return false;
		}
		if(a.trim().isEmpty() || a.trim() == null) {
			return false;
		}
		return true;
	}
}
