package controller;

import java.awt.event.*;
import view.*;
import model.*;

public class ChoiceContactController implements ActionListener{

	private Carnet carnet;
	private CarnetAdresse vue;

	public ChoiceContactController (Carnet carn, CarnetAdresse vue){
		this.vue = vue;
		this.carnet = carn;
	}

	public void actionPerformed(ActionEvent e) {
	  	switch(e.getActionCommand()){
	  		case "<" :
	  			if(this.carnet.precedentPossible()){
	  				try {
	  					this.carnet.personnePrecedent();
	  					//this.vue.liste.selectedIndex();
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
	  					//this.vue.liste.selectedIndex();
	  				}catch (Exception excep){}	  				
	  				this.vue.details();
	  				if(!this.carnet.suivantPossible()) this.vue.activateNextButton(false);
	  			}
	  			if(this.carnet.precedentPossible()) this.vue.activatePreviousButton(true);
	  			break;
	  	}
	}	

}