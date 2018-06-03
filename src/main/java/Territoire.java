package main.java;

import java.util.ArrayList;

public class Territoire {

	private String nom; 
	private CodeRVB codeRVB;
	private ArrayList <String> territoiresAdjacents;  
	private Joueur joueurProp; 
	private int nbArmee=1;
	private Armee armee;
	private int milieu_x; // pour pouvoir dessiner au centre du territoire 
	private int milieu_y;
	
	public Territoire(String nom, CodeRVB codeRVB, ArrayList<String> territoiresAdjacents) {
		this.nom = nom;
		this.codeRVB = codeRVB;
		this.territoiresAdjacents = territoiresAdjacents;
	}
	
	
	
	public boolean verifAuMoinsUnearmee() {
		if (this.nbArmee <1){
			System.out.println("Le nombre d'armées doit être supérieur à 1");
			return false;
		}
		return true;
	}
	
	public boolean verifTerritoireAdj(Territoire t){
		for (String territoireAdj : this.territoiresAdjacents){
			if (territoireAdj == t.getNom()){
				return true;
			}
		}
		return false;
	}

	//public boolean verifNbArmee(int )
	
	public boolean verifTerritoireAppartient(Joueur joueur){
		if (this.joueurProp == joueur ){
			return true; 
		}
		return false;
	}
	




	public String getNom() {
		return nom;
	}



	public void setNom(String nom) {
		this.nom = nom;
	}



	public ArrayList<String> getTerritoiresAdjacents() {
		return territoiresAdjacents;
	}



	public void setTerritoiresAdjacents(ArrayList<String> territoiresAdjacents) {
		this.territoiresAdjacents = territoiresAdjacents;
	}
	
	public CodeRVB getCodeRVB() {
		return codeRVB;
	}

	public void setCodeRVB(CodeRVB codeRVB) {
		this.codeRVB = codeRVB;
	}



	public int getMilieu_x() {
		return milieu_x;
	}



	public void setMilieu_x(int milieu_x) {
		this.milieu_x = milieu_x;
	}



	public int getMilieu_y() {
		return milieu_y;
	}



	public void setMilieu_y(int milieu_y) {
		this.milieu_y = milieu_y;
	}



	public Armee getArmee() {
		return armee;
	}



	public void setArmee(Armee armee) {
		this.armee = armee;
	}
	

	
}
