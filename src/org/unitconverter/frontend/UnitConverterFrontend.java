/**
 * 
 */
package org.unitconverter.frontend;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import org.unitconverter.CONFIG;

/**
 * @author Michael Schilonka
 * 
 */
public class UnitConverterFrontend extends JFrame {

	private static final long serialVersionUID = 1L;

	// Window Components
	private JTabbedPane tabbedPane;
	private JPanel panel1;
	private JPanel panel2;


	
	private JComboBox comboboxleft;
	private JComboBox comboboxright;
	

	// size of the window
	static final int H_SIZE = 300;
	static final int W_SIZE = 500;

	public UnitConverterFrontend() {
		initComponents();

	}

	private void initComponents() {
		setTitle("UnitConverter v" + CONFIG.VERSION);
		setSize(W_SIZE, H_SIZE);
		addWindowListener(new SimpleWindowListener());
		setVisible(false);
		
		tabbedPane = new JTabbedPane();		
		panel1 = new JPanel();
		panel1.setLayout(null);
		panel1.setBounds(0, 0, W_SIZE, H_SIZE);
		panel1.setBackground(Color.DARK_GRAY);
		
		panel2 = new JPanel();
		panel2.setLayout(null);
		panel2.setBounds(0, 0, W_SIZE, H_SIZE);
		panel2.setBackground(Color.CYAN);

		comboboxleft = new JComboBox();
		comboboxright = new JComboBox();
		comboboxleft.addItem("Left");
		comboboxright.addItem("Right");

		comboboxleft.setLocation(0, 0);
		comboboxleft.setSize(100, 20);
		comboboxright.setLocation(120, 0);
		comboboxright.setSize(100, 20);
		

		panel1.add(comboboxleft);
		panel1.add(comboboxright);

		panel1.validate();
		tabbedPane.addTab(CONFIG.PANEL1, panel1);
		tabbedPane.addTab(CONFIG.PANEL2, panel2);

		this.add(tabbedPane).validate();
		this.setResizable(false);

	}

	class SimpleWindowListener implements WindowListener {
		public void windowClosing(WindowEvent e) {
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
