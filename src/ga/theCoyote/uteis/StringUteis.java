package ga.theCoyote.uteis;

public class StringUteis {

/*
 *  vamos criar uma verifica��o para saber se a string e vazia
 */
	public static boolean eVazia(String s) {
		if(s == null) {
			return true;
		}
		return s.trim().length() == 0;
	}
	
	
}
