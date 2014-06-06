package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import model.*;

public class UpdateContact extends Container {
	
	private boolean clicked;
	private Personne personne;
	private Carnet carnet;
	private JTextField input1;

	// Constructeur de notre class
	public UpdateContact(Carnet carn, Personne pers, Dimension dim){
		super(dim);
		this.personne = pers;
		this.carnet = carn;
		initPanel();
	}

	public void initPanel(){
		clicked = false;

	  	input1 = new JTextField();
	}

	class ZoneTextListener implements MouseListener {
		public void mouseEntered(MouseEvent e) {
	    	if (input1.getText().equals("Tapez votre nombre ici")){
	    		input1.setText("");
	    	}
		}
		public void mouseExited(MouseEvent ev) {
			if (input1.getText().equals("") && !clicked){
		    	input1.setText("Tapez votre nombre ici");
		    }
		}
		public void mousePressed(MouseEvent eve) {
			clicked = true;
		}
		@Override
		public void mouseClicked(MouseEvent arg0) {
			clicked = true;
		}
		@Override
		public void mouseReleased(MouseEvent arg0) {}
	}

	/*class NomListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0){
		    
		}
	}*/
}