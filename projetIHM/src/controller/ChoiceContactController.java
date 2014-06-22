package controller;

import java.awt.event.*;

import view.*;
import model.*;

public class ChoiceContactController implements ActionListener{

	private Carnet carnet;
	private CarnetAdresse vue;

	/**
	 * construit un nouveau ActionListener
	 * @param vue La vue
	 * @param carn Le modele
	 **/
	public ChoiceContactController (CarnetAdresse vue, Carnet carn){
		this.vue = vue;
		this.carnet = carn;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
	  	switch(e.getActionCommand()){
	  		case "<" :
	  			if(this.carnet.precedentPossible()){
	  				try {
	  					this.carnet.personnePrecedent();
	  					if(this.vue.updatePanelOn()) this.vue.modifContact();
	  					if(this.vue.seeMorePanelOn()) this.vue.moreDetails();
	  					this.vue.selectedIndex(this.carnet.getCourant());
	  				}catch (Exception excep){}
	  				this.vue.details();
	  				if(!this.carnet.precedentPossible()) this.vue.activatePreviousButton(false);
	  			}
	  			if(this.carnet.suivantPossible()) this.vue.activateNextButton(true);
	  			break;
	  		case ">" :
	  			if(this.carnet.suivantPossible()){
	  				try {
	  					this.carnet.personneSuivante();
	  					if(this.vue.updatePanelOn()) this.vue.modifContact();
	  					if(this.vue.seeMorePanelOn()) this.vue.moreDetails();
	  					this.vue.selectedIndex(this.carnet.getCourant());
	  				}catch (Exception excep){}	  				
	  				this.vue.details();
	  				if(!this.carnet.suivantPossible()) this.vue.activateNextButton(false);
	  			}
	  			if(this.carnet.precedentPossible()) this.vue.activatePreviousButton(true);
	  			break;
	  	}
	}	

}