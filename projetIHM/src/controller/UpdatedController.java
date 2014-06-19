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
	private CarnetAdresse vue;

	public UpdatedController (CarnetAdresse vue, Carnet carn){
		this.vue = vue;
		this.carnet = carn;
	}

	public void actionPerformed(ActionEvent e) {
		/*if (this.vue.notEmpty()){
			this.carnet.modifier();
		}*/
	}	
}