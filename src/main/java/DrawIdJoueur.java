package main.java;

public class DrawIdJoueur {
	private String idJoueur;
	private int milieu_x;
	private int milieu_y;
	
	public DrawIdJoueur(Integer idJoueur, int milieu_x, int milieu_y) {
		super();
		this.idJoueur = idJoueur.toString();
		this.milieu_x = milieu_x;
		this.milieu_y = milieu_y;
	}

	
	/**
	 * Getters and setters
	 */
	public String getIdJoueur() {
		return idJoueur;
	}

	public void setIdJoueur(String idJoueur) {
		this.idJoueur = idJoueur;
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
