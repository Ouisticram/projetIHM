package controller;

import java.awt.event.*;

import view.*;
import model.*;

/**
 * @author AUGER-DUBOIS Quentin et BRIAND Kévin
 * @version 1
 **/

public class AddedController implements ActionListener{

	private Carnet carnet;
	private NewContact vue;
	private CarnetAdresse frame;

	/**
	 * construit un nouveau ActionListener
	 * @param vue La vue
	 * @param carn Le modele
	 * @param bigFrame La vue de la fenêtre principale
	 **/
	public AddedController (NewContact vue, Carnet carn, CarnetAdresse bigFrame){
		this.vue = vue;
		this.carnet = carn;
		this.frame = bigFrame;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		String man = "";
		this.vue.setWarningMessageName(false);
		this.vue.setWarningMessageFirstName(false);
		if(this.vue.nameFieldIsEmpty()) this.vue.setWarningMessageName(true);
		if(this.vue.firstNameFieldIsEmpty()) this.vue.setWarningMessageFirstName(true);
		if(!this.vue.nameFieldIsEmpty() && !this.vue.firstNameFieldIsEmpty()){
			if(this.vue.isAMan()) man = "M.";
			else if(this.vue.isAWoman()) man = "Mme";
			if (this.vue.isPro()){
				Professionnel pro = new Professionnel(this.vue.getName(), this.vue.getFirstName(), man, this.vue.getProAdress(), this.vue.getProPhoneNumber(), this.vue.getProCellPhoneNumber(), this.vue.getProEmail(), this.vue.getCompagny());
				this.carnet.ajout(pro);
			}else if(this.vue.isPart()){
				Particulier part = new Particulier(this.vue.getName(), this.vue.getFirstName(), man, this.vue.getAdress(), this.vue.getPhoneNumber(), this.vue.getCellPhoneNumber(), this.vue.getEmail());
				this.carnet.ajout(part);
			}
			this.frame.majListe();
			this.frame.majJList();
			this.frame.details();
			this.frame.setTextPanelDown("Contact ajouté avec succès",true);
		}
	}	
}