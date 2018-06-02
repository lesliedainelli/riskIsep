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
	
	public void addArmee(int nbSoldats, int nbCavaliers, int nbCanons) {
		this.armee.addCanons(nbCanons);
		this.armee.addCavaliers(nbCavaliers);
		this.armee.addSoldats(nbSoldats); 
	}
	
	/**
	 * @param nbSoldats 
	 * @param nbCavaliers
	 * @param nbCanons
	 */
	public void removeArmee(int nbSoldats, int nbCavaliers, int nbCanons) {
		this.armee.removeCanons(nbCanons);
		this.armee.removeCavaliers(nbCavaliers);
		this.armee.removeSoldats(nbSoldats);
	}

	
	/*public void getRGB (){
		Robot robot = null;
		try {
			robot = new Robot();
		} catch (AWTException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	    Color color = robot.getPixelColor(InterfaceCarte.getSourisX(), InterfaceCarte.getSourisY());
	    int valueRed=color.getRed();
		int valueGreen=color.getGreen();
		int valueBlue=color.getBlue();

	    System.out.println("Red   = " + valueRed);
	    System.out.println("Green = " + valueGreen);
	    System.out.println("Blue  = " + valueBlue);
	}*/



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
	

	
}
