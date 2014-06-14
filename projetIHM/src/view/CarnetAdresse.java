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

	private JLabel nom;
	private JLabel prenom;
	private JLabel civilite;

	private Personne[] tab_pers;
	private JList<Personne> liste;

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

		this.carnet = new Carnet(); // création d'un nouveau carnet d'adresse

		this.majListe(); // initialisation de la liste de personne

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
		//gauche.setPreferredSize (new Dimension(275,150));

		JPanel buttonPane = new JPanel();
		buttonPane.setLayout(new BoxLayout(buttonPane, BoxLayout.LINE_AXIS));
		buttonPane.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 10));
		buttonPane.setBackground(new Color(96,185,206));

		JButton showMore = new JButton("Voir plus...");
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

		infos.add(name);
		infos.add(this.nom);
		infos.add(firstname);
		infos.add(this.prenom);
		infos.add(civility);
		infos.add(this.civilite);

		gauche.add(infos, BorderLayout.CENTER);
		gauche.add(buttonPane, BorderLayout.SOUTH);

	// Panel en haut à droite
		JPanel droite = new JPanel();
		droite.setLayout(new BorderLayout());

		JPanel panListe = new JPanel();
		panListe.setLayout(new BoxLayout(panListe, BoxLayout.Y_AXIS));

		this.liste = new JList<Personne>(this.tab_pers);
		this.liste.setFont(smallPlainFont);
		this.liste.setBackground(new Color(96,185,206));
		if(this.tab_pers.length > 0) this.liste.setSelectedIndex(0);
		this.liste.setMaximumSize(new Dimension(Integer.MAX_VALUE, Integer.MAX_VALUE)) ;
		this.liste.setAlignmentX(Component.CENTER_ALIGNMENT);
		this.details((Personne)this.liste.getSelectedValue());

		ListSelectionListener l1 = new SelectedContactController(this, this.liste);
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
<<<<<<< HEAD

		JPanel midCenter = new JPanel(new GridLayout(3,1,0,8));
		midCenter.setBackground(new Color(96,185,206));

		JButton addSomeone = new JButton(new ImageIcon("src/16x16_add.png"));
		addSomeone.setBackground(new Color(96,185,206));
		addSomeone.setBorderPainted(false);

		ActionListener a1 = new AddContactController(this);
		addSomeone.addActionListener(a1);

		JButton updateSomeone = new JButton(new ImageIcon("src/16x16_settings.png"));
		updateSomeone.setBackground(new Color(96,185,206));
		updateSomeone.setBorderPainted(false);
		
		JButton deleteSomeone = new JButton(new ImageIcon("src/16x16_delete.png"));
		deleteSomeone.setBackground(new Color(96,185,206));
		deleteSomeone.setBorderPainted(false);

		midCenter.add(addSomeone);
		midCenter.add(updateSomeone);
		midCenter.add(deleteSomeone);

		mid.add(midCenter);
=======
		JPanel midCenter = new JPanel(new GridLayout(3,1,0,8));
		JButton addSomeone = new JButton(new ImageIcon("src/16x16_add.png"));
		JButton updateSomeone = new JButton(new ImageIcon("src/16x16_settings.png"));
		JButton deleteSomeone = new JButton(new ImageIcon("src/16x16_delete.png"));
		midCenter.add(addSomeone);
		midCenter.add(updateSomeone);
		midCenter.add(deleteSomeone);
		mid.add("North", new JLabel(" "));
		mid.add("South", new JLabel(" "));
		mid.add("East", new JLabel("   "));
		mid.add("West", new JLabel("   "));

		midCenter.setBackground(new Color(96,185,206));
		mid.add("Center",midCenter);
		
		ActionListener a1 = new AddContactController(this);
		addSomeone.addActionListener(a1);

		mid.setBackground(new Color(96,185,206));
>>>>>>> origin/master

	//Ajout au panel du haut
		this.up.add(gauche, BorderLayout.WEST);
		this.up.add(mid, BorderLayout.CENTER);
		this.up.add(droite, BorderLayout.EAST);

	// Panel du bas
		this.down = new JPanel();
		this.down.setPreferredSize(this.dimPaneDown);
		this.down.setLayout(new BorderLayout());
		this.down.setBackground(new Color(4,129,158));

		JLabel msg = new JLabel("Bienvenue dans votre carnet d'adresse");
		msg.setFont(bigBoldFont);

		this.down.add(msg, BorderLayout.CENTER);

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

	private Color Color(int i, int j, int k) {
		Color couleur = new Color(i,j,k);
		return couleur;
	}

	private void majListe(){
		int i = 0;
		this.tab_pers = new Personne[this.carnet.getContacts().size()];
		for(Personne p : this.carnet.getContacts()){
			this.tab_pers[i] = p;
			i++;
		}
	}

	public void details(Personne pers){
		this.nom.setText(pers.getNom());
		this.prenom.setText(pers.getPrenom());
		this.civilite.setText(pers.getCivilite());
	}

	public void moreDetails(Personne pers){
		this.down.removeAll();
	}

	public void addContact(){
		this.down.removeAll();
		NewContact newContact = new NewContact(this.carnet, this.dimPaneDown);
		this.down.add(newContact.getPanel());
		this.down.revalidate();
	}

	public void modifContact(Personne pers){
		this.down.removeAll();
		UpdateContact updateContact = new UpdateContact(this.carnet, pers, this.dimPaneDown);
		this.down.add(updateContact.getPanel());
		this.down.revalidate();
	}
}