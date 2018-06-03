package main.java;

import java.util.ArrayList;
import java.util.List;

import main.java.CodeRVB;

public class Territoires {
	ArrayList<String> listTerritoiresAdjacents = new ArrayList<String>();
	Territoire terr;
	ArrayList<Territoire> listTerritoires = new ArrayList<Territoire>();
	
	public ArrayList<Territoire> getListTerritoires() {
		return listTerritoires;
	}

	/**
	 * 
	 */
	public Territoires() {
		super();
		
		/**
		 * Amerique du Sud
		 */
		listTerritoiresAdjacents = new ArrayList<String>();
		listTerritoiresAdjacents.add("Bresil");
		listTerritoiresAdjacents.add("Perou");
		terr = new Territoire("Argentine", new CodeRVB(95, 13, 27), listTerritoiresAdjacents);
		listTerritoires.add(terr);
		terr.setMilieu_x(217);
		terr.setMilieu_y(477);
		
		listTerritoiresAdjacents = new ArrayList<String>();
		listTerritoiresAdjacents.add("Argentine");
		listTerritoiresAdjacents.add("Perou");
		listTerritoiresAdjacents.add("Venezuela");
		listTerritoiresAdjacents.add("Afrique du nord");		
		terr = new Territoire("Bresil", new CodeRVB(153, 37, 55), listTerritoiresAdjacents);
		listTerritoires.add(terr);
		terr.setMilieu_x(263);
		terr.setMilieu_y(371);
		
		
		listTerritoiresAdjacents = new ArrayList<String>();
		listTerritoiresAdjacents.add("Bresil");
		listTerritoiresAdjacents.add("Argentine");
		listTerritoiresAdjacents.add("Venezuela");	
		terr = new Territoire("Perou", new CodeRVB(170, 93, 106), listTerritoiresAdjacents);
		listTerritoires.add(terr);
		terr.setMilieu_x(212);
		terr.setMilieu_y(401);
		
		listTerritoiresAdjacents = new ArrayList<String>();
		listTerritoiresAdjacents.add("Bresil");
		listTerritoiresAdjacents.add("Perou");
		listTerritoiresAdjacents.add("Amerique centrale");	
		terr = new Territoire("Venezuela", new CodeRVB(255, 2, 44), listTerritoiresAdjacents);
		listTerritoires.add(terr);
		terr.setMilieu_x(198);
		terr.setMilieu_y(328);
		
		
		
		/**
		 * Amerique du Nord
		 */
		//1 : Alaska
		listTerritoiresAdjacents = new ArrayList<String>(); 
		listTerritoiresAdjacents.add("Territoires du Nord-Ouest"); 
		listTerritoiresAdjacents.add("Alberta"); 
		terr = new Territoire("Alaska", new CodeRVB(231, 226, 63), listTerritoiresAdjacents); 
		listTerritoires.add(terr); 
		terr.setMilieu_x(67);
		terr.setMilieu_y(105);

		//2
		listTerritoiresAdjacents = new ArrayList<String>(); 
		listTerritoiresAdjacents.add("Territoires du Nord-Ouest"); 
		listTerritoiresAdjacents.add("Alaska"); 
		listTerritoiresAdjacents.add("Etats de l'Ouest"); 
		listTerritoiresAdjacents.add("Ontario" );
		terr = new Territoire("Alberta", new CodeRVB(193, 202, 10), listTerritoiresAdjacents); 
		listTerritoires.add(terr); 
		terr.setMilieu_x(135);
		terr.setMilieu_y(151);

		//3
		listTerritoiresAdjacents = new ArrayList<String>(); 
		listTerritoiresAdjacents.add("Etas de l'Est"); 
		listTerritoiresAdjacents.add("Venezuela"); 
		listTerritoiresAdjacents.add("Etats de l'Ouest"); 
		terr = new Territoire("Amerique centrale", new CodeRVB(251, 255, 13), listTerritoiresAdjacents); 
		listTerritoires.add(terr);
		terr.setMilieu_x(146);
		terr.setMilieu_y(287);

		//4
		listTerritoiresAdjacents = new ArrayList<String>(); 
		listTerritoiresAdjacents.add("Quebec" ); 
		listTerritoiresAdjacents.add("Ontario "); 
		listTerritoiresAdjacents.add("Amerique centrale"); 
		listTerritoiresAdjacents.add("Etats de l'Ouest "); 
		terr = new Territoire("Etats de l'Est", new CodeRVB(170,150, 22), listTerritoiresAdjacents); 
		listTerritoires.add(terr);
		terr.setMilieu_x(199);
		terr.setMilieu_y(223);

		//5
		listTerritoiresAdjacents = new ArrayList<String>(); 
		listTerritoiresAdjacents.add("Quebec" ); 
		listTerritoiresAdjacents.add("Ontario"); 
		listTerritoiresAdjacents.add("Territoire du Nord-Ouest"); 
		listTerritoiresAdjacents.add("Etats de l'Ouest"); 
		listTerritoiresAdjacents.add("Islande"); 
		terr = new Territoire("Groenland", new CodeRVB(195,210, 30), listTerritoiresAdjacents); 
		listTerritoires.add(terr);
		terr.setMilieu_x(297);
		terr.setMilieu_y(77);

		//6
		listTerritoiresAdjacents = new ArrayList<String>(); 
		listTerritoiresAdjacents.add("Quebec" ); 
		listTerritoiresAdjacents.add("Alaska"); 
		listTerritoiresAdjacents.add("Alberta" ); 
		listTerritoiresAdjacents.add("Ontario"); 
		listTerritoiresAdjacents.add("Groenland"); 
		terr = new Territoire("Territoire du Nord-Ouest", new CodeRVB(224,220, 96), listTerritoiresAdjacents); 
		listTerritoires.add(terr);
		terr.setMilieu_x(145);
		terr.setMilieu_y(104);

		//7
		listTerritoiresAdjacents = new ArrayList<String>(); 
		listTerritoiresAdjacents.add("Quebec" ); 
		listTerritoiresAdjacents.add("Territoire du Nord-Ouest"); 
		listTerritoiresAdjacents.add("Alberta"); 
		listTerritoiresAdjacents.add("Groenland"); 
		listTerritoiresAdjacents.add("Etats de l'Ouest"); 
		listTerritoiresAdjacents.add("Etas de l'Est"); 
		terr = new Territoire("Ontario", new CodeRVB(246,222, 65), listTerritoiresAdjacents); 
		listTerritoires.add(terr);
		terr.setMilieu_x(193);
		terr.setMilieu_y(164);

		//8
		listTerritoiresAdjacents = new ArrayList<String>(); 
		listTerritoiresAdjacents.add("Territoire du Nord-Ouest"); 
		listTerritoiresAdjacents.add("Groenland"); 
		listTerritoiresAdjacents.add("Etats de l'Est"); 
		terr = new Territoire("Quebec", new CodeRVB(252,236, 127), listTerritoiresAdjacents); 
		listTerritoires.add(terr);
		terr.setMilieu_x(245);
		terr.setMilieu_y(160);

		//9
		listTerritoiresAdjacents = new ArrayList<String>(); 
		listTerritoiresAdjacents.add("Amerique centrale"); 
		listTerritoiresAdjacents.add("Alberta"); 
		listTerritoiresAdjacents.add("Etas de l'Est"); 
		listTerritoiresAdjacents.add("Ontario");
		terr = new Territoire("Etats de l'Ouest", new CodeRVB(246,230, 84), listTerritoiresAdjacents); 
		listTerritoires.add(terr);
		terr.setMilieu_x(133);
		terr.setMilieu_y(209);


		
		
		
		/**
		 * Europe
		 */
		//1
		listTerritoiresAdjacents = new ArrayList<String>(); 
		listTerritoiresAdjacents.add("Islande"); 
		listTerritoiresAdjacents.add("Europe Occidentale"); 
		listTerritoiresAdjacents.add("Europe du Nord"); 
		listTerritoiresAdjacents.add("Scandinavie"); 
		terr = new Territoire("Grande Bretagne", new CodeRVB(21, 83, 229), listTerritoiresAdjacents); 
		listTerritoires.add(terr); 
		terr.setMilieu_x(358);
		terr.setMilieu_y(208);

		//2
		listTerritoiresAdjacents = new ArrayList<String>(); 
		listTerritoiresAdjacents.add("Groenland"); 
		listTerritoiresAdjacents.add("Scandinavie"); 
		listTerritoiresAdjacents.add("Grande Bretagne"); 
		terr = new Territoire("Islande", new CodeRVB(100, 172, 188), listTerritoiresAdjacents); 
		listTerritoires.add(terr); 
		terr.setMilieu_x(364);
		terr.setMilieu_y(133);

		//3
		listTerritoiresAdjacents = new ArrayList<String>(); 
		listTerritoiresAdjacents.add("Grande Bretagne"); 
		listTerritoiresAdjacents.add("Scandinavie"); 
		listTerritoiresAdjacents.add("Europe Occidentale"); 
		listTerritoiresAdjacents.add("Europe du Sud"); 
		listTerritoiresAdjacents.add("Ukraine"); 
		terr = new Territoire("Europe du Nord", new CodeRVB(59, 62, 133), listTerritoiresAdjacents); 
		listTerritoires.add(terr);
		terr.setMilieu_x(425);
		terr.setMilieu_y(204);

		//4
		listTerritoiresAdjacents = new ArrayList<String>(); 
		listTerritoiresAdjacents.add("Grande Bretagne" ); 
		listTerritoiresAdjacents.add("Europe du Nord"); 
		listTerritoiresAdjacents.add("Islande"); 
		listTerritoiresAdjacents.add("Ukraine"); 
		terr = new Territoire("Scandinavie", new CodeRVB(50,134,153), listTerritoiresAdjacents); 
		listTerritoires.add(terr);
		terr.setMilieu_x(422);
		terr.setMilieu_y(138);

		//5
		listTerritoiresAdjacents = new ArrayList<String>(); 
		listTerritoiresAdjacents.add("Europe Occidentale" ); 
		listTerritoiresAdjacents.add("Europe du Nord"); 
		listTerritoiresAdjacents.add("Ukraine"); 
		listTerritoiresAdjacents.add("Egypte"); 
		terr = new Territoire("Europe du Sud", new CodeRVB(55,95, 187), listTerritoiresAdjacents); 
		listTerritoires.add(terr);
		terr.setMilieu_x(444);
		terr.setMilieu_y(255);

		//6
		listTerritoiresAdjacents = new ArrayList<String>(); 
		listTerritoiresAdjacents.add("Afghanistan" ); 
		listTerritoiresAdjacents.add("Moyen-Orient"); 
		listTerritoiresAdjacents.add("Oural"); 
		listTerritoiresAdjacents.add("Scandinavie"); 
		listTerritoiresAdjacents.add("Eruope du Nord"); 
		listTerritoiresAdjacents.add("Europe du Sud"); 
		terr = new Territoire("Ukraine", new CodeRVB(50,104, 113), listTerritoiresAdjacents); 
		listTerritoires.add(terr);
		terr.setMilieu_x(492);
		terr.setMilieu_y(175);

		//7
		listTerritoiresAdjacents = new ArrayList<String>();  
		listTerritoiresAdjacents.add("Europe du Sud"); 
		listTerritoiresAdjacents.add("Eruope du Nord"); 
		listTerritoiresAdjacents.add("Grande Bretagne"); 
		listTerritoiresAdjacents.add("Afrique du Nord"); 
		terr = new Territoire("Europe Occidentale", new CodeRVB(28,97, 113), listTerritoiresAdjacents); 
		listTerritoires.add(terr);
		terr.setMilieu_x(364);
		terr.setMilieu_y(282);






		/**
		 * Asie
		 */
		//1
		listTerritoiresAdjacents = new ArrayList<String>(); 
		listTerritoiresAdjacents.add("Chine"); 
		listTerritoiresAdjacents.add("Oural"); 
		listTerritoiresAdjacents.add("Moyen-Orient"); 
		listTerritoiresAdjacents.add("Inde"); 
		listTerritoiresAdjacents.add("Ukraine"); 
		terr = new Territoire("Afghanistan ", new CodeRVB(12, 144, 69), listTerritoiresAdjacents); 
		listTerritoires.add(terr); 
		terr.setMilieu_x(569);
		terr.setMilieu_y(226);

		//2
		listTerritoiresAdjacents = new ArrayList<String>(); 
		listTerritoiresAdjacents.add("Mongolie"); 
		listTerritoiresAdjacents.add("Siam"); 
		listTerritoiresAdjacents.add("Siberie"); 
		listTerritoiresAdjacents.add("Oural"); 
		listTerritoiresAdjacents.add("Inde"); 
		listTerritoiresAdjacents.add("Afghanistan"); 
		terr = new Territoire("Chine", new CodeRVB(15, 77, 42), listTerritoiresAdjacents); 
		listTerritoires.add(terr); 
		terr.setMilieu_x(666);
		terr.setMilieu_y(267);

		//3
		listTerritoiresAdjacents = new ArrayList<String>(); 
		listTerritoiresAdjacents.add("Siam"); 
		listTerritoiresAdjacents.add("Moyen-Orient"); 
		listTerritoiresAdjacents.add("Chine"); 
		listTerritoiresAdjacents.add("Afghanistan"); 
		terr = new Territoire("Inde", new CodeRVB(6, 55, 28), listTerritoiresAdjacents); 
		listTerritoires.add(terr);
		terr.setMilieu_x(618);
		terr.setMilieu_y(318);

		//4
		listTerritoiresAdjacents = new ArrayList<String>(); 
		listTerritoiresAdjacents.add("Yakoutie" ); 
		listTerritoiresAdjacents.add("Siberie"); 
		listTerritoiresAdjacents.add("Mongolie"); 
		listTerritoiresAdjacents.add("Kamtchatka"); 
		terr = new Territoire("Tchita", new CodeRVB(167,236,178), listTerritoiresAdjacents); 
		listTerritoires.add(terr);
		terr.setMilieu_x(677);
		terr.setMilieu_y(163);

		//5
		listTerritoiresAdjacents = new ArrayList<String>(); 
		listTerritoiresAdjacents.add("Tchita"); 
		listTerritoiresAdjacents.add("Mongolie"); 
		terr = new Territoire("Japon", new CodeRVB(128,255, 103), listTerritoiresAdjacents); 
		listTerritoires.add(terr);
		terr.setMilieu_x(773);
		terr.setMilieu_y(221);

		//6
		listTerritoiresAdjacents = new ArrayList<String>(); 
		listTerritoiresAdjacents.add("Alaska"); 
		listTerritoiresAdjacents.add("Yakoutie"); 
		listTerritoiresAdjacents.add("Tchita"); 
		listTerritoiresAdjacents.add("Mongolie"); 
		listTerritoiresAdjacents.add("Japon"); 
		terr = new Territoire("Kamtchatka", new CodeRVB(43,255, 0), listTerritoiresAdjacents); 
		listTerritoires.add(terr);
		terr.setMilieu_x(753);
		terr.setMilieu_y(94);

		//7
		listTerritoiresAdjacents = new ArrayList<String>();  
		listTerritoiresAdjacents.add("Afrique de l'Est"); 
		listTerritoiresAdjacents.add("Inde"); 
		listTerritoiresAdjacents.add("Afghanistan"); 
		listTerritoiresAdjacents.add("Ukraine"); 
		terr = new Territoire("Moyen-Orient", new CodeRVB(12,119, 58), listTerritoiresAdjacents); 
		listTerritoires.add(terr);
		terr.setMilieu_x(527);
		terr.setMilieu_y(334);

		//8
		listTerritoiresAdjacents = new ArrayList<String>(); 
		listTerritoiresAdjacents.add("Kamtchatka"); 
		listTerritoiresAdjacents.add("Japon"); 
		listTerritoiresAdjacents.add("Tchita");
		listTerritoiresAdjacents.add("Chine");
		terr = new Territoire("Mongolie ", new CodeRVB(38,80, 30), listTerritoiresAdjacents); 
		listTerritoires.add(terr);
		terr.setMilieu_x(689);
		terr.setMilieu_y(213);
		
		//9
		listTerritoiresAdjacents = new ArrayList<String>(); 
		listTerritoiresAdjacents.add("Indonesie"); 
		listTerritoiresAdjacents.add("Chine"); 
		listTerritoiresAdjacents.add("Inde");
		terr = new Territoire("Siam", new CodeRVB(0,83, 4), listTerritoiresAdjacents); 
		listTerritoires.add(terr);
		terr.setMilieu_x(677);
		terr.setMilieu_y(328);

		//10
		listTerritoiresAdjacents = new ArrayList<String>(); 
		listTerritoiresAdjacents.add("Tchita"); 
		listTerritoiresAdjacents.add("Chine"); 
		listTerritoiresAdjacents.add("Yakoutie"); 
		listTerritoiresAdjacents.add("Oural");
		terr = new Territoire("Siberie", new CodeRVB(66,124, 76), listTerritoiresAdjacents); 
		listTerritoires.add(terr);
		terr.setMilieu_x(624);
		terr.setMilieu_y(116);

		//11
		listTerritoiresAdjacents = new ArrayList<String>(); 
		listTerritoiresAdjacents.add("Afghanistan"); 
		listTerritoiresAdjacents.add("Siberie"); 
		listTerritoiresAdjacents.add("Ukraine");
		terr = new Territoire("Oural", new CodeRVB(69,143, 101), listTerritoiresAdjacents); 
		listTerritoires.add(terr);
		terr.setMilieu_x(581);
		terr.setMilieu_y(156);

		//12
		listTerritoiresAdjacents = new ArrayList<String>(); 
		listTerritoiresAdjacents.add("Tchita"); 
		listTerritoiresAdjacents.add("Kamtchatka"); 
		listTerritoiresAdjacents.add("Siberie");
		terr = new Territoire("Yakoutie", new CodeRVB(86,135, 76), listTerritoiresAdjacents); 
		listTerritoires.add(terr);
		terr.setMilieu_x(684);
		terr.setMilieu_y(88);




		/**
		 * Afrique
		 */
		//1
		listTerritoiresAdjacents = new ArrayList<String>();  
		listTerritoiresAdjacents.add("Afrique du Nord"); 
		listTerritoiresAdjacents.add("Afrique de l'Est"); 
		listTerritoiresAdjacents.add("Afrique du Sud"); 
		terr = new Territoire("Congo", new CodeRVB(126, 110, 85), listTerritoiresAdjacents); 
		listTerritoires.add(terr); 
		terr.setMilieu_x(456);
		terr.setMilieu_y(429);

		//2
		listTerritoiresAdjacents = new ArrayList<String>(); 
		listTerritoiresAdjacents.add("Moyen-Orient"); 
		listTerritoiresAdjacents.add("Egypte"); 
		listTerritoiresAdjacents.add("Afrique du Nord"); 
		listTerritoiresAdjacents.add("Congo"); 
		listTerritoiresAdjacents.add("Afrique du Sud"); 
		listTerritoiresAdjacents.add("Madagascar"); 
		terr = new Territoire("Afrique de l'Est ", new CodeRVB(231, 192, 123), listTerritoiresAdjacents); 
		listTerritoires.add(terr); 
		terr.setMilieu_x(496);
		terr.setMilieu_y(397);

		//3
		listTerritoiresAdjacents = new ArrayList<String>(); 
		listTerritoiresAdjacents.add("Europe du Sud"); 
		listTerritoiresAdjacents.add("Moyen-Orient"); 
		listTerritoiresAdjacents.add("Afrique de l'Est"); 
		listTerritoiresAdjacents.add("Afrique du Nord"); 
		terr = new Territoire("Egypte  ", new CodeRVB(179, 136, 61), listTerritoiresAdjacents); 
		listTerritoires.add(terr);
		terr.setMilieu_x(452);
		terr.setMilieu_y(338);

		//4
		listTerritoiresAdjacents = new ArrayList<String>(); 
		listTerritoiresAdjacents.add("Afrique du Sud"); 
		listTerritoiresAdjacents.add("Afrique de l'Est"); 
		terr = new Territoire("Madagascar", new CodeRVB(195,130,0), listTerritoiresAdjacents); 
		listTerritoires.add(terr);
		terr.setMilieu_x(537);
		terr.setMilieu_y(511);

		//5
		listTerritoiresAdjacents = new ArrayList<String>(); 
		listTerritoiresAdjacents.add("Europe Occidentale"); 
		listTerritoiresAdjacents.add("Bresil"); 
		listTerritoiresAdjacents.add("Egypte"); 
		listTerritoiresAdjacents.add("Congo"); 
		terr = new Territoire("Afrique du Nord", new CodeRVB(136,94, 21), listTerritoiresAdjacents); 
		listTerritoires.add(terr);
		terr.setMilieu_x(392);
		terr.setMilieu_y(367);

		//6
		listTerritoiresAdjacents = new ArrayList<String>(); 
		listTerritoiresAdjacents.add("Madagascar"); 
		listTerritoiresAdjacents.add("Afrique de l'Est"); 
		listTerritoiresAdjacents.add("Congo"); 
		terr = new Territoire("Afrique du Sud", new CodeRVB(103,76, 31), listTerritoiresAdjacents); 
		listTerritoires.add(terr);
		terr.setMilieu_x(463);
		terr.setMilieu_y(506);



		/**
		 * Oceanie
		 */
		//1
		listTerritoiresAdjacents = new ArrayList<String>();  
		listTerritoiresAdjacents.add("Nouvelle-Guinee"); 
		listTerritoiresAdjacents.add("Australie Occidentale"); 
		terr = new Territoire("Australie Orientale", new CodeRVB(125, 81, 187), listTerritoiresAdjacents); 
		listTerritoires.add(terr); 
		terr.setMilieu_x(800);
		terr.setMilieu_y(505);

		//2
		listTerritoiresAdjacents = new ArrayList<String>(); 
		listTerritoiresAdjacents.add("Siam"); 
		listTerritoiresAdjacents.add("Australie Occidentale"); 
		listTerritoiresAdjacents.add("Nouvelle-Guinee"); 
		terr = new Territoire("Indonesie", new CodeRVB(125, 117, 139), listTerritoiresAdjacents); 
		listTerritoires.add(terr); 
		terr.setMilieu_x(697);
		terr.setMilieu_y(422);

		//3
		listTerritoiresAdjacents = new ArrayList<String>(); 
		listTerritoiresAdjacents.add("Australie Occidentale"); 
		listTerritoiresAdjacents.add("Indonesie"); 
		listTerritoiresAdjacents.add("Australie Orientale"); 
		terr = new Territoire("Nouvelle-Guinee", new CodeRVB(102, 78, 135), listTerritoiresAdjacents); 
		listTerritoires.add(terr);
		terr.setMilieu_x(765);
		terr.setMilieu_y(403);

		//4
		listTerritoiresAdjacents = new ArrayList<String>(); 
		listTerritoiresAdjacents.add("Afrique du Sud"); 
		listTerritoiresAdjacents.add("Indonesie"); 
		listTerritoiresAdjacents.add("Nouvelle-Guinee"); 
		terr = new Territoire("Australie Occidentale", new CodeRVB(86,42,148), listTerritoiresAdjacents); 
		listTerritoires.add(terr);
		terr.setMilieu_x(729);
		terr.setMilieu_y(504);
	}
	
}
