package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import model.*;

/**
 * @author AUGER-DUBOIS Quentin et BRIAND Kévin
 * @version 1
 **/

public class SeeMore extends Container {
	
	private Personne personne;
	private Carnet carnet;

	// Constructeur de notre class
	public SeeMore(Carnet carn, Personne pers, Dimension dim){
		super(dim);
		this.personne = pers;
		this.carnet = carn;
		initPanel();
		this.panel.setBackground(new Color(4,129,158));
	}

	public void initPanel(){

	// Création des composants
	    JPanel general = new JPanel();
	    general.setLayout(new GridLayout(4,2));
	    general.setBackground(new Color(4,129,158));
		JTabbedPane tabbedPane = new JTabbedPane();
		tabbedPane.setBackground(new Color(4,129,158));

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
			JLabel enterAdresse = new JLabel();
			enterAdresse.setText(part.getAdresse());
			pers1.add(Box.createHorizontalStrut(10));
			pers1.add(adresse);
			pers1.add(Box.createHorizontalStrut(75));
			pers1.add(enterAdresse);

			Box pers2 = Box.createHorizontalBox();
			JLabel telD = new JLabel("Téléphone Domicile : ");
			telD.setFont(smallBoldFont);
			JLabel enterTelD= new JLabel();
			enterTelD.setText(part.getTelD());
			pers2.add(Box.createHorizontalStrut(10));
			pers2.add(telD);
			pers2.add(Box.createHorizontalStrut(10));
			pers2.add(enterTelD);

			Box pers3 = Box.createHorizontalBox();
			JLabel telP = new JLabel("Téléphone Portable : ");
			telP.setFont(smallBoldFont);
			JLabel enterTelP= new JLabel();
			enterTelP.setText(part.getTelP());
			pers3.add(Box.createHorizontalStrut(10));
			pers3.add(telP);
			pers3.add(Box.createHorizontalStrut(11));
			pers3.add(enterTelP);

			Box pers4 = Box.createHorizontalBox();
			JLabel email = new JLabel("Email : ");
			email.setFont(smallBoldFont);
			JLabel enterEmail = new JLabel();
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
			JLabel enterAdressePro = new JLabel();
			enterAdressePro.setText(prof.getAdresse());
			pro1.add(Box.createHorizontalStrut(10));
			pro1.add(adressePro);
			pro1.add(Box.createHorizontalStrut(10));
			pro1.add(enterAdressePro);

			Box pro2 = Box.createHorizontalBox();
			JLabel telB = new JLabel("Téléphone Bureau : ");
			telB.setFont(smallBoldFont);
			JLabel enterTelB= new JLabel();
			enterTelB.setText(prof.getTelB());
			pro2.add(Box.createHorizontalStrut(10));
			pro2.add(telB);
			pro2.add(Box.createHorizontalStrut(39));
			pro2.add(enterTelB);

			Box pro3 = Box.createHorizontalBox();
			JLabel telPPro = new JLabel("Téléphone Portable : ");
			telPPro.setFont(smallBoldFont);
			JLabel enterTelPPro= new JLabel();
			enterTelPPro.setText(prof.getTelP());
			pro3.add(Box.createHorizontalStrut(10));
			pro3.add(telPPro);
			pro3.add(Box.createHorizontalStrut(34));
			pro3.add(enterTelPPro);

			Box pro4 = Box.createHorizontalBox();
			JLabel emailPro = new JLabel("Email : ");
			emailPro.setFont(smallBoldFont);
			JLabel enterEmailPro = new JLabel();
			enterEmailPro.setText(prof.getEmail());
			pro4.add(Box.createHorizontalStrut(10));
			pro4.add(emailPro);
			pro4.add(Box.createHorizontalStrut(112));
			pro4.add(enterEmailPro);

			Box pro5 = Box.createHorizontalBox();
			JLabel entreprise = new JLabel("Entreprise : ");
			entreprise.setFont(smallBoldFont);
			JLabel enterEntreprise = new JLabel();
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
			JLabel enterAdresse = new JLabel();
			pers1.add(Box.createHorizontalStrut(10));
			pers1.add(adresse);
			pers1.add(Box.createHorizontalStrut(75));
			pers1.add(enterAdresse);

			Box pers2 = Box.createHorizontalBox();
			JLabel telD = new JLabel("Téléphone Domicile : ");
			telD.setFont(smallBoldFont);
			JLabel enterTelD= new JLabel();
			pers2.add(Box.createHorizontalStrut(10));
			pers2.add(telD);
			pers2.add(Box.createHorizontalStrut(10));
			pers2.add(enterTelD);

			Box pers3 = Box.createHorizontalBox();
			JLabel telP = new JLabel("Téléphone Portable : ");
			telP.setFont(smallBoldFont);
			JLabel enterTelP= new JLabel();
			pers3.add(Box.createHorizontalStrut(10));
			pers3.add(telP);
			pers3.add(Box.createHorizontalStrut(11));
			pers3.add(enterTelP);

			Box pers4 = Box.createHorizontalBox();
			JLabel email = new JLabel("Email : ");
			email.setFont(smallBoldFont);
			JLabel enterEmail = new JLabel();
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
			JLabel enterAdressePro = new JLabel();
			pro1.add(Box.createHorizontalStrut(10));
			pro1.add(adressePro);
			pro1.add(Box.createHorizontalStrut(10));
			pro1.add(enterAdressePro);

			Box pro2 = Box.createHorizontalBox();
			JLabel telB = new JLabel("Téléphone Bureau : ");
			telB.setFont(smallBoldFont);
			JLabel enterTelB= new JLabel();
			pro2.add(Box.createHorizontalStrut(10));
			pro2.add(telB);
			pro2.add(Box.createHorizontalStrut(39));
			pro2.add(enterTelB);

			Box pro3 = Box.createHorizontalBox();
			JLabel telPPro = new JLabel("Téléphone Portable : ");
			telPPro.setFont(smallBoldFont);
			JLabel enterTelPPro= new JLabel();
			pro3.add(Box.createHorizontalStrut(10));
			pro3.add(telPPro);
			pro3.add(Box.createHorizontalStrut(34));
			pro3.add(enterTelPPro);

			Box pro4 = Box.createHorizontalBox();
			JLabel emailPro = new JLabel("Email : ");
			emailPro.setFont(smallBoldFont);
			JLabel enterEmailPro = new JLabel();
			pro4.add(Box.createHorizontalStrut(10));
			pro4.add(emailPro);
			pro4.add(Box.createHorizontalStrut(112));
			pro4.add(enterEmailPro);

			Box pro5 = Box.createHorizontalBox();
			JLabel entreprise = new JLabel("Entreprise : ");
			entreprise.setFont(smallBoldFont);
			JLabel enterEntreprise = new JLabel();
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
		JLabel enterName = new JLabel();
		enterName.setText(this.personne.getNom());
		box1.add(Box.createHorizontalStrut(10));
		box1.add(nom);
		box1.add(Box.createHorizontalStrut(28)); // ajoute des pixels d'écarts sur un plan horizontal
		box1.add(enterName);

		Box box2 = Box.createHorizontalBox();
		JLabel prenom = new JLabel("Prénom : ");
		prenom.setFont(smallBoldFont);
		JLabel enterFirstName = new JLabel();
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

	// Ajout au panel principal
		this.panel.setLayout(new BorderLayout());
		this.panel.add(general, BorderLayout.NORTH);
		this.panel.add(tabbedPane, BorderLayout.CENTER);
	}
}