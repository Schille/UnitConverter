/**
 * 
 */
package org.unitconverter.frontend;



import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

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
	
	  class SimpleWindowListener implements WindowListener
	  {
	    public void windowClosing(WindowEvent e)
	    {
	      e.getWindow().dispose();
	      System.exit(0);                            
	    }

		@Override
		public void windowActivated(WindowEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void windowClosed(WindowEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void windowDeactivated(WindowEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void windowDeiconified(WindowEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void windowIconified(WindowEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void windowOpened(WindowEvent arg0) {
			// TODO Auto-generated method stub
			
		}           
	  }
	
	
	
}
