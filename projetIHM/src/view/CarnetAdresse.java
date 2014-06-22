package view;

import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.event.*;
import model.*;
import controller.*;

/**
 * @author AUGER-DUBOIS Quentin et BRIAND Kévin
 * @version 1
 **/

public class CarnetAdresse extends JFrame {

	private Dimension dimPaneDown;
	private Font bigBoldFont = new Font("Arial", Font.BOLD, 30);
	private Font smallBoldFont = new Font("Arial", Font.BOLD, 14);
	private Font smallPlainFont = new Font("Arial", Font.PLAIN, 14);

	private Carnet carnet;

	private java.awt.Container principal;
	private JPanel up;
	private JPanel down;

	private JButton nextPeople;
	private JButton previousPeople;

	private JLabel nom;
	private JLabel prenom;
	private JLabel civilite;

	private Personne[] tab_pers;
	private JList<Personne> liste;

	private boolean updatePanelLoad;
	private boolean seeMorePanelLoad;
	private ClassLoader cl;

	/**
	 * construit une nouvelle fenêtre
	 * @param titre Le titre de la fenêtre
	 * @param dim La dimension de la fenêtre
	 */
	public CarnetAdresse(String titre, Dimension dim){
		super(titre);

		this.updatePanelLoad = false;
		this.seeMorePanelLoad = false;
		this.cl = this.getClass().getClassLoader();

		this.carnet = new Carnet(); // création d'un nouveau carnet d'adresse

		this.principal = this.getContentPane();
		this.principal.setPreferredSize(dim);
		this.principal.setLayout(new GridBagLayout());

		int height = (int)(dim.getHeight()/3);
		int heightBas = (int)dim.getHeight()-height;
		int width = (int)dim.getWidth();
		this.dimPaneDown = new Dimension(width,heightBas);

	// Panel du haut
		this.up = new JPanel();
		this.up.setLayout(new BorderLayout());
		this.up.setPreferredSize(new Dimension(width,height));

	// Panel en haut à gauche
		JPanel gauche = new JPanel();
		gauche.setLayout(new BorderLayout());
		gauche.setPreferredSize (new Dimension(275,0));

		JPanel buttonPane = new JPanel();
		buttonPane.setLayout(new BoxLayout(buttonPane, BoxLayout.LINE_AXIS));
		buttonPane.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 35));
		buttonPane.setBackground(new Color(96,185,206));

		JButton showMore = new JButton("Voir plus...");

		ActionListener al = new SeeMoreController(this);
		showMore.addActionListener(al);

		JButton search = new JButton("Rechercher");

		ActionListener alr = new SearchController(this);
		search.addActionListener(alr);

		buttonPane.add(Box.createHorizontalGlue());
		buttonPane.add(showMore);
		buttonPane.add(Box.createRigidArea(new Dimension(10, 0)));
		buttonPane.add(search);

		JPanel infos = new JPanel();
		infos.setBackground(new Color(96,185,206));
		infos.setBorder(BorderFactory.createTitledBorder("Informations"));
		infos.setLayout(new GridLayout(3,2));
		JLabel name = new JLabel("nom: ");
		name.setFont(smallBoldFont);
		JLabel firstname = new JLabel("prenom: ");
		firstname.setFont(smallBoldFont);
		JLabel civility = new JLabel("civilité: ");
		civility.setFont(smallBoldFont);
		this.nom = new JLabel();
		this.nom.setFont(smallPlainFont);
		this.prenom = new JLabel();
		this.prenom.setFont(smallPlainFont);
		this.civilite = new JLabel();
		this.civilite.setFont(smallPlainFont);
		this.details();

		nextPeople = new JButton(">");
		previousPeople = new JButton("<");
		previousPeople.setEnabled(false);

		ActionListener a = new ChoiceContactController(this, this.carnet);
		nextPeople.addActionListener(a);
		previousPeople.addActionListener(a);

		infos.add(name);
		infos.add(this.nom);
		infos.add(firstname);
		infos.add(this.prenom);
		infos.add(civility);
		infos.add(this.civilite);

		gauche.add(infos, BorderLayout.CENTER);
		gauche.add(buttonPane, BorderLayout.SOUTH);
		gauche.add(nextPeople, BorderLayout.EAST);
		gauche.add(previousPeople, BorderLayout.WEST);

	// Panel en haut à droite
		JPanel droite = new JPanel();
		droite.setLayout(new BorderLayout());

		JPanel panListe = new JPanel();
		panListe.setLayout(new BoxLayout(panListe, BoxLayout.Y_AXIS));

		this.majListe(); // initialisation de la liste de personne
		this.liste = new JList<Personne>(this.tab_pers);
		this.liste.setFont(smallPlainFont);
		this.liste.setBackground(new Color(96,185,206));
		if(this.tab_pers.length > 0) this.selectedIndex(0);
		this.liste.setCellRenderer(new ProPersoCellRenderer());
		this.liste.setSelectionBackground(new Color(240,209,146));
		this.liste.setMaximumSize(new Dimension(Integer.MAX_VALUE, Integer.MAX_VALUE)) ;
		this.liste.setAlignmentX(Component.CENTER_ALIGNMENT);

		ListSelectionListener l1 = new SelectedContactController(this, this.carnet);
		this.liste.addListSelectionListener(l1);

		panListe.add(this.liste);

		JScrollPane scrollArea = new JScrollPane(panListe,
                    JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                    JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

		droite.add(scrollArea, BorderLayout.CENTER);
		droite.setPreferredSize(new Dimension(200,0));

	// Panel en haut au milieu

		JPanel mid = new JPanel();
		mid.setBackground(new Color(96,185,206));
		mid.setLayout(new BorderLayout());

		JPanel midCenter = new JPanel(new GridLayout(3,1,0,8));
		midCenter.setBackground(new Color(96,185,206));

		JButton addSomeone = new JButton(new ImageIcon(this.cl.getResource("add_32x32.png")));
		addSomeone.setBackground(new Color(96,185,206));
		addSomeone.setBorderPainted(false);

		ActionListener a1 = new AddContactController(this);
		addSomeone.addActionListener(a1);

		JButton updateSomeone = new JButton(new ImageIcon(this.cl.getResource("tools_32x32.png")));
		updateSomeone.setBackground(new Color(96,185,206));
		updateSomeone.setBorderPainted(false);

		ActionListener a2 = new UpdateContactController(this);
		updateSomeone.addActionListener(a2);
		
		JButton deleteSomeone = new JButton(new ImageIcon(this.cl.getResource("delete_32x32.png")));
		deleteSomeone.setBackground(new Color(96,185,206));
		deleteSomeone.setBorderPainted(false);

		ActionListener a3 = new RemoveContactController(this, this.carnet);
		deleteSomeone.addActionListener(a3);

		midCenter.add(addSomeone);
		midCenter.add(updateSomeone);
		midCenter.add(deleteSomeone);

		mid.add(midCenter);

	//Ajout au panel du haut
		this.up.add(gauche, BorderLayout.WEST);
		this.up.add(mid, BorderLayout.CENTER);
		this.up.add(droite, BorderLayout.EAST);

	// Panel du bas
		this.down = new JPanel();
		this.down.setPreferredSize(this.dimPaneDown);
		this.down.setBackground(new Color(4,129,158));
		this.welcome();		

	//Positionnement du Panel principal
		GridBagConstraints gbc = new GridBagConstraints();		

		//On positionne la case de depart du composant
		gbc.gridx = 0;
		gbc.gridy = 0;

		gbc.gridheight = 1;
		gbc.gridwidth = 1;
		this.principal.add(this.up, gbc);

		gbc.gridx = 0;
		gbc.gridy = 1;

		gbc.gridheight = 2;
		gbc.gridwidth = 1;
		this.principal.add(this.down, gbc);

	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    this.setLocationRelativeTo(null);
	    this.pack();
	    this.setResizable(false);
	    this.setVisible(true);
	}

	/**
	* Change la personne sélectionné dans la JList
	* @param index l'index de la personne à sélectionner
	*/
	public void selectedIndex(int index){
		this.liste.setSelectedIndex(index);
	}

	/**
	* Retourne la personne selectionné
	* @return La personne qui eest sélectionné
	*/
	public Personne selectedValue(){
		return (Personne)this.liste.getSelectedValue();
	}

	/**
	 * active / désactive le Bouton permettant de passer au contact suivant
	 * @param state vrai si le bouton doit être activé
	 */
	public void activateNextButton(boolean state) {
		nextPeople.setEnabled(state);
	}

	/**
	 * Change la couleur du fond de l'objet, de la liste, sélectionné
	 * @param couleur La couleur dont on veut mettre le fond de l'objet, de la liste, sélectionné
	 */
	public void changeListColor(Color couleur) {
		this.liste.setSelectionBackground(couleur);
	}

	/**
	 * active / désactive le Bouton permettant de passer au contact précédent
	 * @param state vrai si le bouton doit être activé
	 */
	public void activatePreviousButton(boolean state) {
		previousPeople.setEnabled(state);
	}

	/**
	 * méthode qui met a jour le contenu du tableau de Personne
	 */
	public void majListe(){
		int i = 0;
		this.tab_pers = new Personne[this.carnet.getContacts().size()];
		for(Personne p : this.carnet.getContacts()){
			this.tab_pers[i] = p;
			i++;
		}
	}

	/**
	 * méthode qui met a jour le contenu de la JList
	 */
	public void majJList(){
		this.liste.setListData(this.tab_pers);
	}

	/**
	 * méthode qui créé une nouvelle liste de Personne dans la JList
	 * @param contacts La nouvelle liste de Personne à utiliser
	 */
	public void changeList(java.util.List<Personne> contacts){
		int i = 0;
		Personne[] tab_contacts  = new Personne[contacts.size()];
		for(Personne p : contacts){
			tab_contacts[i] = p;
			i++;
		}
		this.liste.setListData(tab_contacts);
	}

    private static class ProPersoCellRenderer extends DefaultListCellRenderer {

        public Component getListCellRendererComponent(JList list, Object value, int index,
                									boolean isSelected, boolean cellHasFocus) {

            JLabel label = (JLabel) super.getListCellRendererComponent(
                    list, value, index, isSelected, cellHasFocus);
            if (value instanceof Particulier ) {
                label.setIcon(new ImageIcon(getClass().getResource("/home.png")));
            }
            else if (value instanceof Professionnel) {
                label.setIcon(new ImageIcon(getClass().getResource("/company.png")));
            }
            label.setHorizontalTextPosition(JLabel.RIGHT);
            return label;
        }
    }

    /**
	 * méthode qui affiche les succès ou échec des évènements
	 * @param text Le message à afficher
	 * @param succed vrai si l'évènement à réussi et faux sinon
	 */
    public void setTextPanelDown(String text, boolean succed){
    	this.down.removeAll();
    	Message message = new Message(this.dimPaneDown, text, succed);
    	this.down.add(message.getPanel());
		this.down.revalidate();
    }

	/**
	 * méthode qui sert à afficher le message de bienvenue dans le conteneur du bas
	 */
    public void welcome(){
    	this.down.removeAll();

    	JPanel welcome = new JPanel();
    	welcome.setLayout(new BorderLayout());
    	welcome.setPreferredSize(this.dimPaneDown);
    	welcome.setBackground(new Color(4,129,158));

    	JPanel tmp = new JPanel();
    	tmp.setLayout(new FlowLayout(FlowLayout.CENTER));
    	tmp.setBackground(new Color(4,129,158));
    	JLabel msg = new JLabel("Bienvenue dans votre carnet d'adresse");
		msg.setFont(bigBoldFont);
		tmp.add(msg);

		JLabel img = new JLabel(new ImageIcon(getClass().getResource("/contact.jpg")));

		welcome.add(tmp,BorderLayout.NORTH);
		welcome.add(img,BorderLayout.CENTER);

		this.down.add(welcome);
		this.down.revalidate();
    }

    /**
	 * méthode qui affiche dans le conteneur en haut à gauche les informations de la Personne courante
	 */
	public void details(){
		try{
			this.nom.setText(this.carnet.getPersonne().getNom());
			this.prenom.setText(this.carnet.getPersonne().getPrenom());
			this.civilite.setText(this.carnet.getPersonne().getCivilite());
		}catch(CarnetException e) {System.out.println(e.getMessage());}
	}

	/**
	 * méthode qui charge la classe SeeMore dans le conteneur du bas
	 */
	public void moreDetails(){
		if(this.updatePanelLoad) this.updatePanelLoad = false;
		if(!this.seeMorePanelLoad) this.seeMorePanelLoad = true;
		try{
			this.down.removeAll();
			SeeMore seeMore = new SeeMore(this.carnet.getPersonne(), this.dimPaneDown);
			this.down.add(seeMore.getPanel());
			this.down.revalidate();
		}catch(CarnetException e) {System.out.println(e.getMessage());}
	}

	/**
	 * méthode qui indique si le bouton "Voir plus" est le dernier à avoir été utilisé
	 * @return vrai si le bouton "Voir plus" est le dernier à avoir été cliqué et faux sinon
	 */
	public boolean seeMorePanelOn(){
		return this.seeMorePanelLoad;
	}

	/**
	 * méthode qui charge la classe NewContact dans le conteneur du bas
	 */
	public void addContact(){
		if(this.updatePanelLoad) this.updatePanelLoad = false;
		if(this.seeMorePanelLoad) this.seeMorePanelLoad = false;
		this.down.removeAll();
		NewContact newContact = new NewContact(this.carnet, this.dimPaneDown, this);
		this.down.add(newContact.getPanel());
		this.down.revalidate();
	}

	/**
	 * méthode qui charge la classe UpdateContact dans le conteneur du bas
	 */
	public void modifContact(){
		if(!this.updatePanelLoad) this.updatePanelLoad = true;
		if(this.seeMorePanelLoad) this.seeMorePanelLoad = false;
		try{
			this.down.removeAll();
			UpdateContact updateContact = new UpdateContact(this.carnet, this.carnet.getPersonne(), this.dimPaneDown, this);
			this.down.add(updateContact.getPanel());
			this.down.revalidate();
		}catch(CarnetException e) {System.out.println(e.getMessage());}
	}

	/**
	 * méthode qui indique si le bouton "modifier" est le dernier à avoir été utilisé
	 * @return vrai si le bouton "modifier" est le dernier à avoir été cliqué et faux sinon
	 */
	public boolean updatePanelOn(){
		return this.updatePanelLoad;
	}

	/**
	 * méthode qui charge la classe Search dans le conteneur du bas
	 */
	public void rechercher(){
		if(this.updatePanelLoad) this.updatePanelLoad = false;
		if(this.seeMorePanelLoad) this.seeMorePanelLoad = false;
		this.down.removeAll();
		Search search = new Search(this.carnet, this.dimPaneDown, this);
		this.down.add(search.getPanel());
		this.down.revalidate();
	}
}