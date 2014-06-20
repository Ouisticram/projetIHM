package controller;

import java.awt.event.*;
import view.*;
import model.*;

/**
 * @author AUGER-DUBOIS Quentin et BRIAND Kévin
 * @version 1
 **/

public class UpdatedController implements ActionListener{

	private Carnet carnet;
	private UpdateContact vue;
	private CarnetAdresse frame;

	public UpdatedController (UpdateContact vue, Carnet carn, CarnetAdresse bigFrame){
		this.vue = vue;
		this.carnet = carn;
		this.frame = bigFrame;
	}

	public void actionPerformed(ActionEvent e) {
		String man = "";
		System.out.println("Nom : "+this.vue.getName());
		if(this.vue.isAMan()) man = "M.";
		else if(this.vue.isAWoman()) man = "Mme";
		if (this.vue.isPro()){
			Professionnel pro = new Professionnel(this.vue.getName(), this.vue.getFirstName(), man, this.vue.getProAdress(), this.vue.getProPhoneNumber(), this.vue.getProCellPhoneNumber(), this.vue.getProEmail(), this.vue.getCompagny());
			try{
				this.carnet.modifier(pro);
			}catch(CarnetException ce) {this.frame.setTextPanelDown("Erreur impossible de mofier ce contact",true);}
			
		}else if(this.vue.isPart()){
			Particulier part = new Particulier(this.vue.getName(), this.vue.getFirstName(), man, this.vue.getAdress(), this.vue.getPhoneNumber(), this.vue.getCellPhoneNumber(), this.vue.getEmail());
			try{
				this.carnet.modifier(part);
			}catch(CarnetException ce) {this.frame.setTextPanelDown("Erreur impossible de mofier ce contact",true);}
		}
		this.frame.majListe();
		this.frame.majJList();
		this.frame.details();
		this.frame.setTextPanelDown("Contact modifié avec succès",true);
	}	
}