package org.unitconverter.frontend;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import org.unitconverter.components.JTextFieldUnit;

	 class BoxListener implements ActionListener {
		 
			private JTextFieldUnit othertext;
			private JTextFieldUnit thistext;
			private JComboBox lefte, righte;
			private UnitConverterFrontend frontend;
			
			BoxListener (JTextFieldUnit field, JTextFieldUnit fieldthis, JComboBox left, JComboBox right, UnitConverterFrontend front) {
				othertext = field;
				thistext = fieldthis;
				lefte = left;
				righte = right;
				frontend = front;
		 }

		@Override
		public void actionPerformed(ActionEvent e) {
			frontend.writeValue(othertext, thistext, lefte, righte);
		}
	 }