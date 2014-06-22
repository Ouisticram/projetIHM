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

	/**
	 * construit une nouveau conteneur	 
	 * @param dim La dimension du panel
	 * @param msg Le message à afficher dans le conteneur
	 * @param good vrai si on doit afficher un image et faux pour une autre
	 */
	public Message(Dimension dim, String msg, boolean good){
		super(dim);
		this.message = msg;
		this.succed = good;
		this.cl = this.getClass().getClassLoader();
		initPanel();
		this.panel.setBackground(new Color(4,129,158));
	}

	/**
	 * méthode qui intialise le Panel
	 */
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
}