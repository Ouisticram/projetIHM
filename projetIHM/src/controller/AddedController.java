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

	public AddedController (NewContact vue, Carnet carn){
		this.vue = vue;
		this.carnet = carn;
	}

	public void actionPerformed(ActionEvent e) {
		this.vue.isPro();
		//Professionnel pro = new Professionnel(this.vue.getName(), this.vue.getFirstName(), this.vue., this.vue., this.vue., this.vue., this.vue., this.vue.);
	}	
}