package main.java;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class JeuPanel extends JPanel  {
	
	//Partie partie = new Partie();
	private Territoire tDep, tArr, tDepAtt, tArrAtt;
	private Joueur joueur = Partie.getInstance().getJoueur();
	private static final Insets insets = new Insets(0, 0, 0, 0);
	private JLabel joueurNomLabel, joueurIdLabel, labelNbSoldatRenfort, labelNbCavalierRenfort, labelNbCanonRenfort,
			labelTerrSelct, labelNbSoldat, labelNbCavalier, labelNbCanon, labelAppartJoueurNom, labelAppartJoueurId, 
			labelTerrDep, labelTerrArr, labelTour;
	
	
	
	private JLabel labelTerrDepAtt = new JLabel();
	private JLabel labelTerrArrAtt = new JLabel();

	private JButton echangeCavalierBtn = new JButton("Echanger soldat");
	private JButton echangeCanonBtn = new JButton("Echanger soldat");
/*	private JButton okBtnAjoutSoldat = new JButton("OK");
	private JButton okBtnAjoutCavalier = new JButton("OK");
	private JButton okBtnAjoutCanon = new JButton("OK");*/
	private JButton okBtnAjoutArmee = new JButton("OK");
	private JButton okBtnTerrDep = new JButton("OK");
	private JButton okBtnTerrArr = new JButton("OK");
	private JButton okBtnTerrDepAtt = new JButton("OK");
	private JButton okBtnTerrArrAtt = new JButton("OK");
	private JButton okBtnNbUnite = new JButton("OK");
	private JButton okDeplacement = new JButton("OK");
	
	
	private JButton finTourBtn = new JButton("Fin de tour");
	private JButton positionBtn = new JButton("Position des armées");
	private JButton deplacementBtn = new JButton("Déplacement vers un territoire allié");
	private JButton attaqueBtn = new JButton("Attaquer un territoire");
	
	
	
	
	/**
	 * Panel : Attaquer un territoire
	
	
/*	private JComboBox<Integer> cbAjoutSoldat = initComboBox(nbSoldatRenfort);
	private JComboBox<Integer> cbAjoutCavalier = initComboBox(nbCavalierRenfort); 
	private JComboBox<Integer> cbAjoutCanon = initComboBox(nbCanonRenfort);*/
	//private JComboBox<Integer> cbAjoutSoldat = initComboBoxInterger(joueur.getArmeeRecu().getNbSoldat());
	private JComboBox<Integer> cbAjoutSoldat = new JComboBox<>();
	private JComboBox<Integer> cbAjoutCavalier = new JComboBox<>(); 
	private JComboBox<Integer> cbAjoutCanon = new JComboBox<>();
//	private JComboBox<String> cbTerritoireName= new JComboBox<>();
	
	private JComboBox<Integer> cbNbSoldat = new JComboBox<>();
	private JComboBox<Integer> cbNbCavalier = new JComboBox<>(); 
	private JComboBox<Integer> cbNbCanon = new JComboBox<>();
	
	private JComboBox<Integer> cbNbSoldatAtt = new JComboBox<>();
	private JComboBox<Integer> cbNbCavalierAtt = new JComboBox<>(); 
	private JComboBox<Integer> cbNbCanonAtt = new JComboBox<>();
	
	private ArrayList<Territoire> territoireJoueur = new ArrayList<Territoire>();
	

	/**
	 * 
	 */
	public JeuPanel() {
	
		this.setVisible(true);
		this.setBorder(BorderFactory.createTitledBorder(""));
		this.setLayout(new GridBagLayout());
		
		joueurNomLabel = new JLabel(joueur.getNom());
		joueurIdLabel = new JLabel(joueur.getId().toString());
		
		Integer nbSoldatRenfort = joueur.getArmeeRecu().getNbSoldat();
		Integer nbCavalierRenfort = joueur.getArmeeRecu().getNbCavalier();
		Integer nbCanonRenfort = joueur.getArmeeRecu().getNbCanon();
		
		labelNbSoldatRenfort = new JLabel(nbSoldatRenfort.toString());
		labelNbCavalierRenfort = new JLabel(nbCavalierRenfort.toString());
		labelNbCanonRenfort = new JLabel(nbCanonRenfort.toString());
		//labelTerrSelct =  new JLabel(Partie.getInstance().getTerritoireSelected().getNom());
		labelTerrSelct =  new JLabel("");
		

		/**
		 * Panel : Nom joueur
		 */
		JPanel pJoueur = new JPanel();
		pJoueur.setPreferredSize(new Dimension(420, 43));
		pJoueur.setBorder(BorderFactory.createTitledBorder("Nom du joueur"));
		pJoueur.setLayout(new GridBagLayout());
		addItem(pJoueur, joueurNomLabel, 0, 0, 1, 1, GridBagConstraints.CENTER);
		addItem(pJoueur, joueurIdLabel, 1, 0, 1, 1, GridBagConstraints.CENTER);

		
		/**
		 * Panel : Nombre de renfort reçu 
		 */
		JPanel pRenfort = new JPanel();
		pRenfort.setBorder(BorderFactory.createTitledBorder("Réception des renforts"));
		pRenfort.setPreferredSize(new Dimension(420, 105));
		pRenfort.setLayout(new GridBagLayout());
		addItem(pRenfort, new JLabel("Nombre de soldats : "), 0, 0, 1, 1, GridBagConstraints.EAST);
		addItem(pRenfort, labelNbSoldatRenfort, 1, 0, 1, 1, GridBagConstraints.WEST);
		addItem(pRenfort, new JLabel("Nombre de cavaliers : "), 0, 1, 1, 1, GridBagConstraints.EAST);
		addItem(pRenfort, labelNbCavalierRenfort, 1, 1, 1, 1, GridBagConstraints.WEST);
		addItem(pRenfort, echangeCavalierBtn, 2, 1, 1, 1, GridBagConstraints.WEST);
		addItem(pRenfort,new JLabel("Nombre de canons : "), 0, 2, 1, 1, GridBagConstraints.EAST);
		addItem(pRenfort, labelNbCanonRenfort, 1, 2, 1, 1, GridBagConstraints.WEST);
		addItem(pRenfort, echangeCanonBtn, 2, 2, 1, 1, GridBagConstraints.WEST);
		
		/**
		 * Panel : posisiton des renforts
		 */
		JPanel pPositionRenfort = new JPanel();
		pPositionRenfort.setVisible(false);
		pPositionRenfort.setBorder(BorderFactory.createTitledBorder("Position des armées"));
		pPositionRenfort.setPreferredSize(new Dimension(420, 85));
		pPositionRenfort.setLayout(new GridBagLayout());
/*		addItem(pPositionRenfort, new JLabel("Territoire sélectionné : "), 0, 0, 2, 1, GridBagConstraints.CENTER);
		addItem(pPositionRenfort, labelTerrSelct , 2, 0, 2, 1, GridBagConstraints.CENTER);*/
		addItem(pPositionRenfort, new JLabel("Ajout Soldat"), 0, 0, 1, 1, GridBagConstraints.CENTER);
		addItem(pPositionRenfort, new JLabel("Ajout Cavalier"), 1, 0, 1, 1, GridBagConstraints.CENTER);
		addItem(pPositionRenfort, new JLabel("Ajout Canon"), 2, 0, 1, 1, GridBagConstraints.CENTER);
		addItem(pPositionRenfort, cbAjoutSoldat, 0, 1, 1, 1, GridBagConstraints.CENTER);
		addItem(pPositionRenfort, cbAjoutCavalier, 1, 1, 1, 1, GridBagConstraints.CENTER);
		addItem(pPositionRenfort, cbAjoutCanon, 2, 1, 1, 1, GridBagConstraints.CENTER);
		addItem(pPositionRenfort, okBtnAjoutArmee, 3, 1, 1, 1, GridBagConstraints.WEST);

		/**
		 * Panel : vue territoire
		 */
		
		labelNbSoldat = new JLabel("");
		labelNbCavalier = new JLabel("");
		labelNbCanon = new JLabel("");
		labelAppartJoueurNom = new JLabel("");
		labelAppartJoueurId = new JLabel("");
		
		
		JPanel pVueTerritoire = new JPanel();
		pVueTerritoire.setBorder(BorderFactory.createTitledBorder("Territoire"));
		pVueTerritoire.setPreferredSize(new Dimension(420, 105));
		pVueTerritoire.setLayout(new GridBagLayout());
		addItem(pVueTerritoire, new JLabel("Territoire sélectionné : "), 0, 0, 2, 1, GridBagConstraints.CENTER);
		addItem(pVueTerritoire, labelTerrSelct , 2, 0, 2, 1, GridBagConstraints.CENTER);
		addItem(pVueTerritoire, new JLabel("Nombre Soldat"), 0, 1, 1, 1, GridBagConstraints.CENTER);
		addItem(pVueTerritoire, new JLabel("Nombre Cavalier"), 1, 1, 1, 1, GridBagConstraints.CENTER);
		addItem(pVueTerritoire, new JLabel("Nombre Canon"), 2, 1, 1, 1, GridBagConstraints.CENTER);
		addItem(pVueTerritoire, labelNbSoldat, 0, 2, 1, 1, GridBagConstraints.CENTER);
		addItem(pVueTerritoire, labelNbCavalier, 1, 2, 1, 1, GridBagConstraints.CENTER);
		addItem(pVueTerritoire, labelNbCanon, 2, 2, 1, 1, GridBagConstraints.CENTER);
		
		
		labelTerrDep =  new JLabel("");
		labelTerrArr =  new JLabel("");
		
		/**
		 * Panel : Deplacement vers Territoire alié
		 */
		JPanel pDeplacementTerrAlie = new JPanel();
		pDeplacementTerrAlie.setVisible(false);
		pDeplacementTerrAlie.setBorder(BorderFactory.createTitledBorder("Déplacement vers un territoire allié"));
		pDeplacementTerrAlie.setPreferredSize(new Dimension(420, 143));
		pDeplacementTerrAlie.setLayout(new GridBagLayout());
		addItem(pDeplacementTerrAlie, new JLabel("Territoire de départ : "), 0, 0, 2, 1, GridBagConstraints.CENTER);
		addItem(pDeplacementTerrAlie, labelTerrDep, 2, 0, 1, 1, GridBagConstraints.CENTER);
		addItem(pDeplacementTerrAlie, okBtnTerrDep, 3, 0, 1, 1, GridBagConstraints.CENTER);
		addItem(pDeplacementTerrAlie, new JLabel("Territoire de arrivée : "), 0, 1, 2, 1, GridBagConstraints.CENTER);
		addItem(pDeplacementTerrAlie, labelTerrArr, 2, 1, 1, 1, GridBagConstraints.CENTER);
		addItem(pDeplacementTerrAlie, okBtnTerrArr, 3, 1, 1, 1, GridBagConstraints.CENTER);
		addItem(pDeplacementTerrAlie, new JLabel("Nombre Soldat"), 0, 2, 1, 1, GridBagConstraints.CENTER);
		addItem(pDeplacementTerrAlie, new JLabel("Nombre Cavalier"), 1, 2, 1, 1, GridBagConstraints.CENTER);
		addItem(pDeplacementTerrAlie, new JLabel("Nombre Canon"), 2, 2, 1, 1, GridBagConstraints.CENTER);
		addItem(pDeplacementTerrAlie, cbNbSoldat, 0, 3, 1, 1, GridBagConstraints.CENTER);
		addItem(pDeplacementTerrAlie, cbNbCavalier, 1, 3, 1, 1, GridBagConstraints.CENTER);
		addItem(pDeplacementTerrAlie, cbNbCanon, 2, 3, 1, 1, GridBagConstraints.CENTER);
		addItem(pDeplacementTerrAlie, okDeplacement, 3, 3, 1, 1, GridBagConstraints.CENTER);
		
		/**
		 * Panel : Attaquer un territoire
		 */
		JPanel pAttaquerTerr = new JPanel();
		pAttaquerTerr.setVisible(false);
		pAttaquerTerr.setBorder(BorderFactory.createTitledBorder("Attaquer un territoire"));
		pAttaquerTerr.setPreferredSize(new Dimension(420, 250));
		pAttaquerTerr.setLayout(new GridBagLayout());
		addItem(pAttaquerTerr, new JLabel("Territoire attaquant : "), 0, 0, 2, 1, GridBagConstraints.CENTER);
		addItem(pAttaquerTerr, labelTerrDepAtt, 2, 0, 1, 1, GridBagConstraints.CENTER);
		addItem(pAttaquerTerr, okBtnTerrDepAtt, 3, 0, 1, 1, GridBagConstraints.CENTER);
		addItem(pAttaquerTerr, new JLabel("Territoire défenseur : "), 0, 1, 2, 1, GridBagConstraints.CENTER);
		addItem(pAttaquerTerr, labelTerrArrAtt, 2, 1, 1, 1, GridBagConstraints.CENTER);
		addItem(pAttaquerTerr, okBtnTerrArrAtt, 3, 1, 1, 1, GridBagConstraints.CENTER);
		addItem(pAttaquerTerr, new JLabel("Soldat"), 0, 2, 1, 1, GridBagConstraints.CENTER);
		addItem(pAttaquerTerr, new JLabel("Cavalier"), 1, 2, 1, 1, GridBagConstraints.CENTER);
		addItem(pAttaquerTerr, new JLabel("Canon"), 2, 2, 1, 1, GridBagConstraints.CENTER);
		addItem(pAttaquerTerr, cbNbSoldatAtt, 0, 3, 1, 1, GridBagConstraints.CENTER);
		addItem(pAttaquerTerr, cbNbCavalierAtt, 1, 3, 1, 1, GridBagConstraints.CENTER);
		addItem(pAttaquerTerr, cbNbCanonAtt, 2, 3, 1, 1, GridBagConstraints.CENTER);
		addItem(pAttaquerTerr, okBtnNbUnite, 3, 3, 1, 1, GridBagConstraints.CENTER);
		addItem(pAttaquerTerr, new JLabel("Attaquant"), 0, 4, 2, 1, GridBagConstraints.CENTER);
		addItem(pAttaquerTerr, new JLabel("Défenseur"), 2, 4, 2, 1, GridBagConstraints.CENTER);
		addItem(pAttaquerTerr, new JLabel("Canon"), 0, 5, 1, 1, GridBagConstraints.EAST);
		addItem(pAttaquerTerr, new JLabel("5"), 1, 5, 1, 1, GridBagConstraints.WEST);
		addItem(pAttaquerTerr, new JLabel("Soldat"), 2, 5, 1, 1, GridBagConstraints.EAST);
		addItem(pAttaquerTerr, new JLabel("4"), 3, 5, 1, 1, GridBagConstraints.WEST);
		addItem(pAttaquerTerr, new JLabel("Cavalier"), 0, 6, 1, 1, GridBagConstraints.EAST);
		addItem(pAttaquerTerr, new JLabel("3"), 1, 6, 1, 1, GridBagConstraints.WEST);
		addItem(pAttaquerTerr, new JLabel("Soldat"), 2, 6, 1, 1, GridBagConstraints.EAST);
		addItem(pAttaquerTerr, new JLabel("3"), 3, 6, 1, 1, GridBagConstraints.WEST);
		addItem(pAttaquerTerr, new JLabel("Soldat"), 0, 7, 1, 1, GridBagConstraints.EAST);
		addItem(pAttaquerTerr, new JLabel("3"), 1, 7, 1, 1, GridBagConstraints.WEST);
		
		
		/**
		 * Panel : Message
		 */
		JPanel pMessage = new JPanel();
		pMessage.setPreferredSize(new Dimension(420, 50));
		pMessage.setBorder(BorderFactory.createTitledBorder("Message"));
		pMessage.setLayout(new GridBagLayout());
		addItem(pMessage, new JLabel("Veuillez saisir un nombre blablabla"), 0, 0, 1, 1, GridBagConstraints.CENTER);
		
		
		/**
		 * Ajout au panel principal
		 */
		if(joueur.getTour() == 0){
			deplacementBtn.setVisible(false);
			attaqueBtn.setVisible(false);
			finTourBtn.setVisible(false);
		} /*else if (joueur.getTour() == 1) {
			finTourBtn.setVisible(true);
			deplacementBtn.setVisible(true);
			attaqueBtn.setVisible(true);
			positionBtn.setVisible(false);
		} else {
			finTourBtn.setVisible(false);
			deplacementBtn.setVisible(true);
			attaqueBtn.setVisible(true);
			positionBtn.setVisible(true);
		}*/
		labelTour = new JLabel ();
		labelTour.setText("Tour : " + joueur.getTour().toString());
		//addItem(this, new JLabel("Tour : "), 0, 0, 1, 1, GridBagConstraints.CENTER);
		addItem(this, labelTour, 0, 0, 1, 1, GridBagConstraints.CENTER);
		addItem(this, pJoueur, 0, 1, 1, 1, GridBagConstraints.CENTER);
		addItem(this, pRenfort, 0, 2, 1, 1, GridBagConstraints.CENTER);
		addItem(this, pVueTerritoire, 0, 3, 1, 1, GridBagConstraints.CENTER);
		addItem(this, positionBtn, 0, 4, 1, 1, GridBagConstraints.CENTER);
		addItem(this, pPositionRenfort, 0, 4, 1, 1, GridBagConstraints.CENTER);
		addItem(this, deplacementBtn, 0, 5, 1, 1, GridBagConstraints.CENTER);
		addItem(this, pDeplacementTerrAlie, 0, 5, 1, 1, GridBagConstraints.CENTER);
		addItem(this, attaqueBtn, 0, 6, 1, 1, GridBagConstraints.CENTER);
		addItem(this, pAttaquerTerr, 0, 6, 1, 1, GridBagConstraints.CENTER);
		addItem(this, finTourBtn, 0, 7, 1, 1, GridBagConstraints.CENTER);
		

		/**
		 * Au clic sur bouton position:
		 * panneau position visible et btn pas visible
		 */
		positionBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				positionBtn.setVisible(false);
				pPositionRenfort.setVisible(true);
				pDeplacementTerrAlie.setVisible(false);
				pAttaquerTerr.setVisible(false);
				cbAjoutSoldat.setModel( modelComboBox(joueur.getArmeeRecu().getNbSoldat()));
				cbAjoutCavalier.setModel( modelComboBox(joueur.getArmeeRecu().getNbCavalier()));
				cbAjoutCanon.setModel( modelComboBox(joueur.getArmeeRecu().getNbCanon()));
			}
		});
		 
		 okBtnAjoutArmee.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					Integer nbSoldat = (Integer) cbAjoutSoldat.getSelectedItem();
					Integer nbCavalier = (Integer) cbAjoutCavalier.getSelectedItem();
					Integer nbCanon = (Integer) cbAjoutCanon.getSelectedItem();
					Partie.getInstance().initPlacementArmee(nbSoldat, nbCavalier, nbCanon );
					// MAJ du nombre de renfort
					labelNbSoldatRenfort.setText(joueur.getArmeeRecu().getNbSoldat().toString());
					labelNbCavalierRenfort.setText(joueur.getArmeeRecu().getNbCavalier().toString());
					labelNbCanonRenfort.setText(joueur.getArmeeRecu().getNbCanon().toString());
