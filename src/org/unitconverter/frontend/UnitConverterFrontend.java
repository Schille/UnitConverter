/**
 * 
 */
package org.unitconverter.frontend;

import java.awt.GraphicsConfiguration;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

import org.unitconverter.CONFIG;

/**
 * @author Michael Schilonka
 *
 */
public class UnitConverterFrontend extends JFrame {

	private static final long serialVersionUID = 1L;

	// size of the window
	static final int H_SIZE = 300;
	static final int W_SIZE = 500;

	public UnitConverterFrontend()
	{
		setTitle("UnitConverter v" + CONFIG.VERSION);
		setSize(W_SIZE,H_SIZE);
		addWindowListener(new SimpleWindowListener());

	}
	
	  class SimpleWindowListener extends WindowAdapter
	  {
	    public void windowClosing(WindowEvent e)
	    {
	      e.getWindow().dispose();
	      System.exit(0);                            
	    }           
	  }
	
	
	
}
