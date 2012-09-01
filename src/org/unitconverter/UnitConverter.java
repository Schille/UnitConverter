package org.unitconverter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import javax.measure.quantity.Length;
import javax.measure.quantity.Mass;
import javax.measure.quantity.Quantity;
import javax.measure.quantity.Volume;
import javax.measure.unit.Dimension;
import javax.measure.unit.SI;
import javax.measure.unit.SystemOfUnits;
import javax.measure.unit.Unit;
import javax.swing.LookAndFeel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import org.unitconverter.frontend.UnitConverterFrontend;

/**
 * @author Michael Schilonka
 *
 */

public class UnitConverter {
	
	private UnitConverterFrontend frontend;

	
	public UnitConverter(){
		frontend = new UnitConverterFrontend();
	}
	
	public void run(){
		frontend.setVisible(true);	
	}

	/**
	 * @param args
	 * @throws UnsupportedLookAndFeelException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * @throws ClassNotFoundException 
	 */
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
		UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
		
		UnitConverter converter = new UnitConverter();
		converter.run();
	}
	


}

