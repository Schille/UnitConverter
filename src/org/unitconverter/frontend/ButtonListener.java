package org.unitconverter.frontend;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import org.unitconverter.*;
import org.unitconverter.CONFIG.Units;


public class ButtonListener implements ActionListener {
	char menu;
	
	private UnitConverterFrontend frontend;
	ButtonListener (UnitConverterFrontend front, char c) {
		frontend = front;
		menu = c;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		switch (menu) {
		case 'b': frontend.switchMenu(); break; 
		case 'm': 	frontend.emptyBox();
					frontend.fillComboBox(Units.MASS);
					frontend.switchMenu();
					break;
		case 'c':  	frontend.emptyBox();
					frontend.fillComboBox(CONFIG.Units.CAPACITY);
					frontend.switchMenu();	
					break;
		case 'l':  	frontend.emptyBox();
					frontend.fillComboBox(CONFIG.Units.LENGTH); 
					frontend.switchMenu();
					break;
		case 'a':  	frontend.emptyBox();
					frontend.fillComboBox(CONFIG.Units.AREA); 
					frontend.switchMenu();
					break;
		}
		
		
		
	}
	


}
