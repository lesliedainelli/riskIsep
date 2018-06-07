package main.java;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Collections;

public class Partie {

	private ArrayList<Joueur> joueurList = new ArrayList<Joueur>();
	private ArrayList<DrawIdJoueur> drawIdJoueurList = new ArrayList<DrawIdJoueur>();
	private int nbJoueur;
	Territoires territoires = new Territoires();
	private ArrayList<Territoire> territoiresList= territoires.getListTerritoires();
	private int sourisX;
	private int sourisY;
	private int countJoueur=0;
	private Joueur joueur; 
	private boolean isSelected = false;
	private ArrayList <Unite> listAttaquant = new ArrayList <Unite> ();
	private ArrayList <Unite> listDefenseur = new ArrayList <Unite> ();

	
	/** Constructeur prive */
    private Partie()
    { }
 
    /** Instance unique pre-initialisee */
    private static Partie INSTANCE = new Partie();
     
    /** Point d'acces pour l'instance unique du singleton */
    public static Partie getInstance()
    {   return INSTANCE;
    }

    
	/**
	 * Passe au joueur suivant lorsque l'on fini le tour
	 */
	public void nextJoueur (){
		if (countJoueur == joueurList.size()-1){
			this.countJoueur=0;
			this.joueur = joueurList.get(countJoueur);
			
		} else{
			this.countJoueur++;
			this.joueur = joueurList.get(countJoueur);
		}
	}


	/**
	 * @param nomJoueursList
	 */
	public void initListJoueurs(ArrayList <String> nomJoueursList) {
		for (int i = 1; i <= nbJoueur; i++) {
			this.joueurList.add(new Joueur(i, nomJoueursList.get(i-1))); // reccup avec textfield
		}
		this.joueur = joueurList.get(0);
	}
	
	
	
	
	public void initTerritoireAlea (){
		int j = 0; 
		Collections.shuffle(territoiresList); // mélange liste Territoires
		for (Territoire t : territoiresList){
			if (j==joueurList.size()){
				j=0;
			}
			joueurList.get(j).addTerritoire(t);
			j++;
		}
	}
	
	public void dessinTerritoire (){
		for (Joueur j : joueurList ){
			for (Territoire t : j.getTerritoireList()){
				DrawIdJoueur d = new DrawIdJoueur (j.getId(),t.getMilieu_x(),t.getMilieu_y());
				drawIdJoueurList.add(d);
			}
		}
	}
	
	public ArrayList<DrawIdJoueur> dessinTerritoireVictoire (Territoire tDef, Joueur joueur){
		for (Joueur j : joueurList ){
			for (Territoire t : j.getTerritoireList()){
				if(t.equals(tDef)){
					DrawIdJoueur d = new DrawIdJoueur (joueur.getId(),t.getMilieu_x(),t.getMilieu_y());
				} else {
					DrawIdJoueur d = new DrawIdJoueur (j.getId(),t.getMilieu_x(),t.getMilieu_y());
					drawIdJoueurList.add(d);
				}
			}
		}
		return drawIdJoueurList;
	}
	
	public void initArmees(){
		int nbArmee = 0; 
		switch (nbJoueur){
		case 2: 
			nbArmee=40;
			break; 
		case 3: 
			nbArmee=35;
			break;
		case 4: 
			nbArmee=30;
			break;
		case 5: 
			nbArmee=25;
			break;
		case 6: 
			nbArmee=20;
			break;
		}
		
		for (Joueur j : joueurList){
			j.getArmeeRecu().addArmee(nbArmee, 0, 0); // place tt dans osldat par def
			for (Territoire t : j.getTerritoireList()){
				System.out.println("terri " + t.getNom());
				j.placementArmee(t, 1, 0, 0);
			}
		}
	}

	
	public void initPlaceArmeeTerritoire(){
		//verif au moins 1 
		
	}
	
	
	
