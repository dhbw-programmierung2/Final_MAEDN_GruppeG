package game;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import javafx.scene.image.Image;
import launcher.LauncherController;

/**
 * Diese Klasse ist für das Würfel verantwortlich
 * 
 * @author Lukas, Kim, Isabelle, Jonas
 * @version 1.0
 */
public class Dice {

	// Variable enthält die gewürfelte Zahl
	public int cubeNumber;
	
	/*
	 * Diese Methode würfelt eine Zahl zwischen 1 und 6
	 */
	public int rollTheDice() {
		Random random = new Random();
		int cubeNumber = random.nextInt(6)+1;
		
		return cubeNumber;
		
	}
	

}
