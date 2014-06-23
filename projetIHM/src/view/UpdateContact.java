package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import model.*;
import controller.*;

/**
 * @author AUGER-DUBOIS Quentin et BRIAND Kévin
 * @version 1
 **/

public class UpdateContact extends Container {
	
	private Personne personne;
	private Carnet carnet;
	private JTabbedPane tabbedPane;
	private JTextField enterName;
	private JTextField enterFirstName;
	private JRadioButton men;
	private JRadioButton women;
	private JTextField enterAdresse;
	private JTextField enterTelD;
	private JTextField enterTelP;
	private JTextField enterEmail;
	private JTextField enterAdressePro;
	private JTextField enterTelB;
	private JTextField enterTelPPro;
	private JTextField enterEmailPro;
	private JTextField enterEntreprise;
	private JLabel imgWarning1;
	private JLabel msgWarning1;
	private JLabel imgWarning2;
	private JLabel msgWarning2;
	private CarnetAdresse frame;
	private ClassLoader cl;

	/**
	 * construit un nouveau conteneur
	 * @param carn Le modele
	 * @param pers La personne à modifier
	 * @param dim Les dimensions du conteneur
	 * @param bigFrame La vue de la fenêtre principale
	 */
	public UpdateContact(Carnet carn, Personne pers, Dimension dim, CarnetAdresse bigFrame){
		super(dim);
		this.personne = pers;
		this.carnet = carn;
		this.frame = bigFrame;
		this.cl = this.getClass().getClassLoader();
		initPanel();
		this.panel.setBackground(new Color(4,129,158));
	}

