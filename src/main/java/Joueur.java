package main.java;


import java.util.ArrayList;
import java.util.Random;

public class Joueur {

	private int nbTerritoiresCaptures;
	private int id;
	private String nom; 
	private ArrayList<Territoire> territoireList = new ArrayList<Territoire>();
	private ArrayList<Region> regionList= new ArrayList<Region>();
	private final int COUT_CAVALIER = 3;
	private final int COUT_CANON=7;
	private Armee armeeRecu =  new Armee();
	private Integer tour = 0; 
	
	public void incrementTour (){
		tour++;
	}


	public Joueur(Integer id, String nom) {
		this.id = id;
		this.nom = nom;
	}
	
	public boolean verifTerritoireAppartient(Territoire t ){
		for (Territoire terr : this.territoireList){
			if(terr.equals(t)){
				return true; 
			}
		}
		return false;
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
	
	
	/**
	 * Calcul du nombre de renforts au début de chaque tour
	 * Par défaut tous ces renforts sont des soldats que l'on pourra échanger après
	 */
	public void receptionRenfort(){
		int nbTerritoire = (int) Math.floor(this.getTerritoireList().size()/3);
		int nbRegion = (int) Math.floor(this.getRegionList().size()/2);
		int nbCapture = calculBonusCapture(); // a verif pour histoire des 50 %
		int somme = nbTerritoire+nbRegion+nbCapture;
		if (somme<2){
			this.armeeRecu.addSoldats(2);
		}else {
			this.armeeRecu.addSoldats(somme);
		}
	}
	
	public int calculBonusCapture (){
		Random r = new Random();
		int bonus =0;
		for (int i=0; i< this.nbTerritoiresCaptures; i++){
			bonus = bonus + 0 + r.nextInt(1 - 0);
		}
		return bonus;
	}
	
	
	
	
	public void echangePourCavalier(int nbCavalier) {
		if (this.armeeRecu.getSoldatList().size() >= nbCavalier * COUT_CAVALIER) {  // vérif peut échanger 
			this.armeeRecu.addCavaliers(nbCavalier);
			this.armeeRecu.removeSoldats(nbCavalier * COUT_CAVALIER);
			System.out.println(nbCavalier * COUT_CAVALIER);
			//System.out.println("taille " + armeeRecu.getCavalierList().size());
			//System.out.println(" nb "+ armeeRecu.getNbCavalier().toString());
			
		} else {
			System.out.println("Vous n'avez pas assez de soldats pour obtenir " + nbCavalier
					+ " cavalier(s) (coût d'un cavalier: "+COUT_CAVALIER +")");
		}
	}
	
	
	public void echangePourCanon(int nbCanon) {
		if (this.armeeRecu.getSoldatList().size() >= nbCanon * COUT_CANON) {  // vérif peut échanger 
			this.armeeRecu.addCanons(nbCanon);
			this.armeeRecu.removeSoldats(nbCanon * COUT_CANON);
		} else {
			System.out.println("Vous n'avez pas assez de soldats pour obtenir " + nbCanon
					+ " cavalier(s) (coût d'un canon: "+COUT_CANON +")");
		}
	}
	
	public void placementArmee(Territoire t, int nbSoldat, int nbCavalier, int nbCanon){
		if(this.armeeRecu.getSoldatList().size() < nbSoldat){
			System.out.println(" vous n'avez pas assez de soldats"); 
		} else if (this.armeeRecu.getCavalierList().size() < nbCavalier){
			System.out.println(" vous n'avez pas assez de cavaliers");
		} else if (this.armeeRecu.getCanonList().size() < nbCanon){
			System.out.println(" vous n'avez pas assez de canons");
		} else {
			//System.out.println(t.getArmee());
			t.getArmee().addArmee(nbSoldat, nbCavalier, nbCanon);
			armeeRecu.removeArmee(nbSoldat, nbCavalier, nbCanon);
		}
	}


	public int getNbTerritoiresCaptures() {
		return nbTerritoiresCaptures;
	}

	public void setNbTerritoiresCaptures(int nbTerritoiresCaptures) {
		this.nbTerritoiresCaptures = nbTerritoiresCaptures;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

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

	public Armee getArmeeRecu() {
		return armeeRecu;
	}

	public void setArmeeRecu(Armee armeeRecu) {
		this.armeeRecu = armeeRecu;
	}


	public Integer getTour() {
		return tour;
	}


	public void setTour(Integer tour) {
		this.tour = tour;
	}
	
	
/*	public Integer getNbSoldatRenfort() {
		return nbSoldatRenfort;
	}

	public void setNbSoldatRenfort(Integer nbSoldatRenfort) {
		this.nbSoldatRenfort = nbSoldatRenfort;
	}

	public Integer getNbCavalierRenfort() {
		return nbCavalierRenfort;
	}

	public void setNbCavalierRenfort(Integer nbCavalierRenfort) {
		this.nbCavalierRenfort = nbCavalierRenfort;
	}

	public Integer getNbCanonRenfort() {
		return nbCanonRenfort;
	}

	public void setNbCanonRenfort(Integer nbCanonRenfort) {
		this.nbCanonRenfort = nbCanonRenfort;
	}*/
	
	
}
