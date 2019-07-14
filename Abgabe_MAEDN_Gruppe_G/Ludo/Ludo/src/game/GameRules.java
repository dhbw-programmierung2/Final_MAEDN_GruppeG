package game;

import java.util.ArrayList;
import java.util.List;

/**
 * Diese Klasse enthält die Spielregeln 
 * 
 * @author Lukas, Kim, Isabelle, Jonas
 * @version 1.0
 */
public class GameRules {

	private List<Spieler> spielerList = new ArrayList<>();

	/*
	 * Startfelder der jeweiligen Farben
	 */
	int[][] startboxBlau = new int[4][4];
	int[][] startboxRot = new int[4][4];
	int[][] startboxGrün = new int[4][4];
	int[][] startboxGelb = new int[4][4];
	int[][] startboxSchwarz = new int[4][4];
	int[][] startboxLila = new int[4][4];
	

	
	/*
	 * Zielfelder der jeweiligen Farben
	 */
	int[][] zielBlau = new int[4][4];
	int[][] zielRot = new int[4][4];
	int[][] zielGrün = new int[4][4];
	int[][] zielGelb = new int[4][4];
	int[][] zielSchwarz = new int[4][4];
	int[][] zielLila = new int[4][4];
	
	/*
	 * Array des jeweiligen Spielfeldes
	 */
	int[][] spielfeldVier = new int[40][40];
	
	int[][] spielfeldSechs = new int[46][46];

	public void erstelleSpieler(List<String> playerNameList, List<String> colorList, List<String> rivalList){
		int max = playerNameList.size();
		for (int index = 0; index < max; index++){
			Spieler neuerSpieler = new Spieler();
			String name = playerNameList.get(index);
			String farbe = colorList.get(index);
			String rival = rivalList.get(index);
			neuerSpieler.initSpieler(name, farbe, rival);
		}
	}

	public void erstelleKimsSixpack(){
		Board neuesBrett = new Board();
		List<Felder> localListe = neuesBrett.getFelderListe();
		localListe.stream().filter(field -> field.getColor.);
	}



	public void startGame(){
		do {
			for (Spieler spieler : spielerList){
				int amountThrows = checkThrows();
				for (int index = 0; index < amountThrows; index++){
					
					//Methoden die hier aufgerufen werden müssen
					rollTheDice();
					checkBreakFree();
					moveFigure();
				}
			}
		} while (!pruefeGewinner);
	}

	
	/*
	 * Methode um Figur zu ziehen
	 */
	public void goForward() {
		
		RollTheDice rtd = new RollTheDice();
		
		rtd.rollTheDice();
		
		/*
		 * value von rollTheDice + stelle an der ein token steht = valider zug
		 */
		
		
	}
	
	public void validMove() {
		
		/*
		 * check ob token in bound of array ist
		 * wenn ja stelle + rollTheDice
		 * wenn nein, schauen ob restl felder + zielArray reichen -> ziehen
		 * => belegt = !validmove und aussetzen oder anderer Token ziehen
		 */
	}

}
