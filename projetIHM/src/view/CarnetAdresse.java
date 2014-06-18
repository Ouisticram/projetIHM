package view;

import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.JComponent.*;
import java.awt.event.*;
import model.*;
import controller.*;

/**
 * @author AUGER-DUBOIS Quentin et BRIAND Kévin
 * @version 1
 **/

public class CarnetAdresse extends JFrame {

	private Dimension dimPaneDown;
	private Dimension dim1 = new Dimension(100, 100);
	private Font bigBoldFont = new Font("Arial", Font.BOLD, 30);
	private Font smallBoldFont = new Font("Arial", Font.BOLD, 14);
	private Font smallPlainFont = new Font("Arial", Font.PLAIN, 14);
	private Carnet carnet;

	private JPanel principal;
	private JPanel up;
	private JPanel down;

	private JButton nextPeople;
	private JButton previousPeople;

	private JLabel nom;
	private JLabel prenom;
	private JLabel civilite;

	private Personne[] tab_pers;
	private JList<Personne> liste;

	private ClassLoader cl;

	/**
	 * construit une nouvelle fenêtre
	 * @param titre Le titre de la fenêtre
	 * @param dim La dimension de la fenêtre
	 **/
	public CarnetAdresse(String titre, Dimension dim){
		super(titre);
		this.setPreferredSize(dim);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setResizable(false);
		this.pack();
		this.cl = this.getClass().getClassLoader();

		this.carnet = new Carnet(); // création d'un nouveau carnet d'adresse

		this.principal = new JPanel();		
		this.principal.setLayout(new GridBagLayout());
		this.setContentPane(this.principal);

		int height = (int)(this.getGlassPane().getHeight()/3);
		int heightBas = (int)(this.getGlassPane().getHeight()-height);
		int width = (int)(this.getGlassPane().getWidth());
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

		ActionListener al = new SeeMoreController(this, this.carnet);
		showMore.addActionListener(al);

		JButton search = new JButton("Rechercher");

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

		ActionListener a = new ChoiceContactController(this.carnet,this);
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

		ActionListener a2 = new UpdateContactController(this, this.carnet);
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
		this.down.setLayout(new BorderLayout());
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

		this.setVisible(true);
	}

	/**
	* Fonction qui retourne une couleur en RGB
	* @param i la quantité de rouge dans la couleur, avec 0 <= i <= 255
	* @param j la quantité de vert dans la couleur, avec 0 <= j <= 255
	* @param k la quantité de bleu dans la couleur, avec 0 <= j <= 255
	* @return couleur La couleur voulue
	*/
	private Color Color(int i, int j, int k) {
		Color couleur = new Color(i,j,k);
		return couleur;
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
	* Fonction qui met a jour le contenu de la JList
	*/
	public void majListe(){
		int i = 0;
		this.tab_pers = new Personne[this.carnet.getContacts().size()];
		for(Personne p : this.carnet.getContacts()){
			this.tab_pers[i] = p;
			i++;
		}
	}

	public void majJList(){
		this.liste.setListData(this.tab_pers);
	}

	private static class ProPersoCellRenderer extends DefaultListCellRenderer {
        public Component getListCellRendererComponent( JList list, Object value, int index, boolean isSelected, boolean cellHasFocus ) {
            Component c = super.getListCellRendererComponent( list, value, index, isSelected, cellHasFocus );
            if (value instanceof Particulier ) {
                c.setBackground(new Color(250,185,56));
            }
            else if (value instanceof Professionnel) {
                c.setBackground(new Color(250,68,156));
            }
            return c;
        }  
    }

    public void setTextPanelDown(String text, boolean succed){
    	this.down.removeAll();
    	Message message = new Message(this.dimPaneDown, text, succed);
    	this.down.add(message.getPanel());
		this.down.revalidate();
    }

    public void welcome(){
    	this.down.removeAll();

    	JLabel msg = new JLabel("Bienvenue dans votre carnet d'adresse");
		msg.setFont(bigBoldFont);

		JLabel author = new JLabel("Réalisé par Quentin AUGER-DUBOIS\net Kévin BRIAND");

		this.down.setLayout(new GridBagLayout());
		this.down.add(msg);

		// TODO
		/*GridBagConstraints gbcDown = new GridBagConstraints();
		gbcDown.anchor = GridBagConstraints.CENTER;
		gbcDown.gridx = 1;
		gbcDown.gridy = 1;

		gbcDown.gridheight = 1;
		gbcDown.gridwidth = 1;
		this.down.add(msg, gbcDown);

		gbcDown.anchor = GridBagConstraints.LAST_LINE_END;
		this.down.add(author, gbcDown);*/

		this.down.revalidate();
    }

	public void details(){
		this.nom.setText(this.carnet.getPersonne().getNom());
		this.prenom.setText(this.carnet.getPersonne().getPrenom());
		this.civilite.setText(this.carnet.getPersonne().getCivilite());
	}

	public void moreDetails(){
		this.down.removeAll();
		SeeMore seeMore = new SeeMore(this.carnet, this.carnet.getPersonne(), this.dimPaneDown);
		this.down.add(seeMore.getPanel());
		this.down.revalidate();
	}

	public void addContact(){
		this.down.removeAll();
		NewContact newContact = new NewContact(this.carnet, this.dimPaneDown);
		this.down.add(newContact.getPanel());
		this.down.revalidate();
	}

	public void modifContact(){
		this.down.removeAll();
		UpdateContact updateContact = new UpdateContact(this.carnet, this.carnet.getPersonne(), this.dimPaneDown);
		this.down.add(updateContact.getPanel());
		this.down.revalidate();
	}
}