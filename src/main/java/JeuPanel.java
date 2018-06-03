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
	
	private Joueur joueur = Partie.getInstance().getJoueur();
	private static final Insets insets = new Insets(0, 0, 0, 0);
	private JLabel joueurNomLabel, joueurIdLabel, labelNbSoldatRenfort, labelNbCavalierRenfort,labelNbCanonRenfort, labelTerrSelct;
	

	


	private JButton echangeCavalierBtn = new JButton("Echanger soldat");
	private JButton echangeCanonBtn = new JButton("Echanger soldat");
/*	private JButton okBtnAjoutSoldat = new JButton("OK");
	private JButton okBtnAjoutCavalier = new JButton("OK");
	private JButton okBtnAjoutCanon = new JButton("OK");*/
	private JButton okBtnAjoutArmee = new JButton("OK");
	private JButton okBtnTerrDep = new JButton("OK");
	private JButton okBtnTerrArr = new JButton("OK");
	private JButton okBtnNbUnite = new JButton("OK");
	
	private JButton finTourBtn = new JButton("Fin de tour");
	private JButton positionBtn = new JButton("Position des armées");
	private JButton deplacementBtn = new JButton("Deplacement vers Territoire alié");
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
		pJoueur.setBorder(BorderFactory.createTitledBorder("Nom Joueur"));
		pJoueur.setLayout(new GridBagLayout());
		addItem(pJoueur, joueurNomLabel, 0, 0, 1, 1, GridBagConstraints.CENTER);
		addItem(pJoueur, joueurIdLabel, 1, 0, 1, 1, GridBagConstraints.CENTER);

		
		/**
		 * Panel : Nombre de renfort reçu 
		 */
		JPanel pRenfort = new JPanel();
		pRenfort.setBorder(BorderFactory.createTitledBorder("Reception de renfort : "));
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
		pPositionRenfort.setBorder(BorderFactory.createTitledBorder("Position des renfort : "));
		pPositionRenfort.setPreferredSize(new Dimension(420, 105));
		pPositionRenfort.setLayout(new GridBagLayout());
		
