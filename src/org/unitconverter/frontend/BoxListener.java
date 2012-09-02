package org.unitconverter.frontend;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JTextField;

	 class BoxListener implements ActionListener {
		 
			private JTextField othertext;
			private JTextField thistext;
			private JComboBox lefte, righte;
			private UnitConverterFrontend frontend;
			
			BoxListener (JTextField field, JTextField fieldthis, JComboBox left, JComboBox right, UnitConverterFrontend front) {
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