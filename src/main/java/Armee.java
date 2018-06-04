package main.java;


import java.util.ArrayList;

public class Armee {

	private ArrayList<Soldat> soldatList = new ArrayList<Soldat>();
	private ArrayList<Cavalier> cavalierList = new ArrayList<Cavalier>();
	private ArrayList<Canon> canonList = new ArrayList<Canon>();

/*	public Armee(ArrayList<Soldat> soldatList, ArrayList<Cavalier> cavalierList, ArrayList<Canon> canonList) {
		super();
		this.soldatList = soldatList;
		this.cavalierList = cavalierList;
		this.canonList = canonList;
	}*/
	
	public Armee() {
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
			System.out.println("Nombre de soldats à retirer supérieur au nombre que vous avez"); // voir si nécessaire ???
		} else {
			int listSize = this.soldatList.size()-1;
			for (int i = listSize ; i > listSize - nbSoldats ; i--) {
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
			System.out.println("Nombre de cavaliers à retirer supérieur au nombre que vous avez");
		} else {
			int listSize = this.cavalierList.size()-1;
			for (int i = listSize ; i > listSize - nbCavaliers ; i--) {
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
			System.out.println("Nombre de canons à retirer supérieur au nombre que vous avez");
		} else {
			int listSize = this.canonList.size()-1;
			for (int i = listSize ; i > listSize - nbCanons ; i--) {
				this.canonList.remove(getCanonList().get(i)); 
			}
		}
	}
	

	public void addArmee(int nbSoldats, int nbCavaliers, int nbCanons) {
		this.addCanons(nbCanons);
		this.addCavaliers(nbCavaliers);
		this.addSoldats(nbSoldats); 
	}
	
	/**
	 * @param nbSoldats 
	 * @param nbCavaliers
	 * @param nbCanons
	 */
	public void removeArmee(int nbSoldats, int nbCavaliers, int nbCanons) {
		this.removeCanons(nbCanons);
		this.removeCavaliers(nbCavaliers);
		this.removeSoldats(nbSoldats);
	}
	
	public boolean armeeVide (){
		if (getNbSoldat()==0 && getNbCavalier()==0 && getNbCanon()==0 ){
			return true;
		}
		return false;
	}
	
	
	/**
	 * Getter and setter 
	 */
	public Integer getNbUnite(){
		return this.soldatList.size() + this.cavalierList.size() + this.canonList.size();
	}
	
	public Integer getNbSoldat() {
		return this.soldatList.size();
	}
	
	public Integer getNbCavalier() {
		return this.cavalierList.size();
	}
	
	public Integer getNbCanon() {
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
