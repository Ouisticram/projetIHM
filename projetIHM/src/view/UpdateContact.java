package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import model.*;

/**
 * @author AUGER-DUBOIS Quentin et BRIAND Kévin
 * @version 1
 **/

public class UpdateContact extends Container {
	
	private Personne personne;
	private Carnet carnet;

	// Constructeur de notre class
	public UpdateContact(Carnet carn, Personne pers, Dimension dim){
		super(dim);
		this.personne = pers;
		this.carnet = carn;
		initPanel();
	}

	public void initPanel(){

	// Création des composants
	    JPanel general = new JPanel();
	    general.setLayout(new GridLayout(4,2));
	    general.setBackground(new Color(4,129,158));
	    JPanel commit = new JPanel();
	    commit.setBackground(new Color(4,129,158));
		JTabbedPane tabbedPane = new JTabbedPane();

		if (this.personne instanceof Particulier){

			Particulier part = (Particulier)this.personne;

			JComponent perso = new JPanel();
			perso.setBackground(new Color(4,129,158));
			tabbedPane.addTab("personnel", perso);
			perso.setLayout(new GridLayout(4,1));

		// Panel de l'onglet
			Box pers1 = Box.createHorizontalBox();
			JLabel adresse = new JLabel("Adresse: ");
			adresse.setFont(smallBoldFont);
			JTextField enterAdresse = new JTextField(30);
			enterAdresse.setMaximumSize(enterAdresse.getPreferredSize());
			enterAdresse.setText(part.getAdresse());
			pers1.add(Box.createHorizontalStrut(10));
			pers1.add(adresse);
			pers1.add(Box.createHorizontalStrut(75));
			pers1.add(enterAdresse);

			Box pers2 = Box.createHorizontalBox();
			JLabel telD = new JLabel("Téléphone Domicile : ");
			telD.setFont(smallBoldFont);
			JTextField enterTelD= new JTextField(10);
			enterTelD.setMaximumSize(enterTelD.getPreferredSize());
			enterTelD.setText(part.getTelD());
			pers2.add(Box.createHorizontalStrut(10));
			pers2.add(telD);
			pers2.add(Box.createHorizontalStrut(10));
			pers2.add(enterTelD);

			Box pers3 = Box.createHorizontalBox();
			JLabel telP = new JLabel("Téléphone Portable : ");
			telP.setFont(smallBoldFont);
			JTextField enterTelP= new JTextField(10);
			enterTelP.setMaximumSize(enterTelP.getPreferredSize());
			enterTelP.setText(part.getTelP());
			pers3.add(Box.createHorizontalStrut(10));
			pers3.add(telP);
			pers3.add(Box.createHorizontalStrut(11));
			pers3.add(enterTelP);

			Box pers4 = Box.createHorizontalBox();
			JLabel email = new JLabel("Email : ");
			email.setFont(smallBoldFont);
			JTextField enterEmail = new JTextField(15);
			enterEmail.setMaximumSize(enterEmail.getPreferredSize());
			enterEmail.setText(part.getEmail());
			pers4.add(Box.createHorizontalStrut(10));
			pers4.add(email);
			pers4.add(Box.createHorizontalStrut(90));
			pers4.add(enterEmail);

			perso.add(pers1);
			perso.add(pers2);
			perso.add(pers3);
			perso.add(pers4);
		}else if(this.personne instanceof Professionnel){

			Professionnel prof = (Professionnel)this.personne;

			JComponent pro = new JPanel();
			pro.setBackground(new Color(4,129,158));
			tabbedPane.addTab("professionnel", pro);
			pro.setLayout(new GridLayout(5, 1));

		// Panel de l'onglet
			Box pro1 = Box.createHorizontalBox();
			JLabel adressePro = new JLabel("Adresse de l'entreprise : ");
			adressePro.setFont(smallBoldFont);
			JTextField enterAdressePro = new JTextField(30);
			enterAdressePro.setMaximumSize(enterAdressePro.getPreferredSize());
			enterAdressePro.setText(prof.getAdresse());
			pro1.add(Box.createHorizontalStrut(10));
			pro1.add(adressePro);
			pro1.add(Box.createHorizontalStrut(10));
			pro1.add(enterAdressePro);

			Box pro2 = Box.createHorizontalBox();
			JLabel telB = new JLabel("Téléphone Bureau : ");
			telB.setFont(smallBoldFont);
			JTextField enterTelB= new JTextField(10);
			enterTelB.setMaximumSize(enterTelB.getPreferredSize());
			enterTelB.setText(prof.getTelB());
			pro2.add(Box.createHorizontalStrut(10));
			pro2.add(telB);
			pro2.add(Box.createHorizontalStrut(39));
			pro2.add(enterTelB);

			Box pro3 = Box.createHorizontalBox();
			JLabel telPPro = new JLabel("Téléphone Portable : ");
			telPPro.setFont(smallBoldFont);
			JTextField enterTelPPro= new JTextField(10);
			enterTelPPro.setMaximumSize(enterTelPPro.getPreferredSize());
			enterTelPPro.setText(prof.getTelP());
			pro3.add(Box.createHorizontalStrut(10));
			pro3.add(telPPro);
			pro3.add(Box.createHorizontalStrut(34));
			pro3.add(enterTelPPro);

			Box pro4 = Box.createHorizontalBox();
			JLabel emailPro = new JLabel("Email : ");
			emailPro.setFont(smallBoldFont);
			JTextField enterEmailPro = new JTextField(15);
			enterEmailPro.setMaximumSize(enterEmailPro.getPreferredSize());
			enterEmailPro.setText(prof.getEmail());
			pro4.add(Box.createHorizontalStrut(10));
			pro4.add(emailPro);
			pro4.add(Box.createHorizontalStrut(112));
			pro4.add(enterEmailPro);

			Box pro5 = Box.createHorizontalBox();
			JLabel entreprise = new JLabel("Entreprise : ");
			entreprise.setFont(smallBoldFont);
			JTextField enterEntreprise = new JTextField(15);
			enterEntreprise.setMaximumSize(enterEntreprise.getPreferredSize());
			enterEntreprise.setText(prof.getEntreprise());
			pro5.add(Box.createHorizontalStrut(10));
			pro5.add(entreprise);
			pro5.add(Box.createHorizontalStrut(84));
			pro5.add(enterEntreprise);

			pro.add(pro2);
			pro.add(pro3);
			pro.add(pro4);
			pro.add(pro5);
			pro.add(pro1);
		}else{

			JComponent perso = new JPanel();
			perso.setBackground(new Color(4,129,158));
			tabbedPane.addTab("personnel", perso);
			perso.setLayout(new GridLayout(4,1));

			JComponent pro = new JPanel();
			pro.setBackground(new Color(4,129,158));
			tabbedPane.addTab("professionnel", pro);
			pro.setLayout(new GridLayout(5, 1));
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
		}	

	// Panel general
		Box box1 = Box.createHorizontalBox();
		JLabel nom = new JLabel("Nom : ");
		nom.setFont(smallBoldFont);
		JTextField enterName;
		enterName = new JTextField(15);
		enterName.setMaximumSize(enterName.getPreferredSize());
		enterName.setText(this.personne.getNom());
		box1.add(Box.createHorizontalStrut(10));
		box1.add(nom);
		box1.add(Box.createHorizontalStrut(28)); // ajoute des pixels d'écarts sur un plan horizontal
		box1.add(enterName);

		Box box2 = Box.createHorizontalBox();
		JLabel prenom = new JLabel("Prénom : ");
		prenom.setFont(smallBoldFont);
		JTextField enterFirstName = new JTextField(15);
		enterFirstName.setMaximumSize(enterFirstName.getPreferredSize());
		enterFirstName.setText(this.personne.getPrenom());
		box2.add(Box.createHorizontalStrut(10));
		box2.add(prenom);
		box2.add(Box.createHorizontalStrut(10));
		box2.add(enterFirstName);

		Box box3 = Box.createHorizontalBox();
		JLabel civilite = new JLabel("Civilité : ");
		civilite.setFont(smallBoldFont);
		JRadioButton men = new JRadioButton("Monsieur");
		men.setBackground(new Color(4,129,158));
		if(this.personne.getCivilite().equals("M.")) men.setSelected(true);
		JRadioButton women = new JRadioButton("Madame");
		women.setBackground(new Color(4,129,158));
		if(this.personne.getCivilite().equals("Mme")) women.setSelected(true);
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

	// Panel de validation
		JButton valider = new JButton("Enregistrer");

		commit.add(valider);

	// Ajout au panel principal
		this.panel.setLayout(new BorderLayout());
		this.panel.add(general, BorderLayout.NORTH);
		this.panel.add(tabbedPane, BorderLayout.CENTER);
		this.panel.add(commit, BorderLayout.SOUTH);
	}
}