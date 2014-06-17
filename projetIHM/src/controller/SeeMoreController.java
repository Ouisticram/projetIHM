package controller;

import java.awt.event.*;
import javax.swing.*;
import view.*;
import model.*;

/**
 * @author AUGER-DUBOIS Quentin et BRIAND Kévin
 * @version 1
 **/

public class SeeMoreController implements ActionListener{

	private Carnet carnet;
	private CarnetAdresse vue;

	public SeeMoreController (CarnetAdresse vue, Carnet carn){
		this.vue = vue;
		this.carnet = carn;
	}

	public void actionPerformed(ActionEvent e) {
	  	this.vue.moreDetails();
	}

}