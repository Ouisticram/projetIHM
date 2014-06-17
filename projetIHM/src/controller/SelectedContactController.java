package controller;

import javax.swing.*;
import javax.swing.event.*;
import view.*;
import model.*;

/**
 * @author AUGER-DUBOIS Quentin et BRIAND Kévin
 * @version 1
 **/

public class SelectedContactController implements ListSelectionListener{

	private Carnet carnet;
	private CarnetAdresse vue;

	public SelectedContactController (CarnetAdresse vue, Carnet carn){
		this.vue = vue;
		this.carnet = carn;
	}

	public void valueChanged(ListSelectionEvent e) {
		this.carnet.setCourant((Personne)this.vue.selectedValue());
		if(!this.carnet.suivantPossible()) this.vue.activateNextButton(false);
		else this.vue.activateNextButton(true);
		if(!this.carnet.precedentPossible()) this.vue.activatePreviousButton(false);
		else this.vue.activatePreviousButton(true);
		this.vue.details();
	}
}