/*		setCbAjoutSoldat(initComboBoxInterger(nbSoldatRenfort));
		setCbAjoutCavalier(initComboBoxInterger(nbCavalierRenfort));
		setCbAjoutCanon(initComboBoxInterger(nbCanonRenfort));*/
		
		addItem(pPositionRenfort, new JLabel("Territoire sélectionné : "), 0, 0, 2, 1, GridBagConstraints.CENTER);
		addItem(pPositionRenfort, labelTerrSelct , 2, 0, 2, 1, GridBagConstraints.CENTER);
		addItem(pPositionRenfort, new JLabel("Ajout Soldat"), 0, 1, 1, 1, GridBagConstraints.CENTER);
		addItem(pPositionRenfort, new JLabel("Ajout Cavalier"), 1, 1, 1, 1, GridBagConstraints.CENTER);
		addItem(pPositionRenfort, new JLabel("Ajout Canon"), 2, 1, 1, 1, GridBagConstraints.CENTER);
		addItem(pPositionRenfort, cbAjoutSoldat, 0, 2, 1, 1, GridBagConstraints.CENTER);
		addItem(pPositionRenfort, cbAjoutCavalier, 1, 2, 1, 1, GridBagConstraints.CENTER);
		addItem(pPositionRenfort, cbAjoutCanon, 2, 2, 1, 1, GridBagConstraints.CENTER);
		addItem(pPositionRenfort, okBtnAjoutArmee, 3, 2, 1, 1, GridBagConstraints.WEST);


		
		/**
		 * Panel : Deplacement vers Territoire alié
		 */
		JPanel pDeplacementTerrAlie = new JPanel();
		pDeplacementTerrAlie.setVisible(false);
		pDeplacementTerrAlie.setBorder(BorderFactory.createTitledBorder("Deplacement vers Territoire alié : "));
		pDeplacementTerrAlie.setPreferredSize(new Dimension(420, 143));
		pDeplacementTerrAlie.setLayout(new GridBagLayout());
		addItem(pDeplacementTerrAlie, new JLabel("Territoire départ : "), 0, 0, 1, 1, GridBagConstraints.CENTER);
		addItem(pDeplacementTerrAlie, new JLabel("Brésil"), 1, 0, 1, 1, GridBagConstraints.CENTER);
		addItem(pDeplacementTerrAlie, okBtnTerrDep, 2, 0, 1, 1, GridBagConstraints.CENTER);
		addItem(pDeplacementTerrAlie, new JLabel("Territoire arrivé : "), 0, 1, 1, 1, GridBagConstraints.CENTER);
		addItem(pDeplacementTerrAlie, new JLabel("Brésil"), 1, 1, 1, 1, GridBagConstraints.CENTER);
		addItem(pDeplacementTerrAlie, okBtnTerrArr, 2, 1, 1, 1, GridBagConstraints.CENTER);
		addItem(pDeplacementTerrAlie, new JLabel("Nombre Soldat"), 0, 2, 1, 1, GridBagConstraints.CENTER);
		addItem(pDeplacementTerrAlie, new JLabel("Nombre Cavalier"), 1, 2, 1, 1, GridBagConstraints.CENTER);
		addItem(pDeplacementTerrAlie, new JLabel("Nombre Canon"), 2, 2, 1, 1, GridBagConstraints.CENTER);
		addItem(pDeplacementTerrAlie, cbNbSoldat, 0, 3, 1, 1, GridBagConstraints.CENTER);
		addItem(pDeplacementTerrAlie, cbNbCavalier, 1, 3, 1, 1, GridBagConstraints.CENTER);
		addItem(pDeplacementTerrAlie, cbNbCanon, 2, 3, 1, 1, GridBagConstraints.CENTER);
		addItem(pDeplacementTerrAlie, okBtnNbUnite, 3, 3, 1, 1, GridBagConstraints.WEST);
		
		/**
		 * Panel : Attaquer un territoire
		 */
		JPanel pAttaquerTerr = new JPanel();
		pAttaquerTerr.setVisible(false);
		pAttaquerTerr.setBorder(BorderFactory.createTitledBorder("Attaquer un territoire : "));
		pAttaquerTerr.setPreferredSize(new Dimension(420, 182));
		pAttaquerTerr.setLayout(new GridBagLayout());
		addItem(pAttaquerTerr, new JLabel("Territoire départ : "), 0, 2, 2, 1, GridBagConstraints.CENTER);
		addItem(pAttaquerTerr, new JLabel("Territoire arrivé : "), 2, 2, 2, 1, GridBagConstraints.CENTER);
		addItem(pAttaquerTerr, new JLabel("Pérou"), 0, 3, 2, 1, GridBagConstraints.CENTER);
		addItem(pAttaquerTerr, new JLabel("Brésil"), 2, 3, 2, 1, GridBagConstraints.CENTER);
		addItem(pAttaquerTerr, new JLabel("Nombre Soldat"), 0, 0, 1, 1, GridBagConstraints.CENTER);
		addItem(pAttaquerTerr, new JLabel("Nombre Cavalier"), 1, 0, 1, 1, GridBagConstraints.CENTER);
		addItem(pAttaquerTerr, new JLabel("Nombre Canon"), 2, 0, 1, 1, GridBagConstraints.CENTER);
		addItem(pAttaquerTerr, cbNbSoldatAtt, 0, 1, 1, 1, GridBagConstraints.CENTER);
		addItem(pAttaquerTerr, cbNbCavalierAtt, 1, 1, 1, 1, GridBagConstraints.CENTER);
		addItem(pAttaquerTerr, cbNbCanonAtt, 2, 1, 1, 1, GridBagConstraints.CENTER);
		addItem(pAttaquerTerr, okBtnNbUnite, 3, 1, 1, 1, GridBagConstraints.WEST);
		addItem(pAttaquerTerr, new JLabel("Soldat"), 0, 4, 1, 1, GridBagConstraints.EAST);
		addItem(pAttaquerTerr, new JLabel("3"), 1, 4, 1, 1, GridBagConstraints.WEST);
		addItem(pAttaquerTerr, new JLabel("Soldat"), 2, 4, 1, 1, GridBagConstraints.EAST);
		addItem(pAttaquerTerr, new JLabel("2"), 3, 4, 1, 1, GridBagConstraints.WEST);
		addItem(pAttaquerTerr, new JLabel("Soldat"), 0, 5, 1, 1, GridBagConstraints.EAST);
		addItem(pAttaquerTerr, new JLabel("3"), 1, 5, 1, 1, GridBagConstraints.WEST);
		addItem(pAttaquerTerr, new JLabel("Soldat"), 2, 5, 1, 1, GridBagConstraints.EAST);
		addItem(pAttaquerTerr, new JLabel("2"), 3, 5, 1, 1, GridBagConstraints.WEST);
		addItem(pAttaquerTerr, new JLabel("Soldat"), 0, 6, 1, 1, GridBagConstraints.EAST);
		addItem(pAttaquerTerr, new JLabel("3"), 1, 6, 1, 1, GridBagConstraints.WEST);
		addItem(pAttaquerTerr, new JLabel("Soldat"), 2, 6, 1, 1, GridBagConstraints.EAST);
		addItem(pAttaquerTerr, new JLabel("2"), 3, 6, 1, 1, GridBagConstraints.WEST);
		
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
		addItem(this, pJoueur, 0, 0, 1, 1, GridBagConstraints.CENTER);
		addItem(this, pRenfort, 0, 1, 1, 1, GridBagConstraints.CENTER);
		addItem(this, positionBtn, 0, 2, 1, 1, GridBagConstraints.CENTER);
		addItem(this, pPositionRenfort, 0, 2, 1, 1, GridBagConstraints.CENTER);
		addItem(this, deplacementBtn, 0, 3, 1, 1, GridBagConstraints.CENTER);
		addItem(this, pDeplacementTerrAlie, 0, 3, 1, 1, GridBagConstraints.CENTER);
		addItem(this, attaqueBtn, 0, 4, 1, 1, GridBagConstraints.CENTER);
		addItem(this, pAttaquerTerr, 0, 4, 1, 1, GridBagConstraints.CENTER);
		addItem(this, finTourBtn, 0, 5, 1, 1, GridBagConstraints.CENTER);
		
		
		/**
		 * Au clic sur bouton position:
		 * panneau position visible et btn pas visible
		 */
		positionBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				pPositionRenfort.setVisible(true);
				positionBtn.setVisible(false);
				cbAjoutSoldat.setModel( modelComboBox(joueur.getArmeeRecu().getNbSoldat()) );
				cbAjoutCavalier.setModel( modelComboBox(joueur.getArmeeRecu().getNbCavalier()) );
				cbAjoutCanon.setModel( modelComboBox(joueur.getArmeeRecu().getNbCanon()) );

				
