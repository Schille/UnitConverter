package org.unitconverter.components;

import org.unitconverter.frontend.UnitConverterFrontend;

public class WaitingThread implements Runnable {

	private Thread thread;
	public UnitConverterFrontend front;
	private JTextFieldUnit othertext;
	private JTextFieldUnit thistext;
	private JComboBoxUnit lefte, righte;

	public WaitingThread(UnitConverterFrontend frontend, JTextFieldUnit field,
			JTextFieldUnit fieldthis, JComboBoxUnit left, JComboBoxUnit right) {
		front = frontend;
		othertext = field;
		thistext = fieldthis;
		lefte = left;
		righte = right;
		thread = new Thread(this);
		thread.start();
	}

	@Override
	public void run() {
			try {
				thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			front.writeValue(othertext, thistext, lefte, righte);
		
	}
	
	public void start()
	{
		thread.run();
	}
}
