package controller;

import java.awt.event.*;
import view.*;
import model.*;

/**
 * @author AUGER-DUBOIS Quentin et BRIAND Kévin
 * @version 1
 **/

public class SearchedController implements KeyListener{

	private Search vue;
	private Carnet carnet;
	private int code;
	private CarnetAdresse frame;

	/**
	 * construit un nouveau KeyListener
	 * @param vue La vue
	 * @param carn Le modele
	 * @param bigFrame la vue de la fenêtre principale
	 **/
	public SearchedController (Search vue, Carnet carn, CarnetAdresse bigFrame){
		this.vue = vue;
		this.carnet = carn;
		this.frame = bigFrame;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void keyPressed(KeyEvent e){
		this.code = e.getKeyCode();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void keyTyped(KeyEvent e){
		String content = "";
		if(this.code == 8) content = this.vue.getSearchContent();
		else content = this.vue.getSearchContent()+e.getKeyChar();
		this.frame.changeList(this.carnet.recherche(content));
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void keyReleased(KeyEvent e){}
}