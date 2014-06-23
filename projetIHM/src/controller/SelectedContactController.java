package controller;

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

	/**
	 * construit un nouveau ListSelectionListener
	 * @param vue La vue
	 * @param carn Le modele
	 **/
	public SelectedContactController (CarnetAdresse vue, Carnet carn){
		this.vue = vue;
		this.carnet = carn;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void valueChanged(ListSelectionEvent e) {
		this.carnet.setCourant((Personne)this.vue.selectedValue());
		if(this.vue.updatePanelOn()) this.vue.modifContact();
		if(this.vue.seeMorePanelOn()) this.vue.moreDetails();
		if(!this.carnet.suivantPossible()) this.vue.activateNextButton(false);
		else this.vue.activateNextButton(true);
		if(!this.carnet.precedentPossible()) this.vue.activatePreviousButton(false);
		else this.vue.activatePreviousButton(true);
		this.vue.details();
	}
}