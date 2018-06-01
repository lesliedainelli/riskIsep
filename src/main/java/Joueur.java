package main.java;


import java.util.ArrayList;

public class Joueur {

//	protected int nbArmee;
	protected int nbTerritoiresCaptures;
	protected int id;
	protected String nom; 
/*	protected int nbSoldats;
	protected int nbCavaliers;
	protected int nbCanons;*/
	protected ArrayList<Territoire> territoireList;
	protected ArrayList<Region> regionList;
	//protected int nbTerritoires = this.territoireList.size();// peut faire ça?? demander
	


	public Joueur(int id, String nom) {
		this.id = id;
		this.nom = nom;
	}
	
	public boolean gagner (){
		if (this.territoireList.size()==42){
			return true;
		}
		return false; 
	}
	
	public boolean perdu (){
		if (this.territoireList.size()==0){
			return true;
		}
		return false; 
	}
	
	public void gagneTerritoire (){
		this.nbTerritoiresCaptures++;
	}
	
	public void addTerritoire (Territoire territoire){
		this.territoireList.add(territoire);
	}
	
	public void removeTerritoire (Territoire territoire){
		this.territoireList.remove(territoire);
	}
	
	public void resetTerritoiresCaptures (){
		this.nbTerritoiresCaptures=0;
	}
	


/*	public int getNbArmee() {
		return nbArmee;
	}

	public void setNbArmee(int nbArmee) {
		this.nbArmee = nbArmee;
	}*/

	public int getNbTerritoiresCaptures() {
		return nbTerritoiresCaptures;
	}

	public void setNbTerritoiresCaptures(int nbTerritoiresCaptures) {
		this.nbTerritoiresCaptures = nbTerritoiresCaptures;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

/*	public int getNbSoldats() {
		return nbSoldats;
	}

	public void setNbSoldats(int nbSoldats) {
		this.nbSoldats = nbSoldats;
	}

	public int getNbCavaliers() {
		return nbCavaliers;
	}

	public void setNbCavaliers(int nbCavaliers) {
		this.nbCavaliers = nbCavaliers;
	}

	public int getNbCanons() {
		return nbCanons;
	}

	public void setNbCanons(int nbCanons) {
		this.nbCanons = nbCanons;
	}*/

	public ArrayList<Territoire> getTerritoireList() {
		return territoireList;
	}

	public void setTerritoireList(ArrayList<Territoire> territoireList) {
		this.territoireList = territoireList;
	}

	public ArrayList<Region> getRegionList() {
		return regionList;
	}

	public void setRegionList(ArrayList<Region> regionList) {
		this.regionList = regionList;
	}


	
	
}
