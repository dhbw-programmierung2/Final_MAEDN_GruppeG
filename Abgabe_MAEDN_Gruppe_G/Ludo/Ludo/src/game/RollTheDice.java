package game;

import java.util.Random;

import javafx.scene.image.Image;

/**
 * Diese Klasse ist für das Würfel verantwortlich
 * 
 * @author Lukas, Kim, Isabelle, Jonas
 * @version 1.0
 */
class RollTheDice {

	/*
	 * Diese Methode würfelt eine Zahl zwischen 1 und 6
	 */
	int rollTheDice() {
		Random random = new Random();
		return random.nextInt(6)+1;
	}
	

}
