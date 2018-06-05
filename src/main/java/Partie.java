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


	public void initListJoueurs(ArrayList <String> nomJoueursList) {
		for (int i = 1; i <= nbJoueur; i++) {
			this.joueurList.add(new Joueur(i, nomJoueursList.get(i-1))); // reccup avec textfield
		}
		this.joueur = joueurList.get(0);
		System.out.println("initListJoueurs ");
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
		System.out.println("ok ");
	}
	
	public void dessinTerritoire (){
		for (Joueur j : joueurList ){
			for (Territoire t : j.getTerritoireList()){
				DrawIdJoueur d = new DrawIdJoueur (j.getId(),t.getMilieu_x(),t.getMilieu_y());
				drawIdJoueurList.add(d);
			}
		}
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
				//t.getArmee().addArmee(1, 0, 0); //place 1 soldat sur chaque territoire
			}
			//j.getArmeeRecu().removeArmee(1, 0, 0);
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
			System.out.println("Territoire n'appartient pas au joueur : " + joueur.getNom() + " " + joueur.getId());
		}

	}
	
	
	
	
	
	public void deplacementVersTerritoireAllie (Territoire tDep, Territoire tArr, int nbSoldat, int nbCavalier, int nbCanon){
		if (this.joueur.verifTerritoireAppartient(tDep) && this.joueur.verifTerritoireAppartient(tArr) && tDep.verifTerritoireAdj(tArr)) {
			tArr.getArmee().addArmee(nbSoldat, nbCavalier, nbCanon);
			tDep.getArmee().removeArmee(nbSoldat, nbCavalier, nbCanon);
			//verif nb deplacemnt
		} else {
			System.out.println("ces territoires ne vous appartiennent pas");
		}
	}

	
	public void attaque (Territoire tDep, Territoire tArr, int nbSoldat, int nbCavalier, int nbCanon){
		if (this.joueur.verifTerritoireAppartient(tDep)  && tDep.verifTerritoireAdj(tArr)) {
			if (tArr.getArmee().getNbUnite()>1){
				
			} else { //forcement un soldat
				int x = tArr.getArmee().getSoldatList().get(0).nbAleatoire();
			}
			
			
			tDep.getArmee().addArmee(nbSoldat, nbCavalier, nbCanon);
			tArr.getArmee().removeArmee(nbSoldat, nbCavalier, nbCanon);
		} else {
			System.out.println("ce territoire ne vous appartiennent pas / pas adjacent");
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


	
	
	
}
