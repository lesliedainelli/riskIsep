package main.java;


import java.util.ArrayList;

public class Armee {

	private ArrayList<Soldat> soldatList;
	private ArrayList<Cavalier> cavalierList;
	private ArrayList<Canon> canonList;

	public Armee(ArrayList<Soldat> soldatList, ArrayList<Cavalier> cavalierList, ArrayList<Canon> canonList) {
		super();
		this.soldatList = soldatList;
		this.cavalierList = cavalierList;
		this.canonList = canonList;
	}
	
	/**
	 * Permet d'ajouter plusieurs soldats à la liste de soldat
	 * @param nbSoldats: nombre de soldats à ajouter à la liste 
	 */
	public void addSoldats(int nbSoldats) {
		for (int i = 0; i < nbSoldats; i++) {
			this.soldatList.add(new Soldat());
		}
	}
	
	/**
	 * Permet d'ajouter plusieurs cavaliers à la liste de cavalier
	 * @param nbCavaliers: nombre de cavalier à ajouter à la liste
	 */
	public void addCavaliers(int nbCavaliers) {
		for (int i = 0; i < nbCavaliers; i++) {
			this.cavalierList.add(new Cavalier());
		}
	}
	
	/**
	 * Permet d'ajouter plusieurs canons à la liste de canon
	 * @param nbCanons: nombre de canon à ajouter à la liste
	 */
	public void addCanons(int nbCanons) {
		for (int i = 0; i < nbCanons; i++) {
			this.canonList.add(new Canon());
		}
	}
	
	/**
	 * Permet de retirer plusieurs soldats à la liste de soldat
	 * @param nbSoldats: nombre de soldats à retirer à la liste 
	 */
	public void removeSoldats(int nbSoldats) {
		if (nbSoldats > this.soldatList.size()){
			System.out.println("Nombre de soldat à retirer supérieur au nombre que vous avez"); // voir si nécessaire ???
		} else {
			for (int i = 0; i < nbSoldats; i++) {
				this.soldatList.remove(getSoldatList().get(i)); 
			}
		}
	}
	
	/**
	 * Permet de retirer plusieurs cavaliers à la liste de cavalier
	 * @param nbCavaliers: nombre de cavalier à retirer à la liste
	 */
	public void removeCavaliers(int nbCavaliers) {
		if (nbCavaliers > this.cavalierList.size()){
			System.out.println("Nombre de cavalier à retirer supérieur au nombre que vous avez");
		} else {
			for (int i = 0; i < nbCavaliers; i++) {
				this.cavalierList.remove(getCavalierList().get(i)); 
			}
		}
	}
	
	/**
	 * Permet de retirer plusieurs canons à la liste de canon
	 * @param nbCanons: nombre de canon à retirer à la liste
	 */
	public void removeCanons(int nbCanons) {
		if (nbCanons > this.canonList.size()){
			System.out.println("Nombre de canon à retirer supérieur au nombre que vous avez");
		} else {
			for (int i = 0; i < nbCanons; i++) {
				this.canonList.remove(getCanonList().get(i)); 
			}
		}
	}
	

	
	
	
	
	/**
	 * Getter and setter 
	 */
	public int getNbUnite(){
		return this.soldatList.size() + this.cavalierList.size() + this.canonList.size();
	}
	
	public int getNbSoldat() {
		return this.soldatList.size();
	}
	
	public int getNbCavalier() {
		return this.cavalierList.size();
	}
	
	public int getNbCanon() {
		return this.canonList.size();
	}

	public ArrayList<Soldat> getSoldatList() {
		return soldatList;
	}

	public void setSoldatList(ArrayList<Soldat> soldatList) {
		this.soldatList = soldatList;
	}

	public ArrayList<Cavalier> getCavalierList() {
		return cavalierList;
	}

	public void setCavalierList(ArrayList<Cavalier> cavalierList) {
		this.cavalierList = cavalierList;
	}

	public ArrayList<Canon> getCanonList() {
		return canonList;
	}

	public void setCanonList(ArrayList<Canon> canonList) {
		this.canonList = canonList;
	}

}
