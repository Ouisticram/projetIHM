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
	private ActionListener controller;

	public SelectedContactController (CarnetAdresse vue, JList list, ActionListener control){
		this.vue = vue;
		this.liste = list;
		this.controller = control;
	}

	public void valueChanged(ListSelectionEvent e) {
		this.vue.details((Personne)this.liste.getSelectedValue());
		((UpdateContactController)this.controller).updateSelected(this.liste);
	}
}