package main.java;

import java.util.ArrayList;

public class Region {


	protected ArrayList<Territoire> territoire;
	protected String nom; 
	protected int id; 
	
	public Region(ArrayList<Territoire> territoire, String nom, int id) {
		super();
		this.territoire = territoire;
		this.nom = nom;
		this.id = id;
	}

}
