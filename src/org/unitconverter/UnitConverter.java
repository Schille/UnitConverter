package org.unitconverter;

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
	 */
	public static void main(String[] args) {
		UnitConverter converter = new UnitConverter();
		converter.run();
	}

}

