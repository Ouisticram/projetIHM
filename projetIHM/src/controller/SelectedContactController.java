package controller;

import javax.swing.*;
import javax.swing.event.*;
import java.awt.event.*;
import view.*;
import model.*;

/**
 * @author AUGER-DUBOIS Quentin et BRIAND Kévin
 * @version 1
 **/

public class SelectedContactController implements ListSelectionListener{

	private CarnetAdresse vue;
	private JList liste;

	public SelectedContactController (CarnetAdresse vue, JList list){
		this.vue = vue;
		this.liste = list;
	}

	public void valueChanged(ListSelectionEvent e) {
		//this.vue./*TODO*/((Personne)this.liste.getSelectedValue());
		this.vue.details();
	}
}