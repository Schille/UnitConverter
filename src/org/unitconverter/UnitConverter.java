package org.unitconverter;

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

