package controller;

import java.awt.event.*;
import view.*;

public class AddContactController implements ActionListener{

	private CarnetAdresse vue;

	public AddContactController (CarnetAdresse vue){
		this.vue = vue;
	}

	public void actionPerformed(ActionEvent e) {
	  	this.vue.addContact();
	}	

}