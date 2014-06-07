package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import model.*;

public class NewContact extends Container {

	private boolean clicked;
	private Carnet carnet;
	private JTextField input1;

	// Constructeur de notre class
	public NewContact(Carnet carn, Dimension dim){
		super(dim);
		this.carnet = carn;
		initPanel();
	}

	public void initPanel(){		
	    clicked = false;
	    
	   JTabbedPane tabbedPane = new JTabbedPane();
	   ImageIcon icon = createImageIcon("images/middle.gif");
	   
	   JComponent panel1 = makeTextPanel("Panel #1");
	   tabbedPane.addTab("général", icon, panel1,
	                  "Informations général");
	   JComponent panel2 = makeTextPanel("Panel #2");
	   tabbedPane.addTab("personnel", icon, panel2,
	                  "Informations personnelles");
	   JComponent panel3 = makeTextPanel("Panel #3");
	   tabbedPane.addTab("professionnel", icon, panel3,
	                  "Informations professionnelles");

		input1 = new JTextField();
		JLabel nom = new JLabel("nom: ");
		JTextField enterName = new JTextField();
		JLabel prenom = new JLabel("prénom:");
		JTextField enterFirstName = new JTextField();
		Jlabel civilite = new JLabel("civilité");
		JRadioButton men = new JRadioButton("Monsieur");
		JRadioButton women = new JRadioButton("Madame");
		ButtonGroup group = new ButtonGroup();
		group.add(men);
		group.add(women);
		
		panel1.add(nom);
		panel1.add(enterName);
		panel1.add(prenom);
		panel1.add(enterFirstName);
		panel1.add(civilite);
		panel1.add(group);
		
		this.getPanel().add(tabbedPane);
	}

	class ZoneTextListener implements MouseListener {
		public void mouseEntered(MouseEvent e) {
	    	if (enterName.getText().equals("Ex: name")){
	    		enterName.setText("");
	    	}
		}
		public void mouseExited(MouseEvent ev) {
			if (enterName.getText().equals("") && !clicked){
		    	enterName.setText("Ex: name");
		    }
		}
		public void mousePressed(MouseEvent eve) {
			clicked = true;
		}
		@Override
		public void mouseClicked(MouseEvent even) {
			clicked = true;
		}
		@Override
		public void mouseReleased(MouseEvent event) {}
	}

	/*class NomListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0){
		    
		}
	}*/
}
