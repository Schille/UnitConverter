package org.unitconverter.components;

import java.awt.event.KeyEvent;

import javax.swing.JTextField;

public class JTextFieldUnit extends JTextField {
	
	public JTextFieldUnit (String text) {
		super(text);
		
	}
	
		  public void processKeyEvent(KeyEvent ev) {
		    char c = ev.getKeyChar();
		    try {
		     
		      if ((c > 31 && c < 127) && !(c == 44) && !(c == 46) ) {
		        Integer.parseInt(c + "");
		      }
		      String name = super.getText();
		      if (c == 46) {		    	  
			    	if(super.getText().contains(".")) {
			    	return;
			    	}
			      }
		      
		      if (c == 44) {
		    	  if(super.getText().contains(".")) {
		    		   return;
		    	  }
		    	  else  ev.setKeyChar('.');
		      }
		      super.processKeyEvent(ev);
		    }
		    catch (NumberFormatException nfe) {
		      
		    }
		  }
		}


