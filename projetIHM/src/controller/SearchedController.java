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
	int code;
	CarnetAdresse frame;
	JTextField field;

	public SearchedController (Carnet carn, CarnetAdresse bigFrame, JTextField f){
		this.carnet = carn;
		this.frame = bigFrame;
		this.field = f;
	}

	public void keyPressed(KeyEvent e){
		this.code = e.getKeyCode();
	}
	public void keyTyped(KeyEvent e){
		String content = "";
		if(this.code == 8) content = this.field.getText();
		else content = this.field.getText()+e.getKeyChar();
		this.frame.changeList(this.carnet.recherche(content));
	}

	
	public void keyReleased(KeyEvent e){}
}