/*					//MAJ vue territoire
					labelNbSoldat.setText(joueur.getArmee().getNbSoldat().toString());
					labelNbCavalier.setText(t.getArmee().getNbCavalier().toString());
					labelNbCanon.setText(t.getArmee().getNbCanon().toString());*/
					//MAJ comboBox 
					cbAjoutSoldat.setModel( modelComboBox(joueur.getArmeeRecu().getNbSoldat()) );
					cbAjoutCavalier.setModel( modelComboBox(joueur.getArmeeRecu().getNbCavalier()) );
					cbAjoutCanon.setModel( modelComboBox(joueur.getArmeeRecu().getNbCanon()) );
					//position de toutes les armées au minimum pour finir un tour
					if (joueur.getArmeeRecu().armeeVide()) {
						if(joueur.getTour()==0){
							pPositionRenfort.setVisible(false);
							finTourBtn.setVisible(true);
							deplacementBtn.setVisible(false);
							attaqueBtn.setVisible(false);
						} else if(joueur.getTour()==1){
							pPositionRenfort.setVisible(false);
							positionBtn.setVisible(false);
							finTourBtn.setVisible(true);
							deplacementBtn.setVisible(true);
							attaqueBtn.setVisible(true);
						} else {
							pPositionRenfort.setVisible(false);
							finTourBtn.setVisible(true);
							deplacementBtn.setVisible(true);
							attaqueBtn.setVisible(true);
						}
						
					}
				}
			});
		 
		okDeplacement.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (tDep != null && tArr != null) {
					Integer nbSoldat = (Integer) cbNbSoldat.getSelectedItem();
					Integer nbCavalier = (Integer) cbNbCavalier.getSelectedItem();
					Integer nbCanon = (Integer) cbNbCanon.getSelectedItem();
					Partie.getInstance().deplacementVersTerritoireAllie(tDep, tArr, nbSoldat, nbCavalier, nbCanon);
				} else {
					System.out.println("Veuillez saisir un territoire de départ et d'arrive");
				}

			}
		});
		
		
		
		deplacementBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// on affiche le btn une fois que les armée reçues sont distribuées
				if (joueur.getArmeeRecu().armeeVide()) {
					pDeplacementTerrAlie.setVisible(true);
					deplacementBtn.setVisible(false);
					attaqueBtn.setVisible(true);
					pPositionRenfort.setVisible(false);
					pAttaquerTerr.setVisible(false);

				} else {
					System.out.println("Veuillez placer toutes vos armées");
				}
			}
		});
		
		
		okBtnTerrDep.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				tDep = Partie.getInstance().getTerritoireSelected();
				labelTerrDep.setText(tDep.getNom());
				cbNbSoldat.setModel( modelComboBox(tDep.getArmee().getNbSoldat() - 1)); // (-1) pour forcer l'utilisateur à laisser 1 armée sur terr
				cbNbCavalier.setModel( modelComboBox(tDep.getArmee().getNbCavalier()) );
				cbNbCanon.setModel( modelComboBox(tDep.getArmee().getNbCanon()) );
				
			}
		});
		
		okBtnTerrArr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				tArr = Partie.getInstance().getTerritoireSelected();
				labelTerrArr.setText(tArr.getNom());
			}
		});
		
		okBtnTerrDepAtt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				tDepAtt = Partie.getInstance().getTerritoireSelected();
				labelTerrDepAtt.setText(tDepAtt.getNom());
				cbNbSoldatAtt.setModel( modelComboBox(tDepAtt.getArmee().getNbSoldat() - 1)); // (-1) pour forcer l'utilisateur à laisser 1 armée sur terr
				cbNbCavalierAtt.setModel( modelComboBox(tDepAtt.getArmee().getNbCavalier()) );
				cbNbCanonAtt.setModel( modelComboBox(tDepAtt.getArmee().getNbCanon()) );
				
			}
		});
		
		okBtnTerrArrAtt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				tArrAtt = Partie.getInstance().getTerritoireSelected();
				labelTerrArrAtt.setText(tArrAtt.getNom());
			}
		});
		
		attaqueBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				pAttaquerTerr.setVisible(true);
				attaqueBtn.setVisible(false);
				deplacementBtn.setVisible(true);
				pPositionRenfort.setVisible(false);
				pDeplacementTerrAlie.setVisible(false);
			}
		});
		

		
		/**
		 * Changement de joueur 
		 * 
		 */
		finTourBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
					joueur.incrementTour();
					Partie.getInstance().nextJoueur();
					joueur = Partie.getInstance().getJoueur();
					joueurNomLabel.setText(joueur.getNom());
					joueurIdLabel.setText(joueur.getId().toString());
					labelTour.setText("Tour : " + joueur.getTour().toString());
					positionBtn.setVisible(true);
					finTourBtn.setVisible(false);
				//	positionBtn.setVisible(true);
					
					
					if(joueur.getTour() == 0){
						positionBtn.setVisible(true);
						deplacementBtn.setVisible(false);
						attaqueBtn.setVisible(false);
						finTourBtn.setVisible(false);
						//deplacementBtn.setVisible(false);
						//attaqueBtn.setVisible(false);
					} else if (joueur.getTour() == 1){
						deplacementBtn.setVisible(true);
						attaqueBtn.setVisible(true);
						positionBtn.setVisible(false);
						finTourBtn.setVisible(true);
					} else {
						deplacementBtn.setVisible(false);
						attaqueBtn.setVisible(false);
						positionBtn.setVisible(true);
						finTourBtn.setVisible(false);
						//finTourBtn.setVisible(false);
					}
					
					
					
					
