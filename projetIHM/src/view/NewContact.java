package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import model.*;

public class NewContact extends Container {

	private boolean clicked;
	private Carnet carnet;
	private JTextField enterName;

	// Constructeur de notre class
	public NewContact(Carnet carn, Dimension dim){
		super(dim);
		this.carnet = carn;
		initPanel();
	}

	public void initPanel(){		
	    clicked = false;
	    
		JTabbedPane tabbedPane = new JTabbedPane();
	   
		JComponent panel1 = new JPanel();
		tabbedPane.addTab("général", panel1);
		panel1.setLayout(new GridLayout(4,2));		
		JComponent panel2 = new JPanel();
		tabbedPane.addTab("personnel", panel2);
		panel2.setLayout(new GridLayout(1, 1));
		JComponent panel3 = new JPanel();
		tabbedPane.addTab("professionnel", panel3);
		panel3.setLayout(new GridLayout(1, 1));

		Box box1 = Box.createHorizontalBox();
		JLabel nom = new JLabel("nom: ");
		enterName = new JTextField();
		box1.add(nom);
		box1.add(enterName);

		Box box2 = Box.createHorizontalBox();
		JLabel prenom = new JLabel("prénom: ");
		JTextField enterFirstName = new JTextField();
		box2.add(prenom);
		box2.add(enterFirstName);

		Box box3 = Box.createHorizontalBox();
		JLabel civilite = new JLabel("civilité: ");
		JRadioButton men = new JRadioButton("Monsieur");
		JRadioButton women = new JRadioButton("Madame");
		ButtonGroup group = new ButtonGroup();
		group.add(men);
		group.add(women);
		box3.add(civilite);
		box3.add(men);
		box3.add(women);
		
		panel1.add(box1);
		panel1.add(box2);
		panel1.add(box3);
		
		this.panel.setLayout(new BorderLayout());
		this.panel.add(tabbedPane, BorderLayout.CENTER);
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