	public Territoire getTerritoireSelected() {
		int c = InterfaceCarte.getInstance().getImage().getRGB(sourisX, sourisY);
		int red = (c & 0x00ff0000) >> 16;
		int green = (c & 0x0000ff00) >> 8;
		int blue = c & 0x000000ff;
		System.out.println(new Color(c));
		CodeRVB rvbSelected = new CodeRVB(red, green, blue);

		for (Territoire t : territoires.getListTerritoires()) {
			if (rvbSelected.equals(t.getCodeRVB())) {
				System.out.println("Le territoire selectionne est : " + t.getNom());
				return t;
			}
		}
		return null;
	}
	

	
	public void initPlacementArmee(int nbSoldat, int nbCavalier, int nbCanon) {
		Territoire tSelect = getTerritoireSelected();
		if (this.joueur.verifTerritoireAppartient(tSelect)) {
			this.joueur.placementArmee(tSelect, nbSoldat, nbCavalier, nbCanon);
			System.out.println("Armee placée sur le territoire");

		} else {
			InterfaceCarte.getInstance().getLabelMessage().setText("Territoire n'appartient pas au joueur : " + joueur.getNom() + " " + joueur.getId());
			System.out.println("Ce territoire n'appartient pas au joueur : " + joueur.getNom() + " " + joueur.getId());
		}

	}
	
	
	
	
	
	public void deplacementVersTerritoireAllie (Territoire tDep, Territoire tArr, int nbSoldat, int nbCavalier, int nbCanon){
		if (this.joueur.verifTerritoireAppartient(tDep) && this.joueur.verifTerritoireAppartient(tArr) && tDep.verifTerritoireAdj(tArr)) {
			tArr.getArmee().addArmee(nbSoldat, nbCavalier, nbCanon);
			tDep.getArmee().removeArmee(nbSoldat, nbCavalier, nbCanon);
			//verif nb deplacemnt
		} else {
			InterfaceCarte.getInstance().getLabelMessage().setText("Ces territoires ne vous appartiennent pas.");
			System.out.println("ces territoires ne vous appartiennent pas");
		}
	}

	
	public void attaque (Territoire tAtt, Territoire tDef, int nbSoldat, int nbCavalier, int nbCanon){
		if (this.joueur.verifTerritoireAppartient(tAtt)  && tAtt.verifTerritoireAdj(tDef)) {
			listAttaquant.clear();
			listDefenseur.clear();
			
			// Incrémente la liste des attaquants
			for (int i = 0 ; i < nbSoldat ; i++){
				tAtt.getArmee().getSoldatList().get(i).nbAleatoire();
				listAttaquant.add(tAtt.getArmee().getSoldatList().get(i));
			}
			for (int i = 0 ; i < nbCavalier ; i++){
				tAtt.getArmee().getCavalierList().get(i).nbAleatoire();
				listAttaquant.add(tAtt.getArmee().getCavalierList().get(i));
			}
			for (int i = 0 ; i < nbCanon ; i++){
				tAtt.getArmee().getCanonList().get(i).nbAleatoire();
				listAttaquant.add(tAtt.getArmee().getCanonList().get(i));
			}
			Collections.sort(listAttaquant , Unite.comparatorNbAlea);
			
			// Incrémente la liste des défenseur
			
			int compteur =2; //max 2 défenseur
			//while (compteur != 0){
				for (int i =  0 ; i< tDef.getArmee().getSoldatList().size() ; i++){ //priotité 1
					if (compteur==0){
						break;
					}
					tDef.getArmee().getSoldatList().get(i).nbAleatoire();
					listDefenseur.add(tDef.getArmee().getSoldatList().get(i));
					compteur --;
				} 
				
				for (int i =  0 ; i< tDef.getArmee().getCanonList().size() ; i++){//priotité 2
					if (compteur==0){
						break;
					}
					tDef.getArmee().getCanonList().get(i).nbAleatoire();
					listDefenseur.add(tDef.getArmee().getCanonList().get(i));
					compteur --;
				}
				for (int i =  0 ; i< tDef.getArmee().getCavalierList().size() ; i++){//priotité 3
					if (compteur==0){
						break;
					}
					tDef.getArmee().getCavalierList().get(i).nbAleatoire();
					listDefenseur.add(tDef.getArmee().getCavalierList().get(i));
					compteur --;
				}
				//compteur = 0 ; // car veut dire qu'il reste qu'une unité
			//}
		
			
			int x = compareSizeArrayList(listAttaquant, listDefenseur);

			for (int i = 0 ; i < x ; i++ ){
				int nbSoldatAtt = 0;
				int nbCavalierAtt = 0;
				int nbCanonAtt = 0;
				int nbSoldatDef = 0;
				int nbCavalierDef = 0;
				int nbCanonDef = 0;
				
				//defenseur gagne ou égalité (def gagne) 
				if (listAttaquant.get(i).getNumAlea() < listDefenseur.get(i).getNumAlea() || listAttaquant.get(i).getNumAlea() == listDefenseur.get(i).getNumAlea()){
					if (listAttaquant.get(i) instanceof Soldat) {
						nbSoldatAtt = 1; 
					}
					if (listAttaquant.get(i) instanceof Cavalier){
						nbCavalierAtt = 1; 
					}
					if (listAttaquant.get(i) instanceof Canon){
						nbCanonAtt = 1; 
					}
					tAtt.getArmee().removeArmee(nbSoldatAtt, nbCavalierAtt, nbCanonAtt);
					tDef.getArmee().addArmee(nbSoldatAtt, nbCavalierAtt, nbCanonAtt);
					
				// attaquant gagne	
				} else {
					if (listDefenseur.get(i) instanceof Soldat) {
						nbSoldatDef = 1; 
					}
					if (listDefenseur.get(i) instanceof Cavalier){
						nbCavalierDef = 1; 
					}
					if (listDefenseur.get(i) instanceof Canon){
						nbCanonDef = 1; 
					}
					tDef.getArmee().removeArmee(nbSoldatDef, nbCavalierDef, nbCanonDef);
					tAtt.getArmee().addArmee(nbSoldatDef, nbCavalierDef, nbCanonDef);	
					if (tDef.estConquis()){
						//tDef
						//changer id 
						joueur.gagneTerritoire(); // nb  capture
						InterfaceCarte.getInstance().getLabelMessage().setText("Territoire conquis.");
						//CartePanel.getInstance().setList(dessinTerritoireVictoire(tDef, joueur));
						//CartePanel.getInstance().repaint();
						
					}
				}
			}
			
		} else {
			InterfaceCarte.getInstance().getLabelMessage().setText("ce territoire ne vous appartiennent pas / pas adjacent.");
			System.out.println("ce territoire ne vous appartiennent pas / pas adjacent");
		}
	}
	

	
	
