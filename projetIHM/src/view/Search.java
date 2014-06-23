package view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import controller.*;
import model.*;

/**
 * @author AUGER-DUBOIS Quentin et BRIAND Kévin
 * @version 1
 **/

public class Search extends Container {

	private Carnet carnet;
	private CarnetAdresse frame;
	private JTextField champSearch;

	/**
	 * construit un nouveau conteneur
	 * @param carn Le modele
	 * @param dim Les dimensions du conteneur
	 * @param bigFrame La vue de la fenêtre principale
	 */
	public Search(Carnet carn, Dimension dim, CarnetAdresse bigFrame){
		super(dim);
		this.carnet = carn;
		this.frame = bigFrame;
		initPanel();
		this.panel.setBackground(new Color(4,129,158));
	}

	/**
	 * méthode qui intialise le Panel
	 */
	public void initPanel(){
		JLabel rechercher = new JLabel("Rechercher: ");
		rechercher.setFont(midBoldFont);
		this.champSearch = new JTextField();
		this.champSearch.setFont(midPlainFont);
		this.champSearch.setColumns(10);

		KeyListener k = new SearchedController(this, this.carnet, this.frame);
		this.champSearch.addKeyListener(k);

		this.panel.setLayout(new GridBagLayout());
		this.panel.add(rechercher);
		this.panel.add(champSearch);
	}

	/**
	 * méthode qui retourne le contenu du champ de recherche
	 * @return Le contenu du champ de recherche
	 */
	public String getSearchContent(){
		return this.champSearch.getText();
	}

}