package org.unitconverter.frontend;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.measure.unit.Unit;

public class FieldFocusListener implements FocusListener {

	private UnitConverterFrontend frontend;
	
	
	FieldFocusListener (UnitConverterFrontend front) {
		frontend = front;
	}
	@Override
	public void focusGained(FocusEvent arg0) {
		
		frontend.switchLabels();
		
	}

	@Override
	public void focusLost(FocusEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
