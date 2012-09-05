package org.unitconverter.frontend;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JComboBox;
import org.unitconverter.components.*;

public class FieldListener implements KeyListener {
	private JTextFieldUnit othertext;
	private JTextFieldUnit thistext;
	private JComboBoxUnit lefte, righte;
	private UnitConverterFrontend frontend;
	
	FieldListener(JTextFieldUnit field, JTextFieldUnit fieldthis,
			JComboBoxUnit left, JComboBoxUnit right, UnitConverterFrontend front) {
		othertext = field;
		thistext = fieldthis;
		lefte = left;
		righte = right;
		frontend = front;
	}

	
	@Override
	public void keyPressed(KeyEvent e) {
		
	
	} 

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyChar() != 8) {
		frontend.writeValue(othertext, thistext, lefte, righte);
		}
		else {
			new WaitingThread(frontend, othertext, thistext, lefte, righte);
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
	
		
	}	

}
