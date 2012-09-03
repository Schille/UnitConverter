package org.unitconverter.frontend;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import org.unitconverter.components.*;

	 class BoxListener implements ActionListener {
		 
			private JTextFieldUnit othertext;
			private JTextFieldUnit thistext;
			private JComboBoxUnit lefte, righte;
			private UnitConverterFrontend frontend;
			
			BoxListener (JTextFieldUnit field, JTextFieldUnit fieldthis, JComboBoxUnit left, JComboBoxUnit right, UnitConverterFrontend front) {
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