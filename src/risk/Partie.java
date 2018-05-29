package risk;

import java.util.ArrayList;
import java.util.Collections;

public class Partie {

	protected ArrayList<Joueur> joueurList;
	protected ArrayList<Territoire> territoiresList;
	protected int nbJoueur;
	
	public void Partie (){
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
}
