package controller;

import java.awt.event.*;
import view.*;

/**
 * @author AUGER-DUBOIS Quentin et BRIAND Kévin
 * @version 1
 **/

public class SearchController implements ActionListener{

	private CarnetAdresse vue;

	public SearchController(CarnetAdresse vue){
		this.vue = vue;
	}

	public void actionPerformed(ActionEvent e) {
	  	this.vue.rechercher();
	}
}