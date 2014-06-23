package controller;

import java.awt.event.*;

import javax.swing.*;

import view.*;
import model.*;

/**
 * @author AUGER-DUBOIS Quentin et BRIAND Kévin
 * @version 1
 **/

public class RemoveContactController implements ActionListener{

	private Carnet carnet;
	private CarnetAdresse vue;

	/**
	 * construit un nouveau ActionListener
	 * @param vue La vue
	 * @param carn Le modele
	 **/
	public RemoveContactController (CarnetAdresse vue, Carnet carn){
		this.vue = vue;
		this.carnet = carn;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
	  	int reply = JOptionPane.showConfirmDialog(null, "Êtes-vous sûr de vouloir supprimer ce contact", "Supprimer ?",  JOptionPane.YES_NO_OPTION);
		if (reply == JOptionPane.YES_OPTION){
			try{
				this.carnet.supprimer(this.carnet.getPersonne());
				this.vue.majListe();
				this.vue.majJList();
				this.vue.details();
				this.vue.selectedIndex(this.carnet.getCourant());
				this.vue.setTextPanelDown("Contact Supprimé avec succès",true);
			}catch(CarnetException ce) {
				System.out.println(ce.getMessage());
				this.vue.setTextPanelDown("Impossible de supprimer un contact",false);
			}			
		}else if(reply == JOptionPane.NO_OPTION) this.vue.welcome();
	}

}

