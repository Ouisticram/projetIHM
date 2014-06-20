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

	// Constructeur de notre class
	public Search( CarnetAdresse bigFrame, Carnet carn, Dimension dim){
		super(dim);
		this.carnet = carn;
		this.frame = bigFrame;
		initPanel();
		this.panel.setBackground(new Color(4,129,158));
	}

	public void initPanel(){
		JLabel rechercher = new JLabel("Rechercher: ");
		rechercher.setFont(midBoldFont);
		this.champSearch = new JTextField();
		this.champSearch.setFont(midPlainFont);
		this.champSearch.setColumns(10);

		KeyListener k = new SearchedController(this.carnet, this.frame, this.champSearch);
		this.champSearch.addKeyListener(k);

		this.panel.setLayout(new GridBagLayout());
		this.panel.add(rechercher);
		this.panel.add(champSearch);
	}

}