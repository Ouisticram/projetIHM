package view;

import java.awt.*;
import javax.swing.*;
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
	private Carnet carnet;
	private JPanel principal;
	private JPanel up;
	private JPanel down;

	private JLabel nom;
	private JLabel prenom;
	private JLabel civilite;

	String[] tab_string = {"Jean Paul", "Dupont Pierre", "Troll tueur", "Robert Triman", "Steve Jobs", "Martin Luter", "Mirco soft", "Star Wars", "Node Wars", "Star Craft"};
	JButton[] tab_button = new JButton[tab_string.length];

	private JLabel informations;

	/**
	 * construit une nouvelle fenêtre
	 * @param titre Le titre de la fenêtre
	 * @param dim La dimension de la fenêtre
	 **/
	public CarnetAdresse(String titre, Dimension dim){
		super(titre);

		// création d'un nouveau carnet d'adresse
		carnet = new Carnet();

		/*************** FOR TEST ****************/

		nom = new JLabel("Jean");
		prenom = new JLabel("Paul");
		civilite = new JLabel("Monsieur");

		/*****************************************/

		principal = new JPanel();		
		principal.setLayout(new GridBagLayout());
		principal.setBackground((java.awt.Color) Color(155,225,150));

		int height = (int)((dim.getHeight()-29)/3);
		int width = (int)(dim.getWidth()-6);
		dimPaneDown = new Dimension(width,height*2);

		up = new JPanel();
		up.setLayout(new BorderLayout());
		up.setPreferredSize(new Dimension(width,height));		
		up.setBackground((java.awt.Color) Color(234,250,191));

	// Panel en haut à gauche
		JPanel gauche = new JPanel();
		gauche.setLayout(new BorderLayout());
		gauche.setBackground((java.awt.Color) Color(150,150,191));

		JPanel buttonPane = new JPanel();
		buttonPane.setLayout(new BoxLayout(buttonPane, BoxLayout.LINE_AXIS));
		buttonPane.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 10));

		JButton showMore = new JButton("Voir plus...");
		JButton addSomeone = new JButton("Ajouter un contact");

		buttonPane.add(Box.createHorizontalGlue());
		buttonPane.add(showMore);
		buttonPane.add(Box.createRigidArea(new Dimension(10, 0)));
		buttonPane.add(addSomeone);

		ActionListener a1 = new AddContactController(this);
		addSomeone.addActionListener(a1);

		JPanel infos = new JPanel();
		infos.setBorder(BorderFactory.createTitledBorder("Informations"));	
		infos.setLayout(new GridLayout(3,2));
		JLabel name = new JLabel("nom: ");
		JLabel firstname = new JLabel("prenom: ");
		JLabel civility = new JLabel("civilité: ");

		infos.add(name);
		infos.add(nom);
		infos.add(firstname);
		infos.add(prenom);
		infos.add(civility);
		infos.add(civilite);

		gauche.add(infos, BorderLayout.CENTER);
		gauche.add(buttonPane, BorderLayout.SOUTH);
		gauche.setSize(new Dimension(280,50));

	// Panel en haut à droite
		JPanel droite = new JPanel();
		droite.setLayout(new BorderLayout());

		JPanel liste = new JPanel();
		liste.setLayout(new BoxLayout(liste, BoxLayout.Y_AXIS));
		liste.setBackground((java.awt.Color) Color(234,150,191));

		for(int i=0; i<tab_string.length; i++){
			tab_button[i] = new JButton(tab_string[i]);
			tab_button[i].setMaximumSize(new Dimension(Integer.MAX_VALUE, Integer.MAX_VALUE)) ;
			tab_button[i].setAlignmentX(Component.CENTER_ALIGNMENT);
			liste.add(tab_button[i]);			
		}

		JScrollPane scrollArea = new JScrollPane(liste,
                    JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                    JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

		droite.add(scrollArea, BorderLayout.CENTER);
		droite.setPreferredSize(new Dimension(280,50));		

		up.add(gauche, BorderLayout.WEST);
		up.add(droite, BorderLayout.EAST);

		down = new JPanel();
		down.setPreferredSize(dimPaneDown);
		down.setBackground(Color.WHITE);

		JLabel img = new JLabel();
		ClassLoader cl = this.getClass().getClassLoader();
		img.setIcon(new ImageIcon(cl.getResource("contact.jpg")));

		down.add(img);

	//Positionnement du Panel principal
		GridBagConstraints gbc = new GridBagConstraints();		

		//On positionne la case de depart du composant
		gbc.gridx = 0;
		gbc.gridy = 0;

		gbc.gridheight = 1;
		gbc.gridwidth = 1;
		principal.add(up, gbc);

		gbc.gridx = 0;
		gbc.gridy = 1;

		gbc.gridheight = 2;
		gbc.gridwidth = 1;
		principal.add(down, gbc);

		this.setPreferredSize(dim);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setResizable(false);
		this.pack();
		this.setContentPane(principal);
		this.setVisible(true);
		System.out.println("La hauteur est de "+height+" et la largeur est de "+width);
		System.out.println("La hauteur du panel principal est de "+principal.getHeight()+" et la largeur est de "+principal.getWidth());	
	}

	private Object Color(int i, int j, int k) {
		Color couleur = new Color(i,j,k);
		return couleur;
	}

	public void moreDetails(Personne pers){
		down.removeAll();
	}

	public void addContact(){
		down.removeAll();
		NewContact newContact = new NewContact(carnet, dimPaneDown);
		down.add(newContact.getPanel());
		down.revalidate();	
	}

	public void modifContact(Personne pers){
		down.removeAll();
		UpdateContact updateContact = new UpdateContact(carnet, pers, dimPaneDown);
		down.add(updateContact.getPanel());
		down.revalidate();	
	}
}