/*					if (joueur.getTour() == 1){
						positionBtn.setVisible(false);
						finTourBtn.setVisible(true);
					} else {
						positionBtn.setVisible(true);
					}*/
					pPositionRenfort.setVisible(false);
					pDeplacementTerrAlie.setVisible(false);
					pAttaquerTerr.setVisible(false);
					//MAJ des labels
					labelNbSoldatRenfort.setText(joueur.getArmeeRecu().getNbSoldat().toString());
					labelNbCavalierRenfort.setText(joueur.getArmeeRecu().getNbCavalier().toString());
					labelNbCanonRenfort.setText(joueur.getArmeeRecu().getNbCanon().toString());
					if (joueur.getTour() > 1){
						joueur.receptionRenfort();
						// MAJ du nombre de renfort
						labelNbSoldatRenfort.setText(joueur.getArmeeRecu().getNbSoldat().toString());
						labelNbCavalierRenfort.setText(joueur.getArmeeRecu().getNbCavalier().toString());
						labelNbCanonRenfort.setText(joueur.getArmeeRecu().getNbCanon().toString());
					}
			}
		});
		
		echangeCavalierBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				joueur.echangePourCavalier(1);
				labelNbSoldatRenfort.setText(joueur.getArmeeRecu().getNbSoldat().toString());
				labelNbCavalierRenfort.setText(joueur.getArmeeRecu().getNbCavalier().toString());
				//cbAjoutSoldat = new JComboBox (ve2initComboBoxInterger(joueur.getArmeeRecu().getNbSoldat()));
				cbAjoutSoldat.setModel( modelComboBox(joueur.getArmeeRecu().getNbSoldat()) );
				cbAjoutCavalier.setModel( modelComboBox(joueur.getArmeeRecu().getNbCavalier()) );
				//labelNbSoldatRenfort.setText(nbSoldatRenfort.toString());
				//labelNbCavalierRenfort.setText(nbCavalierRenfort.toString());
			}
		});
		
		
		echangeCanonBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				joueur.echangePourCanon(1);
				labelNbSoldatRenfort.setText(joueur.getArmeeRecu().getNbSoldat().toString());
				labelNbCanonRenfort.setText(joueur.getArmeeRecu().getNbCanon().toString());
				cbAjoutSoldat.setModel( modelComboBox(joueur.getArmeeRecu().getNbSoldat()) );
				cbAjoutCanon.setModel( modelComboBox(joueur.getArmeeRecu().getNbCanon()) );
			}
		});
		
		
	}
	
	
	/**
	 * Permet de creer une comboBox en fonction du nombre d'unite
	 * @param nbItem : nb Unité (soldat, cavalier, canon)
	 * @return JComboBox
	 */
	private JComboBox<Integer> initComboBoxInterger(Integer nbItem) {
		Integer[] value = new Integer[nbItem+1];
		for (int i = 0; i <= nbItem; i++) {
			value[i] = i;
		}
		return new JComboBox<>(value);
	}
	
	
	//DefaultComboBoxModel model = new DefaultComboBoxModel( yourStringArray );
	//comboBox.setModel( modelComboBox );
	private DefaultComboBoxModel<Integer> modelComboBox(Integer nbItem) {
		Integer[] value = new Integer[nbItem+1];
		for (int i = 0; i <= nbItem; i++) {
			value[i] = i;
		}
		DefaultComboBoxModel<Integer> model = new DefaultComboBoxModel<Integer>(value);
		return model;
	}
	
	
	/**
	 * @return
	 */
	private JComboBox<String> initComboBoxTerritoire() {
		territoireJoueur = joueur.getTerritoireList(); 
		JComboBox<String> cb = new JComboBox<>();
		for (Territoire t : territoireJoueur){
			cb.addItem(t.getNom());
		}
		return cb;
	}

	
	/**
	 * permet de placer un component selon un axe x et y 
	 * @param p : panel sur lequel on place le component
	 * @param c : component que l'on veut placer
	 * @param x : axe x
	 * @param y : axey 
	 * @param width : largeur
	 * @param height : hauteur
	 * @param align : alignement (centre, gauche, droite)
	 */
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
	
	
	// Getters and Setters
