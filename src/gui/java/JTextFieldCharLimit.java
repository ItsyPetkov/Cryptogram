package gui.java;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

public class JTextFieldCharLimit extends PlainDocument{
	private int limit;
	
	public JTextFieldCharLimit(int limit) {
		this.limit = limit;
	}
	
	public void insertString(int offset, String str, AttributeSet set) throws BadLocationException {
		if (str == null) {
			return;
		} else if ((getLength() + str.length()) <= limit) {
			str = str.toUpperCase();
			super.insertString(offset, str, set);
		}
	}
}
