package ga.theCoyote.uteis;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

public class TextoGeral extends PlainDocument{
	
	private int quantidadeMaxima;

	public TextoGeral(int maxLen) {
		super();
		if(maxLen <=0) throw new IllegalArgumentException("Informe a quantidade de caracteres!");
		quantidadeMaxima = maxLen;
	}
	
	@Override
	public void insertString(int offset, String str, AttributeSet attr)throws BadLocationException{
		if(str == null || getLength()==quantidadeMaxima) return;
		int quantiaTotal = (getLength()+str.length());
		if(quantiaTotal <= quantidadeMaxima) {
			super.insertString(offset, str.replaceAll("", ""), attr);
			return;
		}
		String nova = str.substring(0,getLength()-quantidadeMaxima);
		super.insertString(offset, nova, attr);
	}

}
