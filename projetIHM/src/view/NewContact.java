package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import model.*;

/**
 * @author AUGER-DUBOIS Quentin et BRIAND Kévin
 * @version 1
 **/

public class NewContact extends Container {

	private boolean clicked;
	private Carnet carnet;
	private JTextField enterName;

	// Constructeur de notre class
	public NewContact(Carnet carn, Dimension dim){
		super(dim);
		this.carnet = carn;
		initPanel();
		this.panel.setBackground(new Color(4,129,158));
	}

	public void initPanel(){		
	    clicked = false;

	// Création des composants
	    JPanel general = new JPanel();
	    general.setLayout(new GridLayout(4,2));
	    general.setBackground(new Color(4,129,158));
	    JPanel commit = new JPanel();
	    commit.setBackground(new Color(4,129,158));
		JTabbedPane tabbedPane = new JTabbedPane();
		JComponent perso = new JPanel();
		perso.setBackground(new Color(4,129,158));
		tabbedPane.addTab("personnel", perso);
		perso.setLayout(new GridLayout(4,1));		
		JComponent pro = new JPanel();
		pro.setBackground(new Color(4,129,158));
		tabbedPane.addTab("professionnel", pro);
		pro.setLayout(new GridLayout(5, 1));

	// Panel general
		Box box1 = Box.createHorizontalBox();
		JLabel nom = new JLabel("Nom : ");
		nom.setFont(smallBoldFont);
		enterName = new JTextField(15);
		enterName.setText("Ex: name");
		enterName.addMouseListener(new ZoneTextListener());
		enterName.setMaximumSize(enterName.getPreferredSize());
		box1.add(Box.createHorizontalStrut(10));
		box1.add(nom);
		box1.add(Box.createHorizontalStrut(28)); // ajoute des pixels d'écarts sur un plan horizontal
		box1.add(enterName);

		Box box2 = Box.createHorizontalBox();
		JLabel prenom = new JLabel("Prénom : ");
		prenom.setFont(smallBoldFont);
		JTextField enterFirstName = new JTextField(15);
		enterFirstName.setMaximumSize(enterFirstName.getPreferredSize());
		box2.add(Box.createHorizontalStrut(10));
		box2.add(prenom);
		box2.add(Box.createHorizontalStrut(10));
		box2.add(enterFirstName);

		Box box3 = Box.createHorizontalBox();
		JLabel civilite = new JLabel("Civilité : ");
		civilite.setFont(smallBoldFont);
		JRadioButton men = new JRadioButton("Monsieur");
		men.setBackground(new Color(4,129,158));
		men.setSelected(true);
		JRadioButton women = new JRadioButton("Madame");
		women.setBackground(new Color(4,129,158));
		ButtonGroup group = new ButtonGroup();
		group.add(men);
		group.add(women);
		box3.add(Box.createHorizontalStrut(10));
		box3.add(civilite);
		box3.add(Box.createHorizontalStrut(17));
		box3.add(men);
		box3.add(Box.createHorizontalStrut(10));
		box3.add(women);
		
		general.add(box1);
		general.add(box2);
		general.add(box3);

	// Panel des onglets
		Box pers1 = Box.createHorizontalBox();
		JLabel adresse = new JLabel("Adresse: ");
		adresse.setFont(smallBoldFont);
		JTextField enterAdresse = new JTextField(30);
		enterAdresse.setMaximumSize(enterAdresse.getPreferredSize());
		pers1.add(Box.createHorizontalStrut(10));
		pers1.add(adresse);
		pers1.add(Box.createHorizontalStrut(75));
		pers1.add(enterAdresse);

		Box pers2 = Box.createHorizontalBox();
		JLabel telD = new JLabel("Téléphone Domicile : ");
		telD.setFont(smallBoldFont);
		JTextField enterTelD= new JTextField(10);
		enterTelD.setMaximumSize(enterTelD.getPreferredSize());
		pers2.add(Box.createHorizontalStrut(10));
		pers2.add(telD);
		pers2.add(Box.createHorizontalStrut(10));
		pers2.add(enterTelD);

		Box pers3 = Box.createHorizontalBox();
		JLabel telP = new JLabel("Téléphone Portable : ");
		telP.setFont(smallBoldFont);
		JTextField enterTelP= new JTextField(10);
		enterTelP.setMaximumSize(enterTelP.getPreferredSize());
		pers3.add(Box.createHorizontalStrut(10));
		pers3.add(telP);
		pers3.add(Box.createHorizontalStrut(11));
		pers3.add(enterTelP);

		Box pers4 = Box.createHorizontalBox();
		JLabel email = new JLabel("Email : ");
		email.setFont(smallBoldFont);
		JTextField enterEmail = new JTextField(15);
		enterEmail.setMaximumSize(enterEmail.getPreferredSize());
		pers4.add(Box.createHorizontalStrut(10));
		pers4.add(email);
		pers4.add(Box.createHorizontalStrut(90));
		pers4.add(enterEmail);

		perso.add(pers1);
		perso.add(pers2);
		perso.add(pers3);
		perso.add(pers4);

		Box pro1 = Box.createHorizontalBox();
		JLabel adressePro = new JLabel("Adresse de l'entreprise : ");
		adressePro.setFont(smallBoldFont);
		JTextField enterAdressePro = new JTextField(30);
		enterAdressePro.setMaximumSize(enterAdressePro.getPreferredSize());
		pro1.add(Box.createHorizontalStrut(10));
		pro1.add(adressePro);
		pro1.add(Box.createHorizontalStrut(10));
		pro1.add(enterAdressePro);

		Box pro2 = Box.createHorizontalBox();
		JLabel telB = new JLabel("Téléphone Bureau : ");
		telB.setFont(smallBoldFont);
		JTextField enterTelB= new JTextField(10);
		enterTelB.setMaximumSize(enterTelB.getPreferredSize());
		pro2.add(Box.createHorizontalStrut(10));
		pro2.add(telB);
		pro2.add(Box.createHorizontalStrut(39));
		pro2.add(enterTelB);

		Box pro3 = Box.createHorizontalBox();
		JLabel telPPro = new JLabel("Téléphone Portable : ");
		telPPro.setFont(smallBoldFont);
		JTextField enterTelPPro= new JTextField(10);
		enterTelPPro.setMaximumSize(enterTelPPro.getPreferredSize());
		pro3.add(Box.createHorizontalStrut(10));
		pro3.add(telPPro);
		pro3.add(Box.createHorizontalStrut(34));
		pro3.add(enterTelPPro);

		Box pro4 = Box.createHorizontalBox();
		JLabel emailPro = new JLabel("Email : ");
		emailPro.setFont(smallBoldFont);
		JTextField enterEmailPro = new JTextField(15);
		enterEmailPro.setMaximumSize(enterEmailPro.getPreferredSize());
		pro4.add(Box.createHorizontalStrut(10));
		pro4.add(emailPro);
		pro4.add(Box.createHorizontalStrut(112));
		pro4.add(enterEmailPro);

		Box pro5 = Box.createHorizontalBox();
		JLabel entreprise = new JLabel("Entreprise : ");
		entreprise.setFont(smallBoldFont);
		JTextField enterEntreprise = new JTextField(15);
		enterEntreprise.setMaximumSize(enterEntreprise.getPreferredSize());
		pro5.add(Box.createHorizontalStrut(10));
		pro5.add(entreprise);
		pro5.add(Box.createHorizontalStrut(84));
		pro5.add(enterEntreprise);

		pro.add(pro2);
		pro.add(pro3);
		pro.add(pro4);
		pro.add(pro5);
		pro.add(pro1);

	// Panel de validation
		JButton valider = new JButton("Ajouter");

		commit.add(valider);

	// Ajout au panel principal
		this.panel.setLayout(new BorderLayout());
		this.panel.add(general, BorderLayout.NORTH);
		this.panel.add(tabbedPane, BorderLayout.CENTER);
		this.panel.add(commit, BorderLayout.SOUTH);
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
}
