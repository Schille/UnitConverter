package org.unitconverter.frontend;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ButtonListener implements ActionListener {

	
	private UnitConverterFrontend frontend;
	ButtonListener (UnitConverterFrontend front, char c) {
		frontend = front;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		frontend.switchMenu();
		
		
	}
	


}
