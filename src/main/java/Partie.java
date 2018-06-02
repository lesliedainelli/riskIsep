package main.java;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Collections;

public class Partie {

	protected ArrayList<Joueur> joueurList;
	protected ArrayList<Territoire> territoiresList;
	protected int nbJoueur;
	

	Territoires territoires = new Territoires();
	//int x = InterfaceCarte.getInstance().getSourisX();
	
	
	
	/** Constructeur prive */
    private Partie()
    {}
 
    /** Instance unique pre-initialisee */
    private static Partie INSTANCE = new Partie();
     
    /** Point d'acces pour l'instance unique du singleton */
    public static Partie getInstance()
    {   return INSTANCE;
    }

	


	public void initListJoueurs() {
		for (int i = 1; i <= nbJoueur; i++) {
			joueurList.add(new Joueur(i, "nom1")); // reccup avec label 
		}
	}
	
	public void initTerritoireAlea (){
		int j = 0; 
		Collections.shuffle(territoiresList); // mélange liste Territoires
		for (Territoire t : territoiresList){
			if (j==joueurList.size()-1){
				j=0;
			}
			joueurList.get(j).addTerritoire(t);
			j++;
		}
	}
	
	public void dessinTerritoire (){
		//for (joueur)
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
			//j.setNbArmee(nbArmee);
		}
	}
	
	public void initPlaceArmeeTerritoire(){
		//verif au moins 1 
		
	}
	
	
	public void getTerritoireSelected(int sourisX, int sourisY) {

		int c = InterfaceCarte.getInstance().getImage().getRGB(sourisX, sourisY);
		int red = (c & 0x00ff0000) >> 16;
		int green = (c & 0x0000ff00) >> 8;
		int blue = c & 0x000000ff;
		System.out.println(new Color(c));
		CodeRVB rvbSelected = new CodeRVB(red, green, blue);

		for (Territoire t : territoires.getListTerritoires()) {
			if (rvbSelected.equals(t.getCodeRVB())) {
				System.out.println("Le territoire selected is : " + t.getNom());
				//System.out.println(InterfaceCarte.getInstance().getImage().getWidth());
				//System.out.println(InterfaceCarte.getInstance().getImage().getHeight());
				break;
			}
		}

	}
	
	
	
}
