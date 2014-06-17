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
		System.out.println("Ta clique ! ...");
	  	switch(e.getActionCommand()){
	  		case "<" :
	  			System.out.println("Sur < ;)");
	  			if(this.carnet.precedentPossible()){
	  				System.out.println("En + t'es dans le if, chapeau :)");
	  				try {this.carnet.personnePrecedent();}
	  				catch (Exception excep){}
	  				this.vue.details();
	  				if(!this.carnet.precedentPossible()) this.vue.activatePreviousButton(false);
	  			}
	  			if(this.carnet.suivantPossible()) this.vue.activateNextButton(true);
	  			break;
	  		case ">" :
	  			System.out.println("Sur > ;)");
	  			if(this.carnet.suivantPossible()){
	  				System.out.println("En + t'es dans le if, chapeau :)");
	  				try {this.carnet.personneSuivante();}
	  				catch (Exception excep){}	  				
	  				this.vue.details();
	  				if(!this.carnet.suivantPossible()) this.vue.activateNextButton(false);
	  			}
	  			if(this.carnet.precedentPossible()) this.vue.activatePreviousButton(true);
	  			break;
	  	}
	}	

}