package controller;

import java.awt.event.*;
import javax.swing.*;
import view.*;
import model.*;

/**
 * @author AUGER-DUBOIS Quentin et BRIAND Kévin
 * @version 1
 **/

public class SearchedController implements KeyListener{

	Carnet carnet;
	CarnetAdresse frame;
	JTextField field;

	public SearchedController (Carnet carn, CarnetAdresse bigFrame, JTextField f){
		this.carnet = carn;
		this.frame = bigFrame;
		this.field = f;
	}

	public void keyTyped(KeyEvent e){
		//this.area.setText(e.getKeyChar());
		this.frame.changeList(this.carnet.recherche(this.field.getText()));
	}

	public void keyPressed(KeyEvent e){}
	public void keyReleased(KeyEvent e){}
}