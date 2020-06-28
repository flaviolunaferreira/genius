package ga.theCoyote.uteis;

import java.text.ParseException;

import javax.swing.JFormattedTextField;
import javax.swing.text.MaskFormatter;

public class FormartarCampo {

	public static void formatarCep(JFormattedTextField campo) {
		try {
			MaskFormatter mask = new MaskFormatter("##.###-###");
			mask.install(campo);
		} catch( ParseException e) {
			e.printStackTrace();
		}
	}
	
	public static void formatarData(JFormattedTextField campo) {
		try {
			MaskFormatter mask = new MaskFormatter("##/##/####");
			mask.install(campo);
		} catch( ParseException e) {
			e.printStackTrace();
		}
	}
	
	public static void formatarFone(JFormattedTextField campo) {
		try {
			MaskFormatter mask = new MaskFormatter("(##)#####-####");
			mask.install(campo);
		} catch( ParseException e) {
			e.printStackTrace();
		}
	}
	
	public static void formatarMoeda(JFormattedTextField campo) {
		campo.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("###,###.00"))));
	}
	
}
