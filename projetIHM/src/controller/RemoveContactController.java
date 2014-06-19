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

	public RemoveContactController (CarnetAdresse vue, Carnet carn){
		this.vue = vue;
		this.carnet = carn;
	}

	public void actionPerformed(ActionEvent e) {
	  	int reply = JOptionPane.showConfirmDialog(null, "Êtes-vous sûr de vouloir supprimer ce contact", "Supprimer ?",  JOptionPane.YES_NO_OPTION);
		if (reply == JOptionPane.YES_OPTION){
			this.carnet.supprimer(this.carnet.getPersonne());
			this.vue.majListe();
			this.vue.majJList();
			this.vue.setTextPanelDown("Contact Supprimé avec succès",true);
		}else if(reply == JOptionPane.NO_OPTION) this.vue.welcome();
	}

}

