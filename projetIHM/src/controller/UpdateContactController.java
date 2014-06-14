package controller;

import java.awt.event.*;
import javax.swing.*;
import view.*;
import model.*;

/**
 * @author AUGER-DUBOIS Quentin et BRIAND Kévin
 * @version 1
 **/

public class UpdateContactController implements ActionListener{

	private CarnetAdresse vue;
	private Personne personne;

	public UpdateContactController (CarnetAdresse vue, JList liste){
		this.vue = vue;
		this.personne = (Personne)liste.getSelectedValue();
	}

	public void updateSelected(JList liste){
		this.personne = (Personne)liste.getSelectedValue();
	}

	public void actionPerformed(ActionEvent e) {
	  	this.vue.modifContact(this.personne);
	}

}