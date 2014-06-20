package view;

import java.awt.*;
import javax.swing.*;

/**
 * @author AUGER-DUBOIS Quentin et BRIAND Kévin
 * @version 1
 **/

public class Message extends Container {

	private String message;
	private boolean succed;
	private ClassLoader cl;

	// Constructeur de notre class
	public Message(Dimension dim, String msg, boolean good){
		super(dim);
		this.message = msg;
		this.succed = good;
		this.cl = this.getClass().getClassLoader();
		initPanel();
		this.panel.setBackground(new Color(4,129,158));
	}

	public void initPanel(){
		JLabel labelMessage = new JLabel(" "+this.message);
		labelMessage.setFont(bigBoldFont);
		labelMessage.setBackground(new Color(98,129,158));
		JLabel img;
		if(this.succed) img = new JLabel(new ImageIcon(this.cl.getResource("Validate_64x64.png")));
		else img = new JLabel(new ImageIcon(cl.getResource("error_64x64.png")));

		this.panel.setLayout(new GridBagLayout());
		this.panel.add(img);
		this.panel.add(labelMessage);
	}

	/**
	* Fonction qui retourne une couleur en RGB
	* @param i la quantité de rouge dans la couleur, avec 0 <= i <= 255
	* @param j la quantité de vert dans la couleur, avec 0 <= j <= 255
	* @param k la quantité de bleu dans la couleur, avec 0 <= j <= 255
	* @return couleur La couleur voulue
	*/
	private Color Color(int i, int j, int k) {
		Color couleur = new Color(i,j,k);
		return couleur;
	}
}