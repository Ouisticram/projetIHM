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

	Carnet carnet;
	CarnetAdresse frame;
	JTextField champSearch;

	// Constructeur de notre class
	public Search( CarnetAdresse bigFrame, Carnet carn, Dimension dim){
		super(dim);
		this.carnet = carn;
		this.frame = bigFrame;
		initPanel();
		this.panel.setBackground(new Color(4,129,158));
	}

	public void initPanel(){
		JLabel rechercher = new JLabel("Rechercher ");
		this.champSearch = new JTextField();
		this.champSearch.setColumns(20);

		KeyListener k = new SearchedController(this.carnet, this.frame, this.champSearch);
		this.champSearch.addKeyListener(k);

		this.panel.setLayout(new GridBagLayout());
		this.panel.add(rechercher);
		this.panel.add(champSearch);
	}

}