	/**
	 * méthode qui intialise le Panel
	 */
	public void initPanel(){

	// Création des composants
	    JPanel general = new JPanel();
	    general.setLayout(new GridLayout(4,2));
	    general.setBackground(new Color(4,129,158));
	    JPanel commit = new JPanel();
	    commit.setBackground(new Color(4,129,158));
		this.tabbedPane = new JTabbedPane();
		this.tabbedPane.setBackground(new Color(4,129,158));

		if (this.isPart()){

			Particulier part = (Particulier)this.personne;

			JComponent perso = new JPanel();
			perso.setBackground(new Color(4,129,158));
			this.tabbedPane.addTab("personnel", perso);
			perso.setLayout(new GridLayout(4,1));

		// Panel de l'onglet
			Box pers1 = Box.createHorizontalBox();
			JLabel adresse = new JLabel("Adresse: ");
			adresse.setFont(smallBoldFont);
			this.enterAdresse = new JTextField(30);
			this.enterAdresse.setMaximumSize(this.enterAdresse.getPreferredSize());
			this.enterAdresse.setText(part.getAdresse());
			pers1.add(Box.createHorizontalStrut(10));
			pers1.add(adresse);
			pers1.add(Box.createHorizontalStrut(95));
			pers1.add(this.enterAdresse);

			Box pers2 = Box.createHorizontalBox();
			JLabel telD = new JLabel("Téléphone Domicile : ");
			telD.setFont(smallBoldFont);
			this.enterTelD= new JTextField(10);
			this.enterTelD.setMaximumSize(this.enterTelD.getPreferredSize());
			this.enterTelD.setText(part.getTelD());
			pers2.add(Box.createHorizontalStrut(10));
			pers2.add(telD);
			pers2.add(Box.createHorizontalStrut(10));
			pers2.add(this.enterTelD);

			Box pers3 = Box.createHorizontalBox();
			JLabel telP = new JLabel("Téléphone Portable : ");
			telP.setFont(smallBoldFont);
			this.enterTelP= new JTextField(10);
			this.enterTelP.setMaximumSize(this.enterTelP.getPreferredSize());
			this.enterTelP.setText(part.getTelP());
			pers3.add(Box.createHorizontalStrut(10));
			pers3.add(telP);
			pers3.add(Box.createHorizontalStrut(11));
			pers3.add(this.enterTelP);

			Box pers4 = Box.createHorizontalBox();
			JLabel email = new JLabel("Email : ");
			email.setFont(smallBoldFont);
			this.enterEmail = new JTextField(15);
			this.enterEmail.setMaximumSize(this.enterEmail.getPreferredSize());
			this.enterEmail.setText(part.getEmail());
			pers4.add(Box.createHorizontalStrut(10));
			pers4.add(email);
			pers4.add(Box.createHorizontalStrut(111));
			pers4.add(this.enterEmail);

			perso.add(pers1);
			perso.add(pers2);
			perso.add(pers3);
			perso.add(pers4);
		}else if(this.isPro()){

			Professionnel prof = (Professionnel)this.personne;

			JComponent pro = new JPanel();
			pro.setBackground(new Color(4,129,158));
			this.tabbedPane.addTab("professionnel", pro);
			pro.setLayout(new GridLayout(5, 1));

		// Panel de l'onglet
			Box pro1 = Box.createHorizontalBox();
			JLabel adressePro = new JLabel("Adresse de l'entreprise : ");
			adressePro.setFont(smallBoldFont);
			this.enterAdressePro = new JTextField(30);
			this.enterAdressePro.setMaximumSize(this.enterAdressePro.getPreferredSize());
			this.enterAdressePro.setText(prof.getAdresse());
			pro1.add(Box.createHorizontalStrut(10));
			pro1.add(adressePro);
			pro1.add(Box.createHorizontalStrut(10));
			pro1.add(this.enterAdressePro);

			Box pro2 = Box.createHorizontalBox();
			JLabel telB = new JLabel("Téléphone Bureau : ");
			telB.setFont(smallBoldFont);
			this.enterTelB= new JTextField(10);
			this.enterTelB.setMaximumSize(this.enterTelB.getPreferredSize());
			this.enterTelB.setText(prof.getTelB());
			pro2.add(Box.createHorizontalStrut(10));
			pro2.add(telB);
			pro2.add(Box.createHorizontalStrut(46));
			pro2.add(this.enterTelB);

			Box pro3 = Box.createHorizontalBox();
			JLabel telPPro = new JLabel("Téléphone Portable : ");
			telPPro.setFont(smallBoldFont);
			this.enterTelPPro= new JTextField(10);
			this.enterTelPPro.setMaximumSize(this.enterTelPPro.getPreferredSize());
			this.enterTelPPro.setText(prof.getTelP());
			pro3.add(Box.createHorizontalStrut(10));
			pro3.add(telPPro);
			pro3.add(Box.createHorizontalStrut(38));
			pro3.add(this.enterTelPPro);

			Box pro4 = Box.createHorizontalBox();
			JLabel emailPro = new JLabel("Email : ");
			emailPro.setFont(smallBoldFont);
			this.enterEmailPro = new JTextField(15);
			this.enterEmailPro.setMaximumSize(this.enterEmailPro.getPreferredSize());
			this.enterEmailPro.setText(prof.getEmail());
			pro4.add(Box.createHorizontalStrut(10));
			pro4.add(emailPro);
			pro4.add(Box.createHorizontalStrut(139));
			pro4.add(this.enterEmailPro);

			Box pro5 = Box.createHorizontalBox();
			JLabel entreprise = new JLabel("Entreprise : ");
			entreprise.setFont(smallBoldFont);
			this.enterEntreprise = new JTextField(15);
			this.enterEntreprise.setMaximumSize(this.enterEntreprise.getPreferredSize());
			this.enterEntreprise.setText(prof.getEntreprise());
			pro5.add(Box.createHorizontalStrut(10));
			pro5.add(entreprise);
			pro5.add(Box.createHorizontalStrut(102));
			pro5.add(this.enterEntreprise);

			pro.add(pro2);
			pro.add(pro3);
			pro.add(pro4);
			pro.add(pro5);
			pro.add(pro1);
		}else{

			JComponent perso = new JPanel();
			perso.setBackground(new Color(4,129,158));
			this.tabbedPane.addTab("personnel", perso);
			perso.setLayout(new GridLayout(4,1));

			JComponent pro = new JPanel();
			pro.setBackground(new Color(4,129,158));
			this.tabbedPane.addTab("professionnel", pro);
			pro.setLayout(new GridLayout(5, 1));
		// Panel des onglets
			Box pers1 = Box.createHorizontalBox();
			JLabel adresse = new JLabel("Adresse: ");
			adresse.setFont(smallBoldFont);
			this.enterAdresse = new JTextField(30);
			this.enterAdresse.setMaximumSize(this.enterAdresse.getPreferredSize());
			pers1.add(Box.createHorizontalStrut(10));
			pers1.add(adresse);
			pers1.add(Box.createHorizontalStrut(75));
			pers1.add(this.enterAdresse);

			Box pers2 = Box.createHorizontalBox();
			JLabel telD = new JLabel("Téléphone Domicile : ");
			telD.setFont(smallBoldFont);
			this.enterTelD= new JTextField(10);
			this.enterTelD.setMaximumSize(this.enterTelD.getPreferredSize());
			pers2.add(Box.createHorizontalStrut(10));
			pers2.add(telD);
			pers2.add(Box.createHorizontalStrut(10));
			pers2.add(this.enterTelD);

			Box pers3 = Box.createHorizontalBox();
			JLabel telP = new JLabel("Téléphone Portable : ");
			telP.setFont(smallBoldFont);
			this.enterTelP= new JTextField(10);
			this.enterTelP.setMaximumSize(this.enterTelP.getPreferredSize());
			pers3.add(Box.createHorizontalStrut(10));
			pers3.add(telP);
			pers3.add(Box.createHorizontalStrut(11));
			pers3.add(this.enterTelP);

			Box pers4 = Box.createHorizontalBox();
			JLabel email = new JLabel("Email : ");
			email.setFont(smallBoldFont);
			this.enterEmail = new JTextField(15);
			this.enterEmail.setMaximumSize(this.enterEmail.getPreferredSize());
			pers4.add(Box.createHorizontalStrut(10));
			pers4.add(email);
			pers4.add(Box.createHorizontalStrut(90));
			pers4.add(this.enterEmail);

			perso.add(pers1);
			perso.add(pers2);
			perso.add(pers3);
			perso.add(pers4);

			Box pro1 = Box.createHorizontalBox();
			JLabel adressePro = new JLabel("Adresse de l'entreprise : ");
			adressePro.setFont(smallBoldFont);
			this.enterAdressePro = new JTextField(30);
			this.enterAdressePro.setMaximumSize(this.enterAdressePro.getPreferredSize());
			pro1.add(Box.createHorizontalStrut(10));
			pro1.add(adressePro);
			pro1.add(Box.createHorizontalStrut(10));
			pro1.add(this.enterAdressePro);

			Box pro2 = Box.createHorizontalBox();
			JLabel telB = new JLabel("Téléphone Bureau : ");
			telB.setFont(smallBoldFont);
			this.enterTelB= new JTextField(10);
			this.enterTelB.setMaximumSize(this.enterTelB.getPreferredSize());
			pro2.add(Box.createHorizontalStrut(10));
			pro2.add(telB);
			pro2.add(Box.createHorizontalStrut(39));
			pro2.add(this.enterTelB);

			Box pro3 = Box.createHorizontalBox();
			JLabel telPPro = new JLabel("Téléphone Portable : ");
			telPPro.setFont(smallBoldFont);
			this.enterTelPPro= new JTextField(10);
			this.enterTelPPro.setMaximumSize(this.enterTelPPro.getPreferredSize());
			pro3.add(Box.createHorizontalStrut(10));
			pro3.add(telPPro);
			pro3.add(Box.createHorizontalStrut(34));
			pro3.add(this.enterTelPPro);

			Box pro4 = Box.createHorizontalBox();
			JLabel emailPro = new JLabel("Email : ");
			emailPro.setFont(smallBoldFont);
			this.enterEmailPro = new JTextField(15);
			this.enterEmailPro.setMaximumSize(this.enterEmailPro.getPreferredSize());
			pro4.add(Box.createHorizontalStrut(10));
			pro4.add(emailPro);
			pro4.add(Box.createHorizontalStrut(112));
			pro4.add(this.enterEmailPro);

			Box pro5 = Box.createHorizontalBox();
			JLabel entreprise = new JLabel("Entreprise : ");
			entreprise.setFont(smallBoldFont);
			this.enterEntreprise = new JTextField(15);
			this.enterEntreprise.setMaximumSize(this.enterEntreprise.getPreferredSize());
			pro5.add(Box.createHorizontalStrut(10));
			pro5.add(entreprise);
			pro5.add(Box.createHorizontalStrut(84));
			pro5.add(this.enterEntreprise);

			pro.add(pro2);
			pro.add(pro3);
			pro.add(pro4);
			pro.add(pro5);
			pro.add(pro1);
		}	

	// Panel general
		Box box1 = Box.createHorizontalBox();
		JLabel nom = new JLabel("Nom* : ");
		nom.setFont(smallBoldFont);
		this.enterName = new JTextField(15);
		this.enterName.setMaximumSize(this.enterName.getPreferredSize());
		this.enterName.setText(this.personne.getNom());
		box1.add(Box.createHorizontalStrut(10));
		box1.add(nom);
		box1.add(Box.createHorizontalStrut(33)); // ajoute des pixels d'écarts sur un plan horizontal
		box1.add(this.enterName);
		box1.add(Box.createHorizontalStrut(10));
		this.imgWarning1 = new JLabel(new ImageIcon(this.cl.getResource("warning-red.png")));
		this.imgWarning1.setVisible(false);
		this.msgWarning1 = new JLabel(" Ce champ est obligatoire");
		this.msgWarning1.setVisible(false);
		box1.add(this.imgWarning1);
		box1.add(this.msgWarning1);

		Box box2 = Box.createHorizontalBox();
		JLabel prenom = new JLabel("Prénom* : ");
		prenom.setFont(smallBoldFont);
		this.enterFirstName = new JTextField(15);
		this.enterFirstName.setMaximumSize(this.enterFirstName.getPreferredSize());
		this.enterFirstName.setText(this.personne.getPrenom());
		box2.add(Box.createHorizontalStrut(10));
		box2.add(prenom);
		box2.add(Box.createHorizontalStrut(10));
		box2.add(this.enterFirstName);
		this.imgWarning2 = new JLabel(new ImageIcon(this.cl.getResource("warning-red.png")));
		this.imgWarning2.setVisible(false);
		this.msgWarning2 = new JLabel(" Ce champ est obligatoire");
		this.msgWarning2.setVisible(false);
		box2.add(this.imgWarning2);
		box2.add(this.msgWarning2);

		Box box3 = Box.createHorizontalBox();
		JLabel civilite = new JLabel("Civilité : ");
		civilite.setFont(smallBoldFont);
		this.men = new JRadioButton("Monsieur");
		this.men.setBackground(new Color(4,129,158));
		if(this.personne.getCivilite().equals("M.")) this.men.setSelected(true);
		this.women = new JRadioButton("Madame");
		this.women.setBackground(new Color(4,129,158));
		if(this.personne.getCivilite().equals("Mme")) this.women.setSelected(true);
		ButtonGroup group = new ButtonGroup();
		group.add(this.men);
		group.add(this.women);
		box3.add(Box.createHorizontalStrut(10));
		box3.add(civilite);
		box3.add(Box.createHorizontalStrut(17));
		box3.add(this.men);
		box3.add(Box.createHorizontalStrut(10));
		box3.add(this.women);

		Box box4 = Box.createHorizontalBox();
		JLabel condition = new JLabel("(*) champs obligatoire");
		box4.add(Box.createHorizontalStrut(10));
		box4.add(condition);
		
		general.add(box1);
		general.add(box2);
		general.add(box3);
		general.add(box4);

	// Panel de validation
		JButton valider = new JButton("Enregistrer");

		ActionListener a = new UpdatedController(this, this.carnet, this.frame);
		valider.addActionListener(a);

		commit.add(valider);

	// Ajout au panel principal
		this.panel.setLayout(new BorderLayout());
		this.panel.add(general, BorderLayout.NORTH);
		this.panel.add(this.tabbedPane, BorderLayout.CENTER);
		this.panel.add(commit, BorderLayout.SOUTH);
	}