/*
	public void setNbSoldatRenfort(Integer nbSoldatRenfort) {
		this.nbSoldatRenfort = nbSoldatRenfort;
	}


	public void setNbCavalierRenfort(Integer nbCavalierRenfort) {
		this.nbCavalierRenfort = nbCavalierRenfort;
	}


	public void setNbCanonRenfort(Integer nbCanonRenfort) {
		this.nbCanonRenfort = nbCanonRenfort;
	}


	public Integer getNbSoldatRenfort() {
		return nbSoldatRenfort;
	}


	public Integer getNbCavalierRenfort() {
		return nbCavalierRenfort;
	}


	public Integer getNbCanonRenfort() {
		return nbCanonRenfort;
	}*/

	public JComboBox<Integer> getCbAjoutSoldat() {
		return cbAjoutSoldat;
	}


	public void setCbAjoutSoldat(JComboBox<Integer> cbAjoutSoldat) {
		this.cbAjoutSoldat = cbAjoutSoldat;
	}


	public JComboBox<Integer> getCbAjoutCavalier() {
		return cbAjoutCavalier;
	}


	public void setCbAjoutCavalier(JComboBox<Integer> cbAjoutCavalier) {
		this.cbAjoutCavalier = cbAjoutCavalier;
	}


	public JComboBox<Integer> getCbAjoutCanon() {
		return cbAjoutCanon;
	}


	public void setCbAjoutCanon(JComboBox<Integer> cbAjoutCanon) {
		this.cbAjoutCanon = cbAjoutCanon;
	}


	public JComboBox<Integer> getCbNbSoldat() {
		return cbNbSoldat;
	}


	public void setCbNbSoldat(JComboBox<Integer> cbNbSoldat) {
		this.cbNbSoldat = cbNbSoldat;
	}


	public JComboBox<Integer> getCbNbCavalier() {
		return cbNbCavalier;
	}


	public void setCbNbCavalier(JComboBox<Integer> cbNbCavalier) {
		this.cbNbCavalier = cbNbCavalier;
	}


	public JComboBox<Integer> getCbNbCanon() {
		return cbNbCanon;
	}


	public void setCbNbCanon(JComboBox<Integer> cbNbCanon) {
		this.cbNbCanon = cbNbCanon;
	}


	public JComboBox<Integer> getCbNbSoldatAtt() {
		return cbNbSoldatAtt;
	}


	public void setCbNbSoldatAtt(JComboBox<Integer> cbNbSoldatAtt) {
		this.cbNbSoldatAtt = cbNbSoldatAtt;
	}


	public JComboBox<Integer> getCbNbCavalierAtt() {
		return cbNbCavalierAtt;
	}


	public void setCbNbCavalierAtt(JComboBox<Integer> cbNbCavalierAtt) {
		this.cbNbCavalierAtt = cbNbCavalierAtt;
	}


	public JComboBox<Integer> getCbNbCanonAtt() {
		return cbNbCanonAtt;
	}


	public void setCbNbCanonAtt(JComboBox<Integer> cbNbCanonAtt) {
		this.cbNbCanonAtt = cbNbCanonAtt;
	}


	public JLabel getLabelTerrSelct() {
		return labelTerrSelct;
	}


	public void setLabelTerrSelct(JLabel labelTerrSelct) {
		this.labelTerrSelct = labelTerrSelct;
	}


	public JLabel getLabelNbSoldat() {
		return labelNbSoldat;
	}


	public void setLabelNbSoldat(JLabel labelNbSoldat) {
		this.labelNbSoldat = labelNbSoldat;
	}


	public JLabel getLabelNbCavalier() {
		return labelNbCavalier;
	}


	public void setLabelNbCavalier(JLabel labelNbCavalier) {
		this.labelNbCavalier = labelNbCavalier;
	}


	public JLabel getLabelNbCanon() {
		return labelNbCanon;
	}


	public void setLabelNbCanon(JLabel labelNbCanon) {
		this.labelNbCanon = labelNbCanon;
	}


	

}
