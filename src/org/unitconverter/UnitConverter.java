package org.unitconverter;

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
		UIManager.setLookAndFeel(
	            UIManager.getCrossPlatformLookAndFeelClassName());
		
		UnitConverter converter = new UnitConverter();
		converter.run();
	}

}