	/**
	 * Indique si l'onglet professionnel est sélectionné
	 * @return vrai si l'onglet professionnel est sélectionné et faux sinon
	 */
	public boolean isPro(){
		if (this.personne instanceof Professionnel) return true;
		else return false;
	}

	/**
	 * Indique si l'onglet personnel est sélectionné
	 * @return vrai si l'onglet personnel est sélectionné et faux sinon
	 */
	public boolean isPart(){
		if (this.personne instanceof Particulier) return true;
		else return false;
	}

	/**
	 * Donne le nom d'une personne
	 * @return le texte présent dans la JTextField enterName
	 */
	public String getName() {
		return this.enterName.getText();
	}

	/**
	 * Donne le prénom d'une personne
	 * @return le texte présent dans la JTextField enterFirstName
	 */
	public String getFirstName() {
		return this.enterFirstName.getText();
	}

	/**
	 * Indique si la personne en un homme
	 * @return True si c'est un homme et faux sinon
	 */
	public boolean isAMan() {
		return this.men.isSelected();
	}

	/**
	 * Indique si la personne en une femme
	 * @return True si c'est une femme et faux sinon
	 */
	public boolean isAWoman() {
		return this.women.isSelected();
	}

	/**
	 * Donne l'adresse personnel d'une personne
	 * @return le texte présent dans la JTextField enterAdresse
	 */
	public String getAdress() {
		return this.enterAdresse.getText();
	}

