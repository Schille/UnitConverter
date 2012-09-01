/**
 * 
 */
package org.unitconverter.frontend;

import java.awt.Color;
import java.awt.Component;
import java.awt.Image;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

import org.unitconverter.CONFIG;
import org.unitconverter.Converter;

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
	private JPanel panel3;
	private JPanel panel4;
	private JPanel panel5;
	
	private JPanel panel_gr;
	private JPanel panel_menu;
	private JPanel panel_conv;
	private JPanel panel_gr2;
	
	
	private JLabel label_l;
	private JLabel label_r;
	private JLabel label_menu;
	private JLabel label_mass;
	private JLabel label_area;
	private JLabel label_cap;
	private JLabel label_len;
	
	private JButton button_mass;
	private JButton button_cap;
	private JButton button_len;
	private JButton button_back;
	private JButton button_area;
	

	private JTextField fieldleft;
	private JTextField fieldright;
	
	private JComboBox comboboxleft;
	private JComboBox comboboxright;
	
	private JComboBox comboboxleft_2;
	private JComboBox comboboxright_2;
	

	// size of the window
	static final int H_SIZE = 300;
	static final int W_SIZE = 550;

	public UnitConverterFrontend() {
		initComponents();

	}

	private void initComponents() {
		setTitle("UnitConverter v" + CONFIG.VERSION);
		setSize(W_SIZE, H_SIZE);
		addWindowListener(new SimpleWindowListener());
		setVisible(false);
		
		tabbedPane = new JTabbedPane();	
	
		
		
		panel_gr = producePanel(3);
		panel_menu = createPanelMenu();
		panel_conv = producePanel(4);
		panel_gr2 = producePanel(5);

		
		
		panel_gr.add(panel_menu);
	
		
		tabbedPane.addTab(CONFIG.PANEL1, panel_gr);
		tabbedPane.addTab(CONFIG.PANEL2, panel_gr2);

		this.add(tabbedPane).validate();
		this.setResizable(false);

	}
	
	 void switchMenu () {
		 
		if(panel_gr.isAncestorOf(panel_menu)) {
		 panel_gr.removeAll();
		 panel_gr.add(panel_conv);
		 panel_gr.validate();
		 panel_gr.repaint();
			 
			
		 }
		 else {
			 panel_gr.removeAll();
			 panel_gr.add(panel_menu);
			 panel_gr.validate();
			 panel_gr.repaint(); 
		 }
		 
		this.validate();
		this.repaint();
		
	}
	 
	 
	 private JPanel producePanel (int k) {
		//Panel for "Sekundarstufe 2"
			panel1 = new JPanel();
			panel1.setLayout(null);
			panel1.setBounds(0, 0, W_SIZE, H_SIZE);
			
			
			//MenuPanel for "Sekundarstufe 1"


			panel3 = new JPanel();
			panel3.setLayout(null);
			panel3.setBounds(0, 0, W_SIZE, H_SIZE);
			
			panel5 = new JPanel();
			panel5.setLayout(null);
			panel5.setBounds(0, 0, W_SIZE, H_SIZE);
			
			
			comboboxleft = new JComboBox();
			comboboxright = new JComboBox();
			comboboxleft_2 = new JComboBox();
			comboboxright_2 = new JComboBox();
			
			fieldleft = new JTextField();
			fieldright = new JTextField();
			
			label_l = new JLabel("Von: ");
			label_r = new JLabel("In: ");
			

			comboboxleft.setLocation(155, H_SIZE/3);
			comboboxright.setLocation(425, H_SIZE/3);
			comboboxleft.setSize(100, 25);
			comboboxright.setSize(100, 25);
			
			comboboxleft_2.setLocation(155, H_SIZE/3);
			comboboxright_2.setLocation(425, H_SIZE/3);
			comboboxleft_2.setSize(100, 25);
			comboboxright_2.setSize(100, 25);
			
			fieldleft.setLocation(30, H_SIZE/3);
			fieldright.setLocation(300, H_SIZE/3);
			fieldleft.setSize(120, 25);
			fieldright.setSize(120, 25);
			
			label_l.setLocation(33, H_SIZE/3-20);
			label_r.setLocation(302, H_SIZE/3-20);
			
			
			
			
			label_l.setSize(50, 25);
			label_r.setSize(50, 25);

			
			button_back = new JButton("Zurück zum Menü!");
			button_back.setSize(150, 30);
			button_back.setLocation(390, 210);
			button_back.addActionListener(new ButtonListener(this, 'b'));
			
			
			
			panel1.add(comboboxleft);
			panel1.add(comboboxright);
			panel1.add(fieldleft);
			panel1.add(fieldright);
			panel1.add(label_l);
			panel1.add(label_r);
		

			
			
			panel4 = panel1;
			panel5 = panel1;
			
			
			
			panel1.validate();
			
			fillComboBox(CONFIG.Units.ALL);
			
			switch(k) {
			case 1: return panel1;
			case 2: return panel2;
			case 3: return panel3;
			case 4: panel4.add(button_back); 
			panel4.add(comboboxleft);
			panel4.add(comboboxright);
					return panel4;
					
			case 5: panel5.remove(comboboxleft);
					panel5.remove(comboboxright);
					panel5.add(comboboxleft_2);
					panel5.add(comboboxright_2);
				return panel5;
			}
			
			return panel3;
			
	 }
	 
	 private JPanel createPanelMenu () {
			panel2 = new JPanel();
			panel2.setLayout(null);
			panel2.setBounds(0, 0, W_SIZE, H_SIZE);
			
			label_menu = new JLabel("Bitte wähle eine physikalische Größe!");
			label_mass = new JLabel("Masse");
			label_area = new JLabel("Fläche");
			label_cap  = new JLabel("Volumen");
			label_len  = new JLabel("Länge");
			
			ImageIcon mass = new ImageIcon("pic/mass.png");
			Image mass_i = mass.getImage();
			Image mass_n = mass_i.getScaledInstance(110, 110, java.awt.Image.SCALE_SMOOTH);
			mass = new ImageIcon(mass_n);
			
			ImageIcon len = new ImageIcon("pic/len.jpg");
			Image len_i = len.getImage();
			Image len_n = len_i.getScaledInstance(110, 110, java.awt.Image.SCALE_SMOOTH);
			len = new ImageIcon(len_n);
			
			ImageIcon cap = new ImageIcon("pic/vol.jpg");
			Image cap_i = cap.getImage();
			Image cap_n = cap_i.getScaledInstance(110, 110, java.awt.Image.SCALE_SMOOTH);
			cap = new ImageIcon(cap_n);
			
			ImageIcon area = new ImageIcon("pic/area.gif");
			Image area_i = area.getImage();
			Image area_n = area_i.getScaledInstance(110, 110, java.awt.Image.SCALE_SMOOTH);
			area = new ImageIcon(area_n);
			
			
			
			button_mass = new JButton(mass);
			button_area = new JButton(area);		
			button_cap = new JButton(cap);
			button_len = new JButton(len);
			
			

			button_mass.setSize(120, 120);
			button_mass.setLocation(20, 50);
			button_mass.addActionListener(new ButtonListener(this, 'm'));
			
			button_cap.setSize(120, 120);
			button_cap.setLocation(150, 50);
			button_cap.addActionListener(new ButtonListener(this, 'c'));
			
			button_len.setSize(120, 120);
			button_len.setLocation(280, 50);
			button_len.addActionListener(new ButtonListener(this, 'l'));
			
		
			button_area.setSize(120, 120);
			button_area.setLocation(410, 50);
			button_area.addActionListener(new ButtonListener(this, 'l'));
			
			label_menu.setSize(550, 25);
			label_menu.setLocation(0, 20);
			label_menu.setHorizontalAlignment(JLabel.CENTER);
			
			panel2.add(button_mass);
			panel2.add(button_cap);
			panel2.add(button_len);
			panel2.add(button_area);
			panel2.add(label_menu);
			
			return panel2;
			
	 }
			

	 public void fillComboBox(CONFIG.Units myUnits){
		 for(String key : Converter.getUnitsAppropriated(myUnits)){
			 comboboxleft.addItem(key);
			 comboboxleft_2.addItem(key);
		 }
		 for(String key : Converter.getUnitsAppropriated(myUnits)){
			 comboboxright.addItem(key);
			 comboboxright_2.addItem(key);
			 
		 }

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
