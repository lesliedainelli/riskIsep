package main.java;

import java.util.Comparator;
import java.util.Random;

public class Unite {

	// final???
	protected int PuissanceMin;
	protected int PuissanceMax;
	protected int prioriteATT;
	protected int prioriteDEF;
	protected int mvtTour;
	protected int nbMvtTour;
	protected Integer numAlea;

	public Unite(int puissanceMin, int puissanceMax, int prioriteATT, int prioriteDEF, int mvtTour) {
		super();
		PuissanceMin = puissanceMin;
		PuissanceMax = puissanceMax;
		this.prioriteATT = prioriteATT;
		this.prioriteDEF = prioriteDEF;
		this.mvtTour = mvtTour;
	}
	
	public void initNbMvtTour(){
		this.nbMvtTour = this.mvtTour;
	}
	
	public void mouvement() {
		if (this.nbMvtTour <= 0) {
			System.out.println("Vous ne plus déplacer cette unité durant ce tour");
		} else {
			this.nbMvtTour--;
		}
	}
	
	public void nbAleatoire (){
		Random r = new Random();
		Integer result = PuissanceMin + r.nextInt(PuissanceMax - PuissanceMin);
		numAlea = result;
		//return result;
	}

	public static Comparator <Unite> comparatorNbAlea = new Comparator <Unite> (){
		
		@Override 
		public int compare(Unite u1, Unite u2){
			 return (int) (u2.getNumAlea() - u1.getNumAlea());
			//return u2.getNumAlea().compareTo(u1.getNumAlea());
		}
	};
	
	public int getPuissanceMin() {
		return PuissanceMin;
	}

	public void setPuissanceMin(int puissanceMin) {
		PuissanceMin = puissanceMin;
	}

	public int getPuissanceMax() {
		return PuissanceMax;
	}

	public void setPuissanceMax(int puissanceMax) {
		PuissanceMax = puissanceMax;
	}

	public int getPrioriteATT() {
		return prioriteATT;
	}

	public void setPrioriteATT(int prioriteATT) {
		this.prioriteATT = prioriteATT;
	}

	public int getPrioriteDEF() {
		return prioriteDEF;
	}

	public void setPrioriteDEF(int prioriteDEF) {
		this.prioriteDEF = prioriteDEF;
	}

	public int getMvtTour() {
		return mvtTour;
	}

	public void setMvtTour(int mvtTour) {
		this.mvtTour = mvtTour;
	}

	public int getNbMvtTour() {
		return nbMvtTour;
	}

	public void setNbMvtTour(int nbMvtTour) {
		this.nbMvtTour = nbMvtTour;
	}

	public Integer getNumAlea() {
		return numAlea;
	}

	public void setNumAlea(Integer numAlea) {
		this.numAlea = numAlea;
	}


	

}
