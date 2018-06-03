package main.java;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;

import javax.imageio.ImageIO;
import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class InterfacePrincipale extends JFrame{
	
	private int nbJoueur;
	private JButton validerNbJoueurBtn = new JButton("Valider");
	private JButton startPartBtn = new JButton("Commencer la partie");
	private final ButtonGroup buttonGroup = new ButtonGroup();

	private JRadioButton nbJoueur2 = new JRadioButton("2");
	private JRadioButton nbJoueur3 = new JRadioButton("3");
	private JRadioButton nbJoueur4 = new JRadioButton("4");
	private JRadioButton nbJoueur5 = new JRadioButton("5");
	private JRadioButton nbJoueur6 = new JRadioButton("6");
	
	private JLabel labelNomJoueur1= new JLabel("Nom du joueur 1");
	private JLabel labelNomJoueur2= new JLabel("Nom du joueur 2"); 
	private JLabel labelNomJoueur3= new JLabel("Nom du joueur 3"); 
	private JLabel labelNomJoueur4= new JLabel("Nom du joueur 4"); 
	private JLabel labelNomJoueur5= new JLabel("Nom du joueur 5");
	private JLabel labelNomJoueur6= new JLabel("Nom du joueur 6");
	
	private JTextField txtNomJoueur1 = new JTextField ();
	private JTextField txtNomJoueur2 = new JTextField ();
	private JTextField txtNomJoueur3 = new JTextField ();
	private JTextField txtNomJoueur4 = new JTextField ();
	private JTextField txtNomJoueur5 = new JTextField ();
	private JTextField txtNomJoueur6 = new JTextField ();
	
	private JLabel [] tabJLabel= {labelNomJoueur1,labelNomJoueur2, labelNomJoueur3, labelNomJoueur4, labelNomJoueur5, labelNomJoueur6};
	private JTextField [] tabJTextField= {txtNomJoueur1,txtNomJoueur2, txtNomJoueur3, txtNomJoueur4, txtNomJoueur5, txtNomJoueur6};
	
	
//	private JTextField txtNomJoueur1, txtNomJoueur2, txtNomJoueur3, txtNomJoueur4, txtNomJoueur5, txtNomJoueur6; 
//	private JLabel [] tabJLabel= {labelNomJoueur1,labelNomJoueur2, labelNomJoueur3, labelNomJoueur4, labelNomJoueur5, labelNomJoueur6};
	
	public InterfacePrincipale() {

		
		this.setTitle("Jeu RISK");
		this.setSize(800, 500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.getContentPane().setLayout(new FlowLayout());
		this.getContentPane().setBackground(Color.white);
		
		
		buttonGroup.add(nbJoueur2);
		buttonGroup.add(nbJoueur3);
		buttonGroup.add(nbJoueur4);
		buttonGroup.add(nbJoueur5);
		buttonGroup.add(nbJoueur6);

		JPanel panNbJoueur = new JPanel();
		JPanel panNomJoueur = new JPanel();
		
		creationPanneau(panNbJoueur, 100, "Nombre de joueurs : ");
		
		panNbJoueur.add(nbJoueur2);
		panNbJoueur.add(nbJoueur3);
		panNbJoueur.add(nbJoueur4);
		panNbJoueur.add(nbJoueur5);
		panNbJoueur.add(nbJoueur6);
		panNbJoueur.add(validerNbJoueurBtn);

		
		this.getContentPane().add(panNbJoueur);
		this.getContentPane().add(panNomJoueur);
		
		panNomJoueur.setVisible(false);

		validerNbJoueurBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String strNbJoueur = getSelectedButtonText(buttonGroup);
				nbJoueur = Integer.parseInt(strNbJoueur);
				creationPanneau(panNomJoueur, nbJoueur * 70 , "Noms des joueurs : ");

			
				for (int i=0; i < nbJoueur; i++){
					tabJTextField[i].setPreferredSize(new Dimension(500, 35));
					panNomJoueur.add(tabJLabel[i]);
					panNomJoueur.add(tabJTextField[i]);
				}
				
				panNomJoueur.add(startPartBtn);
			}
		});
		
		
		startPartBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ArrayList <String> nomJoueursList = new ArrayList <String>();

				for (int i=0; i < nbJoueur; i++){
					String jTextValue = tabJTextField[i].getText();
					nomJoueursList.add(jTextValue);
					//System.out.println(" jTextValue : " + jTextValue);
				}
				
				Partie.getInstance().setNbJoueur(nbJoueur);
				Partie.getInstance().initListJoueurs(nomJoueursList);
				Partie.getInstance().initTerritoireAlea ();
				Partie.getInstance().initArmees();
				Partie.getInstance().dessinTerritoire();
				InterfaceCarte.getInstance().init();

			}
		});

		this.setVisible(true);
	}

	/**
	 * @param buttonGroup
	 * @return texte du bouton selectionné
	 */
	public String getSelectedButtonText(ButtonGroup buttonGroup) {
		for (Enumeration<AbstractButton> buttons = buttonGroup.getElements(); buttons.hasMoreElements();) {
			AbstractButton button = buttons.nextElement();

			if (button.isSelected()) {
				return button.getText();
			}
		}
		return null;
	}

	public void creationPanneau (JPanel pan, int dimY, String name){
		pan.setBackground(Color.white);
		pan.setPreferredSize(new Dimension(700, dimY));
		pan.setBorder(BorderFactory.createTitledBorder(name));
		pan.setVisible(true);
	}
	

	


}
