package ga.theCoyote.uteis;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidarEmail {
	public static boolean Validar(String email) {
	    boolean valido = false;
	    if (email != null && email.length() > 0) {
	        String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
	        Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
	        Matcher matcher = pattern.matcher(email);
	        if (matcher.matches()) {
	            valido = true;
	        }
	    }
	    return valido;
	}
}
