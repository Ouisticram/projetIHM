package view;

import java.awt.*;
import javax.swing.*;
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
	private Carnet carnet;
	private JPanel principal;
	private JPanel up;
	private JPanel down;

	private JLabel nom;
	private JLabel prenom;
	private JLabel civilite;

	String[] tab_string;
	JList<String> liste;

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
		this.majListe();

		/*************** FOR TEST ****************/

		nom = new JLabel("Jean");
		prenom = new JLabel("Paul");
		civilite = new JLabel("Monsieur");

		/*****************************************/

		this.setPreferredSize(dim);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setResizable(false);
		this.pack();

		principal = new JPanel();		
		principal.setLayout(new GridBagLayout());
		principal.setBackground((java.awt.Color) Color(155,225,150));
		this.setContentPane(principal);

		int height = (int)(this.getGlassPane().getHeight()/3);
		int width = (int)(this.getGlassPane().getWidth());
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

	// Panel en haut à droite
		JPanel droite = new JPanel();
		droite.setLayout(new BorderLayout());

		JPanel panListe = new JPanel();
		panListe.setLayout(new BoxLayout(panListe, BoxLayout.Y_AXIS));
		panListe.setBackground((java.awt.Color) Color(234,150,191));

		liste = new JList<String>(tab_string);
		if(tab_string.length > 0) liste.setSelectedIndex(0);
		liste.setMaximumSize(new Dimension(Integer.MAX_VALUE, Integer.MAX_VALUE)) ;
		liste.setAlignmentX(Component.CENTER_ALIGNMENT);
		panListe.add(liste);

		JScrollPane scrollArea = new JScrollPane(panListe,
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

		this.setVisible(true);
	}

	private Object Color(int i, int j, int k) {
		Color couleur = new Color(i,j,k);
		return couleur;
	}

	private void majListe(){
		int i = 0;
		this.tab_string = new String[this.carnet.getContacts().size()];
		for(Personne p : this.carnet.getContacts()){
			this.tab_string[i] = p.getNom() + " " + p.getPrenom(); 
			i++;
		}
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