package controller;

import java.awt.event.*;
import view.*;

/**
 * @author AUGER-DUBOIS Quentin et BRIAND Kévin
 * @version 1
 **/

public class UpdateContactController implements ActionListener{

	private CarnetAdresse vue;

	/**
	 * construit un nouveau ActionListener
	 * @param vue La vue
	 **/
	public UpdateContactController (CarnetAdresse vue){
		this.vue = vue;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
	  	this.vue.modifContact();
	}

}