	public int compareSizeArrayList (ArrayList <Unite> listA, ArrayList <Unite> listB){
		if (listA.size() > listB.size()){
			return listB.size();
		} else { 
			return listA.size();
		}
	}


	
	
	/*
	 * Getters ans Setters
	 */
	public ArrayList<Joueur> getJoueurList() {
		return joueurList;
	}




	public void setJoueurList(ArrayList<Joueur> joueurList) {
		this.joueurList = joueurList;
	}




	public ArrayList<DrawIdJoueur> getDrawIdJoueurList() {
		return drawIdJoueurList;
	}




	public void setDrawIdJoueurList(ArrayList<DrawIdJoueur> drawIdJoueurList) {
		this.drawIdJoueurList = drawIdJoueurList;
	}




	public int getNbJoueur() {
		return nbJoueur;
	}

	public void setNbJoueur(int nbJoueur) {
		this.nbJoueur = nbJoueur;
	}

	public ArrayList<Territoire> getTerritoiresList() {
		return territoiresList;
	}

	public void setTerritoiresList(ArrayList<Territoire> territoiresList) {
		this.territoiresList = territoiresList;
	}

	public int getSourisX() {
		return sourisX;
	}

	public void setSourisX(int sourisX) {
		this.sourisX = sourisX;
	}


	public int getSourisY() {
		return sourisY;
	}

	public void setSourisY(int sourisY) {
		this.sourisY = sourisY;
	}

	public Joueur getJoueur() {
		return joueur;
	}

	public void setJoueur(Joueur joueur) {
		this.joueur = joueur;
	}


	public boolean isSelected() {
		return isSelected;
	}


	public void setSelected(boolean isSelected) {
		this.isSelected = isSelected;
	}


	public ArrayList<Unite> getListAttaquant() {
		return listAttaquant;
	}


	public void setListAttaquant(ArrayList<Unite> listAttaquant) {
		this.listAttaquant = listAttaquant;
	}


	public ArrayList<Unite> getListDefenseur() {
		return listDefenseur;
	}


	public void setListDefenseur(ArrayList<Unite> listDefenseur) {
		this.listDefenseur = listDefenseur;
	}


	
	
	
}
