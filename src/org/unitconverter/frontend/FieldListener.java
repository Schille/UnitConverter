package org.unitconverter.frontend;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JComboBox;
import javax.swing.JTextField;

public class FieldListener implements KeyListener {
	private JTextField othertext;
	private JTextField thistext;
	private JComboBox lefte, righte;
	private UnitConverterFrontend frontend;
	
	FieldListener (JTextField field, JTextField fieldthis, JComboBox left, JComboBox right, UnitConverterFrontend front) {
		othertext = field;
		thistext = fieldthis;
		lefte = left;
		righte = right;
		frontend = front;
	}

	
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
//		JTextField sender = (JTextField)e.getSource();
//		
//		try {
//			Integer.parseInt(sender.getText().substring(sender.getText().length()-1, sender.getText().length()));
//
//			
//		}
//		catch (NumberFormatException ex) {
//		    
//			// sender.setText(sender.getText().substring(0, sender.getText().length()-1));
//		
//		}
		
//		JTextField sender = (JTextField)e.getSource();
//		char c = e.getKeyChar();
//		if(!Character.isDigit(c)) {
//			e.consume();
//			
//		}
		
		
		

//	
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

		frontend.writeValue(othertext, thistext, lefte, righte);
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
	
		
	}	

}
