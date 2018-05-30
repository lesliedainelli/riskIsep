package risk;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

//http://www.java2s.com/Tutorial/Java/0240__Swing/UseGridBagLayouttolayoutRadioButtons.htm

public class jeuPanel extends JPanel {

	private static final Insets insets = new Insets(0, 0, 0, 0);
	  
	private JLabel joueurLabel, recepRenfort,lNbSoldatRenfort, lNbCavalierRenfort,lNbCanonRenfort;
	private JTextField joueurName, tNbSoldatRenfort, tNbCavalierRenfort,tNbCanonRenfort; 
	private JButton echangeCavalier, echangeCanon;
	
	public jeuPanel () {
		this.setBackground(Color.white);
		//this.setBorder(BorderFactory.createTitledBorder("Age du personnage"));
		this.setPreferredSize(new Dimension(60, 60));
		joueurLabel = new JLabel("Nom du joueur : ");
		joueurLabel = new JLabel("Reception de renfort : ");
		joueurName = new JTextField("leslie");
		
		
	    this.setLayout(new GridBagLayout());
	    JPanel pJoueur =  new JPanel();
	    pJoueur.setPreferredSize(new Dimension(250, 40));
	    pJoueur.setBorder(BorderFactory.createTitledBorder("Nom Joueur"));
	    //addItem(pJoueur, new JLabel("Nom du joueur : "), 0, 0, 1, 1, GridBagConstraints.CENTER);
	    addItem(pJoueur, new JLabel("Leslie "), 0, 0, 1, 1, GridBagConstraints.CENTER);
	    
	    JPanel pRenfort =  new JPanel();
	    pRenfort.setBorder(BorderFactory.createTitledBorder("Reception de renfort : "));
	    pRenfort.setPreferredSize(new Dimension(500, 300));
	   // addItem(pRenfort, new JLabel("Reception de renfort : "), 0, 0, 3, 1, GridBagConstraints.CENTER);
	    addItem(pRenfort, new JLabel("Nombre de soldats : "), 0, 0, 1, 1, GridBagConstraints.CENTER);
	    addItem(pRenfort, new JLabel("1"), 1, 0, 1, 1, GridBagConstraints.CENTER);
	    addItem(pRenfort, new JLabel("Nombre de cavaliers : "), 0, 1, 1, 1, GridBagConstraints.CENTER);
	    addItem(pRenfort, new JLabel("2"), 1, 1, 1, 1, GridBagConstraints.CENTER);
	    addItem(pRenfort, new JButton("Echanger soldat"), 2, 1, 1, 1, GridBagConstraints.CENTER);
	    addItem(pRenfort, new JLabel("Nombre de canons : "), 0, 2, 1, 1, GridBagConstraints.CENTER);
	    addItem(pRenfort, new JLabel("3"), 1, 2, 1, 1, GridBagConstraints.CENTER);
	    addItem(pRenfort, new JButton("Echanger soldat"), 2, 2, 1, 1, GridBagConstraints.CENTER);
/*	    addItem(pRenfort, new JLabel("Reception de renfort : "), 0, 1, 3, 1, GridBagConstraints.CENTER);
	    addItem(pRenfort, new JLabel("Nombre de soldats : "), 0, 2, 1, 1, GridBagConstraints.CENTER);
	    addItem(pRenfort, new JLabel("1"), 1, 2, 1, 1, GridBagConstraints.CENTER);
	    addItem(pRenfort, new JLabel("Nombre de cavaliers : "), 0, 3, 1, 1, GridBagConstraints.CENTER);
	    addItem(pRenfort, new JLabel("2"), 1, 3, 1, 1, GridBagConstraints.CENTER);
	    addItem(pRenfort, new JButton("Echanger soldat"), 2, 3, 1, 1, GridBagConstraints.CENTER);
	    addItem(pRenfort, new JLabel("Nombre de canons : "), 0, 4, 1, 1, GridBagConstraints.CENTER);
	    addItem(pRenfort, new JLabel("3"), 1, 4, 1, 1, GridBagConstraints.CENTER);
	    addItem(pRenfort, new JButton("Echanger soldat"), 2, 4, 1, 1, GridBagConstraints.CENTER);*/
	    
	    JPanel pPositionRenfort =  new JPanel();
	    addItem(pPositionRenfort, new JLabel("Veuillez positionner vos renforts : "), 0, 5, 3, 1, GridBagConstraints.CENTER);
	    addItem(pPositionRenfort, new JLabel("Territoire sélectionné : "), 0, 6, 1, 1, GridBagConstraints.CENTER);
	    addItem(pPositionRenfort, new JLabel("Brésil"), 1, 6, 1, 1, GridBagConstraints.CENTER);
	    addItem(pPositionRenfort, new JButton("Positionner un soldat"), 0, 7, 1, 1, GridBagConstraints.CENTER);
	    addItem(pPositionRenfort, new JButton("Positionner un cavalier"), 1, 7, 1, 1, GridBagConstraints.CENTER);
	    addItem(pPositionRenfort, new JButton("Positionner un canon"), 2, 7, 1, 1, GridBagConstraints.CENTER);
	    
	    this.add(pJoueur);
	    this.add(pRenfort);
	    //this.add(pPositionRenfort);
	}

	
	  private void addItem(JPanel p, JComponent c, int x, int y, int width, int height, int align) {
		    GridBagConstraints gc = new GridBagConstraints();
		    gc.gridx = x;
		    gc.gridy = y;
		    gc.gridwidth = width;
		    gc.gridheight = height;
		    gc.weightx = 100.0;
		    gc.weighty = 100.0;
		    gc.insets = new Insets(5, 5, 5, 5);
		    gc.anchor = align;
		    gc.fill = GridBagConstraints.NONE;
		    p.add(c, gc);
		  }
	
}
