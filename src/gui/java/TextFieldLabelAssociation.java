package gui.java;

import javax.swing.JLabel;
import javax.swing.JTextField;

public class TextFieldLabelAssociation {
	private String symbol;
	private JTextField field;
	
	public TextFieldLabelAssociation(String symbol, JTextField field) {
		this.symbol = symbol;
		this.field = field;
	}
	
	public JTextField getField() {
		return field;
	}
	
	public String getSymbol() {
		return symbol;
	}
}