/*				if (Partie.getInstance().isSelected()){
					System.out.println("Partie.getInstance().getTerritoireSelected().getNom()" +Partie.getInstance().getTerritoireSelected().getNom());
					labelTerrSelct.setText(Partie.getInstance().getTerritoireSelected().getNom());
				}*/
			}
		});
		 
		 okBtnAjoutArmee.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					Integer nbSoldat = (Integer) cbAjoutSoldat.getSelectedItem();
					Integer nbCavalier = (Integer) cbAjoutCavalier.getSelectedItem();
					Integer nbCanon = (Integer) cbAjoutCanon.getSelectedItem();
					Partie.getInstance().initPlacementArmee(nbSoldat, nbCavalier, nbCanon );
					System.out.println("ok");
				}
			});
		 
		
		
		
		deplacementBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				pDeplacementTerrAlie.setVisible(true);
				deplacementBtn.setVisible(false);
				//addItem(this, pPositionRenfort, 0, 2, 1, 1, GridBagConstraints.CENTER);
			}
		});
		
		attaqueBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				pAttaquerTerr.setVisible(true);
				attaqueBtn.setVisible(false);
				//addItem(this, pPositionRenfort, 0, 2, 1, 1, GridBagConstraints.CENTER);
			}
		});
		
		/**
		 * MAJ du nombre de renfort soldat � positionner + MAJ ComboBox
		 */
/*		okBtnAjoutSoldat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Integer itemSelected = (Integer) cbAjoutSoldat.getSelectedItem();
				if (itemSelected >= 0) {
					setNbSoldatRenfort(getNbSoldatRenfort() - itemSelected);
					labelNbSoldatRenfort.setText(getNbSoldatRenfort().toString());
					for (int i = cbAjoutSoldat.getItemCount() - 1; i > getNbSoldatRenfort(); i--) {
						cbAjoutSoldat.removeItem(i);
					}
				} else {
					System.out.println("Vous ne pouvez plus ajouter de soldat");
				}
			}
		});
		*//**
		 * MAJ du nombre de renfort cavalier � positionner + MAJ ComboBox
		 *//*
		okBtnAjoutCavalier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Integer itemSelected = (Integer) cbAjoutCavalier.getSelectedItem();
				if (itemSelected >= 0) {
					setNbCavalierRenfort(getNbCavalierRenfort() - itemSelected);
					labelNbCavalierRenfort.setText(getNbCavalierRenfort().toString());
					for (int i = cbAjoutCavalier.getItemCount() - 1; i > getNbCavalierRenfort(); i--) {
						cbAjoutCavalier.removeItem(i);
					}
				} else {
					System.out.println("Vous ne pouvez plus ajouter de cavalier");
				}
			}
		});
		*//**
		 * MAJ du nombre de renfort canon � positionner + MAJ ComboBox
		 *//*
		okBtnAjoutCanon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Integer itemSelected = (Integer) cbAjoutCanon.getSelectedItem();
				if (itemSelected >= 0) {
					setNbCanonRenfort(getNbCanonRenfort() - itemSelected);
					labelNbCanonRenfort.setText(getNbCanonRenfort().toString());
					for (int i = cbAjoutCanon.getItemCount() - 1; i > getNbCanonRenfort(); i--) {
						cbAjoutCanon.removeItem(i);
					}
				} else {
					System.out.println("Vous ne pouvez plus ajouter de canon");
				}
			}
		});*/

		
		/**
		 * Changement de joueur 
		 * 
		 */
		finTourBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Partie.getInstance().nextJoueur();
				joueur = Partie.getInstance().getJoueur();
				joueurNomLabel.setText(joueur.getNom());
				joueurIdLabel.setText(joueur.getId().toString());
				positionBtn.setVisible(true);
				deplacementBtn.setVisible(true);
				attaqueBtn.setVisible(true);
				pPositionRenfort.setVisible(false);
				pDeplacementTerrAlie.setVisible(false);
				pAttaquerTerr.setVisible(false);
				labelNbSoldatRenfort.setText(joueur.getArmeeRecu().getNbSoldat().toString());
				labelNbCavalierRenfort.setText(joueur.getArmeeRecu().getNbCavalier().toString());
				labelNbCanonRenfort.setText(joueur.getArmeeRecu().getNbCanon().toString());
				
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


	

}