	/**
	 * Donne le numéro de téléphone du domicile d'une personne
	 * @return le texte présent dans la JTextField enterTelD
	 */
	public String getPhoneNumber() {
		return this.enterTelD.getText();
	}

	/**
	 * Donne le numéro de téléphone portable personnel d'une personne
	 * @return le texte présent dans la JTextField enterTelP
	 */
	public String getCellPhoneNumber() {
		return this.enterTelP.getText();
	}

	/**
	 * Donne l'email personnel d'une personne
	 * @return le texte présent dans la JTextField enterEmail
	 */
	public String getEmail() {
		return this.enterEmail.getText();
	}

	/**
	 * Donne l'adresse professionnel d'une personne
	 * @return le texte présent dans la JTextField enterAdressePro
	 */
	public String getProAdress() {
		return this.enterAdressePro.getText();
	}

	/**
	 * Donne le numéro de téléphone du bureau d'une personne
	 * @return le texte présent dans la JTextField enterTelB
	 */
	public String getProPhoneNumber() {
		return this.enterTelB.getText();
	}

	/**
	 * Donne le numéro de téléphone portable professionnel d'une personne
	 * @return le texte présent dans la JTextField enterTelPPro
	 */
	public String getProCellPhoneNumber() {
		return this.enterTelPPro.getText();
	}

