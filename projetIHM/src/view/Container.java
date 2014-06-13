package view;

import javax.swing.*;
import java.awt.*;

/**
 * @author AUGER-DUBOIS Quentin et BRIAND Kévin
 * @version 1
 **/

public abstract class Container{

	protected JPanel panel;
	protected Font smallBoldFont = new Font("Arial", Font.BOLD, 14);
	protected Font smallPlainFont = new Font("Arial", Font.PLAIN, 14);
	
	public Container(Dimension dim){
		this.panel = new JPanel();
		this.panel.setPreferredSize(dim);
		this.panel.setBackground(Color.white);
	}
	
	protected JPanel getPanel(){
		return this.panel;
	}
}
