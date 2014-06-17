package controller;

import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
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

	/**
	* Fonction qui retourne une couleur en RGB
	* @param i la quantité de rouge dans la couleur, avec 0 <= i <= 255
	* @param j la quantité de vert dans la couleur, avec 0 <= j <= 255
	* @param k la quantité de bleu dans la couleur, avec 0 <= j <= 255
	* @return couleur La couleur voulue
	*/
	private Color Color(int i, int j, int k) {
		Color couleur = new Color(i,j,k);
		return couleur;
	}
}