	/**
	 * Donne l'email professionnel d'une personne
	 * @return le texte présent dans la JTextField enterEmailPro
	 */
	public String getProEmail() {
		return this.enterEmailPro.getText();
	}

	/**
	 * Donne le nom de l'entreprise dans laquelle travail une personne
	 * @return le texte présent dans la JTextField enterEntreprise
	 */
	public String getCompagny() {
		return this.enterEntreprise.getText();
	}

	/**
	 * indique si le champ nom est vide ou pas
	 * @return vrai si le champ nom est vide
	 */
	public boolean nameFieldIsEmpty(){
		if (this.getName().equals("")) return true;
		else return false;
	}

	/**
	 * indique si le champ prénom est vide ou pas
	 * @return vrai si le champ prénom est vide
	 */
	public boolean firstNameFieldIsEmpty(){
		if (this.getFirstName().equals("")) return true;
		else return false;
	}

	/**
	* méthode qui affiche le message d'avertissement du champ nom
	* @param yes qui est vrai si on doit afficher le message et faux sinon
	*/
	public void setWarningMessageName(boolean yes){
		this.imgWarning1.setVisible(yes);
		this.msgWarning1.setVisible(yes);
		if (yes) this.enterName.setBackground(new Color(255,111,111));
		else this.enterName.setBackground(Color.white);
	}

	/**
	* méthode qui affiche le message d'avertissement du champ prénom
	* @param yes qui est vrai si on doit afficher le message et faux sinon
	*/
	public void setWarningMessageFirstName(boolean yes){
		this.imgWarning2.setVisible(yes);
		this.msgWarning2.setVisible(yes);
		if (yes) this.enterFirstName.setBackground(new Color(255,111,111));
		else this.enterFirstName.setBackground(Color.white);
	}
}