package risk;

import java.util.Scanner;

public class Tour {

	private Joueur joueur;
	private final int COUT_SOLDAT = 1;
	private final int COUT_CAVALIER = 3;
	private final int COUT_CANON=7;
	private Armee armeeRecu;
	
	private static Scanner scan = new Scanner(System.in);

	public Tour(Joueur joueur) {
		this.joueur = joueur;
		receptionRenfort();
		
		//echanges : 
		
		// tant que armee reçu pas vide on demande de placer les armees sur territoires
		
	}
	

	/**
	 * Calcul du nombre de renforts au début de chaque tour
	 * Par défaut tous ces renforts sont des soldats que l'on pourra échanger après
	 */
	public void receptionRenfort(){
		int nbTerritoire = (int) Math.floor(joueur.getTerritoireList().size()/3);
		int nbRegion = (int) Math.floor(joueur.getRegionList().size()/2);
		int nbCapture = joueur.getNbTerritoiresCaptures(); // a verif pour histoire des 50 %
		int somme = nbTerritoire+nbRegion+nbCapture;
		if (somme<2){
			this.armeeRecu.addSoldats(2);
			//this.nbSoldatRecu = 2;
		}else {
			this.armeeRecu.addSoldats(somme);
			//this.nbSoldatRecu = somme;
		}
	}
	
	
	public void echangePourCavalier(int nbCavalier) {
		if (this.armeeRecu.getSoldatList().size() >= nbCavalier * COUT_CAVALIER) {  // vérif peut échanger 
			this.armeeRecu.addCavaliers(nbCavalier);
			this.armeeRecu.removeSoldats(nbCavalier * COUT_CAVALIER);
		} else {
			System.out.println("Vous n'avez pas assez de soldats pour obtenir" + nbCavalier
					+ "cavalier(s) (coût d'un cavalier: "+COUT_CAVALIER +")");
		}
	}
	
	
	public void echangePourCanon(int nbCanon) {
		if (this.armeeRecu.getSoldatList().size() >= nbCanon * COUT_CANON) {  // vérif peut échanger 
			this.armeeRecu.addCanons(nbCanon);
			this.armeeRecu.removeSoldats(nbCanon * COUT_CANON);
		} else {
			System.out.println("Vous n'avez pas assez de soldats pour obtenir" + nbCanon
					+ "cavalier(s) (coût d'un canon: "+COUT_CANON +")");
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
			t.addArmee(nbSoldat, nbCavalier, nbCanon);
		}
	}
	
	public void deplacementVersTerritoireAllie (Territoire tDep, Territoire tArr, int nbSoldat, int nbCavalier, int nbCanon){
	//	tDep
	}
	

}
