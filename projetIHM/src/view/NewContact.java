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
		panel2.setLayout(new GridLayout(4,1));
		JComponent panel3 = new JPanel();
		tabbedPane.addTab("professionnel", panel3);
		panel3.setLayout(new GridLayout(1, 1));

		// ********************[ONGLET GENERAL]***********************

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


// ***********************[ONGLET PERSONNEL]*******************


		/*Box pers1 = Box.createHorizontalBox();
		JLabel adresse = new JLabel("Adresse: ");
		JTextField enterAdresse = new JTextField();
		pers1.add(adresse);
		pers1.add(enterAdresse);

		Box pers2 = Box.createHorizontalBox();
		JLabel telD = new JLabel("Téléphone Domicile : ");
		JTextField enterTelD= new JTextField();
		pers2.add(telD);
		pers2.add(enterTelD);

		Box pers3 = Box.createHorizontalBox();
		JLabel telP = new JLabel("Téléphone Portable : ");
		JTextField enterTelP= new JTextField();
		pers2.add(telP);
		pers2.add(enterTelP);

		Box pers4 = Box.createHorizontalBox();
		JLabel email = new JLabel("Email : ");
		JTextField enterEmail = new JTextField();
		pers2.add(email);
		pers2.add(enterEmail);*/

		JPanel pers1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel adresse = new JLabel("Adresse: ");
		JTextField enterAdresse = new JTextField(50);
		pers1.add(adresse);
		pers1.add(enterAdresse);

		JPanel pers2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel telD = new JLabel("Téléphone Domicile : ");
		JTextField enterTelD= new JTextField(10);
		pers2.add(telD);
		pers2.add(enterTelD);


		JPanel pers3 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel telP = new JLabel("Téléphone Portable : ");
		JTextField enterTelP= new JTextField(10);
		pers2.add(telP);
		pers2.add(enterTelP);


		JPanel pers4 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel email = new JLabel("Email : ");
		JTextField enterEmail = new JTextField(30);
		pers2.add(email);
		pers2.add(enterEmail);


		panel2.add(pers1);
		panel2.add(pers2);
		panel2.add(pers3);
		panel2.add(pers4);

		// ******************************************************

		
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
