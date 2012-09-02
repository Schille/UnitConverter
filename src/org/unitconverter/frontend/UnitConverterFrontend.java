/**
 * 
 */
package org.unitconverter.frontend;

import java.awt.Color;
import java.awt.Component;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.ImageIcon;
import javax.swing.InputVerifier;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

import org.unitconverter.CONFIG;
import org.unitconverter.Converter;

/**
 * @author Michael Schilonka, Robert Stein
 * 
 */
public class UnitConverterFrontend extends JFrame {

	private static final long serialVersionUID = 1L;

	// Window Components
	private JTabbedPane tabbedPane;
	private JPanel panel1;
	private JPanel panel2;
	private JPanel panel3;
	
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

		panel_gr = createPanelMenu();
		panel_menu = createPanelMenu();
		panel_conv = createSek1Panel();
		
		panel_gr2 = createSek2Panel();

		
		
		panel_gr.add(panel_menu);
	
		
		tabbedPane.addTab(CONFIG.PANEL1, panel_gr);
		tabbedPane.addTab(CONFIG.PANEL2, panel_gr2);
		fillComboBox(CONFIG.Units.LENGTH);
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
	 
	 
	 
	 
	 
	 
	 private JPanel createSek1Panel () {
		 
		    panel1 = new JPanel();
			panel1.setLayout(null);
			panel1.setBounds(0, 0, W_SIZE, H_SIZE);
			
			comboboxleft = new JComboBox();
			comboboxright = new JComboBox();
			
			fieldleft = new JTextField("0") {
			  public void processKeyEvent(KeyEvent ev) {
			    char c = ev.getKeyChar();
			    try {
			     
			      if ((c > 31 && c < 127) && !(c == 44) && !(c == 46) ) {
			        Integer.parseInt(c + "");
			      }
			      if (c == 46) {
				    	if(!fieldleft.getText().contains(".")) {
				    	Integer.parseInt(c + "");
				    	}
				      }
			      
			      if (c == 44) {
			    	fieldleft.setText(fieldleft.getText() + ".");
			    	Integer.parseInt(c + "");
			      }
			      super.processKeyEvent(ev);
			    }
			    catch (NumberFormatException nfe) {
			      
			    }
			  }
			};

			
			fieldright = new JTextField("0");
			
			
			label_l = new JLabel("Von: ");
			label_r = new JLabel("In: ");
			

			comboboxleft.setLocation(155, H_SIZE/3);
			comboboxright.setLocation(425, H_SIZE/3);
			comboboxleft.setSize(100, 25);
			comboboxright.setSize(100, 25);
			
			
			fieldleft.setLocation(30, H_SIZE/3);
			fieldright.setLocation(300, H_SIZE/3);
			fieldleft.setSize(120, 25);
			fieldright.setSize(120, 25);
			
			fieldleft.addKeyListener(new FieldListener(fieldright, fieldleft, comboboxleft, comboboxright, this));
			fieldright.addKeyListener(new FieldListener(fieldleft, fieldright, comboboxright, comboboxleft, this));
			
			label_l.setLocation(33, H_SIZE/3-20);
			label_r.setLocation(302, H_SIZE/3-20);
			
			
			
			
			label_l.setSize(50, 25);
			label_r.setSize(50, 25);
	
			button_back = new JButton("ZurŸck zum MenŸ!");
			button_back.setSize(150, 30);
			button_back.setLocation(390, 210);
			button_back.addActionListener(new ButtonListener(this, 'b'));

			panel1.add(fieldleft);
			panel1.add(fieldright);
			panel1.add(label_l);
			panel1.add(label_r);
			panel1.add(button_back); 
			panel1.add(comboboxleft);
			panel1.add(comboboxright);
		 
			comboboxleft.addActionListener(new BoxListener(fieldleft, fieldright, comboboxright, comboboxleft, this));
			comboboxright.addActionListener(new BoxListener(fieldright, fieldleft, comboboxleft, comboboxright, this));
			
			
			panel1.validate();
			
			return panel1;
	 }
	 
	 
	 private JPanel createSek2Panel () {
		 
		    panel3 = new JPanel();
			panel3.setLayout(null);
			panel3.setBounds(0, 0, W_SIZE, H_SIZE);
			
			comboboxleft_2 = new JComboBox();
			comboboxright_2 = new JComboBox();
			
			fieldleft = new JTextField("0");
			fieldright = new JTextField("0");
			
			
			label_l = new JLabel("Von: ");
			label_r = new JLabel("In: ");
			
			
			comboboxleft_2.setLocation(155, H_SIZE/3);
			comboboxright_2.setLocation(425, H_SIZE/3);
			comboboxleft_2.setSize(100, 25);
			comboboxright_2.setSize(100, 25);
			
			
			fieldleft.setLocation(30, H_SIZE/3);
			fieldright.setLocation(300, H_SIZE/3);
			fieldleft.setSize(120, 25);
			fieldright.setSize(120, 25);
			
			fieldleft.addKeyListener(new FieldListener(fieldright, fieldleft, comboboxleft, comboboxright, this));
			fieldright.addKeyListener(new FieldListener(fieldleft, fieldright, comboboxright, comboboxleft, this));
			
			
			label_l.setLocation(33, H_SIZE/3-20);
			label_r.setLocation(302, H_SIZE/3-20);
			
			
			label_l.setSize(50, 25);
			label_r.setSize(50, 25);

			panel3.add(fieldleft);
			panel3.add(fieldright);
			panel3.add(label_l);
			panel3.add(label_r); 
			panel3.add(comboboxleft_2);
			panel3.add(comboboxright_2);
		 
			comboboxleft_2.addActionListener(new BoxListener(fieldleft, fieldright, comboboxright_2, comboboxleft_2, this));
			comboboxright_2.addActionListener(new BoxListener(fieldright, fieldleft, comboboxleft_2, comboboxright_2, this));
			
			
			panel3.validate();
			
			return panel3;
	 }
	 
	 
	 private JPanel createPanelMenu () {
			panel2 = new JPanel();
			panel2.setLayout(null);
			panel2.setBounds(0, 0, W_SIZE, H_SIZE);
			
			label_menu = new JLabel("Bitte wŠhle eine physikalische Grš§e!");
			label_mass = new JLabel("Masse");
			label_area = new JLabel("FlŠche");
			label_cap  = new JLabel("Volumen");
			label_len  = new JLabel("LŠnge");
			
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
	 

	 
	 public void writeValue (JTextField othertext, JTextField thistext, JComboBox lefte, JComboBox righte) {
		 if(lefte.getSelectedItem() != null && righte.getSelectedItem() != null) 
			othertext.setText(Double.toString(Converter.convert(Double.parseDouble(thistext.getText()), lefte.getSelectedItem().toString() , righte.getSelectedItem().toString())));
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
